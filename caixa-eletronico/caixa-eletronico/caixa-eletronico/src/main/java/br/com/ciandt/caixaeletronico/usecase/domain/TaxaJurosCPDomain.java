package br.com.ciandt.caixaeletronico.usecase.domain;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaxaJurosCPDomain extends TaxaDomain{
	
	private BigDecimal saldo;
	private BigDecimal taxaJuros;
}