package br.com.sicredi.assembleia.sessaovotacao.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SessaoVotacaoTest {

    @Test
    void deveFecharSessaoQuandoChamarMetodoFechaSessao(){
        SessaoVotacao sessao = buildSessao();
        PublicadorResultadoSessao publicador = new PublicadorResultadoSessaoMockTest();
        sessao.fechaSessao(publicador);

        assertEquals(StatusSessaoVotacao.FECHADA,sessao.getStatus());
    }

    @Test
    void deveFecharSessaoQuandoStatusAbertaEMomentoEncerramentoEstiverNoPassado(){
        SessaoVotacao sessao = buildSessao();
        PublicadorResultadoSessao publicador = new PublicadorResultadoSessaoMockTest();

        sessao.atualizaStatus(publicador);

        assertEquals(StatusSessaoVotacao.FECHADA,sessao.getStatus());
    }

    @Test
    void deveFicarAbertaSessaoQuandoStatusSessaoAbertaEMomentoEncerramentoEstiverNoFuturo(){
        SessaoVotacao sessao = buildSessaoEncerramentoFuturo();
        PublicadorResultadoSessao publicador = new PublicadorResultadoSessaoMockTest();

        sessao.atualizaStatus(publicador);

        assertEquals(StatusSessaoVotacao.ABERTA,sessao.getStatus());
    }

    private SessaoVotacao buildSessaoEncerramentoFuturo() {
        SessaoVotacao sessao = SessaoVotacao.builder()
                .id(UUID.randomUUID())
                .idPauta(UUID.randomUUID())
                .momentoAbertura(LocalDateTime.of(2024,1,1,1,1))
                .momentoEncerramento(LocalDateTime.MAX)
                .votos(getVotos())
                .status(StatusSessaoVotacao.ABERTA)
                .build();
        return sessao;
    }

    private SessaoVotacao buildSessao() {
        SessaoVotacao sessao = SessaoVotacao.builder()
                .id(UUID.randomUUID())
                .idPauta(UUID.randomUUID())
                .momentoAbertura(LocalDateTime.of(2024,1,1,1,1))
                .momentoEncerramento(LocalDateTime.of(2024,1,1,1,2))
                .votos(getVotos())
                .status(StatusSessaoVotacao.ABERTA)
                .build();
        return sessao;
    }

    private Map<String, VotoPauta> getVotos() {
    return Map.of("18524847727", VotoPauta.builder().cpfAssociado("18524847727").opcaoVoto(OpcaoVoto.SIM).build(),
         "18524847720", VotoPauta.builder().cpfAssociado("18524847727").opcaoVoto(OpcaoVoto.SIM).build()
            );
    }

}