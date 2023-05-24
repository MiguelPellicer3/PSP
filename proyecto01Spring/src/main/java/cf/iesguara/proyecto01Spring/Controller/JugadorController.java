package cf.iesguara.proyecto01Spring.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cf.iesguara.proyecto01Spring.Model.Jugador;
import cf.iesguara.proyecto01Spring.Service.impl.JugadorService;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

	private JugadorService jugadorService;
	
	public JugadorController(JugadorService filmService) {
		this.jugadorService = filmService;
	}
	
	@GetMapping("all")
	public ResponseEntity<List<Jugador>> getAllJugador(){
		return  new ResponseEntity<List<Jugador>>(jugadorService.getAllFilms() , HttpStatus.OK);
	}
	
	//Get /peliculas?id=1
	@GetMapping
	public ResponseEntity<Jugador> showJugador(@RequestParam("id") String idJugador ){
		Long id = Long.parseLong(idJugador);
		Jugador jugador = jugadorService.getById(id);
		if(jugador==null) {
			return  new ResponseEntity<Jugador>(HttpStatus.NOT_FOUND);
		}
		return  new ResponseEntity<Jugador>(jugador , HttpStatus.OK);
	}
	
	
	//Get /peliculas/1 <---- PathVariable
	@GetMapping("/{id}")
	public ResponseEntity<Jugador> showJugador(@PathVariable("id") long idJugador ){
		Jugador jugador = jugadorService.getById(idJugador);
		if(jugador==null) {
			return  new ResponseEntity<Jugador>(HttpStatus.NOT_FOUND);
		}
		return  new ResponseEntity<Jugador>(jugador , HttpStatus.OK);
	}
	
	//Post /jugadores
	@PostMapping
	public ResponseEntity<Jugador> storeJugador(@RequestBody Jugador jugador){
		return new ResponseEntity<Jugador>( jugadorService.storeFilm(jugador), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Jugador> putJugador(@PathVariable("id") long idJugador ,@RequestBody Jugador jugador){
		Jugador jug = jugadorService.putJugador(idJugador, jugador);
		if(jug==null) {
			return  new ResponseEntity<Jugador>(HttpStatus.NOT_FOUND);
		}
		return  new ResponseEntity<Jugador>(jugador , HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Jugador> deleteJugador(@PathVariable("id") long idJugador){
		boolean res = jugadorService.deleteJugador(idJugador);
		if(!res) {
			return  new ResponseEntity<Jugador>(HttpStatus.NOT_FOUND);
		}
		return  new ResponseEntity<Jugador>(HttpStatus.OK);
	}
	
}
