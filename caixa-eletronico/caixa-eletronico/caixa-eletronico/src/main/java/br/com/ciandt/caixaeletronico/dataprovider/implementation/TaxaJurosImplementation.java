package br.com.ciandt.caixaeletronico.dataprovider.implementation;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ciandt.caixaeletronico.dataprovider.entity.TaxaJurosEntity;
import br.com.ciandt.caixaeletronico.dataprovider.mapper.TaxaDataproviderDomainMapper;
import br.com.ciandt.caixaeletronico.usecase.domain.TaxaJurosCCDomain;
import br.com.ciandt.caixaeletronico.usecase.gateway.TaxaGateway;

@Component
public class TaxaJurosImplementation implements TaxaGateway {

	@Autowired
	TaxaDataproviderDomainMapper taxaDataproviderDomainMapper;
	
	@Override
	public TaxaJurosCCDomain getTaxaJuros(double taxaJuros) {

		TaxaJurosEntity taxaJurosEntity = new TaxaJurosEntity();
		taxaJurosEntity.setAgencia("1234");
		taxaJurosEntity.setConta("CC");
		taxaJurosEntity.setSaldo(new BigDecimal(Math.floor(Math.random()*9999 - 1) + -999));
		taxaJurosEntity.setLimite(new BigDecimal(6000));
		taxaJurosEntity.setTaxaJuros(new BigDecimal(15));
		
		double saldo = taxaJurosEntity.getSaldo().doubleValue();
		taxaJurosEntity.setSaldoJurosCalculado(new BigDecimal(Math.floor(saldo + (saldo * taxaJuros) / 100)));

		return taxaDataproviderDomainMapper.getTaxaJurosCC(taxaJurosEntity);
	}
}