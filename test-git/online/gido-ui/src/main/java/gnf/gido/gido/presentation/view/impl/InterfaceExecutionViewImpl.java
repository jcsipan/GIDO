package gnf.gido.gido.presentation.view.impl;

import gnf.ada.vaadin.workbench.application.config.AdaViewConfiguration;
import gnf.ada.vaadin.workbench.application.data.fieldgroup.AdaFieldGroup;
import gnf.ada.vaadin.workbench.presentation.crud.impl.AdaCrudViewImpl;
import gnf.ada.vaadin.workbench.presentation.ui.component.actionbar.AdaGridMenuActionBar;
import gnf.ada.vaadin.workbench.presentation.ui.component.viewcomponent.AdaFormViewComponent;
import gnf.ada.vaadin.workbench.presentation.ui.container.template.AdaAreaType;
import gnf.gido.administracion.entities.BatchEjecucion;
import gnf.gido.gido.application.dto.InterfaceExecutionSearchDto;
import gnf.gido.gido.presentation.presenter.InterfaceExecutionPresenter;
import gnf.gido.gido.presentation.view.InterfaceExecutionView;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(InterfaceExecutionViewImpl.VIEW_ID)
@Scope("prototype")
@AdaViewConfiguration(presenter=InterfaceExecutionPresenter.class, enabledAreas={AdaAreaType.SEARCH, AdaAreaType.GRID, AdaAreaType.DETAIL})
public class InterfaceExecutionViewImpl  extends AdaCrudViewImpl<BatchEjecucion, InterfaceExecutionSearchDto> implements InterfaceExecutionView {
	
	private static final long serialVersionUID = 1L;
	
	public static final String VIEW_ID = "gido.administracion.interfaceview";
	
	private static final String VIEW_TITLE = "gido.administracion.interfaceview";
	 
	 /**
		 * Grid Menu Bar
		 * 
		 */

	 private AdaGridMenuActionBar buttons;

 
	 public AdaGridMenuActionBar getButtons() {
		return buttons;
	}

	public InterfaceExecutionViewImpl() {
	  super(VIEW_ID, VIEW_TITLE);
	 }
	 
	@Override
	public void buildContent() {
		// TODO Auto-generated method stub
		super.buildContent();
	    configureSearchForm();
	    modifyDefaultLayout();
//		this.buttons=configureInterfaceMenuBar();
	}
	
	
	private void modifyDefaultLayout(){
		
		 AdaComponentContainer tabWithDetails = createTabWithDetails();
	}
	
	 private void configureSearchForm(){
	    AdaFormViewComponent searchContent = getSearchContent();
	    AdaFieldGroup<?> fieldGroup = searchContent.getFieldGroup();
	    
	    fieldGroup.getField("nombre").setRequired(true);
	    
	  }
	

	 /**
	  * 
	  * Creates the action bar for the authors's grid
	  * Configures the event
	  * 
	  * @return
	  */
	 private AdaGridMenuActionBar configureInterfaceMenuBar() {

	  // We have to supply a discriminator id in order to have more than one actionbar in the same ViewComponent
	  AdaGridMenuActionBar adaGridMenuActionBar = new AdaGridMenuActionBar(this.getDetailContent(), " ");

	  adaGridMenuActionBar.getNew().setVisible(false);
	  adaGridMenuActionBar.getExportToExcel().setVisible(false);
	  adaGridMenuActionBar.getExportToPdf().setVisible(false);
	 	  
	  //Añadiendo separador
	
	  return adaGridMenuActionBar;
	 }

}
