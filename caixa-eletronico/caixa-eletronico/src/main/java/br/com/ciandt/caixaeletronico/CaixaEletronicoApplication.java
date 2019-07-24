package br.com.ciandt.caixaeletronico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class CaixaEletronicoApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(CaixaEletronicoApplication.class, args);
	}
}