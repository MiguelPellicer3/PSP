package ej09_ContarHilos;

public class Contador {

	private int numero;

	public Contador(int numero) {
		super();
		this.numero = numero;
	}
	public synchronized void incrementar() {
//		synchronized (this) {
			numero++;			
//		}
	}
	public synchronized void decrementar() {
//		synchronized (this) {
			numero--;
//		}
	}
	@Override
	public String toString() {
		return "Contador [numero=" + numero + "]";
	}
	
}
