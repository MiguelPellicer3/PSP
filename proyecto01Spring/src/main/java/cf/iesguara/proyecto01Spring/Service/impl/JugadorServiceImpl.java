package cf.iesguara.proyecto01Spring.Service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cf.iesguara.proyecto01Spring.Model.Jugador;
import cf.iesguara.proyecto01Spring.Repository.JugadorRepository;

@Service
public class JugadorServiceImpl implements JugadorService{

	JugadorRepository jugadorRepository;

		
	public JugadorServiceImpl(JugadorRepository filmRepository) {
		super();
		this.jugadorRepository = filmRepository;
	}



	@Override
	public List<Jugador> getAllFilms() {
		return jugadorRepository.findAll();
	}



	@Override
	public Jugador getById(long idJugador) {
		Long id= (Long) idJugador;
		return jugadorRepository.findById(id).orElse(null);
	}



	@Override
	public Jugador storeFilm(Jugador jugador) {
		return jugadorRepository.save(jugador);
	}
	
	@Override
	public Jugador putJugador(long idJugador,Jugador jugador) {
		Jugador jug = jugadorRepository.findById(idJugador).orElse(null);
		if(jug!=null) {
			jug = jugadorRepository.save(jugador);
		}
		return jug;
	}

	@Override
	public boolean deleteJugador(long idJugador) {
		Jugador jug = jugadorRepository.findById(idJugador).orElse(null);
		if(jug!=null) {
			jugadorRepository.deleteById(idJugador);
			return true;
		}
		return false;
	}
	

}
