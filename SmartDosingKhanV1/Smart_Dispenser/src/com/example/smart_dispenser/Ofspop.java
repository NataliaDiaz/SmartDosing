package com.example.smart_dispenser;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.NumberField;
import com.vaadin.addon.touchkit.ui.Popover;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;



public class Ofspop extends Popover {

	NumberField quantity= new NumberField("Quantity Required");
	CssLayout cd= new CssLayout();
	Button save = new Button("Save");
	Label msg= new Label("current value");
	
	NavigationView navigationView = new NavigationView(cd);
	public void attach()
	{
		super.attach();
		this.setCaption("Amount Required");
		setWidth("50%");
		setHeight("80%");
		buildview();
		
}
	private void buildview() {
		// TODO Auto-generated method stub
		Button close = new Button(null, new ClickListener() {

            public void buttonClick(ClickEvent event) {
                event.getButton().getWindow().getParent()
                        .removeWindow(event.getButton().getWindow());
            }
        });
		
		save.addListener(new ClickListener(){

			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				//qsave();
				FillTray.quantity=quantity.getValue().toString();
				close();
				//msg.setCaption(quantity.getValue().toString());
			}

			
			
		});
        close.setIcon(new ThemeResource("logout.png"));
        navigationView.setRightComponent(close);
        save.setWidth("30%");
		cd.addComponent(quantity);
		cd.addComponent(msg);
		cd.addComponent(save);
		cd.setSizeFull();
		setContent(navigationView);
	}


	private void qsave() {
		// TODO Auto-generated method stub
		
		FillTray.quantity=quantity.getValue().toString();
	}

}