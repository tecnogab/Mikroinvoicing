package ar.com.jgt.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AddClientDAO {
	
	private H2Conn m_conn = null;
	
	public AddClientDAO(){
		m_conn = new H2Conn();
	}
	
	public void insertClient(String p_clientDNI, String p_clientName, String p_clientLastName,
			String p_clientDateUp) {

		String l_insertClient = "INSERT INTO T_CLIENTS"
				+ "(CLIENT_DNI, CLIENT_NAME, CLIENT_LASTNAME, CLIENT_DATEUP) VALUES"
				+ "(?,?,?,?)";

		Connection l_accessDB = m_conn.getConnection();
		PreparedStatement l_ps = null;

		try {

			l_ps = l_accessDB.prepareStatement(l_insertClient);
			
			l_ps.setString(2, p_clientDNI);
			l_ps.setString(3, p_clientName);
			l_ps.setString(4, p_clientLastName);
			l_ps.setString(5, p_clientDateUp);			

			// execute insert SQL stetement
			l_ps.executeUpdate();
			System.out.println("Record is inserted into T_CLIENTS table!");

		} catch (SQLException p_SQLException) {
			JOptionPane.showMessageDialog(null, p_SQLException);
		}

	}

}
