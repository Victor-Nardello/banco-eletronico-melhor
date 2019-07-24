package br.com.ciandt.caixaeletronico.entrypoint.mapper;

import org.springframework.stereotype.Component;

import br.com.ciandt.caixaeletronico.entrypoint.model.response.ContaPoupancaResponse;
import br.com.ciandt.caixaeletronico.usecase.domain.SaldoDomain;

@Component
public class ContaPoupancaResponseMapper {
	
	public ContaPoupancaResponse toResponse(SaldoDomain saldoDomain) {
		
		ContaPoupancaResponse contaPoupancaResponse = new ContaPoupancaResponse();
		
		contaPoupancaResponse.setDataTransacao(saldoDomain.getDataTransacao());
		contaPoupancaResponse.setSaldo(saldoDomain.getSaldo());
		
		return contaPoupancaResponse;
	}
}