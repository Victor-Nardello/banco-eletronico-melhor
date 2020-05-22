package br.com.ciandt.caixaeletronico.dataprovider.implementation;

import java.math.BigDecimal;

import br.com.ciandt.caixaeletronico.usecase.domain.TaxaJurosCCDomain;

public class TaxaJurosImplementation {
	
	public TaxaJurosCCDomain getTaxaJurosCC() {
		
		TaxaJurosCCDomain taxaJurosCCDomain = new TaxaJurosCCDomain();
		taxaJurosCCDomain.setAgencia("1234");
		taxaJurosCCDomain.setConta("CC");
		taxaJurosCCDomain.setSaldo(new BigDecimal(Math.floor(Math.random()*99 - 1) + -999));
		taxaJurosCCDomain.setLimite(new BigDecimal(6000));
		
		return taxaJurosCCDomain;
	}
}