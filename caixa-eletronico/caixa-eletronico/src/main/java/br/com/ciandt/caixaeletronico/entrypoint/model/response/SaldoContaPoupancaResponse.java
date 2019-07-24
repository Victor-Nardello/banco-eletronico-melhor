package br.com.ciandt.caixaeletronico.entrypoint.model.response;

import java.math.BigDecimal;

public class SaldoContaPoupancaResponse extends SaldoResponse {
	
	private BigDecimal saldo;

	public BigDecimal getSaldo() {return saldo;}
	
	public void setSaldo(BigDecimal saldo) {this.saldo = saldo;}
}