package gnf.gido.gido.presentation.event;

import gnf.ada.vaadin.workbench.application.event.type.AdaActionEvent;

public class InterfaceExecutionEvent extends AdaActionEvent { 
	private InterfaceExecutionEvent(String type) {  
		super(type); 
	} 
	
	public static final String GOTO_INTERFACE_EXECUTION = "InterfaceExecutionEvent.GOTO_INTERFACE_EXECUTION";
	
	public static InterfaceExecutionEvent createGotoParametroDetalles() {  
		return new InterfaceExecutionEvent(GOTO_INTERFACE_EXECUTION); 
	}
}
