package br.com.ciandt.caixaeletronico.usecase.domain;

import java.math.BigDecimal;

public class SaqueContaPoupancaDomain extends SaqueDomain {

	private BigDecimal saldo;
	private BigDecimal valorSaque;
	
	public BigDecimal getValorSaque() {return valorSaque;}
	
	public void setValorSaque(BigDecimal valorSaque) {this.valorSaque = valorSaque;}
	
	public BigDecimal getSaldo() {return saldo;}
	
	public void setSaldo(BigDecimal saldo) {this.saldo = saldo;}
}