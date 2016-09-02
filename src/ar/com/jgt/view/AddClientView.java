package ar.com.jgt.view;

import java.awt.BorderLayout;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JDateChooser;

public class AddClientView extends JInternalFrame {

	private static final long serialVersionUID = -2159577181814466659L;
	
	private JPanel mainPanel;
	private JPanel panelContact;
	
	private JLabel lblName;
	private JLabel lblAddrees;
	private JLabel lblLastName;
	private JLabel lblStreet;
	private JLabel lblNeighborhood;
	private JLabel lblPhone;
	private JLabel lblInfo;
	private JLabel lblFechaDeAlta;
	private JLabel lblIp;
	private JLabel lblImageClient;
	
	private JTextField textNeighborhood;
	private JTextField textStreet;
	private JTextField textPhone;
	private JTextField textName;
	private JTextField textLastName;
	private JTextField textIP;
	private JTextField textDNI;
			
	private JDateChooser dateChooser;
	
	private JButton btnSaveClient;

	/**
	 * Create the frame.
	 */
	public AddClientView() {
		setClosable(true);
		setTitle("Alta de clientes");
		setFrameIcon(new ImageIcon(AddClientView.class.getResource("/ar/com/jgt/icons_16x16/businesspeople.png")));		
		setBounds(100, 100, 450, 440);
		
		mainPanel = new JPanel();
		getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(null);
		
		lblName = new JLabel("DNI:");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setBounds(10, 14, 90, 14);		
		mainPanel.add(lblName);
		
		lblAddrees = new JLabel("Nombre:");
		lblAddrees.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddrees.setBounds(10, 39, 90, 14);
		mainPanel.add(lblAddrees);
		
		lblLastName = new JLabel("Apellido:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setBounds(10, 64, 90, 14);
		mainPanel.add(lblLastName);
		
		lblFechaDeAlta = new JLabel("Fecha de alta:");
		lblFechaDeAlta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFechaDeAlta.setBounds(10, 89, 90, 14);
		mainPanel.add(lblFechaDeAlta);
		
		lblIp = new JLabel("IP:");
		lblIp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIp.setBounds(10, 114, 90, 14);
		mainPanel.add(lblIp);
		
		textDNI = new JTextField();
		textDNI.setBounds(110, 11, 135, 20);
		mainPanel.add(textDNI);
		textDNI.setColumns(10);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(110, 36, 135, 20);
		mainPanel.add(textName);
		
		textLastName = new JTextField();
		textLastName.setColumns(10);
		textLastName.setBounds(110, 61, 135, 20);
		mainPanel.add(textLastName);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(110, 86, 135, 20);
		mainPanel.add(dateChooser);
		
		textIP = new JTextField();
		textIP.setBounds(110, 111, 135, 20);
		mainPanel.add(textIP);
		textIP.setColumns(10);
		
		panelContact = new JPanel();
		panelContact.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Inf. de Contacto", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panelContact.setBounds(10, 139, 414, 149);
		mainPanel.add(panelContact);
		panelContact.setLayout(null);
		
		lblNeighborhood = new JLabel("Barrio:");
		lblNeighborhood.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNeighborhood.setBounds(10, 27, 95, 14);
		panelContact.add(lblNeighborhood);
		
		lblStreet = new JLabel("Domicilio/Calle:");
		lblStreet.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStreet.setBounds(10, 52, 95, 14);
		panelContact.add(lblStreet);				
		
		lblPhone = new JLabel("T\u00E9lefono:");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setBounds(10, 77, 95, 14);
		panelContact.add(lblPhone);
		
		textNeighborhood = new JTextField();
		textNeighborhood.setBounds(115, 24, 289, 20);
		panelContact.add(textNeighborhood);
		textNeighborhood.setColumns(10);
		
		textStreet = new JTextField();
		textStreet.setBounds(115, 49, 289, 20);
		panelContact.add(textStreet);
		textStreet.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setBounds(115, 74, 289, 20);
		panelContact.add(textPhone);
		textPhone.setColumns(10);
		
		lblInfo = new JLabel("");
		lblInfo.setBounds(10, 102, 394, 14);
		panelContact.add(lblInfo);			
		
		lblImageClient = new JLabel("");
		lblImageClient.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageClient.setIcon(new ImageIcon(AddClientView.class.getResource("/ar/com/jgt/icons_48x48/businesspeople.png")));
		lblImageClient.setBounds(255, 14, 169, 114);
		mainPanel.add(lblImageClient);
		
		btnSaveClient = new JButton("");
		btnSaveClient.setIcon(new ImageIcon(AddClientView.class.getResource("/ar/com/jgt/icons_64x64/data_floppy_disk.png")));
		btnSaveClient.setBounds(307, 300, 113, 91);
		mainPanel.add(btnSaveClient);
				
	}

	public JTextField getTextNeighborhood() {
		return textNeighborhood;
	}

	public void setTextNeighborhood(JTextField textNeighborhood) {
		this.textNeighborhood = textNeighborhood;
	}

	public JTextField getTextStreet() {
		return textStreet;
	}

	public void setTextStreet(JTextField textStreet) {
		this.textStreet = textStreet;
	}

	public JTextField getTextPhone() {
		return textPhone;
	}

	public void setTextPhone(JTextField textPhone) {
		this.textPhone = textPhone;
	}

	public JTextField getTextName() {
		return textName;
	}

	public void setTextName(JTextField textName) {
		this.textName = textName;
	}

	public JTextField getTextLastName() {
		return textLastName;
	}

	public void setTextLastName(JTextField textLastName) {
		this.textLastName = textLastName;
	}

	public JTextField getTextIP() {
		return textIP;
	}

	public void setTextIP(JTextField textIP) {
		this.textIP = textIP;
	}

	public JTextField getTextDNI() {
		return textDNI;
	}

	public void setTextDNI(JTextField textDNI) {
		this.textDNI = textDNI;
	}

	public JDateChooser getDateChooser() {
		return dateChooser;
	}

	public void setDateChooser(JDateChooser dateChooser) {
		this.dateChooser = dateChooser;
	}

	public JButton getBtnSaveClient() {
		return btnSaveClient;
	}

	public void setBtnSaveClient(JButton btnSaveClient) {
		this.btnSaveClient = btnSaveClient;
	}

	public JLabel getLblImageClient() {
		return lblImageClient;
	}

	public void setLblImageClient(JLabel lblImageClient) {
		this.lblImageClient = lblImageClient;
	}
}
