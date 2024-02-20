package br.com.sicredi.assembleia.pauta.application.service;

import br.com.sicredi.assembleia.pauta.application.api.PautaCadastradaResponse;
import br.com.sicredi.assembleia.pauta.application.api.PautaRequest;
import br.com.sicredi.assembleia.pauta.application.repository.PautaRepository;
import br.com.sicredi.assembleia.pauta.domain.Pauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class PautaApplicationService implements PautaService {
    private final PautaRepository pautaRepository;
    @Override
    public PautaCadastradaResponse cadastraPauta(PautaRequest pautaRequest) {
        log.info("[inicia] PautaApplicationService - cadastraPauta");
        Pauta pauta =  pautaRepository.salva(new Pauta(pautaRequest));
        log.info("[finaliza] PautaApplicationService - cadastraPauta");
        return new PautaCadastradaResponse(pauta);
    }
}
