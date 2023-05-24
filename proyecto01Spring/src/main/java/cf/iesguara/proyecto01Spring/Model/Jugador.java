package cf.iesguara.proyecto01Spring.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Jugador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String apellidos;
	@Column(nullable = true)
	private int dorsal;
	@Column(nullable = true)
	private int partidosJugados;
	@Column(nullable = true)
	private int goles;
	@Column(nullable = true)
	private String Pais;
}
