package App.ProyectoLibreria.servis;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
