package br.com.sicredi.assembleia.pauta.application.infra;

import br.com.sicredi.assembleia.pauta.application.repository.PautaRepository;
import br.com.sicredi.assembleia.pauta.domain.Pauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Log4j2
public class PautaInfraRepository implements PautaRepository {
    private final PautaSpringDataJPA pautaSpringDataJPA;
    @Override
    public Pauta salva(Pauta pauta) {
        log.info("[inicia] PautaInfraRepository - salva");
        pautaSpringDataJPA.save(pauta);
        log.info("[finaliza] PautaInfraRepository - salva");
        return pauta;
    }
}
