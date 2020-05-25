package br.com.ciandt.caixaeletronico.usecase.domain;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaxaJurosCCDomain extends TaxaDomain{
	
	private BigDecimal saldo;
	private BigDecimal limite;
	private boolean divida;
	private BigDecimal taxaJuros;
	private BigDecimal saldoJurosCalculado;
}
