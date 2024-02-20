package br.com.sicredi.assembleia.pauta.application.infra;

import br.com.sicredi.assembleia.pauta.domain.Pauta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PautaSpringDataJPA extends JpaRepository<Pauta, UUID> {
}
