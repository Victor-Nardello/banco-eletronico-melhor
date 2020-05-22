package br.com.ciandt.caixaeletronico.usecase.gateway;

import br.com.ciandt.caixaeletronico.usecase.domain.TaxaJurosCCDomain;
import br.com.ciandt.caixaeletronico.usecase.domain.TaxaJurosCPDomain;

public interface TaxaGateway {

	TaxaJurosCCDomain getTaxaJurosCC15();

	TaxaJurosCPDomain getTaxaJurosCP8();

	TaxaJurosCPDomain getTaxaJurosCP3();

	TaxaJurosCPDomain getTaxaJurosCP5();

	TaxaJurosCCDomain getTaxaJurosCC20();

	TaxaJurosCCDomain getTaxaJurosCC10();
}
