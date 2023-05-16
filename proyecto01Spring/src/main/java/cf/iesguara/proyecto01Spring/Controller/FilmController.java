package cf.iesguara.proyecto01Spring.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cf.iesguara.proyecto01Spring.Model.Film;
import cf.iesguara.proyecto01Spring.Service.impl.FilmService;

@RestController
@RequestMapping("/peliculas")
public class FilmController {

	private FilmService filmService;
	
	public FilmController(FilmService filmService) {
		this.filmService = filmService;
	}
	
	@GetMapping("all")
	public ResponseEntity<List<Film>> getAllFilms(){
		return filmService.getAllFilms();
	}
	
	//Get /peliculas?id=1
	@GetMapping
	public ResponseEntity<Film> showFilmParam(@RequestParam("id") String idFilm ){
		Long id = Long.parseLong(idFilm);
		return filmService.getById(id);
	}
	
	
	//Get /peliculas/1 <---- PathVariable
	@GetMapping("/{id}")
	public ResponseEntity<Film> showFilm(@PathVariable("id") long idFilm ){
		return filmService.getById(idFilm);
	}
	
	//Post /peliculas Añadir Pelicula
	@PostMapping
	public ResponseEntity<Film> storeFilm(@RequestBody Film film){
		return new ResponseEntity<Film>( filmService.storeFilm(film), HttpStatus.CREATED);
	}
	
	
}
