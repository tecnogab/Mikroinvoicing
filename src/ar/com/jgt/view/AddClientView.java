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

import ar.com.jgt.controller.AddClientComboController;

import javax.swing.JComboBox;

public class AddClientView extends JInternalFrame {

	private static final long serialVersionUID = -2159577181814466659L;
	
	private static final String[] ESTACIONES_BASE = {"Lopéz y Planes", "Torre Pizarro"};
	private final String[] PANELES_LPLANES = {"Norte", "Sur", "Este", "Oeste"};
	
	private JPanel mainPanel;
	private JPanel panelContact;
	
	private JLabel lblName;
	private JLabel lblAddrees;
	private JLabel lblLastName;
	private JLabel lblStreet;
	private JLabel lblNeighborhood;
	private JLabel lblPhone;
	private JLabel lblFechaDeAlta;
	private JLabel lblIp;
	
	private JTextField textNeighborhood;
	private JTextField textStreet;
	private JTextField textPhone;
	private JTextField textName;
	private JTextField textLastName;
	private JTextField textIP;
	private JTextField textDNI;
			
	private JDateChooser dateChooser;
	@SuppressWarnings("rawtypes")
	private JComboBox cbBase;
	private JLabel lblBase;
	private JLabel lblPanel;
	@SuppressWarnings("rawtypes")
	private JComboBox cbPanel;
	private JButton btnNewButton;
	private JLabel lblSmsServer;
	private JLabel lblNewLabel;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public AddClientView() {
		setClosable(true);
		setTitle("Alta de clientes");
		setFrameIcon(new ImageIcon(AddClientView.class.getResource("/ar/com/jgt/icons_16x16/businesspeople.png")));		
		setBounds(100, 100, 375, 430);
		
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
		textDNI.setBounds(110, 11, 239, 20);
		mainPanel.add(textDNI);
		textDNI.setColumns(10);
		
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(110, 36, 239, 20);
		mainPanel.add(textName);
		
		textLastName = new JTextField();
		textLastName.setColumns(10);
		textLastName.setBounds(110, 61, 239, 20);
		mainPanel.add(textLastName);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(110, 86, 239, 20);
		mainPanel.add(dateChooser);
		
		textIP = new JTextField();
		textIP.setBounds(110, 111, 239, 20);
		mainPanel.add(textIP);
		textIP.setColumns(10);
		
		panelContact = new JPanel();
		panelContact.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Inf. de Contacto", TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		panelContact.setBounds(10, 192, 339, 115);
		mainPanel.add(panelContact);
		panelContact.setLayout(null);
		
		lblNeighborhood = new JLabel("Domicilio/Calle:");
		lblNeighborhood.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNeighborhood.setBounds(10, 27, 95, 14);
		panelContact.add(lblNeighborhood);
		
		lblStreet = new JLabel("Barrio/Edificio/Piso");
		lblStreet.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStreet.setBounds(10, 52, 95, 14);
		panelContact.add(lblStreet);				
		
		lblPhone = new JLabel("T\u00E9lefono:");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setBounds(10, 77, 95, 14);
		panelContact.add(lblPhone);
		
		textNeighborhood = new JTextField();
		textNeighborhood.setBounds(115, 24, 214, 20);
		panelContact.add(textNeighborhood);
		textNeighborhood.setColumns(10);
		
		textStreet = new JTextField();
		textStreet.setBounds(115, 49, 214, 20);
		panelContact.add(textStreet);
		textStreet.setColumns(10);
		
		textPhone = new JTextField();
		textPhone.setBounds(115, 74, 214, 20);
		panelContact.add(textPhone);
		textPhone.setColumns(10);
		
		lblBase = new JLabel("Base:");
		lblBase.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBase.setBounds(10, 139, 90, 14);
		mainPanel.add(lblBase);
		
		lblPanel = new JLabel("Panel:");
		lblPanel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPanel.setBounds(10, 164, 90, 14);
		mainPanel.add(lblPanel);
		
		cbBase = new JComboBox(ESTACIONES_BASE);
		cbBase.addActionListener(new AddClientComboController(this));
		cbBase.setActionCommand("set_combo_box");
		cbBase.setBounds(110, 136, 239, 20);
		mainPanel.add(cbBase);
		
		cbPanel = new JComboBox(PANELES_LPLANES);			
		cbPanel.setBounds(110, 161, 239, 20);
		mainPanel.add(cbPanel);
		
		btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(AddClientView.class.getResource("/ar/com/jgt/icons_64x64/data_floppy_disk.png")));
		btnNewButton.setBounds(260, 316, 89, 73);
		mainPanel.add(btnNewButton);
		
		lblSmsServer = new JLabel("");
		lblSmsServer.setBounds(10, 375, 240, 14);
		mainPanel.add(lblSmsServer);
		
		lblNewLabel = new JLabel("");		
		lblNewLabel.setBounds(20, 318, 230, 46);
		mainPanel.add(lblNewLabel);
				
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

	@SuppressWarnings("rawtypes")
	public JComboBox getCbBase() {
		return cbBase;
	}

	@SuppressWarnings("rawtypes")
	public void setCbBase(JComboBox cbBase) {
		this.cbBase = cbBase;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCbPanel() {
		return cbPanel;
	}

	@SuppressWarnings("rawtypes")
	public void setCbPanel(JComboBox cbPanel) {
		this.cbPanel = cbPanel;
	}

}
