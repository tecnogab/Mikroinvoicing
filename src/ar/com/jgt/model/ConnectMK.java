package ar.com.jgt.model;

import ar.com.api.mk.ApiConnection;

/**
 *
 * @author gideon
 */
abstract class ConnectMK {

	protected ApiConnection m_conn;

	protected void connect() throws Exception {
		m_conn = ApiConnection.connect(Config.HOST, ApiConnection.DEFAULT_PORT, 2000);
		m_conn.login(Config.USERNAME, Config.PASSWORD);
	}

	protected void disconnect() throws Exception {
		m_conn.close();
	}
}
