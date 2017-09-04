package com.boaglio.casadocodigo.greendogdelivery.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.boaglio.casadocodigo.greendogdelivery.dto.Notificacao;

/**
 * Implementação da interface {@link Notificacao} de desenvolvimento que retorna false
 * (pois o envio de e-mails não deve funcionar em desenvolvimento)
 * 
 * @author vagner
 *
 */
@Component
@Profile("!prod")
public class DevNotificacaoConfig implements Notificacao {

	@Override
	public boolean envioAtivo() {
		return false;
	}

}
