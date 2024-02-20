package br.com.sicredi.assembleia.pauta.application.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pauta")
public interface PautaAPI {
    @PostMapping
    PautaCadastradaResponse cadastraPauta (@Valid @RequestBody PautaRequest pautaRequest);
}
