package cf.iesguara.proyecto01Spring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cf.iesguara.proyecto01Spring.Model.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long>{

	
}
