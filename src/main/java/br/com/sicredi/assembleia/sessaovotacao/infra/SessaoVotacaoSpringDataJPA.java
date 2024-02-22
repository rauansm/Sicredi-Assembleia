package br.com.sicredi.assembleia.sessaovotacao.infra;

import br.com.sicredi.assembleia.sessaovotacao.domain.SessaoVotacao;
import br.com.sicredi.assembleia.sessaovotacao.domain.StatusSessaoVotacao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SessaoVotacaoSpringDataJPA extends JpaRepository<SessaoVotacao, UUID> {
    List<SessaoVotacao> findByStatus(StatusSessaoVotacao aberta);
}
