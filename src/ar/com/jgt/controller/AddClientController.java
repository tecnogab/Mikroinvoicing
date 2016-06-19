package ar.com.jgt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JInternalFrame;

import ar.com.jgt.model.AddClientModel;
import ar.com.jgt.model.AddIpModel;
import ar.com.jgt.view.AddClientView;

public class AddClientController implements ActionListener {

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

	public JInternalFrame initialize() {
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
			
			String l_dni = ui_view.getTextDNI().getText();
			String l_nameCli = ui_view.getTextName().getText();
			String l_lastNameCli = ui_view.getTextLastName().getText();
			Date l_dateUp = ui_view.getDateChooser().getDate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String l_dateUpStr = sdf.format(l_dateUp);
			String l_ipV4Address = ui_view.getTextIP().getText();
			String l_ipV6Address = "2002:450:9:10::71";
			
			AddIpModel addIpModel = new AddIpModel();
			
			int l_idCliente = m_model.sendPost(l_dni, l_nameCli, l_lastNameCli, l_dateUpStr);						
			addIpModel.sendPostIdAddress(l_ipV4Address, l_ipV6Address, l_idCliente);
			
			
		}
	}

}
