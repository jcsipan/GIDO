package gnf.gido.gido.presentation.presenter;

import gnf.ada.core.persistence.dao.beans.AdaSearchDto;
import gnf.ada.core.persistence.dao.conditions.AdaConditionLikeFilter;
import gnf.ada.core.persistence.dao.fetchgroup.AdaFetchElement;
import gnf.ada.vaadin.workbench.presentation.crud.impl.AdaCrudPresenterImpl;
import gnf.gido.administracion.entities.BatchEjecucion;
import gnf.gido.gido.application.dto.InterfaceExecutionSearchDto;
import gnf.gido.gido.presentation.view.InterfaceExecutionView;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class InterfaceExecutionPresenter  extends AdaCrudPresenterImpl<BatchEjecucion, InterfaceExecutionView>{
	
	
	@Override
	 protected AdaSearchDto buildSearchDto() {

		InterfaceExecutionView view = getView();

		 InterfaceExecutionSearchDto searchDto = (InterfaceExecutionSearchDto) view.getSearchDto();
		 String nombre = searchDto.getNombre();

		 AdaSearchDto adaSearchDto = new AdaSearchDto();

		 if (StringUtils.isNotBlank(nombre)) {
		   adaSearchDto.addConditionFilter(new AdaConditionLikeFilter(new AdaFetchElement("nombre"), nombre));
		 }

	  return adaSearchDto;
	  
	 }
	
	
	
	
	/**
	 * configures parameter detail button state
	 */
//	@Override
//	protected void enableUpdateState() {
//		super.enableUpdateState();
//		getView().getTableDetailsActionBar().setFormState(FormState.EDIT);
//	}

	/**
	 * configures parameter detail button state
	 */
//	@Override
//	protected void enableSearchState() {
//		super.enableSearchState();
//		getView().getTableDetailsActionBar().setFormState(FormState.READ);
//	}
	
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
	 
	 
}
