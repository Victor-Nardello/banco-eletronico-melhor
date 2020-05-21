package br.com.ciandt.caixaeletronico.entrypoint.controller;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
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
import br.com.ciandt.caixaeletronico.entrypoint.validation.ValidationSaldoRequest;
import br.com.ciandt.caixaeletronico.usecase.domain.SaldoContaCorrenteDomain;
import br.com.ciandt.caixaeletronico.usecase.domain.SaldoContaPoupancaDomain;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CaixaEletronicoControllerTest {
	
	@Autowired
	private CaixaEletronicoController controller;
	
	private MockMvc mockMvc;
	
	@MockBean
	private SaldoDataProviderDomainMapper saldoDataProviderDomainMapper;
	
	@Mock
	private ValidationSaldoRequest validationSaldoRequest;
    
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
	
	@Test
	public void caixaEletronicoControllerSucessoContaPoupancaTest() throws Exception {

		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		String dataFormatada = format.format(date);
		
		SaldoContaPoupancaDomain saldoContaPoupancaDomainMock = new SaldoContaPoupancaDomain();
		
		saldoContaPoupancaDomainMock.setSaldo(new BigDecimal(100.00));
		saldoContaPoupancaDomainMock.setDataTransacao(date);
		
		Mockito.when(saldoDataProviderDomainMapper.toSaldoContaPoupancaDomain(Mockito.any()))
				.thenReturn(saldoContaPoupancaDomainMock);
		
		mockMvc.perform(get("/caixa-eletronico")
					.param("agencia", "123")
					.param("conta", "123456")
					.param("tipo_conta", "CP"))
				.andExpect(status().isOk())
		        .andExpect(jsonPath("$.saldo", is(100)))
		        .andExpect(jsonPath("$.dataTransacao", is(dataFormatada)));
	}
	
	@Test
	public void caixaEletronicoControllerFalhaContaPoupancaTest() throws Exception {
		
		mockMvc.perform(get("/caixa-eletronico")
					.param("agencia", "")
					.param("conta", "123")
					.param("tipo_conta", "CP"))
				.andExpect(status().isBadRequest())
				.andExpect(status().reason("Campo agencia obrigatorio"));
	}	
	
	@Test
	public void caixaEletronicoControllerAgenciaNullTest() throws Exception {
		
		mockMvc.perform(get("/caixa-eletronico")
				.param("agencia", "")
				.param("conta", "987654")
				.param("tipo_conta", "CC"))
		.andExpect(status().isBadRequest())
		.andExpect(status().reason("Campo agencia obrigatorio"));
	}
	
	@Test
	public void caixaEletronicoControllerContaNullTest() throws Exception {
		
		mockMvc.perform(get("/caixa-eletronico")
					.param("agencia", "098")
					.param("conta", "")
					.param("tipo_conta", ""))
		.andExpect(status().isBadRequest())
		.andExpect(status().reason("Campo conta obrigatorio"));
	}
	
	@Test
	public void caixaEletronicoControllertipoContaNullTest() throws Exception {
		
		mockMvc.perform(get("/caixa-eletronico")
					.param("agencia", "123")
					.param("conta", "123456")
					.param("tipo_conta", ""))
				.andExpect(status().isBadRequest())
				.andExpect(status().reason("Campo tipo_conta obrigatorio"));
	}
	
	@Test
	public void caixaEletronicoControllertipoContaInvalidoTest() throws Exception {
	
		mockMvc.perform(get("/caixa-eletronico")
					.param("agencia", "123")
					.param("conta", "123456")
					.param("tipo_conta", "XPTO"))
				.andExpect(status().isBadRequest())
				.andExpect(status().reason("Campo tipo_conta invalido"));
	}
}