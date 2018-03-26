package by.slivki.trainings;

import by.slivki.trainings.config.JpaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrainingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(new Class<?>[] {TrainingsApplication.class, JpaConfig.class}, args);
	}
}