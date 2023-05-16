package cf.iesguara.proyecto01Spring.Service.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;

import cf.iesguara.proyecto01Spring.Model.Film;

public interface FilmService {

	public ResponseEntity<List<Film>> getAllFilms();

	public ResponseEntity<Film> getById(long idFilm);

	public Film storeFilm(Film film);
}
