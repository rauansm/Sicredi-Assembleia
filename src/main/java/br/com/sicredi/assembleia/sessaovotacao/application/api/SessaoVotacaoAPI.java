package br.com.sicredi.assembleia.sessaovotacao.application.api;

import br.com.sicredi.assembleia.sessaovotacao.domain.SessaoAberturaRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/sessao")
public interface SessaoVotacaoAPI {

    @PostMapping("/abertura")
    @ResponseStatus(code = HttpStatus.CREATED)
    SessaoAberturaResponse abreSessao (@RequestBody @Valid SessaoAberturaRequest sessaoAberturaRequest);

    @PostMapping("/{idSessao}/voto")
    @ResponseStatus(code = HttpStatus.CREATED)
    VotoResponse recebeVoto (@PathVariable UUID idSessao,
                             @RequestBody @Valid VotoRequest votoRequest);

    @GetMapping("/{idSessao}/resultado")
    @ResponseStatus(code = HttpStatus.OK)
    ResultadoSessao obtemResultado (@PathVariable UUID idSessao);


}
