package com.boaglio.casadocodigo.greendogdelivery.config;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.boaglio.casadocodigo.greendogdelivery.dto.Notificacao;

/**
 * Implementação da interface {@link Notificacao} de produção que retorna true
 * (pois o envio de e-mails deve funcionar apenas em produção)
 * 
 * @author vagner
 *
 */
@Component
@Profile("prod")
public class ProdNotificacaoConfig implements Notificacao {

	@Override
	public boolean envioAtivo() {
		return true;
	}

}
