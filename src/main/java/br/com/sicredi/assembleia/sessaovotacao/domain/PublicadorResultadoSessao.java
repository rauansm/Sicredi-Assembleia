package br.com.sicredi.assembleia.sessaovotacao.domain;

import br.com.sicredi.assembleia.sessaovotacao.application.api.ResultadoSessao;

public interface PublicadorResultadoSessao {
    void publica(ResultadoSessao resultadoSessao);
}
