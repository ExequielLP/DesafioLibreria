package App.ProyectoLibreria.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.List;

@Entity
@Data
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
   private String name;
   private Integer  birth_year;
    @Nullable
   private Integer death_year;
    @ManyToMany()
    private List<Libro> libros;
}
