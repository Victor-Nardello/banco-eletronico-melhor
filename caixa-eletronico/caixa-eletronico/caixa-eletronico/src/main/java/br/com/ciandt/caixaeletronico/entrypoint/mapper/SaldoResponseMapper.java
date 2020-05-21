package br.com.ciandt.caixaeletronico.entrypoint.mapper;

import org.springframework.stereotype.Component;

import br.com.ciandt.caixaeletronico.entrypoint.model.response.SaldoContaCorrenteResponse;
import br.com.ciandt.caixaeletronico.entrypoint.model.response.SaldoContaPoupancaResponse;
import br.com.ciandt.caixaeletronico.entrypoint.model.response.SaldoResponse;
import br.com.ciandt.caixaeletronico.usecase.domain.SaldoContaCorrenteDomain;
import br.com.ciandt.caixaeletronico.usecase.domain.SaldoContaPoupancaDomain;
import br.com.ciandt.caixaeletronico.usecase.domain.SaldoDomain;

@Component
public class SaldoResponseMapper {
	
	public SaldoResponse toSaldoResponse(SaldoDomain saldoDomain) {
		
		if (saldoDomain instanceof SaldoContaCorrenteDomain) {
			SaldoContaCorrenteResponse saldoContaCorrenteResponse = new SaldoContaCorrenteResponse();
			
			saldoContaCorrenteResponse.setSaldo(((SaldoContaCorrenteDomain)saldoDomain).getSaldo());
			saldoContaCorrenteResponse.setLimite(((SaldoContaCorrenteDomain)saldoDomain).getLimite());
			saldoContaCorrenteResponse.setDataTransacao(((SaldoContaCorrenteDomain)saldoDomain).getDataTransacao());
			saldoContaCorrenteResponse.setDivida(((SaldoContaCorrenteDomain) saldoDomain).isDivida());
			
			return saldoContaCorrenteResponse;
		}
		
		if(saldoDomain instanceof SaldoContaPoupancaDomain) {
			SaldoContaPoupancaResponse saldoContaPoupancaResponse = new SaldoContaPoupancaResponse();
			
			saldoContaPoupancaResponse.setSaldo(((SaldoContaPoupancaDomain)saldoDomain).getSaldo());
			saldoContaPoupancaResponse.setDataTransacao(((SaldoContaPoupancaDomain)saldoDomain).getDataTransacao());
			
			return saldoContaPoupancaResponse;
		}
		
		return null;
	}
}