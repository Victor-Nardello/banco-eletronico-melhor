package br.com.ciandt.caixaeletronico.usecase.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SaldoDomain {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataTransacao;
	
	private String agencia;
	private String conta;
	private String tipoConta;
	private BigDecimal saldo;
	private BigDecimal limite;
	
	public String getAgencia() {return agencia;}
	
	public void setAgencia(String agencia) {this.agencia = agencia;}
	
	public String getConta() {return conta;}
	
	public void setConta(String conta) {this.conta = conta;}
	
	public String getTipoConta() {return tipoConta;}
	
	public void setTipoConta(String tipoConta) {this.tipoConta = tipoConta;}
	
	public BigDecimal getSaldo() {return saldo;}
	
	public void setSaldo(BigDecimal saldo) {this.saldo = saldo;}
	
	public BigDecimal getLimite() {return limite;}
	
	public void setLimite(BigDecimal limite) {this.limite = limite;}
}