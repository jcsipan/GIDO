package gnf.gido.gido.presentation.event;

import gnf.ada.vaadin.workbench.application.event.type.AdaActionEvent;

public class ParametroDetalleEvent extends AdaActionEvent { 
	private ParametroDetalleEvent(String type) {  
		super(type); 
	} 
	
	public static final String GOTO_PARAM_DETALLES = "ParametroDetalleEvent.GOTO_PARAM_DETALLES";
	
	public static ParametroDetalleEvent createGotoParametroDetalles() {  
		return new ParametroDetalleEvent(GOTO_PARAM_DETALLES); 
	}
}
