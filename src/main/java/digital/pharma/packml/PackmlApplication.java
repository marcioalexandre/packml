package digital.pharma.packml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({
		"digital.pharma.packml.app.controller",
		"digital.pharma.packml.domain.service",
		"digital.pharma.packml.infra.broker.service",
		"digital.pharma.packml.infra.security"
})
@EntityScan("digital.pharma.packml.infra.entity")
@EnableJpaRepositories("digital.pharma.packml.infra.db.repository")
@EnableSwagger2
public class PackmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(PackmlApplication.class, args);
	}
}
