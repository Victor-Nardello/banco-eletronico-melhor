package br.com.ciandt.caixaeletronico.dataprovider.implementation;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ciandt.caixaeletronico.dataprovider.entity.TaxaJurosEntity;
import br.com.ciandt.caixaeletronico.dataprovider.mapper.TaxaDataproviderDomainMapper;
import br.com.ciandt.caixaeletronico.usecase.domain.TaxaJurosCCDomain;
import br.com.ciandt.caixaeletronico.usecase.domain.TaxaJurosCPDomain;

@Component
public class TaxaJurosImplementation {

	@Autowired
	TaxaDataproviderDomainMapper taxaDataproviderDomainMapper;

	public TaxaJurosCCDomain getTaxaJurosCC15() {

		TaxaJurosEntity taxaJurosEntity = new TaxaJurosEntity();
		taxaJurosEntity.setAgencia("1234");
		taxaJurosEntity.setConta("CC");
		taxaJurosEntity.setSaldo(new BigDecimal(Math.floor(Math.random() * 99 - 1) + -999));
		taxaJurosEntity.setLimite(new BigDecimal(6000));
		taxaJurosEntity.setTaxaJuros(new BigDecimal(15));

		return taxaDataproviderDomainMapper.getTaxaJurosCC(taxaJurosEntity);
	}
	
	public TaxaJurosCCDomain getTaxaJurosCC10() {

		TaxaJurosEntity taxaJurosEntity = new TaxaJurosEntity();
		taxaJurosEntity.setAgencia("1234");
		taxaJurosEntity.setConta("CC");
		taxaJurosEntity.setSaldo(new BigDecimal(Math.floor(Math.random() * 99 - 1) + -999));
		taxaJurosEntity.setLimite(new BigDecimal(13000));
		taxaJurosEntity.setTaxaJuros(new BigDecimal(10));

		return taxaDataproviderDomainMapper.getTaxaJurosCC(taxaJurosEntity);
	}
	
	public TaxaJurosCCDomain getTaxaJurosCC20() {

		TaxaJurosEntity taxaJurosEntity = new TaxaJurosEntity();
		taxaJurosEntity.setAgencia("1234");
		taxaJurosEntity.setConta("CC");
		taxaJurosEntity.setSaldo(new BigDecimal(Math.floor(Math.random() * 99 - 1) + -999));
		taxaJurosEntity.setLimite(new BigDecimal(8000));
		taxaJurosEntity.setTaxaJuros(new BigDecimal(20));

		return taxaDataproviderDomainMapper.getTaxaJurosCC(taxaJurosEntity);
	}

	public TaxaJurosCPDomain getTaxaJurosCP5() {

		TaxaJurosEntity taxaJurosEntity = new TaxaJurosEntity();
		taxaJurosEntity.setAgencia("1234");
		taxaJurosEntity.setConta("CP");
		taxaJurosEntity.setSaldo(new BigDecimal(Math.floor(Math.random() * 99 - 1) + -999));
		taxaJurosEntity.setLimite(new BigDecimal(12000));
		taxaJurosEntity.setTaxaJuros(new BigDecimal(5));

		return taxaDataproviderDomainMapper.getTaxaJurosCP(taxaJurosEntity);
	}
	
	public TaxaJurosCPDomain getTaxaJurosCP3() {

		TaxaJurosEntity taxaJurosEntity = new TaxaJurosEntity();
		taxaJurosEntity.setAgencia("1234");
		taxaJurosEntity.setConta("CP");
		taxaJurosEntity.setSaldo(new BigDecimal(Math.floor(Math.random() * 99 - 1) + -999));
		taxaJurosEntity.setLimite(new BigDecimal(4000));
		taxaJurosEntity.setTaxaJuros(new BigDecimal(3));

		return taxaDataproviderDomainMapper.getTaxaJurosCP(taxaJurosEntity);
	}
	
	public TaxaJurosCPDomain getTaxaJurosCP8() {

		TaxaJurosEntity taxaJurosEntity = new TaxaJurosEntity();
		taxaJurosEntity.setAgencia("1234");
		taxaJurosEntity.setConta("CP");
		taxaJurosEntity.setSaldo(new BigDecimal(Math.floor(Math.random() * 99 - 1) + -999));
		taxaJurosEntity.setLimite(new BigDecimal(6700));
		taxaJurosEntity.setTaxaJuros(new BigDecimal(8));

		return taxaDataproviderDomainMapper.getTaxaJurosCP(taxaJurosEntity);
	}
}