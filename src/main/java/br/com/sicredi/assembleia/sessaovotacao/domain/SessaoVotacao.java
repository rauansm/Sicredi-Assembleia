package br.com.sicredi.assembleia.sessaovotacao.domain;

import br.com.sicredi.assembleia.associado.application.service.AssociadoService;
import br.com.sicredi.assembleia.handler.APIException;
import br.com.sicredi.assembleia.pauta.domain.Pauta;
import br.com.sicredi.assembleia.sessaovotacao.application.api.ResultadoSessao;
import br.com.sicredi.assembleia.sessaovotacao.application.api.VotoRequest;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Builder(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class SessaoVotacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    private UUID idPauta;
    private Integer tempoDuracao;
    @Enumerated(EnumType.STRING)
    private StatusSessaoVotacao status;
    private LocalDateTime momentoAbertura;
    private LocalDateTime momentoEncerramento;

    @OneToMany(mappedBy = "sessaoVotacao", cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @MapKey(name = "cpfAssociado")
    private Map<String,VotoPauta> votos;

    public SessaoVotacao(SessaoAberturaRequest sessaoAberturaRequest, Pauta pauta) {
        this.idPauta = pauta.getId();
        this.tempoDuracao = sessaoAberturaRequest.getTempoDuracao().orElse(1);
        this.momentoAbertura = LocalDateTime.now();
        this.momentoEncerramento = momentoAbertura.plusMinutes(this.tempoDuracao);
        this.status = StatusSessaoVotacao.ABERTA;
        this.votos = new HashMap<>();
    }

    public VotoPauta recebeVoto(VotoRequest votoRequest, AssociadoService associadoService, PublicadorResultadoSessao publicadorResultadoSessao){
        validaSessaoAberta(publicadorResultadoSessao);
        validaAssociado(votoRequest.getCpfAssociado(),associadoService);
        VotoPauta voto = new VotoPauta(this, votoRequest);
        votos.put(votoRequest.getCpfAssociado(),voto);
        return voto;
    }

    private void validaSessaoAberta(PublicadorResultadoSessao publicadorResultadoSessao) {
        atualizaStatus(publicadorResultadoSessao);
        if (this.status.equals(StatusSessaoVotacao.FECHADA)){
            throw APIException.negocio("Essa sessão está fechada");
        }
    }

     void atualizaStatus(PublicadorResultadoSessao publicadorResultadoSessao) {
        if (this.status.equals(StatusSessaoVotacao.ABERTA)){
            if (LocalDateTime.now().isAfter(this.momentoEncerramento)){
                fechaSessao(publicadorResultadoSessao);
            }
        }
    }

     void fechaSessao(PublicadorResultadoSessao publicadorResultadoSessao) {
        this.status = StatusSessaoVotacao.FECHADA;
        publicadorResultadoSessao.publica(new ResultadoSessao(this));
    }

     void validaAssociado(String cpfAssociado, AssociadoService associadoService) {
        associadoService.validaAssociadoAptoVoto(cpfAssociado);
        validaVotoDuplicado(cpfAssociado);
    }

     void validaVotoDuplicado(String cpfAssociado) {
        if (this.votos.containsKey(cpfAssociado)){
           throw APIException.negocio("Associado já votou nessa sessão!");
        }
    }

    public ResultadoSessao obtemResultado(PublicadorResultadoSessao publicadorResultadoSessao) {
        atualizaStatus(publicadorResultadoSessao);
    return new ResultadoSessao(this);
    }

    public Long getTotalVotos() {
        return (long) this.votos.size();
    }

    public Long getTotalSim() {
        return calculaVotosPorOpcao(OpcaoVoto.SIM);
    }
    public Long getTotalNao() {
        return calculaVotosPorOpcao(OpcaoVoto.NAO);
    }

    private Long calculaVotosPorOpcao(OpcaoVoto opcaoVoto) {
        return votos.values().stream()
                .filter(v -> v.getOpcaoVoto().equals(opcaoVoto))
                .count();

    }
}
