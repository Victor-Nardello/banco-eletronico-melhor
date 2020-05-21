package br.com.ciandt.caixaeletronico.entrypoint.model.response;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaPoupancaResponse extends SaldoResponse {
	
	private BigDecimal saldo;
}