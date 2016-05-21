package ar.com.jgt.model;

public class MikroInvoicingModel {
	
	public MikroInvoicingModel(){		
	}
	
	public void closeH2Server(){
		if (StartTcpServerForH2.isRunning()) {
			StartTcpServerForH2.stop();
		}
	}
}
