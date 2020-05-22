package br.com.ciandt.caixaeletronico.usecase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ciandt.caixaeletronico.usecase.domain.TaxaDomain;
import br.com.ciandt.caixaeletronico.usecase.gateway.TaxaGateway;

@Service
public class TaxaService {
	
	@Autowired
	TaxaGateway taxaGateway;
	
	public TaxaDomain getTaxaJuros(String tipoConta, String agencia) {
		
		if("CC".equals(tipoConta) && agencia.equals("1111")) {
			return taxaGateway.getTaxaJurosCC15();
		}else if("CC".equals(tipoConta) && agencia.equals("2222")) {
			return taxaGateway.getTaxaJurosCC10();
		}else if("CC".equals(tipoConta) && !agencia.equals("1111") && !agencia.equals("2222")) {
			return taxaGateway.getTaxaJurosCC20();
		}
		
		if("CP".equals(tipoConta) && agencia.equals("1111")) {
			return taxaGateway.getTaxaJurosCP5();
		}else if("CP".equals(tipoConta) && agencia.equals("2222")) {
			return taxaGateway.getTaxaJurosCP3();
		}else if("CP".equals(tipoConta) && !agencia.equals("1111") && !agencia.equals("2222")) {
			return taxaGateway.getTaxaJurosCP8();
		}
		return null;
	}
}