package br.com.ciandt.caixaeletronico.usecase.domain;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaldoContaCorrenteDomain extends SaldoDomain {
	
	private BigDecimal saldo;
	private BigDecimal limite;
	private boolean divida;
}