package fiap.com.br.heroes.controllers;

import fiap.com.br.heroes.models.Hero;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class HeroController {
    private static final Logger log = LoggerFactory.getLogger(HeroController.class);

    record HealthStatus(String status, String message){};

    @GetMapping("/")
    public HealthStatus healthCheck() {
        return new HealthStatus("OK", "Funcionando.");
    }

    @GetMapping("/heroes")
    public List<Hero> listAll() {
        return List.of( new Hero());
    }

    @PostMapping("/heroes")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Hero createHero(@RequestBody Hero hero) {
        log.info("Cadastrando herói: " + hero);
        return hero;
    }

}
