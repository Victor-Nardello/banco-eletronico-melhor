package br.com.ciandt.caixaeletronico.entrypoint.mapper;

import org.springframework.stereotype.Component;

import br.com.ciandt.caixaeletronico.entrypoint.model.response.TaxaJurosCCResponse;
import br.com.ciandt.caixaeletronico.usecase.domain.TaxaDomain;

@Component
public class TaxaCCResponseMapper {

	public TaxaJurosCCResponse toTaxaCCResponse(TaxaDomain taxaDomain) {

		TaxaJurosCCResponse taxaJurosCCResponse = new TaxaJurosCCResponse();
		taxaJurosCCResponse.setDataTransacao(taxaDomain.getDataTransacao());
		taxaJurosCCResponse.setDivida(taxaDomain.isDivida());
		taxaJurosCCResponse.setLimite(taxaDomain.getLimite());
		taxaJurosCCResponse.setSaldo(taxaDomain.getSaldo());
		taxaJurosCCResponse.setTaxaJuros(taxaDomain.getTaxaJuros());
		taxaJurosCCResponse.setSaldoJurosCalculado(taxaDomain.getSaldoJurosCalculado());

		return taxaJurosCCResponse;
	}
}