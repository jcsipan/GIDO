package gnf.gido.gido.presentation.event;

import gnf.ada.vaadin.workbench.application.event.type.AdaActionEvent;
import gnf.gido.administracion.entities.Parametro;

public class ParametrosViewDetalleButtonsEvent extends AdaActionEvent {
	public static final String ADD_DETAIL= "ParametrosViewDetalleButtonsEvent.ADD_DETAIL_BUTTON";
	public static final String EDIT_DETAIL= "ParametrosViewDetalleButtonsEvent.EDIT_DETAIL_BUTTON";
	 public static final String REMOVE_DETAIL= "ParametrosViewDetalleButtonsEvent.REMOVE_DETAIL_BUTTON";

	 private ParametrosViewDetalleButtonsEvent(String type) {
	  super(type);
	 }

	 /**
	  * 
	  * Add parameter detail event
	  * 
	  * @param book
	  * @return
	  */
	 public static ParametrosViewDetalleButtonsEvent addDetailToParameter(Parametro parametro) {
		 ParametrosViewDetalleButtonsEvent event = new ParametrosViewDetalleButtonsEvent(ADD_DETAIL);
	  return event;
	 }
	 
	 /**
	  * 
	  * Add parameter detail event
	  * 
	  * @param book
	  * @return
	  */
	 public static ParametrosViewDetalleButtonsEvent editDetailToParameter(Parametro parametro) {
		 ParametrosViewDetalleButtonsEvent event = new ParametrosViewDetalleButtonsEvent(EDIT_DETAIL);
	  return event;
	 }

	 /**
	  * 
	  * Remove parameter detail event
	  * 
	  * @param book
	  * @return
	  */
	 public static ParametrosViewDetalleButtonsEvent removeDetailFromParameter(Parametro parametro) {
		 ParametrosViewDetalleButtonsEvent event = new ParametrosViewDetalleButtonsEvent(REMOVE_DETAIL);
	  return event;
	 }
}
