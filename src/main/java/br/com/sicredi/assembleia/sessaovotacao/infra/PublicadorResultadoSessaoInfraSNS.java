package br.com.sicredi.assembleia.sessaovotacao.infra;

import br.com.sicredi.assembleia.config.AwsConfigProperties;
import br.com.sicredi.assembleia.sessaovotacao.application.api.ResultadoSessao;
import br.com.sicredi.assembleia.sessaovotacao.domain.PublicadorResultadoSessao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.aws.messaging.core.NotificationMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Log4j2
public class PublicadorResultadoSessaoInfraSNS implements PublicadorResultadoSessao {
    private final NotificationMessagingTemplate publicadorResultadoSNS;
    private final AwsConfigProperties awsSnsProperties;
    @Override
    public void publica(ResultadoSessao resultadoSessao) {
        log.info("[inicia] PublicadorResultadoSessaoInfraSNS - publica");
        publicadorResultadoSNS.sendNotification(awsSnsProperties.getResultadoSessaoTopic(),resultadoSessao,resultadoSessao.getIdPauta().toString());
        log.info("[finaliza] PublicadorResultadoSessaoInfraSNS - publica");
    }
}
