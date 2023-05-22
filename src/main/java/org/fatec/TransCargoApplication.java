package org.fatec;

import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@AllArgsConstructor
@Configuration
public class TransCargoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransCargoApplication.class, args);
	}

}

