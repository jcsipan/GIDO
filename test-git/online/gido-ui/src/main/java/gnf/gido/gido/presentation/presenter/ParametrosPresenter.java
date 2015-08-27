package gnf.gido.gido.presentation.presenter;

import java.io.Serializable;

import gnf.ada.core.persistence.dao.beans.AdaSearchDto;
import gnf.ada.core.persistence.dao.conditions.AdaConditionLikeFilter;
import gnf.ada.core.persistence.dao.fetchgroup.AdaFetchElement;
import gnf.ada.core.persistence.dao.projections.AdaSelectedField;
import gnf.ada.vaadin.workbench.application.control.AdaListener;
import gnf.ada.vaadin.workbench.application.event.type.AdaActionEvent;
import gnf.ada.vaadin.workbench.presentation.crud.impl.AdaCrudPresenterImpl;
import gnf.ada.vaadin.workbench.presentation.ui.component.AdaTable;
import gnf.ada.vaadin.workbench.presentation.ui.component.viewcomponent.AdaFormViewComponent.FormState;
import gnf.ada.vaadin.workbench.presentation.ui.container.view.popup.AdaPopup;
import gnf.ada.vaadin.workbench.presentation.ui.container.view.popup.AdaSelectionPopupHandler;
import gnf.ada.vaadin.workbench.util.AdaNavigation;
import gnf.ada.vaadin.workbench.util.AdaNotification;
import gnf.gido.administracion.entities.Parametro;
import gnf.gido.administracion.entities.ParametroDetalle;
import gnf.gido.gido.application.dto.ParametrosSearchDto;
import gnf.gido.gido.presentation.event.ParametroDetalleEvent;
import gnf.gido.gido.presentation.event.ParametroDetalleSearchPopupEvent;
import gnf.gido.gido.presentation.event.ParametrosViewDetalleButtonsEvent;
import gnf.gido.gido.presentation.view.ParametroDetalleView;
import gnf.gido.gido.presentation.view.ParametrosView;
import gnf.gido.gido.presentation.view.impl.ParametroDetalleViewImpl;
import gnf.gido.gido.presentation.view.impl.ParametrosViewImpl;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ParametrosPresenter  extends AdaCrudPresenterImpl<Parametro, ParametrosView>{
	
	private AdaPopup detailsPopupWindow;
	
	@Override
	 protected AdaSearchDto buildSearchDto() {
		ParametrosView view = getView();

		 // Retrieve values from search dto
		 ParametrosSearchDto searchDto = (ParametrosSearchDto) view.getSearchDto();
		  String descripcion = searchDto.getDescripcion();
		  String nombre = searchDto.getNombre();

		  AdaSearchDto adaSearchDto = new AdaSearchDto();

		 /*if (StringUtils.isNotBlank(descripcion)) {
		   adaSearchDto.addConditionFilter(new AdaConditionEqualsFilter(AdaFetchElement.ROOT_CLASS_ID, descripcion));
		 }*/

		 if (StringUtils.isNotBlank(nombre)) {
		   adaSearchDto.addConditionFilter(new AdaConditionLikeFilter(new AdaFetchElement("nombre"), nombre));
		 }
		 
		 if (StringUtils.isNotBlank(descripcion)) {
			   adaSearchDto.addConditionFilter(new AdaConditionLikeFilter(new AdaFetchElement("descripcion"), descripcion));
		}


		 // Ask for parameter details too
		 adaSearchDto.addSelectedField(new AdaSelectedField("detalles"));

		
	  return adaSearchDto;
	 }
	
	
	
	//Indicamos el tipo de evento
	@AdaListener(hint = ParametroDetalleEvent.GOTO_PARAM_DETALLES)
	public void gotoBoks(AdaActionEvent event) {
	 if(getView().getBean() != null) {
	  //Si se ha seleccionado un elemento cargamos la vista.
	  //Comentamos esta línea porqué aun no tenemos creada la vista a la que queremos ir cuando pulsemos el botón books.
	  AdaNavigation.openView(ParametroDetalleViewImpl.VIEW_ID, true, getView().getBean());
	 } else {
	  //Si no se ha seleccionado ninguna entidad, mostramos un warning.
	  AdaNotification.showWarning("seleccionar.elemento", "seleccionar.elemento.description", true);
	 }
	}
	
	
	
	/**
	 * configures parameter detail button state
	 */
	@Override
	protected void enableUpdateState() {
		super.enableUpdateState();
		getView().getTableDetailsActionBar().setFormState(FormState.EDIT);
	}

	/**
	 * configures parameter detail button state
	 */
	@Override
	protected void enableSearchState() {
		super.enableSearchState();
		getView().getTableDetailsActionBar().setFormState(FormState.READ);
	}
	
	/**
	 * 
	 * Process the parameter detail button click to remove a detail
	 * 
	 * @param event
	 */
	/*@AdaListener(hint = ParametrosViewDetalleButtonsEvent.REMOVE_DETAIL)
	public void onAuthorsRemoveButtonClicked(ParametrosViewDetalleButtonsEvent event) {

		ParametrosView view = getView();

		if (FormState.EDIT.equals(view.getDetailContent().getFormState())) {

			AdaTable tablaDetalles = view.getTablaDetalles();
			ParametroDetalle detalle = (ParametroDetalle) tablaDetalles.getValue();

			if (detalle != null) {
				Parametro parametro = view.getBean();
				parametro.getDetalles().remove(detalle);
				view.refreshTable(parametro);
			}
		}

	}*/
	
	 /**
	  * 
	  * Process the authors button click to show the popup
	  * 
	  * @param event
	  */
	 /*@AdaListener(hint = ParametrosViewDetalleButtonsEvent.ADD_DETAIL)
	 public void onAuthorsButtonClicked(ParametrosViewDetalleButtonsEvent event) {

		 ParametrosView view = getView();

	  if (FormState.EDIT.equals(view.getDetailContent().getFormState())) {
	   Parametro bean = view.getBean();

	   detailsPopupWindow = AdaNavigation.openViewAsSelectionPopup(ParametroDetalleViewImpl.VIEW_ID, ParametroDetalleViewImpl.VIEW_ID + ".popup", bean,
	     new ParametroDetallePopupPresenter());
	   AdaNavigation.openView(ParametroDetalleViewImpl.VIEW_ID, true, getView().getBean());
	  }

	 }*/
	 
	 
	 /**
	  * 
	  * Inner class to handle popup events It is mandatory to define it in a new class (inner or not)
	  * to avoid merging events from the view that opens the popup and the popup itself
	  *  
	  */
	  public class ParametroDetallePopupPresenter implements AdaSelectionPopupHandler {

		  private Parametro parametro  = null;//
		  
		  //en esta variable se indica si se crea un nuevo registro o se edita
		  private String operacion = null;
		  
	  @Override
	  @AdaListener(hint = AdaActionEvent.SELECT_POPUP_ITEM)
	  public void selectPopup(AdaActionEvent event) {
	   addDetailToList((ParametroDetalle) event.getData());
	  }

	  @Override
	  @AdaListener(hint = AdaActionEvent.DOUBLE_CLICK_ITEM)
	  public void doubleClickItem(AdaActionEvent event) {
	   addDetailToList((ParametroDetalle) event.getData());
	  }

	  @Override
	  @AdaListener(hint = AdaActionEvent.CANCEL_POPUP)
	  public void cancelPopup(AdaActionEvent event) {
		  ParametrosPresenter.this.detailsPopupWindow.close();
	  }

	  private void addDetailToList(ParametroDetalle detalle) {

	   if (detalle != null) {
	    Parametro parametro = getView().getBean();
	    parametro.getDetalles().add(detalle);
	    getView().refreshTable(parametro);

	   }
	   ParametrosPresenter.this.detailsPopupWindow.close();

	  }

	  @Override
	  public void initPopupView(Object data, AdaPopup window) {

	   ParametroDetalleView parametroDetalleView = (ParametroDetalleView) window.getView();
	   //authorsView.getDetailContent().setVisible(false);
	   parametroDetalleView.getSearchContent().setVisible(false);
	   //parametroDetalleView.getGridContent().setVisible(false);
	   parametroDetalleView.getDetailContent().setFormState(FormState.EDIT);
	   //parametroDetalleView.getDetailContent().get
	   Parametro parametro = (Parametro) data;
	   parametroDetalleView.dispatchEvent(ParametroDetalleSearchPopupEvent.createCustomParamDetalleSearch(parametro));
	   
	  }
	  
	 

	 }
	 

}
