package gnf.gido.gido.presentation.view;

import gnf.ada.vaadin.workbench.presentation.crud.AdaCrudView;
import gnf.ada.vaadin.workbench.presentation.ui.component.AdaTable;
import gnf.ada.vaadin.workbench.presentation.ui.component.actionbar.AdaGridMenuActionBar;
import gnf.gido.administracion.entities.Parametro;

public interface ParametrosView extends AdaCrudView<Parametro> {
	public void refreshTable(Parametro parametrosBean) ;
	AdaTable getTablaDetalles();

	 AdaGridMenuActionBar getTableDetailsActionBar();
}
