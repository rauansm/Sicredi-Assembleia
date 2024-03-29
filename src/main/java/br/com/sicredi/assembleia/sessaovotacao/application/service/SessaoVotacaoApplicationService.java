package br.com.sicredi.assembleia.sessaovotacao.application.service;

import br.com.sicredi.assembleia.associado.application.service.AssociadoService;
import br.com.sicredi.assembleia.pauta.application.service.PautaService;
import br.com.sicredi.assembleia.pauta.domain.Pauta;
import br.com.sicredi.assembleia.sessaovotacao.application.api.ResultadoSessao;
import br.com.sicredi.assembleia.sessaovotacao.application.api.SessaoAberturaResponse;
import br.com.sicredi.assembleia.sessaovotacao.application.api.VotoRequest;
import br.com.sicredi.assembleia.sessaovotacao.application.api.VotoResponse;
import br.com.sicredi.assembleia.sessaovotacao.application.repository.SessaoVotacaoRepository;
import br.com.sicredi.assembleia.sessaovotacao.domain.PublicadorResultadoSessao;
import br.com.sicredi.assembleia.sessaovotacao.domain.SessaoAberturaRequest;
import br.com.sicredi.assembleia.sessaovotacao.domain.SessaoVotacao;
import br.com.sicredi.assembleia.sessaovotacao.domain.VotoPauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class SessaoVotacaoApplicationService implements SessaoVotacaoService {
    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final PautaService pautaService;
    private final AssociadoService associadoService;
    private final PublicadorResultadoSessao publicadorResultadoSessao;

    @Override
    public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
        log.info("[inicia] SessaoVotacaoApplicationService - abreSessao");
        Pauta pauta = pautaService.buscaPautaPorId(sessaoAberturaRequest.getIdPauta());
        SessaoVotacao sessaoVotacao = sessaoVotacaoRepository.salva(new SessaoVotacao(sessaoAberturaRequest, pauta));
        log.info("[finaliza] SessaoVotacaoApplicationService - abreSessao");
        return new SessaoAberturaResponse(sessaoVotacao);
    }

    @Override
    public VotoResponse recebeVoto(UUID idSessao, VotoRequest votoRequest) {
        log.debug("[inicia] SessaoVotacaoApplicationService - recebeVoto");
        SessaoVotacao sessao = sessaoVotacaoRepository.buscaSessaoPorId(idSessao);
        VotoPauta voto = sessao.recebeVoto(votoRequest,associadoService, publicadorResultadoSessao);
        sessaoVotacaoRepository.salva(sessao);
        log.debug("[finaliza] SessaoVotacaoApplicationService - recebeVoto");
        return new VotoResponse(voto);
    }

    @Override
    public ResultadoSessao obtemResultado(UUID idSessao) {
        log.info("[inicia] SessaoVotacaoApplicationService - obtemResultado");
        SessaoVotacao sessao = sessaoVotacaoRepository.buscaSessaoPorId(idSessao);
        ResultadoSessao resultadoSessao = sessao.obtemResultado(publicadorResultadoSessao);
        sessaoVotacaoRepository.salva(sessao);
        log.info("[finaliza] SessaoVotacaoApplicationService - obtemResultado");
        return resultadoSessao;
    }
}
