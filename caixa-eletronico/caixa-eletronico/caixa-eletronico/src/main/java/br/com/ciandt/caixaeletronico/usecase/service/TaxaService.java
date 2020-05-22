package br.com.ciandt.caixaeletronico.usecase.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ciandt.caixaeletronico.dataprovider.implementation.TaxaJurosImplementation;
import br.com.ciandt.caixaeletronico.usecase.domain.TaxaDomain;

@Service
public class TaxaService {
	
	@Autowired
	TaxaJurosImplementation taxaJurosImplementation;
	
	public TaxaDomain getTaxaJuros(String taxaJuros) {
		
		if(taxaJuros.equals("CC") && taxaJuros.equals(new BigDecimal(1111))) {
			return taxaJurosImplementation.getTaxaJurosCC15();
		}else if(taxaJuros.equals("CC") && taxaJuros.equals(new BigDecimal(2222))) {
			return taxaJurosImplementation.getTaxaJurosCC10();
		}else if(taxaJuros.equals("CC") && !taxaJuros.equals(new BigDecimal(1111)) && !taxaJuros.equals(new BigDecimal(2222))) {
			return taxaJurosImplementation.getTaxaJurosCC20();
		}
		
		if(taxaJuros.equals("CP") && taxaJuros.equals(new BigDecimal(1111))) {
			return taxaJurosImplementation.getTaxaJurosCP5();
		}else if(taxaJuros.equals("CP") && taxaJuros.equals(new BigDecimal(2222))) {
			return taxaJurosImplementation.getTaxaJurosCP3();
		}else if(taxaJuros.equals("CP") && taxaJuros.equals(new BigDecimal(1111)) && taxaJuros.equals(new BigDecimal(2222))) {
			return taxaJurosImplementation.getTaxaJurosCP8();
		}
		return null;
	}
}