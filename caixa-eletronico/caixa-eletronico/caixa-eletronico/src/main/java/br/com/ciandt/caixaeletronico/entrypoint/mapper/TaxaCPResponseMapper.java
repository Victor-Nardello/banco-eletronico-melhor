package br.com.ciandt.caixaeletronico.entrypoint.mapper;

import org.springframework.stereotype.Component;

import br.com.ciandt.caixaeletronico.entrypoint.model.response.TaxaJurosCPResponse;
import br.com.ciandt.caixaeletronico.usecase.domain.TaxaDomain;

@Component
public class TaxaCPResponseMapper {
	
	public TaxaJurosCPResponse toTaxaCPResponse(TaxaDomain taxaDomain) {

		TaxaJurosCPResponse taxaJurosCPResponse = new TaxaJurosCPResponse();
		taxaJurosCPResponse.setDataTransacao(taxaDomain.getDataTransacao());
		taxaJurosCPResponse.setDivida(taxaDomain.isDivida());
		taxaJurosCPResponse.setLimite(taxaDomain.getLimite());
		taxaJurosCPResponse.setSaldo(taxaDomain.getSaldo());
		taxaJurosCPResponse.setTaxaJuros(taxaDomain.getTaxaJuros());
		taxaJurosCPResponse.setTaxaJuros(taxaDomain.getSaldoJurosCalculado());

		return taxaJurosCPResponse;
	}
}