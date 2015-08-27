package gnf.gido.gido.presentation.view.impl;

import gnf.ada.vaadin.workbench.application.config.AdaViewConfiguration;
import gnf.ada.vaadin.workbench.presentation.crud.impl.AdaCrudViewImpl;
import gnf.ada.vaadin.workbench.presentation.ui.component.viewcomponent.AdaFormViewComponent;
import gnf.ada.vaadin.workbench.presentation.ui.component.viewcomponent.AdaGridViewComponent;
import gnf.ada.vaadin.workbench.presentation.ui.container.AdaFormContainer;
import gnf.gido.administracion.entities.ParametroDetalle;
import gnf.gido.gido.application.dto.ParametroDetalleSearchDto;
import gnf.gido.gido.presentation.presenter.ParametroDetallePresenter;
import gnf.gido.gido.presentation.view.ParametroDetalleView;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;



@Component(ParametroDetalleViewImpl.VIEW_ID)
@Scope("prototype")
@AdaViewConfiguration(presenter=ParametroDetallePresenter.class)
public class ParametroDetalleViewImpl  extends AdaCrudViewImpl<ParametroDetalle, ParametroDetalleSearchDto> implements ParametroDetalleView {
	 private static final long serialVersionUID = 1L;
	 public static final String VIEW_ID = "gido.administracion.parametrodetalleview";
	 private static final String VIEW_TITLE = "gido.administracion.parametrodetalleview";
	 
	 public ParametroDetalleViewImpl() {
	  super(VIEW_ID, VIEW_TITLE);
	 }
	 
	 @Override
		public void init() {
			super.init();
			configureGridContent();
			configureDetailContent();
		}
	 
	 private void configureDetailContent() {
		 AdaFormViewComponent detailContent = getDetailContent();
			AdaFormContainer detailsLayout = (AdaFormContainer) detailContent.getFieldsLayout(); 
			detailsLayout.addField("descripcion").addField("estado").addField("valor");
		}
	 
	 private void configureGridContent() {
		 AdaGridViewComponent gridContent = getGridContent();
		 gridContent.getTable().setVisibleColumns(new Object[] { "valor", "descripcion", "estado" }); 
		}
}
