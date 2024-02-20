package br.com.sicredi.assembleia.sessaovotacao.infra;

import br.com.sicredi.assembleia.sessaovotacao.application.repository.SessaoVotacaoRepository;
import br.com.sicredi.assembleia.sessaovotacao.domain.SessaoVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}
