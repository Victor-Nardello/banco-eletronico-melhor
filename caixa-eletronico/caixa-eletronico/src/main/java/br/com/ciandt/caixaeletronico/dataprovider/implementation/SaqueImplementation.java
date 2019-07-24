package br.com.ciandt.caixaeletronico.dataprovider.implementation;

import java.math.BigDecimal;

import br.com.ciandt.caixaeletronico.dataprovider.entity.SaqueEntity;
import br.com.ciandt.caixaeletronico.usecase.domain.SaqueDomain;
import br.com.ciandt.caixaeletronico.usecase.gateway.SaqueGateway;

public class SaqueImplementation implements SaqueGateway {
	
	public SaqueDomain getSaqueContaCorrente() {
		
		SaqueEntity saqueEntity = new SaqueEntity();
		
		saqueEntity.setAgencia("0987");
		saqueEntity.setConta("098765");
		saqueEntity.setSaldo(new BigDecimal(90.00));
		saqueEntity.setLimite(new BigDecimal(1000.00));
		saqueEntity.setTipoConta("CC");
		saqueEntity.setValorSaque(new BigDecimal(10.00));
		saqueEntity.setMensagem("Mensagem");
		saqueEntity.setOperacao("Operação");
		
		return null;
	}

}
