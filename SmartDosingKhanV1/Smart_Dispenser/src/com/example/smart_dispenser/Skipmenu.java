package com.example.smart_dispenser;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.Popover;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;

public class Skipmenu extends  Popover {

	//FillTray ft = new FillTray();

	CssLayout adn= new CssLayout();
	OptionGroup optiongroup = new OptionGroup();
	VerticalComponentGroup vcg = new VerticalComponentGroup();
	Button save = new Button("Save");
	TextField Other = new TextField("Other");
	NavigationView navigationView = new NavigationView(adn);
	
public void attach(){
		
		buildview();
		
		//getWindow().setClosable(true);
		navigationView.setCaption("Reason To Skip");
		setWidth("80%");
		setHeight("70%");
		this.setClosable(true);
		this.setModal(true);
		
	}

private void buildview() {
	// TODO Auto-generated method stub
	
	Other.setCaption(null);
	
	Other.setEnabled(true);
	Other.setInputPrompt("Enter Reason to Skip");
	Other.setVisible(false);
	
	optiongroup.addItem("Post operation change in treatment");
	optiongroup.addItem("Patient not feeling good");
	optiongroup.addItem("Patient auto medicated himself");
	optiongroup.addItem("Later");
	optiongroup.addItem("Other");
	
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
			if(Other.getValue()==null)
			{
				getWindow().showNotification("Please Write the reason", Window.Notification.TYPE_ERROR_MESSAGE);
				
			}
			else
			{
				//message=optiongroup.getValue().toString();
				//FillTray.skipmessage=optiongroup.getValue().toString();
				Dispense.reason=Other.getValue().toString();
				close();
				
			}
		}});
	Button cancel = new Button("Cancel", new ClickListener(){

		public void buttonClick(ClickEvent event) {
			// TODO Auto-generated method stub
			event.getButton().getWindow().getParent()
            .removeWindow(event.getButton().getWindow());

		}}); 
    
optiongroup.addListener(new Property.ValueChangeListener() {
	
	public void valueChange(ValueChangeEvent event) {
		// TODO Auto-generated method stub
		Dispense.reason=optiongroup.getValue().toString();
		if(Dispense.reason.equals("Other")){
			Other.setVisible(true);
		}
		else
		close();
		
	}
});
	
	optiongroup.setStyleName("skipoptions");
	save.setWidth("20%");
	save.setStyleName("skipsave");
	cancel.setWidth("20%");
	cancel.setStyleName("skipcancel");
	
	//optiongroup.setSizeFull();
	//optiongroup.setWidth("90%");
	//optiongroup.setHeight("90%");
	adn.setWidth("90%");
	adn.setHeight("90%");
	//adn.setSizeFull();
	
	adn.addComponent(optiongroup);
	//vcg.addComponent(save);
	Other.setWidth("100%");
	adn.addComponent(Other);
	adn.addComponent(save);
	adn.addComponent(cancel);
	//adn.addComponent(vcg);
	//navigationView.setWidth("100%");
	//navigationView.setHeight("100%");
	
	this.setContent(navigationView);
	
}
/*
public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}
*/
}
