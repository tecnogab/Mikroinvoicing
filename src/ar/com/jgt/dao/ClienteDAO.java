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

	private final Conexion m_conn = Conexion.conectar("listenPostAddClient.php");
	private ClienteJSON m_clienteJSON = null;
	private DataOutputStream m_dos = null;
	private BufferedReader m_br = null;
	private StringBuffer m_brResponse = null;
	private String m_strInputLine = "";
	private int m_idClient = 0;
	
	@Override
	public int create(ClienteDTO p_cliente) {				
		m_clienteJSON = new ClienteJSON();																					
		try {
			m_dos = new DataOutputStream(m_conn.getHttpURLconn().getOutputStream());
			m_dos.writeBytes(m_clienteJSON.createJSON(p_cliente));
			m_dos.flush();
			m_dos.close();			
			m_br = new BufferedReader(new InputStreamReader(m_conn.getHttpURLconn().getInputStream()));			
			m_brResponse = new StringBuffer();
			while ((m_strInputLine = m_br.readLine()) != null) {
				m_brResponse.append(m_strInputLine);
			}		
			m_br.close();
			//idClient = Integer.parseInt(brResponse.toString().replaceAll("\\s",""));		//Capturo el Id auto generedo			
		} catch (IOException p_IOException) {
			p_IOException.printStackTrace();
		}finally {
			m_conn.cerrarConexion();
		}		 																										
		return m_idClient;
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
