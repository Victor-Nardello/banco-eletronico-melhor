package br.com.ciandt.caixaeletronico.entrypoint.model.request;

public class SaqueRequest {
	
	private String agencia;
	private String conta;
	private String tipoConta;
	private String valorSaque;
	
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
	public String getValorSaque() {
		return valorSaque;
	}
	public void setValorSaque(String valorSaque) {
		this.valorSaque = valorSaque;
	}
}