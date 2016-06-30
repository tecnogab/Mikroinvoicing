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
	
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String SERVER_PATH = "http://seguidorgps.com/mki/clients/";
    

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public int sendPost(String p_dni, String p_nombre, String p_apellido, String p_fecha_up){
        
    	JSONObject l_jsonObj = new JSONObject();	        									//Creamos un objeto JSON
        l_jsonObj.put("dni", p_dni);															//Añadimos dni, nombre, apellido y fecha de alta
        l_jsonObj.put("nombre", p_nombre);
        l_jsonObj.put("apellido", p_apellido);
        l_jsonObj.put("fecha_up", p_fecha_up);
        List l_list = new LinkedList();												        	//Creamos una lista para almacenar el JSON
        l_list.addAll(Arrays.asList(l_jsonObj));
        String l_jsonString = JSONValue.toJSONString(l_list);									//Generamos el String JSON        
        System.out.println("JSON GENERADO:");
        System.out.println(l_jsonString);        
        
        int l_idClient = 0;
        
        try {
                    	
        	l_jsonString = URLEncoder.encode(l_jsonString, "UTF-8");							//Codificar el json a URL            
            String l_url = SERVER_PATH + "listenPostAddClient.php";            					//Generar la URL
            URL l_URLObj = new URL(l_url);														//Creamos un nuevo objeto URL con la url donde queremos enviar el JSON            
            HttpURLConnection l_con = (HttpURLConnection) l_URLObj.openConnection();			//Creamos un objeto de conexión            
            l_con.setRequestMethod("POST");														//Añadimos la cabecera
            l_con.setRequestProperty("User-Agent", USER_AGENT);
            l_con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");                          
            
            String l_urlParameters = "json=" + l_jsonString;            						//Creamos los parametros para enviar            
            l_con.setDoOutput(true);															//Enviamos los datos por POST
            DataOutputStream l_dos = new DataOutputStream(l_con.getOutputStream());
            l_dos.writeBytes(l_urlParameters);
            l_dos.flush();
            l_dos.close();
            
            /**
             * int l_responseCode = l_con.getResponseCode();										//Capturamos la respuesta del servidor
             * System.out.println("\nSending 'POST' request to URL : " + l_url);
             * System.out.println("Post parameters : " + l_urlParameters);
             * System.out.println("Response Code : " + l_responseCode);
             * */

            BufferedReader l_br = new BufferedReader(new InputStreamReader(l_con.getInputStream()));
            String l_inputLine;
            StringBuffer l_SBResponse = new StringBuffer();
 
            while ((l_inputLine = l_br.readLine()) != null) {
                l_SBResponse.append(l_inputLine);
            }
            l_idClient = Integer.parseInt(l_SBResponse.toString().replaceAll("\\s",""));		//Capturo el Id auto generedo
            /**
             * System.out.println(id_client);
             * System.out.println(l_SBResponse);
             * */
            
            l_br.close();            															//cerramos la conexiÃ³n
        } catch (Exception p_exception) {
            p_exception.printStackTrace();
        }
        return l_idClient ;
    }

}
