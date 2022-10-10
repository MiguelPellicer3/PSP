public class Hilothread extends Thread {

	private int milisegundos;

	public Hilothread(int milisegundos) {
		super();
		this.milisegundos = milisegundos;
	}

	@Override
	public void run() {
		System.out.println("Soy el hilo "+ this.getId() + " de nombre "+ this.getName());
		try {
			sleep(milisegundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		super.run();
		System.out.println("Terminé!");
	}
}
