package br.com.ciandt.caixaeletronico.dataprovider.mapper;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.ciandt.caixaeletronico.entrypoint.mapper.ContaCorrenteResponseMapper;
import br.com.ciandt.caixaeletronico.entrypoint.model.response.ContaCorrenteResponse;
import br.com.ciandt.caixaeletronico.usecase.domain.SaldoDomain;

@RunWith(MockitoJUnitRunner.class)
public class ContaCorrenteResponseMapperTest {

	@InjectMocks
	ContaCorrenteResponseMapper contaCorrenteMapper;
	
	@Test
	public void testContaCorrenteResponseMapperComSucesso() {

		SaldoDomain saldoDomain = new SaldoDomain();
		
		saldoDomain.setSaldo(new BigDecimal(800.00));
		saldoDomain.setLimite(new BigDecimal(1000.00));
		saldoDomain.setDataTransacao(Date.from(LocalDate.of(2019, 03, 28).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		
		ContaCorrenteResponse resultadocontaCorrenteMapper = contaCorrenteMapper.toCorrenteResponse(saldoDomain);
		
		assertEquals(saldoDomain.getSaldo(), resultadocontaCorrenteMapper.getSaldo());
		assertEquals(saldoDomain.getLimite(), resultadocontaCorrenteMapper.getLimite());
		assertEquals(saldoDomain.getDataTransacao(), resultadocontaCorrenteMapper.getDataTransacao());
	}
}
