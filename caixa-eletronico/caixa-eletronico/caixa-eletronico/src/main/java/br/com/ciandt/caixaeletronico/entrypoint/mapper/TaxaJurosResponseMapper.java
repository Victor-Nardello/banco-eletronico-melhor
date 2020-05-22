package br.com.ciandt.caixaeletronico.entrypoint.mapper;

import org.springframework.stereotype.Component;

import br.com.ciandt.caixaeletronico.entrypoint.model.response.TaxaJurosCCResponse;
import br.com.ciandt.caixaeletronico.entrypoint.model.response.TaxaJurosCPResponse;
import br.com.ciandt.caixaeletronico.entrypoint.model.response.TaxaJurosResponse;
import br.com.ciandt.caixaeletronico.usecase.domain.TaxaDomain;
import br.com.ciandt.caixaeletronico.usecase.domain.TaxaJurosCCDomain;
import br.com.ciandt.caixaeletronico.usecase.domain.TaxaJurosCPDomain;

@Component
public class TaxaJurosResponseMapper {
	
	public TaxaJurosResponse toTaxaJurosResponse(TaxaDomain taxaDomain) {
		
		if(taxaDomain instanceof TaxaJurosCCDomain) {
			
			TaxaJurosCCResponse taxaJurosCCResponse = new TaxaJurosCCResponse();
			taxaJurosCCResponse.setDataTransacao(taxaDomain.getDataTransacao());
			taxaJurosCCResponse.setDivida(taxaDomain.isDivida());
			taxaJurosCCResponse.setLimite(taxaDomain.getLimite());
			taxaJurosCCResponse.setSaldo(taxaDomain.getSaldo());
			taxaJurosCCResponse.setTaxaJuros(taxaDomain.getTaxaJuros());
			
			return taxaJurosCCResponse;
		}
		
		if(taxaDomain instanceof TaxaJurosCPDomain) {
			
			TaxaJurosCPResponse taxaJurosCPResponse = new TaxaJurosCPResponse();
			taxaJurosCPResponse.setDataTransacao(taxaDomain.getDataTransacao());
			taxaJurosCPResponse.setDivida(taxaDomain.isDivida());
			taxaJurosCPResponse.setLimite(taxaDomain.getLimite());
			taxaJurosCPResponse.setSaldo(taxaDomain.getSaldo());
			taxaJurosCPResponse.setTaxaJuros(taxaDomain.getTaxaJuros());
			
			return taxaJurosCPResponse;
		}
		
		return null;
	}
}