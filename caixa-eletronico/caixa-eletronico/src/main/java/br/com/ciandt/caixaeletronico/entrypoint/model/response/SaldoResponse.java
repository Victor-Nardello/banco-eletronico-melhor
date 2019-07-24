package br.com.ciandt.caixaeletronico.entrypoint.model.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SaldoResponse {
	
	@JsonFormat(shape = JsonFormat.Shape.OBJECT, pattern = "dd-MM-yyyy")
	private Date dataTransacao;

	public Date getDataTransacao() {return dataTransacao;}

	public void setDataTransacao(Date dataTransacao) {this.dataTransacao = dataTransacao;}
}