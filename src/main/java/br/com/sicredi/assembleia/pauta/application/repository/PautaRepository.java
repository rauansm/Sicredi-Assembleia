package br.com.sicredi.assembleia.pauta.application.repository;

import br.com.sicredi.assembleia.pauta.domain.Pauta;

import java.util.UUID;

public interface PautaRepository {
    Pauta salva(Pauta pauta);

    Pauta buscaPautaPorId(UUID idPauta);
}
