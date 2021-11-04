package br.com.lucasviasoft.projetolucas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "br.com.lucasviasoft.projetolucas")
public class JobAgendado {

	public static void main(String[] args) {
		SpringApplication.run(JobAgendado.class, args);

		ReceitaDisponibilidadeService consulta = new ReceitaDisponibilidadeService();
		consulta.checkReceitaStatus();
	}

}
