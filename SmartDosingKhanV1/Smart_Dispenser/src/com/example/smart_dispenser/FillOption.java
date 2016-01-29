package com.example.smart_dispenser;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.Popover;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class FillOption extends Popover{

	CssLayout adn= new CssLayout();
	OptionGroup optiongroup = new OptionGroup();
	VerticalComponentGroup vcg = new VerticalComponentGroup();
	Button save = new Button("Save");
	TextField Other = new TextField("Other");
	NavigationView navigationView = new NavigationView(adn);
	


public void attach(){
		
		buildview();
		
		//getWindow().setClosable(true);
		navigationView.setCaption("Fill Tray By");
		setWidth("80%");
		setHeight("70%");
		this.setClosable(true);
		this.setModal(true);
		
	}

private void buildview() {
	// TODO Auto-generated method stub
	
	Other.setCaption(null);
	
	Other.setEnabled(true);
	Other.setInputPrompt("Enter Option For Filling Tray");
	Other.setVisible(false);
	
	optiongroup.addItem("Fill Tray By Patient");
	optiongroup.addItem("Fill Tray By Medicine");
	
	
	optiongroup.setMultiSelect(false);
	optiongroup.setImmediate(true);
	
/*	optiongroup.addListener(new Property.ValueChangeListener() {
		
		public void valueChange(ValueChangeEvent event) {
			// TODO Auto-generated method stub
			message = optiongroup.getValue().toString();
			
		}
	});*/
	
	save.addListener(new ClickListener(){

		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
				//getParent().removeWindow(dialog);
				close();
				
			}
		});
//	getParent().addWindow(this);
	
optiongroup.addListener(new Property.ValueChangeListener() {
	
	public void valueChange(ValueChangeEvent event) {
		// TODO Auto-generated method stub
		dispenserview.choice=optiongroup.getValue().toString();
		
	}
});
	
	optiongroup.setStyleName("skipoptions");
	save.setWidth("20%");
	save.setStyleName("skipsave");
	//optiongroup.setSizeFull();
	//optiongroup.setWidth("90%");
	//optiongroup.setHeight("90%");
	adn.setWidth("90%");
	adn.setHeight("90%");
	//adn.setSizeFull();
	
	adn.addComponent(optiongroup);
	//vcg.addComponent(save);
	adn.addComponent(save);
	
	//adn.addComponent(vcg);
	//navigationView.setWidth("100%");
	//navigationView.setHeight("100%");
	
	this.setContent(navigationView);
	
}
}
