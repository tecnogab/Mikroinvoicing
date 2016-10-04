package ar.com.jgt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.SwingWorker;

import ar.com.jgt.dto.ClienteDTO;
import ar.com.jgt.dto.IpAddressDTO;
import ar.com.jgt.model.AddClientModel;
import ar.com.jgt.model.AddIpModel;
import ar.com.jgt.view.AddClientView;

public class AddClientController implements ActionListener {

	private ClienteDTO cliente = null;
	private IpAddressDTO ipAddress = new IpAddressDTO();
	
	private final static String SEND_DATA_POST = "send_data_post";					//Variable de cadenas constantes para referenciar comandos de acción		
	private AddClientView ui_view = null;
	private AddClientModel m_model = null;

	
	public AddClientController(AddClientView p_view, AddClientModel p_model) {		//Constructor con argumentos que recibe como parametros una VISTA y un MODELO
		ui_view = p_view;
		m_model = p_model;		
	}
	
	public void inicialize(){
		//ui_view.getBtnSaveClient().setActionCommand("send_data_post");
		//ui_view.getBtnSaveClient().addActionListener(this);		
	}
	
	private void setClient(){
		Date date = ui_view.getDateChooser().getDate(); 									//Obtengo la fecha de alta que el usuario ingresa en la vista y lo guardo en una variable del Tipo Date
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");					//Instancia de la clase SimpleDateFormat para dar el formato correcto a la fecha que se desea guardar en la base de datos
		cliente = new ClienteDTO(
				ui_view.getTextDNI().getText(), 
				ui_view.getTextName().getText(), 
				ui_view.getTextLastName().getText(), 
				sdf.format(date));
	}
	
	private void setIpAddress(){
		ipAddress.setIpv4(ui_view.getTextIP().getText());									//Obtengo el numero de IP que el usuario ingresa en la vista y lo guardo en una variable del tipo String
		ipAddress.setIpv6("2002:450:9:10::71");												//Constante del tipo String con una IPV6 - (Pensado por si hay que guardar IPV6 en algun momento)
	}
	
	private void setBtnState(boolean p_flag){
		boolean flag = p_flag;
		if (flag) {
			//ui_view.getBtnSaveClient().setEnabled(true);
			//ui_view.getLblImageClient().setIcon(new ImageIcon(AddClientView.class.getResource("/ar/com/jgt/icons_48x48/businesspeople.png")));
		}else{
			//ui_view.getBtnSaveClient().setEnabled(false);
			//ui_view.getLblImageClient().setIcon(new ImageIcon(AddClientView.class.getResource("/ar/com/jgt/icons_128x128/Loading128x128.gif")));
		}
	}
	
	private void saveClient(){
		SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
			@Override
			protected Void doInBackground() throws Exception {		
				setClient();
				setIpAddress();
				setBtnState(false);
				AddIpModel addIpModel = new AddIpModel();																								//Instancia de la clase AddIpModel utilizada para guardar las IP en el server			
				int l_idCliente = m_model.sendPost(cliente.getDni(), cliente.getNombre(), cliente.getApellido(), cliente.getFechaDeAlta());				//El metodo sendPost de AddClientModel devuelve un entero con el ultimo ID ingresado en la BD			
				addIpModel.sendPostIdAddress(ipAddress.getIpv4(), ipAddress.getIpv6(), l_idCliente);													//El metodo sendPostIdAddress AddIpModel es utilisado para guardar las IPV4, IPV6 y el ID que relaciona las IP con el cliente
				return null;
			}
			@Override
			protected void done(){
				setBtnState(true);
			}				
		};
		worker.execute();
	}	
	
	
	@Override
	public void actionPerformed(ActionEvent p_actionEvent) {						//Metodo heredado de ActionListener para disparar los eventos que llegan de la vista		
		if (p_actionEvent.getActionCommand().equals(SEND_DATA_POST)) {	
			saveClient();
		}
	}
	
}
