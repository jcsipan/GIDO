package gnf.gido.gido.presentation.presenter;

import gnf.ada.core.persistence.dao.beans.AdaSearchDto;
import gnf.ada.core.persistence.dao.conditions.AdaConditionEqualsFilter;
import gnf.ada.core.persistence.dao.fetchgroup.AdaFetchElement;
import gnf.ada.core.persistence.dao.fetchgroup.AdaFetchGroup;
import gnf.ada.vaadin.workbench.presentation.crud.impl.AdaCrudPresenterImpl;
import gnf.ada.vaadin.workbench.presentation.ui.component.AdaComboBox;
import gnf.ada.vaadin.workbench.presentation.ui.container.AdaFormContainer;
import gnf.gido.administracion.entities.Parametro;
import gnf.gido.administracion.entities.ParametroDetalle;
import gnf.gido.gido.presentation.view.ParametroDetalleView;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ParametroDetallePresenter extends AdaCrudPresenterImpl<ParametroDetalle, ParametroDetalleView>{
	//Creamos una variable donde guardaremos el Parametro que recibimos como parámetro.
	private Parametro parametro  = null;//
	
	 @Override
	 protected AdaSearchDto buildSearchDto() {
		 // Retrieve values from search dto
		 AdaSearchDto searchDto = new AdaSearchDto();

		 AdaFetchGroup<ParametroDetalle> group = new AdaFetchGroup<ParametroDetalle>(ParametroDetalle.class);
		//Añadimos un filtro a la búsqueda para recuperar los detalles de la entidad seleccionada.
		 if (parametro != null) {
			   AdaFetchElement element = new AdaFetchElement("idParametro.idParametro", group);
			   searchDto.addConditionFilter(new AdaConditionEqualsFilter(element, parametro.getIdParametro()));
			 }
		 
	  return searchDto;
	 }
	 
	 
	 @Override
	 public void initialViewConfiguration(Serializable entity) {
		 parametro = ((Parametro) entity);
		 try{
		 searchWith(buildSearchDto());
		 }catch(Exception e){
			 e.printStackTrace();
		 }
		 AdaFormContainer fieldsLayout = (AdaFormContainer) getView().getDetailContent().getFieldsLayout();
		  AdaComboBox comboParametro = (AdaComboBox) fieldsLayout.getComponent("idParametro");
		 /*comboParametro.select(parametro);
		 comboParametro.setReadOnly(true);*/
	 }
	 
	//Al crear nuevos detalles, queremos que estos se enlacen al parametro en el que hemos entrado, por lo tanto
	//sobreescribimos el métodos newItem para setear en el atributo parametro, la cuenta sobre la que aplican.

	@Override
	protected void newItem() {
	  ParametroDetalle newParametroDetalle = this.getView().getBean();
	  newParametroDetalle.setIdParametro(parametro);
	 super.newItem();
	
	}

}
