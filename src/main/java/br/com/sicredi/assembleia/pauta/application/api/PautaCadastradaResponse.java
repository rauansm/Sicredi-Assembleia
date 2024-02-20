package br.com.sicredi.assembleia.pauta.application.api;

import br.com.sicredi.assembleia.pauta.domain.Pauta;
import lombok.Value;

import java.util.UUID;
@Value
public class PautaCadastradaResponse {
    private UUID id;

    public PautaCadastradaResponse(Pauta pauta) {
        this.id = pauta.getId();
    }
}
