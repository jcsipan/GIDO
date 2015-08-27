package gnf.gido.gido.presentation.view.impl;

import gnf.ada.vaadin.workbench.application.config.AdaViewConfiguration;
import gnf.ada.vaadin.workbench.presentation.crud.impl.AdaCrudViewImpl;
import gnf.ada.vaadin.workbench.presentation.theme.AdaTheme;
import gnf.ada.vaadin.workbench.presentation.ui.component.AdaTable;
import gnf.ada.vaadin.workbench.presentation.ui.component.actionbar.AdaGridMenuActionBar;
import gnf.ada.vaadin.workbench.presentation.ui.component.viewcomponent.AdaFormViewComponent.FormState;
import gnf.ada.vaadin.workbench.presentation.ui.container.AdaComponentContainer;
import gnf.ada.vaadin.workbench.presentation.ui.container.AdaTabSheetContainer;
import gnf.ada.vaadin.workbench.presentation.ui.factory.AdaComponentFactory;
import gnf.ada.vaadin.workbench.presentation.ui.factory.AdaComponentType;
import gnf.gido.administracion.entities.Parametro;
import gnf.gido.administracion.entities.ParametroDetalle;
import gnf.gido.gido.application.dto.ParametrosSearchDto;
import gnf.gido.gido.presentation.event.ParametroDetalleEvent;
import gnf.gido.gido.presentation.event.ParametrosViewDetalleButtonsEvent;
import gnf.gido.gido.presentation.presenter.ParametrosPresenter;
import gnf.gido.gido.presentation.view.ParametrosView;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Image;
import com.vaadin.ui.VerticalLayout;

@Component(ParametrosViewImpl.VIEW_ID)
@Scope("prototype")
@AdaViewConfiguration(presenter=ParametrosPresenter.class)
public class ParametrosViewImpl  extends AdaCrudViewImpl<Parametro, ParametrosSearchDto> implements ParametrosView {
	private static final long serialVersionUID = 1L;
	public static final String VIEW_ID = "gido.administracion.parametrosview";
	private static final String VIEW_TITLE = "gido.administracion.parametrosview";
	 
	/**
	  * Additional table for Details
	  */
	 private AdaTable tablaDetalles; 
	 
	 /**
		 * Grid Menu Bar
		 */
	 private AdaGridMenuActionBar buttons;
	 
	 public ParametrosViewImpl() {
	  super(VIEW_ID, VIEW_TITLE);
	 }
	 
	 @Override
	 public void buildContent() {
	  super.buildContent();
	  modifyDefaultLayout();
	 }
	 
	 /**
	  * 
	  * We have to create and include the grid inside a Tab below the detail section
	  * 
	  */
	 private void modifyDefaultLayout() {

	  // Get the vertical layout inside the detailContent
	  VerticalLayout detail = (VerticalLayout) getDetailContent().getContent();

	  //AdaActionBar actionBar = getDetailContent().getActionBar();
	  AdaComponentContainer tabWithDetails = createTabWithDetails();

	  // Configure columns with the type
	  refreshTable(null);

	  // Tab at the bottom
	  detail.addComponent(tabWithDetails);

	 }
	 
	 @Override
	 public void refreshTable(Parametro parametrosBean) {

	  List<ParametroDetalle> detalles =  null;

	  if (parametrosBean != null) {
	   detalles = parametrosBean.getDetalles();
	  }

	  BeanItemContainer<ParametroDetalle> detailsDatasource = new BeanItemContainer<ParametroDetalle>(ParametroDetalle.class, detalles);

	  //para ocultar las columnas de la tabla
	  detailsDatasource.removeContainerProperty("idParametro");
	  detailsDatasource.removeContainerProperty("idPdetalle");
	  detailsDatasource.removeContainerProperty("optimistLock");

	  tablaDetalles.setContainerDataSource(detailsDatasource);

	 }
	 
	 /**
	  * 
	  * Creates the tab container and its content
	  * 
	  * @return
	  */
	 private AdaTabSheetContainer createTabWithDetails() {

	  AbstractOrderedLayout layout = new VerticalLayout();
	  layout.setSizeFull();

	  // Create table
	  tablaDetalles = AdaComponentFactory.newInstance(AdaComponentType.TABLE, VIEW_ID + ".tab.parametrodetalles");
	  buttons = configureParametroDetallesMenuBar();

	  // Add table
	  layout.addComponent(buttons);
	  layout.addComponent(tablaDetalles);
	  layout.setExpandRatio(tablaDetalles, 1.0f);

	  // Create tab container
	  AdaTabSheetContainer tabSheetContainer = new AdaTabSheetContainer();
	  tabSheetContainer.addTab(layout, VIEW_ID + ".tab.parametrodetalles");
	  tabSheetContainer.setHeight(200, Unit.PIXELS);

	  return tabSheetContainer;
	 }

	 /* 
	 * Draw the list of details in the grid
	 * 
	 */
	 @Override
	 public void refreshBeanData(Parametro bean) {

	 super.refreshBeanData(bean);
	 refreshTable(bean);

	 }
	 
	 /**
	  * 
	  * Creates the action bar for the authors's grid
	  * Configures the event
	  * 
	  * @return
	  */
	 private AdaGridMenuActionBar configureParametroDetallesMenuBar() {

	  // We have to supply a discriminator id in order to have more than one actionbar in the same ViewComponent
	  AdaGridMenuActionBar adaGridMenuActionBar = new AdaGridMenuActionBar(this.getDetailContent(), "parametrosDetalleTable");

	  Button addDetail = adaGridMenuActionBar.getNew();
	  adaGridMenuActionBar.setActionEventToButton(addDetail, ParametrosViewDetalleButtonsEvent.addDetailToParameter(null));
	  
	  Button editDetail = adaGridMenuActionBar.getEdit();
	  adaGridMenuActionBar.setActionEventToButton(editDetail, ParametrosViewDetalleButtonsEvent.editDetailToParameter(null));

	  Button removeDetail = adaGridMenuActionBar.getRemove();
	  adaGridMenuActionBar.setActionEventToButton(removeDetail, ParametrosViewDetalleButtonsEvent.removeDetailFromParameter(null));

	  //adaGridMenuActionBar.getEdit().setVisible(false);
	  adaGridMenuActionBar.getExportToExcel().setVisible(false);
	  adaGridMenuActionBar.getExportToPdf().setVisible(false);
	  adaGridMenuActionBar.getSeparator().setVisible(false);
	  
	//Añadiendo separador
	  Image separator = new Image(null, new ThemeResource(AdaTheme.ACTIONS_SEPARATOR_ASSET));
	  separator.setPrimaryStyleName(AdaTheme.EXPORT_ACTIONS_SEPARATOR);
	  adaGridMenuActionBar.addComponent(separator);
	  //Añadiendo el botón
	  adaGridMenuActionBar.addAction("gido.administracion.parametrosview.tab.gridmenu", "parametrosview.tab.gridmenu", ParametroDetalleEvent.createGotoParametroDetalles());

	  adaGridMenuActionBar.setFormState(FormState.READ);

	  return adaGridMenuActionBar;
	 }

	public AdaTable getTablaDetalles() {
		return tablaDetalles;
	}

	public void setTablaDetalles(AdaTable tablaDetalles) {
		this.tablaDetalles = tablaDetalles;
	}
	
	@Override
	public AdaGridMenuActionBar getTableDetailsActionBar() {
		// TODO Auto-generated method stub
		return buttons;
	}
}
