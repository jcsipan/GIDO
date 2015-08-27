package gnf.gido.gido.presentation.view;

import gnf.ada.vaadin.workbench.presentation.ui.container.view.AdaAbstractViewContainer;
import gnf.ada.vaadin.workbench.presentation.ui.factory.AdaComponentFactory;
import gnf.ada.vaadin.workbench.presentation.ui.factory.AdaComponentType;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Label;

/**
 * It is only for testing purposes.
 * 
 */
@Component(WelcomeView.VIEW_ID)
@Scope("prototype")
public class WelcomeView extends AdaAbstractViewContainer {

	private static final long serialVersionUID = 1L;

	public static final String VIEW_ID = "gido.welcomeView";
	private static final String VIEW_TITLE = VIEW_ID;

	/**
	 * Default constructor
	 * 
	 */
	public WelcomeView() {
		super(VIEW_ID, VIEW_TITLE);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see gnf.ada.vaadin.workbench.ui.component.view.AdaView#buildContent()
	 */
	@Override
	public void buildContent() {
		// Code snippet to create a component
		Label label = AdaComponentFactory.newInstance(AdaComponentType.LABEL, "welcome.label");
		addComponent(label);
	}

}
