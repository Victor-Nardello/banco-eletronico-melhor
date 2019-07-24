package br.com.ciandt.caixaeletronico.usecase.domain;

import java.math.BigDecimal;

public class SaldoContaPoupancaDomain extends SaldoDomain {
	
	private BigDecimal saldo;

	public BigDecimal getSaldo() {return saldo;}
	
	public void setSaldo(BigDecimal saldo) {this.saldo = saldo;}
}