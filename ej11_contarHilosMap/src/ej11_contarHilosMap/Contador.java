package ej11_contarHilosMap;

import java.util.concurrent.ConcurrentHashMap;

public class Contador {
	
	private ConcurrentHashMap<String, Integer> numero;

	public Contador(ConcurrentHashMap<String, Integer> numero) {
		super();
		this.numero = numero;
	}
	
	public void decrementar (String casilla) {
		//no sincroniza pq son 2 operaciones atomicas
		//Integer num =numero.get(casilla);
		//numero.put(casilla, num);
		
		numero.compute(casilla, (c,valor) -> valor-1);
	}
	public void incrementar (String casilla) {
		//Integer num =numero.get(casilla);
		//numero.put(casilla, num+1);
		
		numero.compute(casilla, (c,valor) -> valor+1);
	}

	@Override
	public String toString() {
		return "Contador [numero=" + numero + "]";
	}
	
}
