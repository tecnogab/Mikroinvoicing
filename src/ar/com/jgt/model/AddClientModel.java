package ar.com.jgt.model;

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

public class AddClientModel {
	
	/**
     * @param args the command line arguments
     */
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String SERVER_PATH = "http://seguidorgps.com/mki/clients/";
    

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public int sendPost(String p_dni, String p_nombre, String p_apellido, String p_fecha_up){
        //Creamos un objeto JSON
        JSONObject l_jsonObj = new JSONObject();
        //Añadimos dni, nombre, apellido y fecha de alta
        l_jsonObj.put("dni", p_dni);
        l_jsonObj.put("nombre", p_nombre);
        l_jsonObj.put("apellido", p_apellido);
        l_jsonObj.put("fecha_up", p_fecha_up);
        
        //Creamos una lista para almacenar el JSON
        List  l_list = new LinkedList();
        l_list.addAll(Arrays.asList(l_jsonObj));
        
        //Generamos el String JSON
        String l_jsonString = JSONValue.toJSONString(l_list);
        //System.out.println("JSON GENERADO:");
        //System.out.println(l_jsonString);
        
        int l_idClient = 0;
        
        try {
            //Codificar el json a URL
            l_jsonString = URLEncoder.encode(l_jsonString, "UTF-8");
            
            //Generar la URL
            String l_url = SERVER_PATH + "listenPostAddClient.php";
            
            //Creamos un nuevo objeto URL con la url donde queremos enviar el JSON
            URL l_URLObj = new URL(l_url);
            
            //Creamos un objeto de conexión
            HttpURLConnection l_con = (HttpURLConnection) l_URLObj.openConnection();
            
            //Añadimos la cabecera
            l_con.setRequestMethod("POST");
            l_con.setRequestProperty("User-Agent", USER_AGENT);
            l_con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            
            //Creamos los parametros para enviar
            String l_urlParameters = "json=" + l_jsonString;
            
            //Enviamos los datos por POST
            l_con.setDoOutput(true);
            DataOutputStream l_dos = new DataOutputStream(l_con.getOutputStream());
            l_dos.writeBytes(l_urlParameters);
            l_dos.flush();
            l_dos.close();
            
            //Capturamos la respuesta del servidor
            //int l_responseCode = l_con.getResponseCode();
            //System.out.println("\nSending 'POST' request to URL : " + l_url);
            //System.out.println("Post parameters : " + l_urlParameters);
            //System.out.println("Response Code : " + l_responseCode);
 
            BufferedReader l_br = new BufferedReader(new InputStreamReader(l_con.getInputStream()));
            String l_inputLine;
            StringBuffer l_SBResponse = new StringBuffer();
 
            while ((l_inputLine = l_br.readLine()) != null) {
                l_SBResponse.append(l_inputLine);
            }
            //Capturo el Id auto generedo
            l_idClient = Integer.parseInt(l_SBResponse.toString().replaceAll("\\s",""));
            //System.out.println(id_client);
            //System.out.println(l_SBResponse);
            
            //cerramos la conexión
            l_br.close();
        } catch (Exception p_exception) {
            p_exception.printStackTrace();
        }
        return l_idClient ;
    }

}
