package br.com.sicredi.assembleia.pauta.application.service;

import br.com.sicredi.assembleia.pauta.application.api.PautaCadastradaResponse;
import br.com.sicredi.assembleia.pauta.application.api.PautaRequest;
import br.com.sicredi.assembleia.pauta.domain.Pauta;

import java.util.UUID;

public interface PautaService {
    PautaCadastradaResponse cadastraPauta(PautaRequest pautaRequest);

    Pauta buscaPautaPorId(UUID idPauta);
}
