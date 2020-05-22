package br.com.ciandt.caixaeletronico.entrypoint.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaldoRequest {
	
	private String agencia;
	private String conta;
	private String tipoConta;
}