package br.com.ciandt.caixaeletronico.dataprovider.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class SaldoEntity {
	
	private String agencia;
	private String conta;
	private String tipoConta;
	private BigDecimal saldo;
	private BigDecimal limite;
	
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
}