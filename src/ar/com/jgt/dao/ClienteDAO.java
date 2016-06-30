package ar.com.jgt.dao;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import ar.com.jgt.conexion.Conexion;
import ar.com.jgt.dto.ClienteDTO;
import ar.com.jgt.interfaces.Grabable;

public class ClienteDAO implements Grabable<ClienteDTO> {
	
	private JSONObject jsonObj = null;
	private List<JSONObject> l_list = null;
	private String jsonString = "";
	final Conexion conn = Conexion.conectar("listenPostAddClient.php");
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean create(ClienteDTO p_cliente) {
		
		jsonObj = new JSONObject(); 																						// Creamos un objeto JSON		
		jsonObj.put("dni", p_cliente.getDni()); 																			// AÒadimos dni									
		jsonObj.put("nombre", p_cliente.getNombre());																		// AÒadimos nombre
		jsonObj.put("apellido", p_cliente.getApellido());																	// AÒadimos apellido
		jsonObj.put("fecha_up", p_cliente.getFechaDeAlta());																// AÒadimos fecha de alta				
		l_list = new LinkedList<JSONObject>(); 																				// Creamos una lista para almacenar JSON
		l_list.addAll(Arrays.asList(jsonObj));				
		jsonString = JSONValue.toJSONString(l_list); 																		// Generamos el String JSON
		
		int idClient = 0;
		
		try {
			
			jsonString = URLEncoder.encode(jsonString, "UTF-8"); 															// Codificar el json a URL			
			String l_urlParameters = "json=" + jsonString; 																	// Creamos los parametros para enviar
			
			conn.getHttpURLconn().setDoOutput(true);
			DataOutputStream dos = new DataOutputStream(conn.getHttpURLconn().getOutputStream());
			dos.writeBytes(l_urlParameters);
			dos.flush();
			dos.close();
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getHttpURLconn().getInputStream()));
			String inputLine;
			StringBuffer l_SBResponse = new StringBuffer();

			while ((inputLine = br.readLine()) != null) {
				l_SBResponse.append(inputLine);
			}
			idClient = Integer.parseInt(l_SBResponse.toString().replaceAll("\\s", "")); 									// Capturo el Id auto generedo

			br.close(); 																									// cerramos la conexi√≥n
		} catch (Exception p_exception) {
			p_exception.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Object p_key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(ClienteDTO p_datos) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ClienteDTO read(Object p_key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteDTO> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
