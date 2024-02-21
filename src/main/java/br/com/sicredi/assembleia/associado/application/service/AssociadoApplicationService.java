package br.com.sicredi.assembleia.associado.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class AssociadoApplicationService implements AssociadoService {
    @Override
    public void validaAssociadoAptoVoto(String cpfAssociado) {
        log.info("[inicia] AssociadoApplicationService - validaAssociadoAptoVoto");
        
        log.info("[finaliza] AssociadoApplicationService - validaAssociadoAptoVoto");
    }
}
