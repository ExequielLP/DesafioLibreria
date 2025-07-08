package App.ProyectoLibreria.menu;


import App.ProyectoLibreria.model.Autor;
import App.ProyectoLibreria.model.DTO.LibroDTO;
import App.ProyectoLibreria.model.DTO.RespuestDTO;
import App.ProyectoLibreria.model.Libro;
import App.ProyectoLibreria.repository.AutorRepository;
import App.ProyectoLibreria.repository.LibroRository;
import App.ProyectoLibreria.servis.ConsumoApi;
import App.ProyectoLibreria.servis.ConvierteDatos;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private ConsumoApi consumoApi = new ConsumoApi();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private Scanner teclado = new Scanner(System.in);
    private ConvierteDatos conversor = new ConvierteDatos();
    private final LibroRository libroRository;
private AutorRepository autorRepository;


    public Menu(LibroRository libroRository, AutorRepository autorRepository) {
        this.libroRository = libroRository;
        this.autorRepository=autorRepository;
    }

    public void menu() {

        System.out.println("Bienvenido!");
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 -  Buscar libro por titulo 
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año 
                    5 - Listar libros por idioma
                    
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarYguardaLibro();
                    break;
                case 2:
                    buscarLibrosRegistrados();

                    break;
                case 3:
                    buscarAutoresRegistrados();

                    break;
                case 4:
                    listarAutoresVivos();

                    break;
                case 5:
                    listarLibrosPorIdioma();

                    break;

                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        }

    }

    private void listarLibrosPorIdioma() {
        List<Libro>listaLibros=libroRository.findAll();
        System.out.println("ingrese el idioma de los libros a listar");
        System.out.println("EN para español ");
        System.out.println("US para ingles");
        var idioma=teclado.nextLine();

        List<Libro> librosFiltrados = listaLibros.stream()
                .filter(libro -> libro.getLanguages() != null && libro.getLanguages().contains(idioma.toLowerCase()))
                .toList();

        if (librosFiltrados.isEmpty()) {
            System.out.println("No se encontraron libros en ese idioma");
        }

    }

    private void listarAutoresVivos() {
        System.out.println("ingrese un año y le diremos si el autor esta con vida");
        var ano=teclado.nextInt();
        List<Autor>autores=autorRepository.findAll();
        autores.stream()
                .filter(autor ->
                        autor.getDeath_year() == null || autor.getDeath_year() > ano)
                .forEach(autor -> System.out.println(autor.getName()));
    }

    private void buscarAutoresRegistrados() {
        List<Autor>autores=autorRepository.findAll();
        if (autores.isEmpty()) System.out.println("Aun no hay autores");
        autores.forEach(autor -> System.out.println(autor.getName()));
    }

    public void buscarLibrosRegistrados() {
        List<Libro>libros=libroRository.findAll();
        if (libros.isEmpty()) System.out.println("No hay libros registrados aun");
        libros.forEach(libro -> System.out.println(libro.getTitle()));

    }


    private void buscarYguardaLibro() {
        System.out.println("ingresa el nombre del libro");
        String libroTeclado = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + libroTeclado.replace(" ", "%20"));
        RespuestDTO respuesta = conversor.obtenerDatos(json, RespuestDTO.class);
        LibroDTO resultadoExacto = respuesta.resultados().stream()
                .filter(libro -> libro.title().toLowerCase().contains(libroTeclado.toLowerCase()))
                .findFirst()
                .orElse(null);
        System.out.println(resultadoExacto);
        Libro libro = new Libro(resultadoExacto.title(), resultadoExacto.autores(), resultadoExacto.languages());
        if (libroRository.findByTitle(libro.getTitle()).isEmpty()) {
            libroRository.save(libro);
            System.out.println(resultadoExacto);
        } else {

            System.out.println("El libro ya esta guardado");

        }

    }

    // proximo paso, guarda en base de datos JAJA
}

;

