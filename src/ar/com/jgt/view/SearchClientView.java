package ar.com.jgt.view;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class SearchClientView extends JInternalFrame {

	private static final long serialVersionUID = -7001381906690652063L;
	private JPanel panel;
	private JTable tableClients;
	private JLabel lblTitle;
	private JScrollPane scrollPane;
	private JTextField textSName;
	private JTextField textSLastName;
	private JTextField textSAddress;
	private JLabel lblImageWait;
	private JLabel lblSName;
	private JLabel lblSLastName;
	private JLabel lblSAddress;

	/**
	 * Create the frame.
	 */
	public SearchClientView() {
		setFrameIcon(new ImageIcon(SearchClientView.class.getResource("/ar/com/jgt/icons_16x16/businesspeople_view.png")));

		String[] columnNames = { "Nombre", "Apellido", "Pasatiempo", "Años de Practica", "Soltero(a)" };

		Object[][] data = { { "Mary", "Campione", "Esquiar", new Integer(5), new Boolean(false) },
				{ "Lhucas", "Huml", "Patinar", new Integer(3), new Boolean(true) },
				{ "Kathya", "Walrath", "Escalar", new Integer(2), new Boolean(false) },
				{ "Marcus", "Andrews", "Correr", new Integer(7), new Boolean(true) },
				{ "Angela", "Lalth", "Nadar", new Integer(4), new Boolean(false) } };

		setClosable(true);
		setResizable(true);
		setMaximizable(true);
		setIconifiable(true);
		setTitle("Consulta de clientes");
		setBounds(100, 100, 600, 400);
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		lblTitle = new JLabel("Busqueda de clientes");

		scrollPane = new JScrollPane();
		
		lblSName = new JLabel("B. P. Nombre:");
		
		lblSLastName = new JLabel("B. P. Apellido:");
		
		lblSAddress = new JLabel("B. P. Domicilio:");
		
		textSName = new JTextField();
		textSName.setColumns(10);
		
		textSLastName = new JTextField();
		textSLastName.setColumns(10);
		
		textSAddress = new JTextField();
		textSAddress.setColumns(10);
		
		lblImageWait = new JLabel("");
		lblImageWait.setIcon(new ImageIcon(SearchClientView.class.getResource("/ar/com/jgt/icons_16x16/loading.gif")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
							.addComponent(lblImageWait))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSName, Alignment.TRAILING)
								.addComponent(lblSLastName, Alignment.TRAILING)
								.addComponent(lblSAddress, Alignment.TRAILING))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textSLastName, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
								.addComponent(textSName, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
								.addComponent(textSAddress, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTitle)
						.addComponent(lblImageWait))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSName)
						.addComponent(textSName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSLastName)
						.addComponent(textSLastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSAddress)
						.addComponent(textSAddress, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(48, Short.MAX_VALUE))
		);

		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);

		tableClients = new JTable(dtm);		
		scrollPane.setViewportView(tableClients);
		
		panel.setLayout(gl_panel);
	}

	public JTable getTableClients() {
		return tableClients;
	}

	public void setTableClients(JTable p_tableClients) {
		this.tableClients = p_tableClients;
	}

	public JTextField getTextSName() {
		return textSName;
	}

	public void setTextSName(JTextField p_textSName) {
		this.textSName = p_textSName;
	}

	public JTextField getTextSLastName() {
		return textSLastName;
	}

	public void setTextSLastName(JTextField p_textSLastName) {
		this.textSLastName = p_textSLastName;
	}

	public JTextField getTextSAddress() {
		return textSAddress;
	}

	public void setTextSAddress(JTextField textSAddress) {
		this.textSAddress = textSAddress;
	}

	public JLabel getLblImageWait() {
		return lblImageWait;
	}

	public void setLblImageWait(JLabel p_lblImageWait) {
		this.lblImageWait = p_lblImageWait;
	}
}
