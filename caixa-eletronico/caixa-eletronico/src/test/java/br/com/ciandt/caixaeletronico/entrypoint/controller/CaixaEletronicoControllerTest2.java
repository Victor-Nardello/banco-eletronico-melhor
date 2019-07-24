package br.com.ciandt.caixaeletronico.entrypoint.controller;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.ciandt.caixaeletronico.dataprovider.mapper.SaldoDataProviderDomainMapper;
import br.com.ciandt.caixaeletronico.usecase.domain.SaldoContaCorrenteDomain;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CaixaEletronicoControllerTest2 {
	
	@Autowired
	private CaixaEletronicoController controller;
	
	@MockBean
	private SaldoDataProviderDomainMapper saldoDataProviderDomainMapper;
	
	private MockMvc mockMvc;
	
	@Before
    public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }
	
	@Test
	public void caixaEletronicoControllerSucessoContaCorrenteTest() throws Exception {
		
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String dataFormatada = format.format(date);
		
		SaldoContaCorrenteDomain saldoContaCorrenteDomainMock = new SaldoContaCorrenteDomain();
		
		saldoContaCorrenteDomainMock.setSaldo(new BigDecimal(100.00));
		saldoContaCorrenteDomainMock.setLimite(new BigDecimal(1000.00));
		saldoContaCorrenteDomainMock.setDataTransacao(date);
		
		Mockito.when(saldoDataProviderDomainMapper.toSaldoContaCorrenteDomain(Mockito.any()))
				.thenReturn(saldoContaCorrenteDomainMock);
		
		mockMvc.perform(get("/caixa-eletronico")
					.param("agencia", "123")
					.param("conta", "123456")
					.param("tipo_conta", "CC"))
				.andExpect(status().isOk())
		        .andExpect(jsonPath("$.saldo", is(100)))
		        .andExpect(jsonPath("$.limite", is(1000)))
		        .andExpect(jsonPath("$.dataTransacao", is(dataFormatada)));
	}
}