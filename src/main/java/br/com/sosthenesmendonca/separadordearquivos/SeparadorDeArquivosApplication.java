package br.com.sosthenesmendonca.separadordearquivos;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.sosthenesmendonca.separadordearquivos.Servicies.SeparadorService;

@SpringBootApplication
public class SeparadorDeArquivosApplication {

	@Autowired
	private static SeparadorService separadorService;
	
	
	public static void main(String[] args) throws IOException {
		SpringApplication.run(SeparadorDeArquivosApplication.class, args);
		//separadorService.obterArquivos();
		
		SeparadorService separador = new SeparadorService();
		separador.obterArquivos();
	}

}
