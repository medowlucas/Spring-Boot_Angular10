package br.com.lucasviasoft.projetolucas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableScheduling
@ComponentScan("br.com.lucasviasoft.projetolucas")
@EnableAutoConfiguration
@EnableJpaRepositories
@EntityScan
public class JobAgendado {

	public static void main(String[] args) {
		SpringApplication.run(JobAgendado.class, args);

	}

}
