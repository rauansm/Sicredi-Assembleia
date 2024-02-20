package br.com.sicredi.assembleia.sessaovotacao.application.api;

import br.com.sicredi.assembleia.sessaovotacao.domain.SessaoAberturaRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/sessao/abertura")
public interface SessaoVotacaoAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    SessaoAberturaResponse abreSessao (@RequestBody @Valid SessaoAberturaRequest sessaoAberturaRequest);
}
