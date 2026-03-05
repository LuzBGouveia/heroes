package fiap.com.br.heroes.controllers;

import fiap.com.br.heroes.models.Hero;
import fiap.com.br.heroes.services.HeroService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@Slf4j
public class HeroController {

    private static final Logger log = LoggerFactory.getLogger(HeroController.class);
    @Autowired
    private HeroService service; // Injeção de dependência - IoC

    @GetMapping
    public List<Hero> listAll(){
        return service.getAllHeroes();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Hero createHero(@RequestBody Hero hero){ //binding
        return service.addHero(hero);
    }

    @GetMapping("/{id}")
    public Hero getHeroById(@PathVariable Long id){
        log.info("Obtendo dados do filme {}", id);
        var optionalHero = service.getHeroById(id);

        if(optionalHero.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return optionalHero.get();
    }

}
