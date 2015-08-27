package gnf.gido.gido.presentation.event;

import gnf.ada.core.bus.event.AdaEvent;
import gnf.gido.administracion.entities.Parametro;

public class ParametroDetalleSearchPopupEvent extends AdaEvent {
	private Parametro parametro;

	 public static final String SEARCH_DETAILS= "ParametroDetalleSearchPopupEvent.CUSTOMIZED_SEARCH";

	 private ParametroDetalleSearchPopupEvent(String type) {
	  super(type);
	 }

	 public static ParametroDetalleSearchPopupEvent createCustomParamDetalleSearch(Parametro parametro) {
		 ParametroDetalleSearchPopupEvent event = new ParametroDetalleSearchPopupEvent(SEARCH_DETAILS);
	  event.parametro = parametro;
	  return event;
	 }

	 public Parametro getParametro() {
	  return parametro;
	 }
}
