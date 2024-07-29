package dev.martella.runnerz;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunnerzApplication {

	private static final Logger log = LoggerFactory.getLogger(RunnerzApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class, args);
		log.info("Application started");


	}
/*
	@Bean
	CommandLineRunner commandLineRunner(RunRepository runRepository) {
		return args -> {
			Run run = new Run(1,"corsa1", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS),10, Local.INDOOR);
			runRepository.create(run);
		};
	}*/

}
