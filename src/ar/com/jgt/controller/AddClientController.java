package ar.com.jgt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;

import ar.com.jgt.model.AddClientModel;
import ar.com.jgt.view.AddClientView;

public class AddClientController implements ActionListener{
	
	/**
	 * Variable de cadenas constantes para referenciar comandos de acción
	 */
	private final static String SEND_DATA_POST = "send_data_post";
	
	private AddClientView ui_view = null;
	private AddClientModel m_model = null;
	
	public AddClientController(AddClientView p_view, AddClientModel p_model) {
		ui_view = p_view;
		m_model = p_model;
	}
	
	public JInternalFrame initialize(){
		ui_view = new AddClientView();
		m_model = new AddClientModel();
		ui_view.getBtnSaveClient().setActionCommand("send_data_post");
		ui_view.getBtnSaveClient().addActionListener(this);
		return ui_view;
	}

	@Override
	public void actionPerformed(ActionEvent p_actionEvent) {
		// TODO Auto-generated method stub
		if (p_actionEvent.getActionCommand().equals(SEND_DATA_POST)) {
			System.out.println(m_model.sendPost(ui_view.getTextDNI().getText(), 
					ui_view.getTextName().getText(), 
					ui_view.getTextLastName().getText(), 
					ui_view.getDateChooser().getDate().toString()));
		}
	}

}
