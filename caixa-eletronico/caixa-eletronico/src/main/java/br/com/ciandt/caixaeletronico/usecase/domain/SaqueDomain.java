package br.com.ciandt.caixaeletronico.usecase.domain;

import java.math.BigDecimal;
import java.util.Date;

public class SaqueDomain {
	
	private String agencia;
	private String conta;
	private String tipoConta;
	private BigDecimal saldo;
	private BigDecimal limite;
	private Date dataTransacao;
	private BigDecimal valorSaque;
	
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
	public String getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}
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
	public Date getDataTransacao() {
		return dataTransacao;
	}
	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}
	public BigDecimal getValorSaque() {
		return valorSaque;
	}
	public void setValorSaque(BigDecimal valorSaque) {
		this.valorSaque = valorSaque;
	}
}