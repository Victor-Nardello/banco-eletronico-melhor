package br.com.ciandt.caixaeletronico.dataprovider.entity;

import java.math.BigDecimal;

public class SaqueEntity {
	
	private String mensagem;
	private String operacao;
	private String agencia;
	private String conta;
	private String tipoConta;
	private BigDecimal saldo;
	private BigDecimal limite;
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
	public BigDecimal getValorSaque() {
		return valorSaque;
	}
	public void setValorSaque(BigDecimal valorSaque) {
		this.valorSaque = valorSaque;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
}
