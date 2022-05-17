package net.foxandr.sport.universiade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = StaffEntityRepository.class)
public class UniversiadeRestApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(UniversiadeRestApiApplication.class, args);
	}
}
