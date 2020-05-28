package br.com.ciandt.caixaeletronico.usecase.gateway;

import br.com.ciandt.caixaeletronico.usecase.domain.TaxaJurosCCDomain;

public interface TaxaGateway {

	TaxaJurosCCDomain getTaxaJuros(double taxaJuros);
}
