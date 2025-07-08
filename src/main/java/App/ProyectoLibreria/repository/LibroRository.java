package App.ProyectoLibreria.repository;

import App.ProyectoLibreria.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibroRository extends JpaRepository<Libro, Long> {

    Optional<Libro> findByTitle(String title);
}
