package fiap.com.br.heroes.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Hero {
    private String name;
    private String superPower;
    private int level;
    private boolean isAlive;
}
