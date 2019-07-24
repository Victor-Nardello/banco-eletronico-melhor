package br.com.ciandt.caixaeletronico.dataprovider.mapper;

import java.util.Date;

import org.springframework.stereotype.Component;

import br.com.ciandt.caixaeletronico.dataprovider.entity.SaldoEntity;
import br.com.ciandt.caixaeletronico.usecase.domain.SaldoContaCorrenteDomain;
import br.com.ciandt.caixaeletronico.usecase.domain.SaldoContaPoupancaDomain;

@Component
public class SaldoDataProviderDomainMapper {
	
	public SaldoContaCorrenteDomain toSaldoContaCorrenteDomain(SaldoEntity saldoEntity) {
		
		SaldoContaCorrenteDomain saldoContaCorrenteDomain = new SaldoContaCorrenteDomain();
		
		saldoContaCorrenteDomain.setLimite(saldoEntity.getLimite());
		saldoContaCorrenteDomain.setSaldo(saldoEntity.getSaldo());
		saldoContaCorrenteDomain.setDataTransacao(new Date());
		
		return saldoContaCorrenteDomain;
	}
	
	public SaldoContaPoupancaDomain toSaldoContaPoupancaDomain(SaldoEntity saldoEntity) {
		
		SaldoContaPoupancaDomain saldoContaPoupancaDomain = new SaldoContaPoupancaDomain();
		
		saldoContaPoupancaDomain.setSaldo(saldoEntity.getSaldo());
		saldoContaPoupancaDomain.setDataTransacao(new Date());
		
		return saldoContaPoupancaDomain;
	}
}