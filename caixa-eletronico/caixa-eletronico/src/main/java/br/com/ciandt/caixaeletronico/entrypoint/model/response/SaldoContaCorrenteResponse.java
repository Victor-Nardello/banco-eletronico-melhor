package br.com.ciandt.caixaeletronico.entrypoint.model.response;

import java.math.BigDecimal;

public class SaldoContaCorrenteResponse extends SaldoResponse {
	
	private BigDecimal saldo;
	private BigDecimal limite;
	
	public BigDecimal getSaldo() {return saldo;}
	
	public void setSaldo(BigDecimal saldo) {this.saldo = saldo;}
	
	public BigDecimal getLimite() {return limite;}
	
	public void setLimite(BigDecimal limite) {this.limite = limite;}
}
