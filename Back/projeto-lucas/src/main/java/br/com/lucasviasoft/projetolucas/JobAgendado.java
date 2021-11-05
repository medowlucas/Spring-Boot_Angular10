package br.com.lucasviasoft.projetolucas;

import br.com.lucasviasoft.projetolucas.service.VerificarDisponibilidadeNfeFazenda;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "br.com.lucasviasoft.projetolucas")
public class JobAgendado {

	public static void main(String[] args) {
		SpringApplication.run(JobAgendado.class, args);

		VerificarDisponibilidadeNfeFazenda consulta = new VerificarDisponibilidadeNfeFazenda();
		consulta.checkReceitaStatus();
	}

}
