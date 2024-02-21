package br.com.sicredi.assembleia.associado.infra.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "serproClientFeing", url = "https://gateway.apiserpro.serpro.gov.br/consulta-cpf-df-trial")
public interface SerproClientFeign {
    @GetMapping(value = "/v1/cpf/{cpfAssociado}")
    ConsultaCPFResponse consultaCPF(@RequestHeader (value = "Authorization") String authorization,
            @PathVariable String cpfAssociado);
}
