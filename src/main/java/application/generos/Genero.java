package application.generos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "generos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String nome;

    public Genero(GeneroDTO dados) {
        this.setId(dados.id());
        this.setNome(dados.nome());
    }

    public Genero(GeneroInsertDTO dados) {
        this.setNome(dados.nome());
    }
}
