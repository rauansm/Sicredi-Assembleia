package br.com.sicredi.assembleia.pauta.application.service;

import br.com.sicredi.assembleia.pauta.application.api.PautaCadastradaResponse;
import br.com.sicredi.assembleia.pauta.application.api.PautaRequest;

public interface PautaService {
    PautaCadastradaResponse cadastraPauta(PautaRequest pautaRequest);
}
