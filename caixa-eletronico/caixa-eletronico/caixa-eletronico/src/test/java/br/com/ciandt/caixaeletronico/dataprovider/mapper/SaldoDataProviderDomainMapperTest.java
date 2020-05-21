package br.com.ciandt.caixaeletronico.dataprovider.mapper;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import br.com.ciandt.caixaeletronico.dataprovider.entity.SaldoEntity;
import br.com.ciandt.caixaeletronico.usecase.domain.SaldoContaCorrenteDomain;

@RunWith(MockitoJUnitRunner.class)
public class SaldoDataProviderDomainMapperTest {
	
	@InjectMocks
	private SaldoDataProviderDomainMapper saldoDataProviderDomainMapper;
	
	@Test
	public void testSaldoDataProviderDomainMapper() {
		
		SaldoEntity saldoEntity = new SaldoEntity();;
		
		saldoEntity.setAgencia("4321");
		saldoEntity.setConta("123456");
		saldoEntity.setTipoConta("1");	
		saldoEntity.setSaldo(new BigDecimal(Math.random()));
		saldoEntity.setLimite(new BigDecimal(1000.00));
		
		SaldoContaCorrenteDomain saldoContaCorrenteDomain = saldoDataProviderDomainMapper.toSaldoContaCorrenteDomain(saldoEntity);
		
		assertEquals(saldoEntity.getSaldo().doubleValue(), 
				saldoContaCorrenteDomain.getSaldo().doubleValue(), 0.1);
		
		assertEquals(saldoEntity.getLimite().doubleValue(), 
				saldoContaCorrenteDomain.getLimite().doubleValue(), 0.1);
	}
}