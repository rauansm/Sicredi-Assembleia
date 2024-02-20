package br.com.sicredi.assembleia.pauta.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pauta")
public interface PautaAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PautaCadastradaResponse cadastraPauta (@Valid @RequestBody PautaRequest pautaRequest);
}
