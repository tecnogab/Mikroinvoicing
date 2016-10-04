package ar.com.jgt.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingUtilities;
import ar.com.jgt.view.AddClientView;

public class AddClientComboController implements ActionListener{
	
	private final String[] PANELES_LPLANES = {"Norte", "Sur", "Este", "Oeste"};
	private final String[] PANELES_TPIZARRO = {"Norte - 3MB", "Sur - 3MB", "Este - 3MB", "Oeste- 3MB", "NORTE - 6MB", "SUR - 6MB", "ESTE - 6MB", "OESTE - 6MB", "05 - 6MB", "06 - 6MB"};
		
	private final static String SET_COMBO_BOX = "set_combo_box";					//Variable de cadenas constantes para referenciar comandos de acción
	
	private AddClientView ui_view = null;	
	
	public AddClientComboController(AddClientView p_view) {
		ui_view = p_view;		
	}

	@Override
	public void actionPerformed(ActionEvent p_actionEvent) {
		
		if (p_actionEvent.getActionCommand().equals(SET_COMBO_BOX)) {			
			SwingUtilities.invokeLater(new Runnable() {				
				@SuppressWarnings("unchecked")
				@Override
				public void run() {
					int l_index = ui_view.getCbBase().getSelectedIndex();
					if (l_index == 0) {
						ui_view.getCbPanel().removeAllItems();
						for (int i = 0; i < PANELES_LPLANES.length; i++) {					
							ui_view.getCbPanel().addItem(PANELES_LPLANES[i]);
						}
					}else if(l_index == 1){
						ui_view.getCbPanel().removeAllItems();
						for (int i = 0; i < PANELES_TPIZARRO.length; i++) {					
							ui_view.getCbPanel().addItem(PANELES_TPIZARRO[i]);
						}
					}					
				}
			});			
		}
	}
}