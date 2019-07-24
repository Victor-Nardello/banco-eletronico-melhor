package br.com.ciandt.caixaeletronico.entrypoint.mapper;

import org.springframework.stereotype.Component;

import br.com.ciandt.caixaeletronico.entrypoint.model.response.SaqueCorrenteResponse;
import br.com.ciandt.caixaeletronico.usecase.domain.SaqueDomain;

@Component
public class SaqueContaCorrenteDomainMapper {
	
	public SaqueCorrenteResponse toSaqueCorrenteResponse(SaqueDomain saqueDomain) {
		
		SaqueCorrenteResponse saqueContaCorrenteResponse = new SaqueCorrenteResponse();
		
		saqueContaCorrenteResponse.setDataTransacao(saqueDomain.getDataTransacao());
		saqueContaCorrenteResponse.setSaldo(saqueDomain.getSaldo());
		saqueContaCorrenteResponse.setLimite(saqueDomain.getLimite());
		saqueContaCorrenteResponse.setValorSaque(saqueDomain.getValorSaque());
		
		return saqueContaCorrenteResponse;
	}
}