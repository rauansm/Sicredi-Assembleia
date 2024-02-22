package br.com.sicredi.assembleia.sessaovotacao.domain;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;
@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class SessaoAberturaRequest {
    @Getter
    @NotNull
    private UUID idPauta;
    private Integer tempoDuracao;

    public Optional<Integer> getTempoDuracao() {
        return Optional.ofNullable(this.tempoDuracao);
    }
}
