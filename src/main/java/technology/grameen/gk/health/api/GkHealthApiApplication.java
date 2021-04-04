package technology.grameen.gk.health.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class GkHealthApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GkHealthApiApplication.class, args);
	}



	@Bean
	public WebMvcConfigurer corsConfigurer() {

		String liveUrl="http://103.26.136.30";
		String devUrl="http://localhost:8081";

		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {

				registry.addMapping("/api/v1/**")
						.allowedMethods("OPTIONS","GET","POST","PUT","DELETE")
						.allowedOrigins(devUrl);
			}
		};
	}
}
