package ej09_ContarHilos;


public class Incrementador extends Thread {

	Contador contador;

	public Incrementador(Contador contador) {
		super();
		this.contador = contador;
	}
	
	@Override
	public void run() {
		for (int i=0; i<300;i++) {
//			synchronized (contador) {
				contador.incrementar();				
//			}
		}
	}
}
