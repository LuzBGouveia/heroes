package fiap.com.br.heroes.models;

import lombok.*;

@Data
@AllArgsConstructor
public class Hero {
    private Long id;
    private String name;
    private String superPower;
    private int level;
    private boolean isAlive;
}
