package br.com.ciandt.caixaeletronico.usecase.domain;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaldoDomain {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date dataTransacao;
	
	private String agencia;
	private String conta;
	private String tipoConta;
	private BigDecimal saldo;
	private BigDecimal limite;
}