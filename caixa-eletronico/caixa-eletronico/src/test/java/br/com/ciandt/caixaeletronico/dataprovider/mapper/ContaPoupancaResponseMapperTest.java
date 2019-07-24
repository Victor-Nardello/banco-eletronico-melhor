package br.com.ciandt.caixaeletronico.dataprovider.mapper;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.ciandt.caixaeletronico.entrypoint.mapper.ContaPoupancaResponseMapper;
import br.com.ciandt.caixaeletronico.entrypoint.model.response.ContaPoupancaResponse;
import br.com.ciandt.caixaeletronico.usecase.domain.SaldoDomain;

@RunWith(MockitoJUnitRunner.class)
public class ContaPoupancaResponseMapperTest {
	
	@InjectMocks
	ContaPoupancaResponseMapper contaPoupancaResponseMapper;
	

	@Test
	public void testContaPoupancaResponseMapper() {
		
		SaldoDomain saldoDomain = new SaldoDomain();
		
		saldoDomain.setDataTransacao(Date.from(LocalDate.of(2019, 03, 28).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		saldoDomain.setSaldo(new BigDecimal(20.85));
		
		ContaPoupancaResponse resultadoPoupancaResponseMapper = contaPoupancaResponseMapper.toResponse(saldoDomain);
		
		assertEquals(saldoDomain.getDataTransacao(), resultadoPoupancaResponseMapper.getDataTransacao());
		assertEquals(saldoDomain.getSaldo().doubleValue(), resultadoPoupancaResponseMapper.getSaldo().doubleValue(), 0.01);
		
	}

}
