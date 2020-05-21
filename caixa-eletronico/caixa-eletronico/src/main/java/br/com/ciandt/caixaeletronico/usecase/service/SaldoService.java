package br.com.ciandt.caixaeletronico.usecase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ciandt.caixaeletronico.usecase.domain.SaldoDomain;
import br.com.ciandt.caixaeletronico.usecase.gateway.SaldoGateway;

@Service
public class SaldoService {
	
	@Autowired
	SaldoGateway saldoGateway;
	
	public SaldoDomain getSaldo(String tipoConta) {
		
		if (tipoConta.equals("CC")) {
			return saldoGateway.getSaldoContaCorrente();
			
		} else if (tipoConta.equals("CP")) {
			return saldoGateway.getSaldoContaPoupanca();	
		}
		
		return null;
	}
	
	public boolean validaDivida(boolean divida) throws Exception{
		
		if(divida == true) {
			return saldoGateway.validaDividaTrue(divida);
		}else if(divida == false) {
			return saldoGateway.validaDividaFalse(divida);
		}
		
		return false;
	}
}