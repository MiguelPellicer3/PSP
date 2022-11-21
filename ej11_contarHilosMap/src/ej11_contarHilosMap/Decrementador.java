package ej11_contarHilosMap;

public class Decrementador extends Thread {

	Contador contador;

	public Decrementador(Contador contador) {
		super();
		this.contador = contador;
	}
	
	@Override
	public void run() {
		for (int i=0; i<300;i++) {
				contador.decrementar("casilla");				
		}
	}
}
