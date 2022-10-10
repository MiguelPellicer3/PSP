
public class HiloRunable implements Runnable{

	private int milisegundos;
	
	public HiloRunable(int milisegundos) {
		super();
		this.milisegundos = milisegundos;
	}

	@Override
	public void run() {
		System.out.println("Soy el hilo "+ Thread.currentThread().getId() + " de nombre "+ Thread.currentThread().getName());
		try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Terminé!");
	}

}
