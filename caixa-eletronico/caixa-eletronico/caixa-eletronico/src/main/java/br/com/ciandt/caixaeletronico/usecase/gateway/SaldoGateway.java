package br.com.ciandt.caixaeletronico.usecase.gateway;

import br.com.ciandt.caixaeletronico.usecase.domain.SaldoDomain;

public interface SaldoGateway {
	
	public SaldoDomain getSaldoContaCorrente();
	
	public SaldoDomain getSaldoContaPoupanca();

}