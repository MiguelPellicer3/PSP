
public class Program {

	public static void main(String[] args) throws InterruptedException {
		Hilothread h1= new Hilothread(3000);
		h1.start();
		h1.join();
		HiloRunable hr= new HiloRunable(1000);
		Thread h2= new Thread(hr);
		h2.start();
	}

}
