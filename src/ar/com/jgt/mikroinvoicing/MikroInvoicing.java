package ar.com.jgt.mikroinvoicing;

import ar.com.jgt.controller.MKIController;
import ar.com.jgt.model.MikroInvoicingModel;
import ar.com.jgt.view.MKIMainView;

public class MikroInvoicing {
	
	private static MKIMainView ui_mainView;
	private static MikroInvoicingModel m_mkiModel;		
	private static MKIController m_mainController;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] p_args) {
		
		ui_mainView = new MKIMainView();			
		m_mkiModel = new MikroInvoicingModel();
		m_mainController = new MKIController(ui_mainView, m_mkiModel);
		
		m_mainController.initialize();
		
	}
	
}
