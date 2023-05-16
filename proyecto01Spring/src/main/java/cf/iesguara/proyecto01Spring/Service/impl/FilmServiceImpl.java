package cf.iesguara.proyecto01Spring.Service.impl;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import cf.iesguara.proyecto01Spring.Model.Film;
import cf.iesguara.proyecto01Spring.Repository.FilmRepository;

@Service
public class FilmServiceImpl implements FilmService{

	FilmRepository filmRepository;

		
	public FilmServiceImpl(FilmRepository filmRepository) {
		super();
		this.filmRepository = filmRepository;
	}



	@Override
	public ResponseEntity<List<Film>> getAllFilms() {
		return new ResponseEntity<List<Film>>(filmRepository.findAll(),HttpStatus.OK);
	}



	@Override
	public ResponseEntity<Film> getById(long idFilm) {
		Long id= (Long) idFilm;
		return new ResponseEntity<Film>(filmRepository.findById(id).get(), HttpStatus.OK);
	}



	@Override
	public Film storeFilm(Film film) {
		return filmRepository.save(film);
	}
	


}
