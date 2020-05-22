package br.com.ciandt.caixaeletronico.dataprovider.implementation;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import br.com.ciandt.caixaeletronico.dataprovider.mapper.SaldoDataProviderDomainMapper;
import br.com.ciandt.caixaeletronico.usecase.domain.SaldoContaCorrenteDomain;
import br.com.ciandt.caixaeletronico.usecase.domain.SaldoContaPoupancaDomain;

@RunWith(MockitoJUnitRunner.class)
public class SaldoImplementationTest {

	@InjectMocks
	SaldoImplementation saldoImplementation;

	@Mock
	SaldoDataProviderDomainMapper saldoDataProviderDomainMapper;

	@Test
	public void testGetSaldoContaPoupancaSemMock() {
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String dataFormatada = format.format(date);
		
		Mockito.when(saldoDataProviderDomainMapper.toSaldoContaPoupancaDomain(Mockito.any())).thenCallRealMethod();
		
		SaldoContaPoupancaDomain saldoContaPoupancaDomainResult = (SaldoContaPoupancaDomain) saldoImplementation.getSaldoContaPoupanca();
		
		assertEquals(new BigDecimal(1000.00).doubleValue(), 
				saldoContaPoupancaDomainResult.getSaldo().doubleValue(), 0.01);
		
		assertEquals(dataFormatada, format.format(saldoContaPoupancaDomainResult.getDataTransacao()));
	}
	
	@Test
	public void testGetSaldoContaPoupancaComMock() {
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String dataFormatada = format.format(date);
		
		SaldoContaPoupancaDomain saldoContaPoupancaDomain = new SaldoContaPoupancaDomain();
		saldoContaPoupancaDomain.setDataTransacao(date);
		saldoContaPoupancaDomain.setSaldo(new BigDecimal(Math.random()));
		
		Mockito.when(saldoDataProviderDomainMapper.toSaldoContaPoupancaDomain(Mockito.any())).thenReturn(saldoContaPoupancaDomain);
		
		SaldoContaPoupancaDomain saldoContaPoupancaDomainResult = (SaldoContaPoupancaDomain) saldoImplementation.getSaldoContaPoupanca();
		
		assertEquals(saldoContaPoupancaDomain.getSaldo().doubleValue(), 
				saldoContaPoupancaDomainResult.getSaldo().doubleValue(), 0.01);
		
		assertEquals(dataFormatada, format.format(saldoContaPoupancaDomainResult.getDataTransacao()));
	}
	
	@Test
	public void testGetSaldoContaCorrenteSemMock() {
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String dataFormatada = format.format(date);
		
		Mockito.when(saldoDataProviderDomainMapper.toSaldoContaCorrenteDomain(Mockito.any())).thenCallRealMethod();
		
		SaldoContaCorrenteDomain saldoContaCorrenteDomainResult = (SaldoContaCorrenteDomain) saldoImplementation.getSaldoContaCorrente();
		
		assertEquals(new BigDecimal(3000.00).doubleValue(), 
				saldoContaCorrenteDomainResult.getSaldo().doubleValue(), 0.01);
		
		assertEquals(new BigDecimal(400.00).doubleValue(), 
				saldoContaCorrenteDomainResult.getLimite().doubleValue(), 0.01);
		
		assertEquals(dataFormatada, format.format(saldoContaCorrenteDomainResult.getDataTransacao()));
	}
	
	@Test
	public void testGetSaldoContaCorrenteComMock() {
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String dataFormatada = format.format(date);
		
		SaldoContaCorrenteDomain saldoContaCorrenteDomain = new SaldoContaCorrenteDomain();
		saldoContaCorrenteDomain.setSaldo(new BigDecimal(Math.random()));
		saldoContaCorrenteDomain.setLimite(new BigDecimal(400.00));
		saldoContaCorrenteDomain.setDataTransacao(date);
		
		Mockito.when(saldoDataProviderDomainMapper.toSaldoContaCorrenteDomain(Mockito.any()))
				.thenReturn(saldoContaCorrenteDomain);
		
		SaldoContaCorrenteDomain saldoContaCorrenteDomainResult = (SaldoContaCorrenteDomain) saldoImplementation.getSaldoContaCorrente();
		
		assertEquals(saldoContaCorrenteDomain.getSaldo().doubleValue(), 
				saldoContaCorrenteDomainResult.getSaldo().doubleValue(), 0.01);
		
		assertEquals(saldoContaCorrenteDomain.getLimite().doubleValue(),
				saldoContaCorrenteDomainResult.getLimite().doubleValue(), 0.01);
		
		assertEquals(dataFormatada, format.format(saldoContaCorrenteDomainResult.getDataTransacao()));
	}
}