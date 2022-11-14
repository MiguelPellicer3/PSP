package ej10_MinaPuertoCuartel;

public class Programa {

	public static void main(String[] args) throws InterruptedException {
		Mina m = new Mina(0);
		Puerto p= new Puerto(0,m);
		
		
		m.minar();System.out.println(m);
		m.minar();System.out.println(m);
		System.out.println(m);
		
		Thread hilo = new Thread(new Minero(m));
		hilo.start();
		p.construirSiHayDinero();
		System.out.println(m);
		System.out.println(p);
		p.construirEnCola();
		System.out.println(m);
		System.out.println(p);
		
	}

}
