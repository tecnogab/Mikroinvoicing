package ar.com.jgt.view;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import ar.com.jgt.dao.ClienteDAO;
import ar.com.jgt.dao.ClienteJSON;
import ar.com.jgt.dto.ClienteDTO;

public class MKIMainView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5987280392421388016L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmNew;
	private JToolBar toolBar;
	private JButton btnAddClient;
	private JDesktopPane desktopPane;
	private JButton btnSearchClients;
	private JLabel lblModeManifest;
	private JMenu mnConfig;
	private JRadioButtonMenuItem rdbServerMode;
	private JRadioButtonMenuItem rdbClientMode;
	private JButton btnCallTempRecibo;

	/**
	 * Create the frame.
	 */
	public MKIMainView() {
		setTitle("Mikroinvoicing");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MKIMainView.class.getResource("/ar/com/jgt/icons_128x128/antenna.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 659);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		
		mnConfig = new JMenu("Config");
		menuBar.add(mnConfig);
		
		rdbServerMode = new JRadioButtonMenuItem("Server mode");
		rdbServerMode.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		rdbServerMode.setIcon(new ImageIcon(MKIMainView.class.getResource("/ar/com/jgt/icons_16x16/server_earth.png")));
		mnConfig.add(rdbServerMode);
		
		rdbClientMode = new JRadioButtonMenuItem("Client mode");
		rdbClientMode.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		rdbClientMode.setIcon(new ImageIcon(MKIMainView.class.getResource("/ar/com/jgt/icons_16x16/server_client_exchange.png")));
		mnConfig.add(rdbClientMode);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		btnAddClient = new JButton("");
		btnAddClient.setToolTipText("Clic aqu\u00ED para dar de alta de nuevos clientes\u2026");
		btnAddClient.setIcon(new ImageIcon(MKIMainView.class.getResource("/ar/com/jgt/icons_48x48/businesspeople.png")));
		toolBar.add(btnAddClient);
		
		btnSearchClients = new JButton("");
		btnSearchClients.setToolTipText("Clic aqu\u00ED para buscar clientes\u2026");
		btnSearchClients.setIcon(new ImageIcon(MKIMainView.class.getResource("/ar/com/jgt/icons_48x48/businesspeople_view.png")));
		toolBar.add(btnSearchClients);
		
		btnCallTempRecibo = new JButton("");
		btnCallTempRecibo.setIcon(new ImageIcon(MKIMainView.class.getResource("/ar/com/jgt/icons_48x48/loader_48x48.gif")));
		btnCallTempRecibo.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent arg0) {
				instanceControl(new RecibosTemporales());
			}
		});
		toolBar.add(btnCallTempRecibo);
		
		JButton btnTest = new JButton("Test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteDTO dto = new ClienteDTO("28050944", "José gabriel", "Tejerina", "1981-05-07");								
				ClienteDAO dao = new ClienteDAO();
				dao.create(dto);
			}
		});
		toolBar.add(btnTest);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBorder(new BackgroundImage());
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		lblModeManifest = new JLabel("");
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_desktopPane.createSequentialGroup()
					.addContainerGap(750, Short.MAX_VALUE)
					.addComponent(lblModeManifest)
					.addContainerGap())
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_desktopPane.createSequentialGroup()
					.addContainerGap(406, Short.MAX_VALUE)
					.addComponent(lblModeManifest)
					.addContainerGap())
		);
		desktopPane.setLayout(gl_desktopPane);
	}

	public JButton getBtnAddClient() {
		return btnAddClient;
	}

	public void setBtnAddClient(JButton p_btnAddClient) {
		this.btnAddClient = p_btnAddClient;
	}

	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public void setDesktopPane(JDesktopPane p_desktopPane) {
		this.desktopPane = p_desktopPane;
	}

	public JButton getBtnSearchClients() {
		return btnSearchClients;
	}

	public void setBtnSearchClients(JButton p_btnSearchClients) {
		this.btnSearchClients = p_btnSearchClients;
	}

	public JLabel getLblModeManifest() {
		return lblModeManifest;
	}

	public void setLblModeManifest(JLabel p_lblModeManifest) {
		this.lblModeManifest = p_lblModeManifest;
	}

	public JRadioButtonMenuItem getRdbServerMode() {
		return rdbServerMode;
	}

	public void setRdbServerMode(JRadioButtonMenuItem p_rdbServerMode) {
		this.rdbServerMode = p_rdbServerMode;
	}

	public JRadioButtonMenuItem getRdbClientMode() {
		return rdbClientMode;
	}

	public void setRdbClientMode(JRadioButtonMenuItem p_rdbClientMode) {
		this.rdbClientMode = p_rdbClientMode;
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
		for (int a = 0; a < getDesktopPane().getComponentCount(); a++) {
			if (p_internalFrame.getClass().isInstance(getDesktopPane().getComponent(a))) {
				p_internalFrame.toFront();
				getDesktopPane().moveToFront(p_internalFrame);
				l_viewFlag = false;
			} else {
				// System.out.println("No lo es, puede mostrarse");
			}
		}
	
		if (l_viewFlag) {
			getDesktopPane().add(p_internalFrame);
		}
		p_internalFrame.setVisible(true);
	}
}