package ej11_contarHilosMap;

import java.util.concurrent.ConcurrentHashMap;

public class Programa {

	public static void main(String[] args) throws InterruptedException {
		ConcurrentHashMap<String, Integer> cont= new ConcurrentHashMap<>();
		cont.put("casilla", 150);
		Contador c= new Contador(cont);
		Incrementador i= new Incrementador(c);
		Decrementador d= new Decrementador(c);
		i.start();
		d.start();
		i.join();
		d.join();
		System.out.println(c);
	}

}
