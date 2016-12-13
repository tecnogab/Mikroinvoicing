package ar.com.jgt.view;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import ar.com.jgt.reportes.Reportes;

import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import java.awt.event.ActionEvent;

public class RecibosTemporales extends JInternalFrame {

	/**
	 */
	private static final long serialVersionUID = 3390486679574959418L;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public RecibosTemporales() {
		setClosable(true);
		setTitle("Recibos temporales");
		setBounds(100, 100, 431, 236);
		getContentPane().setLayout(null);
		
		JLabel lblNombreDelCliente = new JLabel("Nombre del cliente:");
		lblNombreDelCliente.setBounds(10, 11, 135, 14);
		getContentPane().add(lblNombreDelCliente);
		
		textField = new JTextField();
		textField.setBounds(155, 8, 250, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblImporte = new JLabel("Importe:");
		lblImporte.setBounds(56, 36, 89, 14);
		getContentPane().add(lblImporte);
		
		JComboBox<Float> comboBox = new JComboBox<Float>();		
		comboBox.addItem(300.0f);
		comboBox.addItem(318.0f);
		comboBox.addItem(336.0f);
		comboBox.addItem(400.0f);
		comboBox.addItem(424.0f);
		comboBox.addItem(448.0f);
		
		comboBox.addItem(350.0f);
		comboBox.addItem(371.0f);
		comboBox.addItem(392.0f);
		
	
		comboBox.setBounds(155, 39, 92, 20);
		getContentPane().add(comboBox);
		
		JButton btnCallReport = new JButton("VER RECIBO");
		btnCallReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					File l_sourceimage = new File(this.getClass().getResource("/ar/com/jgt/reportes/qr_code.jpg").getFile());
					Image l_qrCode = ImageIO.read(l_sourceimage);
					int l_nRecibo = 18477;
					Integer l_numRecibo = l_nRecibo;
					String l_nameCli = textField.getText();					
					String l_concepto = "ACCESO A INTERNET DICIEMBRE 2016";
					Float l_importe = Float.parseFloat(comboBox.getSelectedItem().toString());
					
					final SwingWorker<Object, Object> worker = new SwingWorker<Object, Object>(){

						@Override
						protected Object doInBackground() throws Exception {
							//TODO Auto-generated method stub
							Reportes l_reporte = new Reportes(l_numRecibo, l_nameCli, l_concepto, l_importe, l_qrCode);
							l_reporte.setVisible(true);							
							btnCallReport.setEnabled(false);
							return null;
						}
						
						@Override
						protected void done() {
							btnCallReport.setEnabled(true);
						}
						
					};
					worker.execute();
															
				} catch (IOException p_IOException) {
					// TODO Auto-generated catch block
					p_IOException.printStackTrace();

				}
			}
		});
		btnCallReport.setBounds(10, 70, 395, 114);
		getContentPane().add(btnCallReport);
	}
}
