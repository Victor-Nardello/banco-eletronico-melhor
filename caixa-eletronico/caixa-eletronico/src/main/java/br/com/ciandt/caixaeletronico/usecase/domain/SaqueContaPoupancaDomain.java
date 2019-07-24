package br.com.ciandt.caixaeletronico.usecase.domain;

import java.math.BigDecimal;

public class SaqueContaPoupancaDomain extends SaqueDomain {

	private BigDecimal saldo;
	private BigDecimal limite;
	private BigDecimal valorSaque;
	private String agencia;
	private String conta;
	
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	public BigDecimal getLimite() {
		return limite;
	}
	public void setLimite(BigDecimal limite) {
		this.limite = limite;
	}
	public BigDecimal getValorSaque() {
		return valorSaque;
	}
	public void setValorSaque(BigDecimal valorSaque) {
		this.valorSaque = valorSaque;
	}
	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
}