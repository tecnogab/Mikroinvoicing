package ar.com.jgt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

import ar.com.jgt.model.AddClientModel;
import ar.com.jgt.model.MikroInvoicingModel;
import ar.com.jgt.model.StartTcpServerForH2;
import ar.com.jgt.view.AddClientView;
import ar.com.jgt.view.MKIMainView;
import ar.com.jgt.view.SearchClientView;

public class MKIController implements ActionListener {

	/**
	 * Variable de cadenas constantes para hacer referencia a comandos de acciÃ³n
	 */
	private final static String SHOW_ADDCLIENTS = "show_addclients";
	private final static String SHOW_SEARCH_CLIENT = "search_client";
	private final static String START_SERVER_H2 = "start_server_h2";

	private MKIMainView ui_view = null;
	private MikroInvoicingModel m_model = null;
	private ButtonGroup m_group = null;

	/**
	 * Main Builder
	 */
	public MKIController(MKIMainView p_view, MikroInvoicingModel p_model) {
		ui_view = p_view;
		m_model = p_model;
	}

	public void initialize() {

		/** Instancia de la vista principal y su modelo */
		ui_view = new MKIMainView();
		m_model = new MikroInvoicingModel();

		/**
		 * Instancia de ButtonGroup para agrupar los radio buttons de arranque y
		 * parada del servidor H2
		 */
		m_group = new ButtonGroup();

		/**
		 * Seteo de acciones y comandos de MKIMainView
		 */
		ui_view.setVisible(true);
		ui_view.setLocationRelativeTo(null);
		ui_view.getBtnAddClient().addActionListener(this);
		ui_view.getBtnAddClient().setActionCommand("show_addclients");
		ui_view.getBtnSearchClients().addActionListener(this);
		ui_view.getBtnSearchClients().setActionCommand("search_client");
		ui_view.getRdbServerMode().addActionListener(this);
		ui_view.getRdbServerMode().setActionCommand("start_server_h2");

		/** Al cerrar la ventana principal se detiene el servidor H2DB */
		windowClosing();

		/** Añado al buttonGroup los radio buttons del menu de configuración */
		m_group.add(ui_view.getRdbClientMode());
		m_group.add(ui_view.getRdbServerMode());
	}

	@Override
	public void actionPerformed(ActionEvent p_actionEvent) {
		
		/**Comando, evento para mostrar la ventana AddClient*/
		if (p_actionEvent.getActionCommand().equals(SHOW_ADDCLIENTS)) {
			AddClientView l_ACV = new AddClientView();
			AddClientModel l_ACM = new AddClientModel();						
			instanceControl(l_ACV);
			AddClientController l_ACC = new AddClientController(l_ACV, l_ACM);
			l_ACC.inicialize();
		}
		
		/**Comando, evento para mostrar la ventana SearchClientView*/
		if (p_actionEvent.getActionCommand().equals(SHOW_SEARCH_CLIENT)) {
			instanceControl(new SearchClientView());
		}
		/**Comando, evento para arrancar el servidor H2*/
		if (p_actionEvent.getActionCommand().equals(START_SERVER_H2)) {
			if (ui_view.getRdbServerMode().isSelected()) {
				StartTcpServerForH2.start();
				ui_view.getLblModeManifest().setIcon(
						new ImageIcon(MKIController.class.getResource("/ar/com/jgt/icons_32x32/server_earth.png")));
			}
		}

	}
	
	/**
	 * Método que controla la manera en que se crea una instancia única de una
	 * ventana interna
	 */
	private void instanceControl(JInternalFrame p_internalFrame) {
		/**
		 * Compruebe si existe una instancia de un componente en JDesktopPane
		 */
		boolean l_viewFlag = true;
		for (int a = 0; a < ui_view.getDesktopPane().getComponentCount(); a++) {
			if (p_internalFrame.getClass().isInstance(ui_view.getDesktopPane().getComponent(a))) {
				p_internalFrame.toFront();
				ui_view.getDesktopPane().moveToFront(p_internalFrame);
				l_viewFlag = false;
			} else {
				// System.out.println("No lo es, puede mostrarse");
			}
		}
	
		if (l_viewFlag) {
			ui_view.getDesktopPane().add(p_internalFrame);
		}
		p_internalFrame.setVisible(true);
	}

	/**
	 * Controles en el evento windowClosing
	 */
	private void windowClosing() {
		ui_view.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent p_windowEvent) {
				m_model.closeH2Server();
			}
		});
	}
}
