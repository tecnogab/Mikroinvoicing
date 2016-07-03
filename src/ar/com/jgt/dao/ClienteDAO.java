package ar.com.jgt.dao;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import ar.com.jgt.conexion.Conexion;
import ar.com.jgt.dto.ClienteDTO;
import ar.com.jgt.interfaces.Grabable;

public class ClienteDAO implements Grabable<ClienteDTO> {	

	private final Conexion conn = Conexion.conectar("listenPostAddClient.php");
	private ClienteJSON clienteJSON = null;
	private DataOutputStream dos = null;
	private BufferedReader br = null;
	private StringBuffer brResponse = null;
	private String strInputLine = "";
	private int idClient = 0;
	
	@Override
	public int create(ClienteDTO p_cliente) {				
		clienteJSON = new ClienteJSON();																					
		try {
			dos = new DataOutputStream(conn.getHttpURLconn().getOutputStream());
			dos.writeBytes(clienteJSON.createJSON(p_cliente));
			dos.flush();
			dos.close();			
			br = new BufferedReader(new InputStreamReader(conn.getHttpURLconn().getInputStream()));			
			brResponse = new StringBuffer();
			while ((strInputLine = br.readLine()) != null) {
				brResponse.append(strInputLine);
			}		
			br.close();
			idClient = Integer.parseInt(brResponse.toString().replaceAll("\\s",""));		//Capturo el Id auto generedo
		} catch (IOException p_IOException) {
			p_IOException.printStackTrace();
		}finally {
			conn.cerrarConexion();
		}		 																										
		return idClient;
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
