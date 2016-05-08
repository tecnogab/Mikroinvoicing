package ar.com.jgt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;

import ar.com.jgt.model.MikroInvoicingDAO;
import ar.com.jgt.model.StartTcpServerForH2;
import ar.com.jgt.view.AddClientView;
import ar.com.jgt.view.MKIMainView;
import ar.com.jgt.view.SearchClientView;

public class MKIController implements ActionListener {

	private ButtonGroup m_group = new ButtonGroup();

	/** The Constant String VARIABLE to reference ActionCommands */
	private final static String SHOW_ADDCLIENTS_VIEW = "show_addclients_view";
	private final static String SHOW_SEARCH_CLIENT_VIEW = "search_client_view";
	private final static String START_SERVER_H2 = "start_server_h2";

	/** Instance of the main view and main model */
	MKIMainView ui_mainView = new MKIMainView();
	MikroInvoicingDAO m_mainModel = new MikroInvoicingDAO();

	AddClientView ui_addClients = new AddClientView();
	SearchClientView ui_searchClients = new SearchClientView();

	/**
	 * Main Builder
	 */
	public MKIController(MKIMainView p_view, MikroInvoicingDAO p_model) {
		this.ui_mainView = p_view;
		this.m_mainModel = p_model;

		this.ui_mainView.getBtnAddClient().addActionListener(this);
		this.ui_mainView.getBtnAddClient().setActionCommand("show_addclients_view");
		this.ui_mainView.getBtnSearchClients().addActionListener(this);
		this.ui_mainView.getBtnSearchClients().setActionCommand("search_client_view");

		this.ui_mainView.getRdbServerMode().addActionListener(this);
		this.ui_mainView.getRdbServerMode().setActionCommand("start_server_h2");

		this.ui_mainView.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent p_windowEvent) {
				if (StartTcpServerForH2.isRunning()) {
					StartTcpServerForH2.stop();
				}
			}
		});

		m_group.add(this.ui_mainView.getRdbClientMode());
		m_group.add(this.ui_mainView.getRdbServerMode());
	}

	@Override
	public void actionPerformed(ActionEvent p_actionEvent) {
		// TODO SHOW_ADDCLIENTS_VIEW
		if (p_actionEvent.getActionCommand().equals(SHOW_ADDCLIENTS_VIEW)) {
			instanceControl(ui_addClients);
		}
		//TODO SHOW_SEARCH_CLIENT_VIEW
		if (p_actionEvent.getActionCommand().equals(SHOW_SEARCH_CLIENT_VIEW)) {
			instanceControl(ui_searchClients);
		}
		//TODO START_SERVER_H2
		if (p_actionEvent.getActionCommand().equals(START_SERVER_H2)) {
			if (this.ui_mainView.getRdbServerMode().isSelected()) {
				StartTcpServerForH2.start();
				this.ui_mainView.getLblModeManifest().setIcon(
						new ImageIcon(MKIController.class.getResource("/ar/com/jgt/icons_32x32/server_earth.png")));
			}
		}

	}

	/** Control method so that only an internal window is instantiated */
	private void instanceControl(JInternalFrame p_internalFrame) {
		boolean l_viewFlag = true;
		/*
		 * Check if instance of a component that is already in the JDesktopPane
		 */
		for (int a = 0; a < ui_mainView.getDesktopPane().getComponentCount(); a++) {
			if (p_internalFrame.getClass().isInstance(ui_mainView.getDesktopPane().getComponent(a))) {
				p_internalFrame.toFront();
				ui_mainView.getDesktopPane().moveToFront(p_internalFrame);
				l_viewFlag = false;
			} else {
				System.out.println("No lo es, puede mostrarse");
			}
		}

		if (l_viewFlag) {
			ui_mainView.getDesktopPane().add(p_internalFrame);
		}
		p_internalFrame.show();
	}
}
