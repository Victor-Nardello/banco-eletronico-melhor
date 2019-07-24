package br.com.ciandt.caixaeletronico.entrypoint.model.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SaqueResponse {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataTransacao;

	public Date getDataTransacao() {
		return dataTransacao;
	}

	public void setDataTransacao(Date dataTransacao) {
		this.dataTransacao = dataTransacao;
	}

}
