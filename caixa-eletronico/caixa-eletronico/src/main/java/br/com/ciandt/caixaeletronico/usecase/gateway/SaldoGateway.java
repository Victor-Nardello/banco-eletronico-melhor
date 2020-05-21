package br.com.ciandt.caixaeletronico.usecase.gateway;

import org.springframework.web.server.ResponseStatusException;

import br.com.ciandt.caixaeletronico.usecase.domain.SaldoDomain;

public interface SaldoGateway {
	
	public SaldoDomain getSaldoContaCorrente();
	
	public SaldoDomain getSaldoContaPoupanca();

	boolean validaDividaTrue(boolean divida) throws ResponseStatusException;

	boolean validaDividaFalse(boolean divida) throws ResponseStatusException;

}