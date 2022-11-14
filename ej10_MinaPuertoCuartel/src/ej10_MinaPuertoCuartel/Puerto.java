package ej10_MinaPuertoCuartel;

public class Puerto {

	int barcos;
	Mina mina;
	
	public Puerto(int barcos, Mina mina) {
		super();
		this.barcos = barcos;
		this.mina = mina;
	}
	
	public void construirSiHayDinero() {
		if (mina.getMonedas()>=2) {
			mina.gastar(2);
			barcos++;
		}else {
			System.out.println("No tienes suficientes monedas");
		}
	}
	public void construirEnCola() throws InterruptedException {
		synchronized (mina) {
			while(mina.getMonedas()<2) {
				System.out.println("Puerto: No hay suficientes monedas, esperando...");
				mina.wait();
			}
			mina.gastar(2);
		}
		barcos++;
	}

	@Override
	public String toString() {
		return "Puerto [barcos=" + barcos + "]";
	}
	
}
