package fiap.com.br.heroes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HeroesApplication {
	record HealthStatus(String status, String message){};

	public static void main(String[] args) {
		SpringApplication.run(HeroesApplication.class, args);
	}

	@GetMapping("/")
	public HealthStatus healthCheck(){
		return new HealthStatus("OK", "API is running");
	}
}
