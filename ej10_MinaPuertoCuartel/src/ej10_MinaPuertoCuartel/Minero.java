package ej10_MinaPuertoCuartel;

public class Minero implements Runnable{
	Mina m;
	

	public Minero(Mina m) {
		super();
		this.m = m;
	}
	
	public Mina getM() {
		return m;
	}

	public void setM(Mina m) {
		this.m = m;
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			m.minar();
			System.out.println("Minadita");
		}
		
	}
	
}
