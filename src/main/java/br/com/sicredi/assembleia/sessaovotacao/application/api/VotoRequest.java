package br.com.sicredi.assembleia.sessaovotacao.application.api;

import br.com.sicredi.assembleia.sessaovotacao.domain.OpcaoVoto;
import lombok.Value;

@Value
public class VotoRequest {

    private String cpfAssociado;
    private OpcaoVoto opcao;
}
