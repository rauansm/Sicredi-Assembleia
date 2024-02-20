package br.com.sicredi.assembleia.pauta.domain;

import br.com.sicredi.assembleia.pauta.application.api.PautaRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Pauta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID id;
    private String titulo;
    private String descricao;
    private UUID idAssociadoAutor;
    @CreationTimestamp
    private LocalDateTime dataCriacao;

    public Pauta(PautaRequest pautaRequest) {
        this.id = UUID.randomUUID();
        this.titulo = pautaRequest.getTitulo();
        this.descricao = pautaRequest.getDescricao();
        this.idAssociadoAutor = pautaRequest.getIdAssociadoAutor();
    }
}
