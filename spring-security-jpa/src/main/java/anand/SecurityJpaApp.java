package anand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import anand.repository.UserRepository;

@SpringBootApplication//(exclude = { SecurityAutoConfiguration.class})
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SecurityJpaApp {

	public static void main(String[] args) {
		SpringApplication.run(SecurityJpaApp.class, args);
	}

}
