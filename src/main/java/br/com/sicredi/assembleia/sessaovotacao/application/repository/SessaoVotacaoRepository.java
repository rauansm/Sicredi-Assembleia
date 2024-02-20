package br.com.sicredi.assembleia.sessaovotacao.application.repository;

import br.com.sicredi.assembleia.sessaovotacao.domain.SessaoVotacao;

public interface SessaoVotacaoRepository {
    SessaoVotacao salva(SessaoVotacao sessaoVotacao);
}
