package br.com.ciandt.caixaeletronico.entrypoint.model.response;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaxaJurosCPResponse extends TaxaJurosResponse {

	private BigDecimal saldo;
	private BigDecimal limite;
	private boolean divida;
	private BigDecimal taxaJuros;
}