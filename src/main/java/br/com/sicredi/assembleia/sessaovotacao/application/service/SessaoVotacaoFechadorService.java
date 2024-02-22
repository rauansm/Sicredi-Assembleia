package br.com.sicredi.assembleia.sessaovotacao.application.service;

import br.com.sicredi.assembleia.sessaovotacao.application.repository.SessaoVotacaoRepository;
import br.com.sicredi.assembleia.sessaovotacao.domain.PublicadorResultadoSessao;
import br.com.sicredi.assembleia.sessaovotacao.domain.SessaoVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoFechadorService {
    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final PublicadorResultadoSessao publicador;

    @Scheduled(cron = "0 * * * * *")
    public void fechaSessoesEncerradas(){
        log.debug("[inicia] SessaoVotacaoFechadorService - fechaSessoesEncerradas");
        List<SessaoVotacao> sessoesAbertas = sessaoVotacaoRepository.buscaAbertas();
        log.debug("[sessaoAberta] {}", sessoesAbertas);
        sessoesAbertas.forEach(sessaoVotacao -> {
                    sessaoVotacao.obtemResultado(publicador);
                    sessaoVotacaoRepository.salva(sessaoVotacao);
                });
        log.debug("[finaliza] SessaoVotacaoFechadorService - fechaSessoesEncerradas");
    }
}
