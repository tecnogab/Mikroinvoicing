package ar.com.jgt.view;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

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

	/**
	 * Create the frame.
	 */
	public MKIMainView() {
		setTitle("Mikroinvoicing");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MKIMainView.class.getResource("/ar/com/jgt/icons_128x128/antenna.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 586);
		
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
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Compile jrxml file.
			       try {
					JasperReport jasperReport = JasperCompileManager.compileReport("D:\\in\\test.jrxml");
					// Parameters for report
				       Map<String, Object> parameters = new HashMap<String, Object>();
				 
				       // DataSource
				       // This is simple example, no database.
				       // then using empty datasource.
				       JRDataSource dataSource = new JREmptyDataSource();
				 
				       JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
				               parameters, dataSource);
				 
				       JasperViewer viewer = new JasperViewer(jasperPrint);
				       viewer.setVisible(true);
				        
				       System.out.println("Done!");
					
				} catch (JRException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		toolBar.add(btnNewButton);
		
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
}
