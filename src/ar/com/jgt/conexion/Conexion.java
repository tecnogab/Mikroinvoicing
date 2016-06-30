package ar.com.jgt.conexion;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Conexion {
	
	private static final String USER_AGENT = "Mozilla/5.0";    
	private static final String SERVER_PATH = "http://seguidorgps.com/mki/clients/";
	
	public static Conexion instance;																
	private HttpURLConnection httpURLconn;	
	
	private Conexion(String p_url){
		URL URLObj;		
		try {									
			URLObj = new URL(SERVER_PATH + p_url);
			httpURLconn = (HttpURLConnection) URLObj.openConnection();
			httpURLconn.setRequestMethod("POST");														
			httpURLconn.setRequestProperty("User-Agent", USER_AGENT);
			httpURLconn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");			
			httpURLconn.setDoOutput(true);
		} catch (MalformedURLException p_MalformedURLException) {
			p_MalformedURLException.printStackTrace();
		} catch (IOException p_IOException) {			
			p_IOException.printStackTrace();
		}
	}	
	public synchronized static Conexion conectar(String p_url){											
		if (instance == null) {
			instance = new Conexion(p_url);
		}
		return instance;
	}
	public HttpURLConnection getHttpURLconn() {		
		return httpURLconn;
	}	
	public void cerrarConexion(){
		instance = null;
	}	
}
