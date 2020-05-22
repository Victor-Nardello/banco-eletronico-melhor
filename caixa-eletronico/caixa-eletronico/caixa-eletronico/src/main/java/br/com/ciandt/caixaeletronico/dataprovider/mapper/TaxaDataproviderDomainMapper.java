package br.com.ciandt.caixaeletronico.dataprovider.mapper;

import java.util.Date;

import org.springframework.stereotype.Component;

import br.com.ciandt.caixaeletronico.dataprovider.entity.TaxaJurosEntity;
import br.com.ciandt.caixaeletronico.usecase.domain.TaxaJurosCCDomain;
import br.com.ciandt.caixaeletronico.usecase.domain.TaxaJurosCPDomain;

@Component
public class TaxaDataproviderDomainMapper{

	public TaxaJurosCCDomain getTaxaJurosCC(TaxaJurosEntity taxaJurosEntity) {

		TaxaJurosCCDomain taxaJurosCCDomain = new TaxaJurosCCDomain();
		taxaJurosCCDomain.setDataTransacao(new Date());
		taxaJurosCCDomain.setLimite(taxaJurosEntity.getLimite());
		taxaJurosCCDomain.setSaldo(taxaJurosEntity.getSaldo());
		taxaJurosCCDomain.setDivida(taxaJurosEntity.isDivida());
		taxaJurosCCDomain.setTaxaJuros(taxaJurosEntity.getTaxaJuros());

		return taxaJurosCCDomain;
	}

	public TaxaJurosCPDomain getTaxaJurosCP(TaxaJurosEntity taxaJurosEntity) {

		TaxaJurosCPDomain taxaJurosCPDomain = new TaxaJurosCPDomain();
		taxaJurosCPDomain.setDataTransacao(new Date());
		taxaJurosCPDomain.setLimite(taxaJurosEntity.getLimite());
		taxaJurosCPDomain.setSaldo(taxaJurosEntity.getSaldo());
		taxaJurosCPDomain.setDivida(taxaJurosEntity.isDivida());
		taxaJurosCPDomain.setTaxaJuros(taxaJurosEntity.getTaxaJuros());

		return taxaJurosCPDomain;
	}
}