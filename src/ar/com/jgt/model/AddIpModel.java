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

public class AddIpModel {

	/**
	 * @param args
	 *            the command line arguments
	 */
	private static final String USER_AGENT = "Mozilla/5.0";
	private static final String SERVER_PATH = "http://seguidorgps.com/mki/ips/";

	public static String getJSON() {

		StringBuffer l_response = null;

		try {
			// Generar la URL
			String l_url = SERVER_PATH + "getClients.php";
			// Creamos un nuevo objeto URL con la url donde pedir el JSON
			URL l_URLObj = new URL(l_url);
			// Creamos un objeto de conexión
			HttpURLConnection l_conn = (HttpURLConnection) l_URLObj.openConnection();
			// Añadimos la cabecera
			l_conn.setRequestMethod("POST");
			l_conn.setRequestProperty("User-Agent", USER_AGENT);
			l_conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			// Enviamos la petición por POST
			l_conn.setDoOutput(true);

			// Capturamos la respuesta del servidor
			int l_responseCode = l_conn.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + l_url);
			System.out.println("Response Code : " + l_responseCode);

			BufferedReader l_br = new BufferedReader(new InputStreamReader(l_conn.getInputStream()));
			String l_inputLine;
			l_response = new StringBuffer();

			while ((l_inputLine = l_br.readLine()) != null) {
				l_response.append(l_inputLine);
			}
			// Mostramos la respuesta del servidor por consola
			System.out.println("Respuesta del servidor: " + l_response);
			System.out.println();
			// cerramos la conexión
			l_br.close();
		} catch (Exception p_exception) {
			p_exception.printStackTrace();
		}

		return l_response.toString();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void sendPostIdAddress(String p_ipv4, String p_ipv6, int p_idClient) {
		// Creamos un objeto JSON
		JSONObject l_jsonObj = new JSONObject();
		// Añado los números de ip
		l_jsonObj.put("ipv4", p_ipv4);
		l_jsonObj.put("ipv6", p_ipv6);
		l_jsonObj.put("id_client", p_idClient);

		// Creamos una lista para almacenar el JSON
		List l_list = new LinkedList();
		l_list.addAll(Arrays.asList(l_jsonObj));

		// Generamos el String JSON
		String l_jsonString = JSONValue.toJSONString(l_list);
		/**System.out.println("JSON GENERADO:");
		System.out.println(l_jsonString);*/
		try {
			// Codificar el json a URL
			l_jsonString = URLEncoder.encode(l_jsonString, "UTF-8");

			// Generar la URL
			String l_url = SERVER_PATH + "listenPostAddIp.php";

			// Creamos un nuevo objeto URL con la url donde queremos enviar el JSON
			URL l_URLObj = new URL(l_url);

			// Creamos un objeto de conexión
			HttpURLConnection l_con = (HttpURLConnection) l_URLObj.openConnection();

			// Añadimos la cabecera
			l_con.setRequestMethod("POST");
			l_con.setRequestProperty("User-Agent", USER_AGENT);
			l_con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			// Creamos los parametros para enviar
			String l_urlParameters = "json=" + l_jsonString;

			// Enviamos los datos por POST
			l_con.setDoOutput(true);
			DataOutputStream l_dos = new DataOutputStream(l_con.getOutputStream());
			l_dos.writeBytes(l_urlParameters);
			l_dos.flush();
			l_dos.close();

			// Capturamos la respuesta del servidor
			/**int l_responseCode = l_con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + l_url);
			System.out.println("Post parameters : " + l_urlParameters);
			System.out.println("Response Code : " + l_responseCode);*/

			BufferedReader l_br = new BufferedReader(new InputStreamReader(l_con.getInputStream()));
			String l_inputLine;
			StringBuffer l_SBResponse = new StringBuffer();

			while ((l_inputLine = l_br.readLine()) != null) {
				l_SBResponse.append(l_inputLine);
			}
			// Mostramos la respuesta del servidor por consola
			/**System.out.println(l_SBResponse);*/
			// cerramos la conexión
			l_br.close();
		} catch (Exception p_exception) {
			p_exception.printStackTrace();
		}
	}
}