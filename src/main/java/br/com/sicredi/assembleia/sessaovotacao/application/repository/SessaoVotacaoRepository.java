package br.com.sicredi.assembleia.sessaovotacao.application.repository;

import br.com.sicredi.assembleia.sessaovotacao.domain.SessaoVotacao;

import java.util.List;
import java.util.UUID;

public interface SessaoVotacaoRepository {
    SessaoVotacao salva(SessaoVotacao sessaoVotacao);

    SessaoVotacao buscaSessaoPorId(UUID idSessao);

    List<SessaoVotacao> buscaAbertas();
}
