package cf.iesguara.proyecto01Spring.Service.impl;

import java.util.List;

import cf.iesguara.proyecto01Spring.Model.Jugador;

public interface JugadorService {

	public List<Jugador> getAllFilms();

	public Jugador getById(long idFilm);

	public Jugador storeFilm(Jugador film);

	Jugador putJugador(long idJugador, Jugador jugador);

	boolean deleteJugador(long idJugador);
}
