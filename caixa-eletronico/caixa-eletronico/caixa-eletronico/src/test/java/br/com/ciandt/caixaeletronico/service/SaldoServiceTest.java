package br.com.ciandt.caixaeletronico.service;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import br.com.ciandt.caixaeletronico.dataprovider.implementation.SaldoImplementation;
import br.com.ciandt.caixaeletronico.dataprovider.mapper.SaldoDataProviderDomainMapper;
import br.com.ciandt.caixaeletronico.usecase.domain.SaldoContaCorrenteDomain;
import br.com.ciandt.caixaeletronico.usecase.domain.SaldoContaPoupancaDomain;
import br.com.ciandt.caixaeletronico.usecase.service.SaldoService;

@RunWith(SpringRunner.class)
public class SaldoServiceTest {
	
	@InjectMocks
	SaldoService saldoService;
	
	@Mock
	SaldoImplementation saldoImplementation;
	
	@Mock
	SaldoDataProviderDomainMapper saldoDataProviderDomainMapper;
	
	@Test
	public void testSaldoServiceCCComMock() {
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String dataFormatada = format.format(date);
		
		SaldoContaCorrenteDomain saldoContaCorrenteDomainMock = new SaldoContaCorrenteDomain();
		
		saldoContaCorrenteDomainMock.setSaldo(new BigDecimal(Math.random()));
		saldoContaCorrenteDomainMock.setLimite(new BigDecimal(1000.00));
		saldoContaCorrenteDomainMock.setDataTransacao(date);
		
		Mockito.when(saldoImplementation.getSaldoContaCorrente()).thenReturn(saldoContaCorrenteDomainMock);
		
		String tipoConta = "CC";
		
		SaldoContaCorrenteDomain saldoContaCorrenteDomainResult = (SaldoContaCorrenteDomain) saldoService.getSaldo(tipoConta);
		
		assertEquals(saldoContaCorrenteDomainMock.getSaldo().doubleValue(), 
				saldoContaCorrenteDomainResult.getSaldo().doubleValue(), 0.01);
		
		assertEquals(saldoContaCorrenteDomainMock.getLimite().doubleValue(), 
				saldoContaCorrenteDomainResult.getLimite().doubleValue(), 0.01);
		
		assertEquals(dataFormatada, format.format(saldoContaCorrenteDomainResult.getDataTransacao()));
	}
	
	@Test
	public void testSaldoServiceCPComMock() {
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String dataFormatada = format.format(date);
		
		SaldoContaPoupancaDomain saldoContaPoupancaDomain = new SaldoContaPoupancaDomain();
		
		saldoContaPoupancaDomain.setDataTransacao(date);
		saldoContaPoupancaDomain.setSaldo(new BigDecimal(Math.random()));
		
		Mockito.when(saldoImplementation.getSaldoContaPoupanca()).thenReturn(saldoContaPoupancaDomain);
		
		String tipoConta = "CP";
		
		SaldoContaPoupancaDomain saldoContaPoupancaDomainResult = (SaldoContaPoupancaDomain) saldoService.getSaldo(tipoConta);
		
		assertEquals(saldoContaPoupancaDomain.getSaldo().doubleValue(), 
				saldoContaPoupancaDomainResult.getSaldo().doubleValue(), 0.01);
		
		assertEquals(dataFormatada, format.format(saldoContaPoupancaDomainResult.getDataTransacao()));	
	}
}