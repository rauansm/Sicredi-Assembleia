package br.com.sicredi.assembleia.sessaovotacao.application.service;

import br.com.sicredi.assembleia.sessaovotacao.application.api.SessaoAberturaResponse;
import br.com.sicredi.assembleia.sessaovotacao.domain.SessaoAberturaRequest;

public interface SessaoVotacaoService {
    SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest);
}
