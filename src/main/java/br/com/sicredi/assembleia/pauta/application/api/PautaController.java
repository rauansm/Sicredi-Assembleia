package br.com.sicredi.assembleia.pauta.application.api;

import br.com.sicredi.assembleia.pauta.application.service.PautaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class PautaController implements PautaAPI {
    private final PautaService pautaService;
    @Override
    public PautaCadastradaResponse cadastraPauta(PautaRequest pautaRequest) {
        log.info("[inicia] PautaController - cadastraPauta");
        PautaCadastradaResponse pautaCadastrada = pautaService.cadastraPauta(pautaRequest);
        log.info("[finalia] PautaController - cadastraPauta");
        return pautaCadastrada;
    }
}
