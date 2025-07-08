package App.ProyectoLibreria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Entity
@Data
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String title;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Autor> autores;
    private List<String> languages;


    public Libro(String title, List<Autor> autores, List<String> languages) {
        this.title = title;
        this.autores = autores;
        this.languages = languages;
    }

    public Libro() {
    }
}
