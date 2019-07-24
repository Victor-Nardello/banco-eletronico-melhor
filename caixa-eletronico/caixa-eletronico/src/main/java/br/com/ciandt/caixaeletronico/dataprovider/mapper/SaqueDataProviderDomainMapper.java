package br.com.ciandt.caixaeletronico.dataprovider.mapper;

import org.springframework.stereotype.Component;

import br.com.ciandt.caixaeletronico.dataprovider.entity.SaqueEntity;
import br.com.ciandt.caixaeletronico.usecase.domain.SaqueDomain;

@Component
public class SaqueDataProviderDomainMapper {
	
	public SaqueDomain toSaqueDomain(SaqueEntity saqueEntity) {
		
		SaqueDomain saqueDomain = new SaqueDomain();
		
		saqueDomain.setSaldo(saqueEntity.getSaldo());
		saqueDomain.setConta(saqueEntity.getConta());
		saqueDomain.setLimite(saqueEntity.getLimite());
		saqueDomain.setTipoConta(saqueEntity.getTipoConta());
		saqueDomain.setValorSaque(saqueEntity.getValorSaque());
		saqueDomain.setAgencia(saqueEntity.getAgencia());
		
		return saqueDomain;
	}
}