package br.com.sicredi.assembleia.sessaovotacao.application.api;

import br.com.sicredi.assembleia.sessaovotacao.application.service.SessaoVotacaoService;
import br.com.sicredi.assembleia.sessaovotacao.domain.SessaoAberturaRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoController implements SessaoVotacaoAPI {
    private final SessaoVotacaoService sessaoVotacaoService;
    @Override
    public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
     log.info("[inicia] SessaoVotacaoController - abreSessao");
     SessaoAberturaResponse sessaoAberturaResponse = sessaoVotacaoService.abreSessao(sessaoAberturaRequest);
     log.info("[finaliza] SessaoVotacaoController - abreSessao");
     return sessaoAberturaResponse;
    }
}
