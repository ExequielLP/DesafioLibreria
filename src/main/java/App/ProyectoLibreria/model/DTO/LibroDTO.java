package App.ProyectoLibreria.model.DTO;

import App.ProyectoLibreria.model.Autor;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroDTO( @JsonAlias("title")String title,
                       @JsonAlias("authors") List<Autor> autores,
                        @JsonAlias("languages") List<String> languages) {
}
