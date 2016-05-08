package ar.com.jgt.mikroinvoicing;

import java.awt.EventQueue;

import ar.com.jgt.controller.MKIController;
import ar.com.jgt.model.MikroInvoicingDAO;
import ar.com.jgt.view.MKIMainView;

public class MikroInvoicing {
	
	private static MKIMainView ui_mainView;
	private static MikroInvoicingDAO m_MIDAO;	
	@SuppressWarnings("unused")
	private static MKIController m_mainController;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] p_args) {
		
		ui_mainView = new MKIMainView();
		m_MIDAO = new MikroInvoicingDAO();
		m_mainController = new MKIController(ui_mainView, m_MIDAO);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {					
					ui_mainView.setVisible(true);
					ui_mainView.setLocationRelativeTo(null);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
