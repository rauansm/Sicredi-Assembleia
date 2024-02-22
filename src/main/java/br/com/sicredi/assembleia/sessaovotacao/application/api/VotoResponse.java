package br.com.sicredi.assembleia.sessaovotacao.application.api;

import br.com.sicredi.assembleia.sessaovotacao.domain.VotoPauta;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class VotoResponse {

    private UUID id;
    private UUID idSessao;
    private String cpfAssociado;
    private LocalDateTime momentoVoto;

    public VotoResponse(VotoPauta voto) {
    this.id = voto.getId();
    this.idSessao = voto.getIdSessao();
    this.cpfAssociado = voto.getCpfAssociado();
    this.momentoVoto = voto.getMomentoVoto();
    }
}
