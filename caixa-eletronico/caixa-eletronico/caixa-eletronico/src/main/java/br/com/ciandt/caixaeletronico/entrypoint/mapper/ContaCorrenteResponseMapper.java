package br.com.ciandt.caixaeletronico.entrypoint.mapper;

import org.springframework.stereotype.Component;

import br.com.ciandt.caixaeletronico.entrypoint.model.response.ContaCorrenteResponse;
import br.com.ciandt.caixaeletronico.usecase.domain.SaldoDomain;

@Component
public class ContaCorrenteResponseMapper {
	
	public ContaCorrenteResponse toCorrenteResponse(SaldoDomain saldoDomain) {
		
		ContaCorrenteResponse contaCorrenteResponse = new ContaCorrenteResponse();
		contaCorrenteResponse.setDataTransacao(saldoDomain.getDataTransacao());
		contaCorrenteResponse.setLimite(saldoDomain.getLimite());
		contaCorrenteResponse.setSaldo(saldoDomain.getSaldo());
		
		return contaCorrenteResponse;
	}
}