import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JSOUP_Meteoclimatic {

	public static void main(String[] args) throws IOException, InterruptedException {
		String server = "https://opendata.aemet.es/opendata";
		String apikey = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI2MzM3OEBpZXNzaWVycmFkZWd1YXJhLmNvbSIsImp0aSI6ImU3MTFkMTg0LTQxNTQtNGY3NS1iYjY0LTM0MTg0OWQxNDZiNCIsImlzcyI6IkFFTUVUIiwiaWF0IjoxNjc2OTA4OTk2LCJ1c2VySWQiOiJlNzExZDE4NC00MTU0LTRmNzUtYmI2NC0zNDE4NDlkMTQ2YjQiLCJyb2xlIjoiIn0.wu1FqZKoLZ-KE3VVw5351HBBEtyVW5VCumJODV7YPdI";
		String endpoint = "/api/observacion/convencional/todas";
		HttpClient cliente = HttpClient.newHttpClient();
		HttpRequest req = HttpRequest.newBuilder().uri(URI.create(server + endpoint + "?api_key=" + apikey)).GET()
				.build();

		HttpResponse<String> res = cliente.send(req, HttpResponse.BodyHandlers.ofString());
		System.out.println(res.body());
		RespuestaAemet amet = new Gson().fromJson(res.body(), RespuestaAemet.class);
		// System.out.println(amet.getDatos());
		HttpRequest reqDatos = HttpRequest.newBuilder().uri(URI.create(amet.getDatos())).GET().build();

		HttpResponse<String> resDatos = cliente.send(reqDatos, HttpResponse.BodyHandlers.ofString());
		java.lang.reflect.Type listType = new TypeToken<ArrayList<EstacionMeteo>>() {
		}.getType();
		List<EstacionMeteo> lista = new Gson().fromJson(resDatos.body(), listType);
		System.out.println(lista.size());
		// System.out.println(lista.get(0));
		for (EstacionMeteo estacionMeteo : lista) {
			if (estacionMeteo.getIdema().equals("0009X"))
				System.out.println(estacionMeteo);

		}
	}
}

class RespuestaAemet {
	private String Descripcion;
	private int Estado;
	private String datos;
	private String metadatos;

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public int getEstado() {
		return Estado;
	}

	public void setEstado(int estado) {
		Estado = estado;
	}

	public String getDatos() {
		return datos;
	}

	public void setDatos(String datos) {
		this.datos = datos;
	}

	public String getMetadatos() {
		return metadatos;
	}

	public void setMetadatos(String metadatos) {
		this.metadatos = metadatos;
	}

}

class Geo850 {
	private float value;
	private boolean present;

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}
}

class EstacionMeteo {
	private String idema;
	private float lon;
	private float lat;
	private float alt;
	private String ubi;
	private String fint;
	private float prec;
	private float pacutp;
	private float pliqt;
	private float psoltp;
	private float vmax;
	private float vv;
	private float vmaxu;
	private float vvu;
	private float dv;
	private float dvu;
	private float dmax;
	private float dmaxu;
	private float stdvv;
	private float stddv;
	private float stdvvu;
	private float stddvu;
	private float hr;
	private float inso;
	private float pres;
	private float pres_nmar;
	private float ts;
	private float tss20cm;
	private float tss5cm;
	private float ta;
	private float tpr;
	private float tamin;
	private float tamax;
	private float vis;
	private float geo700;
	private Geo850 geo850;
	private float geo925;
	private float rviento;
	private float nieve;

	public String getIdema() {
		return idema;
	}

	public void setIdema(String idema) {
		this.idema = idema;
	}

	public float getLon() {
		return lon;
	}

	public void setLon(float lon) {
		this.lon = lon;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getAlt() {
		return alt;
	}

	public void setAlt(float alt) {
		this.alt = alt;
	}

	public String getUbi() {
		return ubi;
	}

	public void setUbi(String ubi) {
		this.ubi = ubi;
	}

	public String getFint() {
		return fint;
	}

	public void setFint(String fint) {
		this.fint = fint;
	}

	public float getPrec() {
		return prec;
	}

	public void setPrec(float prec) {
		this.prec = prec;
	}

	public float getPacutp() {
		return pacutp;
	}

	public void setPacutp(float pacutp) {
		this.pacutp = pacutp;
	}

	public float getPliqt() {
		return pliqt;
	}

	public void setPliqt(float pliqtp) {
		this.pliqt = pliqtp;
	}

	public float getPsoltp() {
		return psoltp;
	}

	public void setPsoltp(float psolt) {
		this.psoltp = psolt;
	}

	public float getVmax() {
		return vmax;
	}

	public void setVmax(float vmax) {
		this.vmax = vmax;
	}

	public float getVv() {
		return vv;
	}

	public void setVv(float vv) {
		this.vv = vv;
	}

	public float getVmaxu() {
		return vmaxu;
	}

	public void setVmaxu(float vmaxu) {
		this.vmaxu = vmaxu;
	}

	public float getVvu() {
		return vvu;
	}

	public void setVvu(float vvu) {
		this.vvu = vvu;
	}

	public float getDv() {
		return dv;
	}

	public void setDv(float dv) {
		this.dv = dv;
	}

	public float getDvu() {
		return dvu;
	}

	public void setDvu(float dvu) {
		this.dvu = dvu;
	}

	public float getDmax() {
		return dmax;
	}

	public void setDmax(float dmax) {
		this.dmax = dmax;
	}

	public float getDmaxu() {
		return dmaxu;
	}

	public void setDmaxu(float dmaxu) {
		this.dmaxu = dmaxu;
	}

	public float getStdvv() {
		return stdvv;
	}

	public void setStdvv(float stdvv) {
		this.stdvv = stdvv;
	}

	public float getStddv() {
		return stddv;
	}

	public void setStddv(float stdv) {
		this.stddv = stdv;
	}

	public float getStdvvu() {
		return stdvvu;
	}

	public void setStdvvu(float stdvvu) {
		this.stdvvu = stdvvu;
	}

	public float getStddvu() {
		return stddvu;
	}

	public void setStddvu(float stddvu) {
		this.stddvu = stddvu;
	}

	public float getHr() {
		return hr;
	}

	public void setHr(float hr) {
		this.hr = hr;
	}

	public float getInso() {
		return inso;
	}

	public void setInso(float inso) {
		this.inso = inso;
	}

	public float getPres() {
		return pres;
	}

	public void setPres(float pres) {
		this.pres = pres;
	}

	public float getPres_nmar() {
		return pres_nmar;
	}

	public void setPres_nmar(float pres_mar) {
		this.pres_nmar = pres_mar;
	}

	public float getTs() {
		return ts;
	}

	public void setTs(float ts) {
		this.ts = ts;
	}

	public float getTss20cm() {
		return tss20cm;
	}

	public void setTss20cm(float tss20cm) {
		this.tss20cm = tss20cm;
	}

	public float getTss5cm() {
		return tss5cm;
	}

	public void setTss5cm(float tss5cm) {
		this.tss5cm = tss5cm;
	}

	public float getTa() {
		return ta;
	}

	public void setTa(float ta) {
		this.ta = ta;
	}

	public float getTpr() {
		return tpr;
	}

	public void setTpr(float tpr) {
		this.tpr = tpr;
	}

	public float getTamin() {
		return tamin;
	}

	public void setTamin(float tamin) {
		this.tamin = tamin;
	}

	public float getTamax() {
		return tamax;
	}

	public void setTamax(float tamax) {
		this.tamax = tamax;
	}

	public float getVis() {
		return vis;
	}

	public void setVis(float vis) {
		this.vis = vis;
	}

	public float getGeo700() {
		return geo700;
	}

	public void setGeo700(float geo700) {
		this.geo700 = geo700;
	}

	public Geo850 getGeo850() {
		return geo850;
	}

	public void setGeo850(Geo850 geo850) {
		this.geo850 = geo850;
	}

	public float getGeo925() {
		return geo925;
	}

	public void setGeo925(float geo925) {
		this.geo925 = geo925;
	}

	public float getRviento() {
		return rviento;
	}

	public void setRviento(float rviento) {
		this.rviento = rviento;
	}

	public float getNieve() {
		return nieve;
	}

	public void setNieve(float nieve) {
		this.nieve = nieve;
	}

	@Override
	public String toString() {
		return "EstacionMeteo [idema=" + idema + ", lon=" + lon + ", lat=" + lat + ", alt=" + alt + ", ubi=" + ubi
				+ ", fint=" + fint + ", prec=" + prec + ", pacutp=" + pacutp + ", pliqt=" + pliqt + ", psoltp=" + psoltp
				+ ", vmax=" + vmax + ", vv=" + vv + ", vmaxu=" + vmaxu + ", vvu=" + vvu + ", dv=" + dv + ", dvu=" + dvu
				+ ", dmax=" + dmax + ", dmaxu=" + dmaxu + ", stdvv=" + stdvv + ", stddv=" + stddv + ", stdvvu=" + stdvvu
				+ ", stddvu=" + stddvu + ", hr=" + hr + ", inso=" + inso + ", pres=" + pres + ", pres_nmar=" + pres_nmar
				+ ", ts=" + ts + ", tss20cm=" + tss20cm + ", tss5cm=" + tss5cm + ", ta=" + ta + ", tpr=" + tpr
				+ ", tamin=" + tamin + ", tamax=" + tamax + ", vis=" + vis + ", geo700=" + geo700 + ", geo850=" + geo850
				+ ", geo925=" + geo925 + ", rviento=" + rviento + ", nieve=" + nieve + "]";
	}

}