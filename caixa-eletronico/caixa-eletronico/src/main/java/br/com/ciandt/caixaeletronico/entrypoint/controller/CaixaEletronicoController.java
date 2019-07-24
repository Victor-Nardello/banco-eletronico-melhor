package br.com.ciandt.caixaeletronico.entrypoint.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ciandt.caixaeletronico.entrypoint.mapper.SaldoRequestMapper;
import br.com.ciandt.caixaeletronico.entrypoint.mapper.SaldoResponseMapper;
import br.com.ciandt.caixaeletronico.entrypoint.model.request.SaldoRequest;
import br.com.ciandt.caixaeletronico.entrypoint.model.response.SaldoResponse;
import br.com.ciandt.caixaeletronico.entrypoint.validation.ValidationSaldoRequest;
import br.com.ciandt.caixaeletronico.usecase.domain.SaldoDomain;
import br.com.ciandt.caixaeletronico.usecase.service.SaldoService;

@RestController
public class CaixaEletronicoController {
	
	@Autowired
	ValidationSaldoRequest validationSaldoRequest;
	
	@Autowired
	SaldoService saldoService;
	
	@Autowired
	SaldoRequestMapper saldoRequestMapper;
	
	@Autowired
	SaldoResponseMapper saldoResponseMapper;
	
	@ResponseBody
	@RequestMapping(value = "/caixa-eletronico", method = RequestMethod.GET)
	public SaldoResponse getSaldo(@RequestParam (value = "agencia") Integer agencia,
			@RequestParam (value = "conta") Integer conta,
			@RequestParam (value = "tipo_conta") String tipoConta) throws Exception {
		
		validationSaldoRequest.validar(agencia, conta, tipoConta);
		
		SaldoRequest saldoRequest = saldoRequestMapper.toSaldoRequest(agencia, conta, tipoConta);
		
		SaldoDomain saldoDomain = saldoService.getSaldo(saldoRequest.getTipoConta());
		
		SaldoResponse saldoResponse = saldoResponseMapper.toSaldoResponse(saldoDomain);
		
		return saldoResponse;
	}
	
//	@ResponseBody
//	public void getSaque(@RequestParam(value = "saldo") String conta,
//						 @RequestParam(value = "limite") String limite,
//						 @RequestParam(value = "tipo_conta") String tipoConta,
//						 @RequestParam(value = "valor_saque") String valorSaque) {
//	}
}