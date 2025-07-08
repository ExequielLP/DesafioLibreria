package App.ProyectoLibreria.model.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record RespuestDTO(@JsonAlias("count") int count,@JsonAlias("results") List<LibroDTO>resultados) {
}
