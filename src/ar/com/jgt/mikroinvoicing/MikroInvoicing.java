package ar.com.jgt.mikroinvoicing;

import ar.com.jgt.controller.MKIController;
import ar.com.jgt.model.MikroInvoicingModel;
import ar.com.jgt.view.MKIMainView;

public class MikroInvoicing {
	
	private static MKIMainView ui_mainView = null;
	private static MikroInvoicingModel m_mkiModel = null;		
	private static MKIController m_mainController = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] p_args) {
		
		m_mainController = new MKIController(ui_mainView, m_mkiModel);
		m_mainController.initialize();
		
	}
	
}
