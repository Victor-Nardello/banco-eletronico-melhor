package br.com.ciandt.caixaeletronico.entrypoint.model.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaxaJurosResponse {

	@JsonFormat(shape = JsonFormat.Shape.OBJECT, pattern = "dd-MM-yyyy")
	private Date dataTransacao;
}