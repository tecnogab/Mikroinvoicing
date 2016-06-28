package ar.com.jgt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.SwingWorker;

import ar.com.jgt.model.AddClientModel;
import ar.com.jgt.model.AddIpModel;
import ar.com.jgt.view.AddClientView;

public class AddClientController implements ActionListener {

	/**
	 * Variable de cadenas constantes para referenciar comandos de acción*/
	private final static String SEND_DATA_POST = "send_data_post";
	
	/**
	 * Declaro las variables objetos de la vista y el modelo*/
	private AddClientView ui_view = null;
	private AddClientModel m_model = null;

	/**
	 * Constructor con argumentos que recibe como parametros una VISTA y un MODELO*/
	public AddClientController(AddClientView p_view, AddClientModel p_model) {
		ui_view = p_view;
		m_model = p_model;		
	}
	
	public void inicialize(){
		ui_view.getBtnSaveClient().setActionCommand("send_data_post");
		ui_view.getBtnSaveClient().addActionListener(this);		
	}

	/**Metodo heredado de ActionListener para disparar los eventos que llegan de la vista*/
	@Override
	public void actionPerformed(ActionEvent p_actionEvent) {		
		if (p_actionEvent.getActionCommand().equals(SEND_DATA_POST)) {	
			
			SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){

				@Override
				protected Void doInBackground() throws Exception {
					ui_view.getBtnSaveClient().setEnabled(false);
					ui_view.getLblImageClient().setIcon(new ImageIcon(AddClientView.class.getResource("/ar/com/jgt/icons_128x128/Loading128x128.gif")));
					String l_dni = ui_view.getTextDNI().getText(); 										//Obtengo el DNI que el usuario ingresa en la vista y lo guardo en una variable del Tipo String
					String l_nameCli = ui_view.getTextName().getText(); 								//Obtengo el Nombre que el usuario ingresa en la vista y lo guardo en una variable del Tipo String
					String l_lastNameCli = ui_view.getTextLastName().getText();							//Obtengo el Apellido que el usuario ingresa en la vista y lo guardo en una variable del Tipo String
					Date l_dateUp = ui_view.getDateChooser().getDate(); 								//Obtengo la fecha de alta que el usuario ingresa en la vista y lo guardo en una variable del Tipo Date			
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");					//Instancia de la clase SimpleDateFormat para dar el formato correcto a la fecha que se desea guardar en la base de datos
					String l_dateUpStr = sdf.format(l_dateUp);											//Guardamos la fecha en una variable del tipo String con formato "yyyy-MM-dd HH:mm:ss" 
					String l_ipV4Address = ui_view.getTextIP().getText();								//Obtengo el numero de IP que el usuario ingresa en la vista y lo guardo en una variable del tipo String
					final String l_ipV6Address = "2002:450:9:10::71";									//Constante del tipo String con una IPV6 - (Pensado por si hay que guardar IPV6 en algun momento) 						
					AddIpModel addIpModel = new AddIpModel();											//Instancia de la clase AddIpModel utilizada para guardar las IP en el server			
					int l_idCliente = m_model.sendPost(l_dni, l_nameCli, l_lastNameCli, l_dateUpStr);	//El metodo sendPost de AddClientModel devuelve un entero con el ultimo ID ingresado en la BD			
					addIpModel.sendPostIdAddress(l_ipV4Address, l_ipV6Address, l_idCliente);			//El metodo sendPostIdAddress AddIpModel es utilisado para guardar las IPV4, IPV6 y el ID que relaciona las IP con el cliente
					return null;
				}
				@Override
				protected void done(){
					ui_view.getBtnSaveClient().setEnabled(true);
					ui_view.getLblImageClient().setIcon(new ImageIcon(AddClientView.class.getResource("/ar/com/jgt/icons_48x48/businesspeople.png")));
				}				
			};
			worker.execute();
		}
	}
	
	
	
	
	
}
