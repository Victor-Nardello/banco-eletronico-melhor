package br.com.ciandt.caixaeletronico.entrypoint.mapper;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import br.com.ciandt.caixaeletronico.entrypoint.model.request.TaxaRequest;

@Component
public class TaxaJurosRequestMapper {
	
	public TaxaRequest requestMapper(Integer agencia, Integer conta, String tipoConta, BigDecimal taxaJuros) {
		
		TaxaRequest taxaRequest = new TaxaRequest();
		taxaRequest.setAgencia(String.valueOf(agencia));
		taxaRequest.setConta(String.valueOf(conta));
		taxaRequest.setTipoConta(String.valueOf(tipoConta));
		taxaRequest.setTaxaJuros(String.valueOf(taxaJuros));
		
		return taxaRequest;
	}
}