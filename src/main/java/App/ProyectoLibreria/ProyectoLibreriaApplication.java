package App.ProyectoLibreria;

import App.ProyectoLibreria.menu.Menu;
import App.ProyectoLibreria.repository.AutorRepository;
import App.ProyectoLibreria.repository.LibroRository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoLibreriaApplication implements CommandLineRunner {
@Autowired
private LibroRository libroRository;
@Autowired
private  AutorRepository autorRepository;
	public static void main(String[] args) {
		SpringApplication.run(ProyectoLibreriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Menu menu=new Menu(libroRository,autorRepository);
		menu.menu();
	}
}
