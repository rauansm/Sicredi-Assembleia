package br.com.sicredi.assembleia.sessaovotacao.application.service;

import br.com.sicredi.assembleia.sessaovotacao.application.api.ResultadoSessao;
import br.com.sicredi.assembleia.sessaovotacao.application.api.SessaoAberturaResponse;
import br.com.sicredi.assembleia.sessaovotacao.application.api.VotoRequest;
import br.com.sicredi.assembleia.sessaovotacao.application.api.VotoResponse;
import br.com.sicredi.assembleia.sessaovotacao.domain.SessaoAberturaRequest;

import java.util.UUID;

public interface SessaoVotacaoService {
    SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest);

    VotoResponse recebeVoto(UUID idSessao, VotoRequest votoRequest);

    ResultadoSessao obtemResultado(UUID idSessao);
}
