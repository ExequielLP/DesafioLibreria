package App.ProyectoLibreria.model.DTO;

import App.ProyectoLibreria.model.Autor;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorDTO(@JsonAlias("name") String name,@JsonAlias("birth_year") int birth_year, @JsonAlias("death_year")int death_year) {
}
