package ar.com.jgt.reportes;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import ar.com.jgt.tools.NumeroALetra;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class Reportes {
	
	private static JasperViewer ui_viewer = null;
	private static JasperPrint m_jasperPrint = null;
	
	public Reportes(){		
	}

	public Reportes(Integer p_numRecibo, String p_nameCli, String p_concepto, Float p_importe, Image p_qrcode) throws IOException, JRException{
		
		File l_report = new File(getClass().getResource("/ar/com/jgt/reportes/recibos.jrxml").getFile());
		File l_logoFile = new File(getClass().getResource("/ar/com/jgt/images/tecnogab.png").getFile());
		
		Image l_logoImage = ImageIO.read(l_logoFile);
		String l_importeStr = String.valueOf(p_importe);
		NumeroALetra l_convert = new NumeroALetra();
		
		JasperReport l_jasperReport = JasperCompileManager.compileReport(l_report.getAbsolutePath());
		Map<String, Object> l_parameters = new HashMap<String, Object>();
		l_parameters.put("rec_num", p_numRecibo);
		l_parameters.put("name_cli", p_nameCli);
		l_parameters.put("suma_str", l_convert.convertir(l_importeStr, false));
		l_parameters.put("concepto_rec", p_concepto);
		l_parameters.put("suma_rec", p_importe);
		l_parameters.put("qr_code", p_qrcode);
		l_parameters.put("logo_param", l_logoImage);
		// DataSource
		// This is simple example, no database.
		// then using empty datasource.
		JRDataSource l_dataSource = new JREmptyDataSource();
		m_jasperPrint = JasperFillManager.fillReport(l_jasperReport, l_parameters, l_dataSource);			
	}

	public void setVisible(boolean p_flag){
		ui_viewer = new JasperViewer(m_jasperPrint, false);
		if (p_flag) {			
			ui_viewer.setVisible(true);
		}else{
			ui_viewer.setVisible(false);
		}
	}
}
