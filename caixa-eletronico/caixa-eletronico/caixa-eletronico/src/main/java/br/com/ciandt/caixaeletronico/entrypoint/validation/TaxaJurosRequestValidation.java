package br.com.ciandt.caixaeletronico.entrypoint.validation;

import java.math.BigDecimal;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class TaxaJurosRequestValidation {

	public void validar(Integer agencia, Integer conta, String tipoConta, BigDecimal taxaJuros) throws Exception {
		
		if(agencia == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo agencia obrigatorio");
		}
		
		if (conta == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo conta obrigatorio");
		} 
		
		if (tipoConta.equals("")) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo tipo_conta obrigatorio");
		}
		
		if(taxaJuros == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo taxa_juros obrigatorio");
		}

		if (!"CC".equals(tipoConta) && !"CP".equals(tipoConta)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Campo tipo_conta invalido");
		}
	}
}