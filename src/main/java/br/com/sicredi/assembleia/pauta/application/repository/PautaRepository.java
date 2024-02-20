package br.com.sicredi.assembleia.pauta.application.repository;

import br.com.sicredi.assembleia.pauta.domain.Pauta;

public interface PautaRepository {
    Pauta salva(Pauta pauta);
}
