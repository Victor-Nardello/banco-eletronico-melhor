package br.com.ciandt.caixaeletronico.usecase.domain;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaldoContaPoupancaDomain extends SaldoDomain {
	
	private BigDecimal saldo;
}