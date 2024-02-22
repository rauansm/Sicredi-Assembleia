package br.com.sicredi.assembleia.pauta.infra;

import br.com.sicredi.assembleia.handler.APIException;
import br.com.sicredi.assembleia.pauta.application.repository.PautaRepository;
import br.com.sicredi.assembleia.pauta.domain.Pauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

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

    @Override
    public Pauta buscaPautaPorId(UUID idPauta) {
        log.info("[inicia] PautaInfraRepository - buscaPautaPorId");
        Optional<Pauta> pauta = pautaSpringDataJPA.findById(idPauta);
        log.info("[finaliza] PautaInfraRepository - buscaPautaPorId");
        return pauta.orElseThrow(() -> APIException.recursoNaoEncontrado("Pauta não encontrada!"));
    }
}
