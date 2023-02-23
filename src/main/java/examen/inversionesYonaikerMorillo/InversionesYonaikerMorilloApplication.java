package examen.inversionesYonaikerMorillo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class InversionesYonaikerMorilloApplication {
	public static void main(String[] args) {
		SpringApplication.run(InversionesYonaikerMorilloApplication.class, args);
	}

	@Configuration
	public class CorsConfig implements WebMvcConfigurer {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/api/**")
					.allowedOrigins("http://localhost:3001")
					.allowedMethods("GET", "POST", "PUT", "DELETE")
					.allowedHeaders("*")
					.allowCredentials(true)
					.maxAge(3600);
		}
	}
}