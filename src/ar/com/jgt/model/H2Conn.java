package ar.com.jgt.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class H2Conn {

	private Connection m_conn = null;
	private String m_path = "";
	private String m_url = "";
	private String m_user = "";
	private String m_password = "";

	public H2Conn() {
		m_path = System.getProperty("user.dir");
		m_url = "localhost";
		m_user = "sa";
		m_password = "";
	}

	public Connection getConnection() {

		try {
			Class.forName("org.h2.Driver");
			m_conn = DriverManager.getConnection("jdbc:h2:tcp://"+ m_url +":9092/"+ m_path +"/db/mikroinvoicing", m_user, m_password);
		} catch (ClassNotFoundException p_classNotFoundException) {
			JOptionPane.showMessageDialog(null, p_classNotFoundException.getMessage());
			p_classNotFoundException.printStackTrace();
		} catch (SQLException p_SQLException) {
			JOptionPane.showMessageDialog(null, p_SQLException.getMessage());
			p_SQLException.printStackTrace();
		}

		return m_conn;
	}

	public void createDataBase() {
		try {
			initDb();
		} catch (SQLException p_SQLException) {
			p_SQLException.printStackTrace();
		} catch (IOException p_IOException) {
			p_IOException.printStackTrace();
		}
	}

	private void initDb() throws SQLException, IOException {

		InputStream l_is = getClass().getClassLoader().getResourceAsStream("mikroinvoicing.sql");
		BufferedReader l_br = new BufferedReader(new InputStreamReader(l_is));
		Connection l_conn = null;

		try {
			l_conn = getConnection();
			String l_line = l_br.readLine();
			StringBuilder l_statement = new StringBuilder();
			while (l_line != null) {
				l_line = l_line.trim();

				if (!l_line.startsWith("--") && !l_line.startsWith("#") && !l_line.startsWith("//")) {
					l_statement.append(l_line);
					if (l_line.endsWith(";")) {
						executeLine(l_conn, l_statement.toString());
						l_statement = new StringBuilder();
					}
				}
				l_line = l_br.readLine();
			}
			if (l_statement.length() > 0) {
				executeLine(l_conn, l_statement.toString());
			}
		} finally {
			try {
				l_br.close();
			} catch (Exception p_exception) {
				System.out.println(p_exception.getMessage());
			}
			try {
				if (l_conn != null)
					l_conn.close();
			} catch (Exception p_exception) {
				System.out.println(p_exception.getMessage());
			}
		}
	}

	private void executeLine(Connection p_connection, String p_statement) throws SQLException {
		PreparedStatement l_pstmt = p_connection.prepareStatement(p_statement);
		l_pstmt.execute();
		l_pstmt.close();
		System.out.println("Ejecutando " + p_statement);
	}

}
