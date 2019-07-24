package br.com.ciandt.caixaeletronico.entrypoint.mapper;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import br.com.ciandt.caixaeletronico.entrypoint.model.response.SaldoContaCorrenteResponse;
import br.com.ciandt.caixaeletronico.entrypoint.model.response.SaldoContaPoupancaResponse;
import br.com.ciandt.caixaeletronico.usecase.domain.SaldoContaCorrenteDomain;
import br.com.ciandt.caixaeletronico.usecase.domain.SaldoContaPoupancaDomain;

@RunWith(MockitoJUnitRunner.class)
public class SaldoResponseMapperTest {

	@InjectMocks
	SaldoResponseMapper saldoResponseMapper;

	@Test
	public void saldoResponseMapperSaldoContaCorrenteDomainToSaldoContaCorrenteResponseTest() {

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String dataFormatada = format.format(date);

		SaldoContaCorrenteDomain saldoContaCorrenteDomain = new SaldoContaCorrenteDomain();
		
		saldoContaCorrenteDomain.setSaldo(new BigDecimal(4000.00));
		saldoContaCorrenteDomain.setLimite(new BigDecimal(4000.00));
		saldoContaCorrenteDomain.setDataTransacao(date);
		
		SaldoContaCorrenteResponse saldoContaCorrenteResponse = (SaldoContaCorrenteResponse) saldoResponseMapper
				.toSaldoResponse(saldoContaCorrenteDomain);
		
		assertEquals(saldoContaCorrenteResponse.getSaldo().doubleValue(),
				saldoContaCorrenteDomain.getSaldo().doubleValue(), 0.01);
		
		assertEquals(saldoContaCorrenteResponse.getLimite().doubleValue(),
				saldoContaCorrenteDomain.getSaldo().doubleValue(), 0.01);
		
		assertEquals(dataFormatada, format.format(saldoContaCorrenteResponse.getDataTransacao()));
	}
	
	@Test
	public void saldoResponseMapperSaldoPoupancaCorrenteDomainToSaldoContaPoupancaResponseTest() {
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String dataFormatada = format.format(date);
		
		SaldoContaPoupancaDomain saldoContaPoupancaDomain = new SaldoContaPoupancaDomain();
		
		saldoContaPoupancaDomain.setSaldo(new BigDecimal(1000.00));
		saldoContaPoupancaDomain.setDataTransacao(date);
		
		SaldoContaPoupancaResponse saldoContaPoupancaResponse = (SaldoContaPoupancaResponse) saldoResponseMapper
				.toSaldoResponse(saldoContaPoupancaDomain);
		
		assertEquals(saldoContaPoupancaResponse.getSaldo().doubleValue(),
				saldoContaPoupancaDomain.getSaldo().doubleValue(), 0.01);
		
		assertEquals(dataFormatada, format.format(saldoContaPoupancaResponse.getDataTransacao()));
	}
}