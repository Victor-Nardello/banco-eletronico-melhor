package br.com.ciandt.caixaeletronico.entrypoint.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ciandt.caixaeletronico.entrypoint.mapper.SaldoRequestMapper;
import br.com.ciandt.caixaeletronico.entrypoint.mapper.SaldoResponseMapper;
import br.com.ciandt.caixaeletronico.entrypoint.mapper.TaxaJurosRequestMapper;
import br.com.ciandt.caixaeletronico.entrypoint.mapper.TaxaJurosResponseMapper;
import br.com.ciandt.caixaeletronico.entrypoint.model.request.SaldoRequest;
import br.com.ciandt.caixaeletronico.entrypoint.model.request.TaxaRequest;
import br.com.ciandt.caixaeletronico.entrypoint.model.response.SaldoResponse;
import br.com.ciandt.caixaeletronico.entrypoint.model.response.TaxaJurosResponse;
import br.com.ciandt.caixaeletronico.entrypoint.validation.TaxaJurosRequestValidation;
import br.com.ciandt.caixaeletronico.entrypoint.validation.ValidationSaldoRequest;
import br.com.ciandt.caixaeletronico.usecase.domain.SaldoDomain;
import br.com.ciandt.caixaeletronico.usecase.domain.TaxaDomain;
import br.com.ciandt.caixaeletronico.usecase.service.SaldoService;
import br.com.ciandt.caixaeletronico.usecase.service.TaxaService;

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
	
	@Autowired
	TaxaJurosRequestValidation taxaJurosRequestValidation;
	
	@Autowired
	TaxaJurosRequestMapper taxaJurosRequestMapper;
	
	@Autowired
	TaxaService taxaService;
	
	@Autowired
	TaxaJurosResponseMapper taxaJurosResponseMapper;
	
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
	
	@ResponseBody
	@RequestMapping(value = "/caixa-eletronico/taxa", method = RequestMethod.GET)
	public TaxaJurosResponse taxaJuros(@RequestParam (value = "agencia") Integer agencia,
			@RequestParam (value = "conta") Integer conta,
			@RequestParam (value = "tipo_conta") String tipoConta,
			@RequestParam (value = "taxa_juros") BigDecimal taxaJuros) throws Exception {
		
		taxaJurosRequestValidation.validar(agencia, conta, tipoConta, taxaJuros);
		TaxaRequest taxaRequest =  taxaJurosRequestMapper.requestMapper(agencia, conta, tipoConta, taxaJuros);
		TaxaDomain taxaDomain = taxaService.getTaxaJuros(taxaRequest.getTipoConta(), taxaRequest.getAgencia());
		TaxaJurosResponse taxaJurosResponse = taxaJurosResponseMapper.toTaxaJurosResponse(taxaDomain);
		
		return taxaJurosResponse;
	}
}