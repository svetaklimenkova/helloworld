package by.slivki.trainings;

import by.slivki.trainings.config.JpaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrainingsApplication {

	public static void main(String[] args) {
		//tgnf
		SpringApplication.run(new Class<?>[] {TrainingsApplication.class, JpaConfig.class}, args);
	}
}