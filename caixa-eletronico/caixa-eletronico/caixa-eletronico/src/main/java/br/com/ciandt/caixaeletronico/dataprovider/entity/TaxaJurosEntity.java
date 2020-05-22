package br.com.ciandt.caixaeletronico.dataprovider.entity;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaxaJurosEntity {
	
	private String agencia;
	private String conta;
	private String tipoConta;
	private BigDecimal saldo;
	private BigDecimal limite;
	private boolean divida;
	private BigDecimal taxaJuros;
}