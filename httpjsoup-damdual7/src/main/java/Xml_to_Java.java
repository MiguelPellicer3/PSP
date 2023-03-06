import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.Charset;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class Xml_to_Java {

	public static void main(String[] args) throws IOException, InterruptedException {
		String rutaXML = "https://parkings.pamplona.es/parkings.xml";
		HttpClient cliente = HttpClient.newHttpClient();
		HttpRequest req = HttpRequest.newBuilder()
				.uri(URI.create(rutaXML))
				.GET()
				.build();
		HttpResponse<String> res = cliente.send(req, HttpResponse.BodyHandlers.ofString(Charset.forName("UTF-16")));
		//System.out.println(res.body());
		XmlMapper xmlMapper = new XmlMapper();
		APARCAMIENTOS aparcamientos=xmlMapper.readValue(res.body(), APARCAMIENTOS.class);
		System.out.println(aparcamientos.APARCAMIENTO.size());
		for (APARCAMIENTO aparcamiento : aparcamientos.APARCAMIENTO) {
			System.out.println(aparcamiento.NOMBRE+"	"+aparcamiento.PLAZAS.LIBRES);
		}
	}

}

class ULTIMA_ACTUALIZACION { 
	
	public ULTIMA_ACTUALIZACION() {
		super();
	}
	public ULTIMA_ACTUALIZACION(String fORMATO, double fECHA) {
		super();
		FORMATO = fORMATO;
		FECHA = fECHA;
	}
	public String FORMATO;
	public double FECHA;
}

class HORARIO { 
	 
	public HORARIO() {
		super();
	}
	public HORARIO(String fORMATO, int dESDE, int hASTA) {
		super();
		FORMATO = fORMATO;
		DESDE = dESDE;
		HASTA = hASTA;
	}
	public String FORMATO;
	public int DESDE;
	public int HASTA;
}

class PLAZAS { 
	
	public PLAZAS() {
		super();
	}
	public PLAZAS(int tOTAL, String lIBRES) {
		super();
		TOTAL = tOTAL;
		LIBRES = lIBRES;
	}
	public int TOTAL;
	public String LIBRES;
}

class RANGO { 
	
	public RANGO() {
		super();
	}
	public RANGO(int cODIGO, String dESCRIPCION, String iMPORTE) {
		super();
		CODIGO = cODIGO;
		DESCRIPCION = dESCRIPCION;
		IMPORTE = iMPORTE;
	}
	public int CODIGO;
	public String DESCRIPCION;
	public String IMPORTE;
}

class PRECIOS_SF { 
	
	public PRECIOS_SF() {
		super();
	}
	public PRECIOS_SF(String fORMATO_FECHA, String fECHA_DESDE, String fECHA_HASTA, String pRECIO_MAXIMO,
			String pRECIO_MINIMO) {
		super();
		FORMATO_FECHA = fORMATO_FECHA;
		FECHA_DESDE = fECHA_DESDE;
		FECHA_HASTA = fECHA_HASTA;
		PRECIO_MAXIMO = pRECIO_MAXIMO;
		PRECIO_MINIMO = pRECIO_MINIMO;
	}
	public String FORMATO_FECHA;
	public String FECHA_DESDE;
	public String FECHA_HASTA;
	public String PRECIO_MAXIMO;
	public String PRECIO_MINIMO;
}

class TARIFAS { 
	
	public TARIFAS() {
		super();
	}
	public TARIFAS(int aNYO, String mONEDA, List<RANGO> rANGO, String pRECIO_MAXIMO_DIARIO, String pRECIO_MINIMO_DIARIO,
			PRECIOS_SF pRECIOS_SF) {
		super();
		ANYO = aNYO;
		MONEDA = mONEDA;
		RANGO = rANGO;
		PRECIO_MAXIMO_DIARIO = pRECIO_MAXIMO_DIARIO;
		PRECIO_MINIMO_DIARIO = pRECIO_MINIMO_DIARIO;
		PRECIOS_SF = pRECIOS_SF;
	}
	public int ANYO;
	public String MONEDA;
	@JacksonXmlElementWrapper(useWrapping = false)
	public List<RANGO> RANGO;
	public String PRECIO_MAXIMO_DIARIO;
	public String PRECIO_MINIMO_DIARIO;
	public PRECIOS_SF PRECIOS_SF;
}

class APARCAMIENTO {
	
	public APARCAMIENTO() {
		super();
	}
	public APARCAMIENTO(int cODIGO, String nOMBRE, String nOMBRE_CORTO, String dIRECCION, int tELEFONO, double lATITUD,
			double lONGITUD, String gESTORA, HORARIO hORARIO, PLAZAS pLAZAS, TARIFAS tARIFAS) {
		super();
		CODIGO = cODIGO;
		NOMBRE = nOMBRE;
		NOMBRE_CORTO = nOMBRE_CORTO;
		DIRECCION = dIRECCION;
		TELEFONO = tELEFONO;
		LATITUD = lATITUD;
		LONGITUD = lONGITUD;
		GESTORA = gESTORA;
		HORARIO = hORARIO;
		PLAZAS = pLAZAS;
		TARIFAS = tARIFAS;
	}
	public int CODIGO;
	public String NOMBRE;
	public String NOMBRE_CORTO;
	public String DIRECCION;
	public int TELEFONO;
	public double LATITUD;
	public double LONGITUD;
	public String GESTORA;
	public HORARIO HORARIO;
	public PLAZAS PLAZAS;
	public TARIFAS TARIFAS;
}

class APARCAMIENTOS { 
	
	public APARCAMIENTOS() {
		super();
	}
	public APARCAMIENTOS(ULTIMA_ACTUALIZACION uLTIMA_ACTUALIZACION, List<APARCAMIENTO> aPARCAMIENTO) {
		super();
		ULTIMA_ACTUALIZACION = uLTIMA_ACTUALIZACION;
		APARCAMIENTO = aPARCAMIENTO;
	}
	public ULTIMA_ACTUALIZACION ULTIMA_ACTUALIZACION;
	@JacksonXmlElementWrapper(useWrapping = false)
	public List<APARCAMIENTO> APARCAMIENTO;
}
