package App.ProyectoLibreria.repository;

import App.ProyectoLibreria.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor,Long> {
}
