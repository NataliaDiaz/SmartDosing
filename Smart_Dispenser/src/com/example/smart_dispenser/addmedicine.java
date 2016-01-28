package com.example.smart_dispenser;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.Popover;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import data.newpatient;

public class addmedicine extends  Popover{
	
	CssLayout adn= new CssLayout();
	newpatient pt = new newpatient();
	Form admedicine = new Form();
	TextField Name = new TextField("Name"); 
	TextField Component = new TextField("Component"); 
	TextField Unit = new TextField("Unit"); 
	TextField Amount = new TextField("Amount"); 
	TextField Indication = new TextField("Indication"); 
	TextField Comment = new TextField("Comment"); 
	String name,component,unit,amount,indication,comment;
	Button save = new Button("Save",admedicine,"commit");
	Button cancel = new Button("Cancel");
	NavigationView navigationView = new NavigationView(adn);
	public void attach(){
		
		buildview();
		navigationView.setCaption("New Medicine");
		setWidth("100%");
		setHeight("80%");
		this.setClosable(true);
		this.setModal(true);
		
		
		//this.setCaption("New Medicine");
		
	}

	private void buildview() {
		// TODO Auto-generated method stub
		admedicine.setCaption("Add Medicine");
		admedicine.getLayout().addComponent(Name);
		Name.setRequired(true);
		admedicine.getLayout().addComponent(Component);
		Component.setRequired(true);
		
		admedicine.getLayout().addComponent(Indication);
		admedicine.getLayout().addComponent(Comment);
		admedicine.setFooter(new VerticalLayout());
		HorizontalLayout bar = new HorizontalLayout();
		admedicine.getFooter().addComponent(bar);
		save.addListener(new ClickListener(){

			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				if(Name.isValid()==false){
					getWindow().showNotification("Enter the Name", Window.Notification.TYPE_ERROR_MESSAGE);
				}
				if(Component.isValid()==false)
				{
					getWindow().showNotification("Enter the Component", Window.Notification.TYPE_ERROR_MESSAGE);
				}
				if(Name.isValid() && Component.isValid()){
					name= Name.getValue().toString();
					component = Component.getValue().toString();
					unit=Unit.getValue().toString();
					amount = Amount.getValue().toString();
					indication = Indication.getValue().toString();
					comment = Comment.getValue().toString();
					pt.addmedicine(name,component,indication,comment);
					Name.setValue("");
					Component.setValue("");
					getWindow().showNotification("Medicine is Added", Window.Notification.TYPE_HUMANIZED_MESSAGE);
					Indication.setValue("");
					Comment.setValue("");
				}
			}
			
		});
		cancel.addListener(new ClickListener(){

			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				close();
			}
			
		});
		Button close = new Button(null, new ClickListener() {

            public void buttonClick(ClickEvent event) {
                event.getButton().getWindow().getParent()
                        .removeWindow(event.getButton().getWindow());
            }
        });
        close.setIcon(new ThemeResource("logout.png"));

        navigationView.setRightComponent(close);
		bar.addComponent(save);
		bar.addComponent(cancel);
		adn.addComponent(admedicine);
		adn.setWidth("100%");
		adn.setHeight("85%");
		setContent(navigationView);
	}
	
	
	

}
