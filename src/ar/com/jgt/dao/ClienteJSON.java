package ar.com.jgt.dao;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import ar.com.jgt.dto.ClienteDTO;
import ar.com.jgt.interfaces.GrabableJSON;

public class ClienteJSON implements GrabableJSON<ClienteDTO>{

	private JSONObject m_jsonObj = null;
	private List<JSONObject> m_JOSONlist = null;
	private String m_jsonString = "";
	private String m_urlParameters = "";
	
	@SuppressWarnings("unchecked")
	@Override
	public String createJSON(ClienteDTO p_json) {
		
		m_jsonObj = new JSONObject(); 													//Creamos un objeto JSON		
		m_jsonObj.put("dni", p_json.getDni()); 											//Añadimos dni									
		m_jsonObj.put("nombre", p_json.getNombre());									//Añadimos nombre
		m_jsonObj.put("apellido", p_json.getApellido());								//Añadimos apellido
		m_jsonObj.put("fecha_up", p_json.getFechaDeAlta());								//Añadimos fecha de alta				
		m_JOSONlist = new LinkedList<JSONObject>(); 									//Creamos una lista para almacenar JSON
		m_JOSONlist.addAll(Arrays.asList(m_jsonObj));									//Se añade a la lista los objetos JSON
		m_jsonString = JSONValue.toJSONString(m_JOSONlist); 							//Generamos el String JSON		
		System.out.println(m_jsonString);
		try {
			m_jsonString = URLEncoder.encode(m_jsonString, "UTF-8");
		} catch (UnsupportedEncodingException p_UnsupportedEncodingException) {
			p_UnsupportedEncodingException.printStackTrace();
		} 																				//Codificar el json a URL			
		m_urlParameters = "json=" + m_jsonString; 										//Creamos los parametros para enviar
		System.out.println(m_jsonString);
		return m_urlParameters;		
	}
}
