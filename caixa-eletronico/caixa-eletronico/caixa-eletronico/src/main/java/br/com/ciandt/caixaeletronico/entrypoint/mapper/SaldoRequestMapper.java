package br.com.ciandt.caixaeletronico.entrypoint.mapper;

import org.springframework.stereotype.Component;

import br.com.ciandt.caixaeletronico.entrypoint.model.request.SaldoRequest;

@Component
public class SaldoRequestMapper {
	
	public SaldoRequest toSaldoRequest(Integer agencia, Integer conta, String tipoConta) {
		
		SaldoRequest saldoRequest = new SaldoRequest();
		
		saldoRequest.setAgencia(String.valueOf(agencia));
		saldoRequest.setConta(String.valueOf(conta));
		saldoRequest.setTipoConta(tipoConta);
		
		return saldoRequest;
	}
}