package br.com.sicredi.assembleia.sessaovotacao.infra;

import br.com.sicredi.assembleia.handler.APIException;
import br.com.sicredi.assembleia.sessaovotacao.application.repository.SessaoVotacaoRepository;
import br.com.sicredi.assembleia.sessaovotacao.domain.SessaoVotacao;
import br.com.sicredi.assembleia.sessaovotacao.domain.StatusSessaoVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoInfraRepository implements SessaoVotacaoRepository {
    private final SessaoVotacaoSpringDataJPA sessaoVotacaoSpringDataJPA;
    @Override
    public SessaoVotacao salva(SessaoVotacao sessaoVotacao) {
        log.info("[inicia] SessaoVotacaoInfraRepository - salva");
        sessaoVotacaoSpringDataJPA.save(sessaoVotacao);
        log.info("[finaliza] SessaoVotacaoInfraRepository - salva");
        return sessaoVotacao;
    }

    @Override
    public SessaoVotacao buscaSessaoPorId(UUID idSessao) {
        log.info("[inicia] SessaoVotacaoInfraRepository - buscaSessaoPorId");
        Optional<SessaoVotacao> sessaoVotacao = sessaoVotacaoSpringDataJPA.findById(idSessao);
        log.info("[finaliza] SessaoVotacaoInfraRepository - buscaSessaoPorId");
        return sessaoVotacao.orElseThrow(() -> APIException.recursoNaoEncontrado("Sessão não encontrada!"));
    }

    @Override
    public List<SessaoVotacao> buscaAbertas() {
        log.debug("[inicia] SessaoVotacaoInfraRepository - buscaAbertas");
        List<SessaoVotacao> sessoes = sessaoVotacaoSpringDataJPA.findByStatus(StatusSessaoVotacao.ABERTA);
        log.debug("[finaiza] SessaoVotacaoInfraRepository - buscaAbertas");
        return sessoes;
    }
}
