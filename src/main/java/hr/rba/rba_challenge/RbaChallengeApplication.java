package hr.rba.rba_challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = { "hr.rba.rba_challenge" })
@EnableJpaRepositories(basePackages = "hr.rba.rba_challenge.repository")
@EnableJpaAuditing
@EnableTransactionManagement
@EntityScan(basePackages = "hr.rba.rba_challenge.model")

public class RbaChallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RbaChallengeApplication.class, args);
	}

}
