package br.com.ciandt.caixaeletronico.service.mapper;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import br.com.ciandt.caixaeletronico.entrypoint.mapper.SaldoRequestMapper;
import br.com.ciandt.caixaeletronico.entrypoint.model.request.SaldoRequest;

@RunWith(MockitoJUnitRunner.class)
public class SaldoRequestMapperTest {

	@InjectMocks
	SaldoRequestMapper saldoRequestMapper;
	
	@Test
	public void testSaldoRequestMapper() {
		
		Integer agencia = 1234;
		Integer conta = 123456;
		String tipoConta = "CC";
		
		SaldoRequest saldoRequest = saldoRequestMapper.toSaldoRequest(agencia, conta, tipoConta);
		
		saldoRequest.setAgencia("1234");
		saldoRequest.setConta("123456");
		saldoRequest.setTipoConta("CC");
		
		assertEquals("1234", saldoRequest.getAgencia());
		assertEquals("123456", saldoRequest.getConta());
		assertEquals("CC", saldoRequest.getTipoConta());
		
		
	}
}