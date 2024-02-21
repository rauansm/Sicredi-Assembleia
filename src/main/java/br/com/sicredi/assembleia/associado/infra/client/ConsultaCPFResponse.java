package br.com.sicredi.assembleia.associado.infra.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ConsultaCPFResponse {

        @JsonProperty("ni")
        private String ni;
        @JsonProperty("nome")
        private String nome;
        @JsonProperty("situacao")
        private Situacao situacao;
        @JsonProperty("nascimento")
        private String nascimento;

    public boolean isInvalid() {
        return !isValid();
    }

    private boolean isValid() {
        return this.situacao.getCodigo().equals("0");
    }


    @Getter
    @ToString
    public static class Situacao {
        @JsonProperty("codigo")
        private String codigo;
        @JsonProperty("descricao")
        private String descricao;
    }
}
