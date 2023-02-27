import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class EjemploHHTPClient {

	public static void main(String[] args) throws IOException, InterruptedException {
		//cliente
		HttpClient cliente = HttpClient.newHttpClient();
		HttpRequest req = HttpRequest.newBuilder()
				.uri(URI.create("https://www.marca.com/futbol/primera-division/calendario.html"))
				.GET()
				.build();
		HttpResponse<String> res = cliente.send(req, HttpResponse.BodyHandlers.ofString());
		System.out.println(res.statusCode());
		System.out.println(res);
		
		//System.out.println(res.body());
		
		Scanner scan = new Scanner(System.in);
		String jornada="0";
		while(Integer.valueOf(jornada) < 1 || Integer.valueOf(jornada) > 39) {
			System.out.println("seleccione un jornada");
			jornada = scan.nextLine();
		}
		
		Document doc = Jsoup.parse(res.body());
		Elements resultadosJugados = doc.select("table#jornada"+ jornada +" tbody tr ");
		for (Element element : resultadosJugados) {
			System.out.println(element.text());
		}
	}
}
