package br.com.sicredi.assembleia.sessaovotacao.domain;

import lombok.Getter;
import lombok.Value;

import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;
@Value
public class SessaoAberturaRequest {
    @Getter
    @NotNull
    private UUID idPauta;
    private Integer tempoDuracao;

    public Optional<Integer> getTempoDuracao() {
        return Optional.ofNullable(this.tempoDuracao);
    }
}
