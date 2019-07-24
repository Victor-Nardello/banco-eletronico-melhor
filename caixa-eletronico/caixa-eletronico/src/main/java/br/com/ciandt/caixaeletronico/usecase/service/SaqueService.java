package br.com.ciandt.caixaeletronico.usecase.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.ciandt.caixaeletronico.usecase.domain.SaqueDomain;
import br.com.ciandt.caixaeletronico.usecase.gateway.SaqueGateway;

public class SaqueService {
	
	@Autowired
	SaqueGateway saqueGateway;
	
	public SaqueDomain getSaque() {
		
		return null;
	}

}
