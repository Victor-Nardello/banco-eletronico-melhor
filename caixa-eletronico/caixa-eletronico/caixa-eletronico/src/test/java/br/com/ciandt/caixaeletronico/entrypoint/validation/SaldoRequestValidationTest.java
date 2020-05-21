package br.com.ciandt.caixaeletronico.entrypoint.validation;

import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.ResponseStatusException;

@RunWith(MockitoJUnitRunner.class)
public class SaldoRequestValidationTest {

	@InjectMocks
	SaldoRequestValidation validationSaldoRequest;

	@Test
	public void validationDeSucessoContaPoupancaTest() throws Exception {

		Integer agencia = new Integer(8);
		Integer conta = new Integer(9);
		String tipoConta = "CP";

		try {
			validationSaldoRequest.validar(agencia, conta, tipoConta);
		} catch (ResponseStatusException e) {
			Assert.fail("Teste conta poupanca não deveria falhar");
		}
	}
	
	@Test
	public void validationDeSucessoContaCorrenteTest() throws Exception {
		
		Integer agencia = new Integer(10);
		Integer conta = new Integer(11);
		String tipoConta = "CC";
		
		try {
			validationSaldoRequest.validar(agencia, conta, tipoConta);
		}catch (ResponseStatusException e) {
			Assert.fail("Teste conta corrente não deveria falhar");
		}
	}

	@Test
	public void validationDeFalhaAgenciaNullTest() throws Exception {

		Integer agencia = null;
		Integer conta = new Integer(9);
		String tipoConta = "CC";
		
		try {
			validationSaldoRequest.validar(agencia, conta, tipoConta);
			Assert.fail("Neste teste agencia é esperado uma exception");
		} catch (ResponseStatusException e) {
			assertEquals("400 BAD_REQUEST \"Campo agencia obrigatorio\"", e.getMessage());
			assertEquals("Campo agencia obrigatorio", e.getReason());
		}
	}
	
	@Test
	public void validationDeFalhaContaNullTest() throws Exception {
		
		Integer agencia = new Integer(10);
		Integer conta = null;
		String tipoConta = "CP";
		
		try {
			validationSaldoRequest.validar(agencia, conta, tipoConta);
			Assert.fail("Neste teste conta é esperado uma exception");
		} catch (ResponseStatusException e) {
			assertEquals("400 BAD_REQUEST \"Campo conta obrigatorio\"", e.getMessage());
			assertEquals("Campo conta obrigatorio", e.getReason());
		}
	}
	
	@Test
	public void validationDeFalhaTipoContaVazioTest() throws Exception {
		
		Integer agencia = new Integer(15);
		Integer conta = new Integer(16);
		String tipoConta = "";
		
		try {
			validationSaldoRequest.validar(agencia, conta, tipoConta);
			Assert.fail("Neste teste tipoConta é esperado uma exception");
		} catch(ResponseStatusException e) {
			assertEquals("400 BAD_REQUEST \"Campo tipo_conta obrigatorio\"", e.getMessage());
			assertEquals("Campo tipo_conta obrigatorio", e.getReason());
		}
	}
	
	@Test
	public void validationDeFalhaTipoContaDiferenteDeCCouCPTest() throws Exception {
		
		Integer agencia = new Integer(15);
		Integer conta = new Integer(16);
		String tipoConta = "c";
		
		try {
			validationSaldoRequest.validar(agencia, conta, tipoConta);
			Assert.fail("Neste teste tipoConta é esperado uma exception");
		} catch(ResponseStatusException e) {
			assertEquals("400 BAD_REQUEST \"Campo tipo_conta invalido\"", e.getMessage());
			assertEquals("Campo tipo_conta invalido", e.getReason());
		}
	}
}