package com.example.smart_dispenser;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.Popover;
import com.vaadin.data.Validator;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import data.newpatient;

public class addnurse extends Popover {
	
	newpatient pt = new newpatient();
	CssLayout adn= new CssLayout();
	Form adnurse = new Form();
	TextField SSN = new TextField("Nurse SSN"); 
	TextField Fname = new TextField("First Name"); 
	TextField Lname = new TextField("Last Name"); 
	TextField Email = new TextField("Email"); 
	TextField Phone = new TextField("Phone"); 
	PasswordField Password = new PasswordField("Password"); 
	PasswordField P2 = new PasswordField("Confirm Password");
	String ssn,fname,lname,email,phone,password;
	Button save = new Button("Save",adnurse,"commit");
	Button cancel = new Button("Cancel");
	NavigationView navigationView = new NavigationView(adn);
	public addnurse(){
		
	}
	public void attach(){
		
		buildview();
	//	this.setCaption("New Nurse");
	//	getWindow().setClosable(true);
		navigationView.setCaption("New Nurse");
		setWidth("100%");
		setHeight("80%");
		this.setClosable(true);
		this.setModal(true);
		
		
	}

	private void buildview() {
		// TODO Auto-generated method stub
		adnurse.setCaption("Add Nurse");
		adnurse.getLayout().addComponent(SSN);
		SSN.setRequired(true);
		Validator ssnValidator = new RegexpValidator(
			    "[0-9]{6}-[0-9]{3}[0-9a-zA-Z]", "SSN must be in the form 123456-123X.");
		SSN.addValidator(ssnValidator);
		adnurse.getLayout().addComponent(Fname);
		Fname.setRequired(true);
		adnurse.getLayout().addComponent(Lname);
		Lname.setRequired(true);
		adnurse.getLayout().addComponent(Email);
		Email.addValidator(new EmailValidator("Invalid Email Address"));
		adnurse.getLayout().addComponent(Phone);
		adnurse.getLayout().addComponent(Password);
		Password.setRequired(true);
		adnurse.getLayout().addComponent(P2);
		P2.setRequired(true);
		adnurse.setFooter(new VerticalLayout());
		HorizontalLayout bar = new HorizontalLayout();
		adnurse.getFooter().addComponent(bar);
		
		save.addListener(new ClickListener(){

			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				
				if(SSN.isValid()== false){
					//getWindow().showNotification("INCORRECT SSN");
					getWindow().showNotification("Incorrect SSN", Window.Notification.TYPE_ERROR_MESSAGE);
				}
				if(Fname.isValid()==false){
					//fname= Fname.getValue().toString();
					//Fname.setValue("");
					getWindow().showNotification("Enter first name", Window.Notification.TYPE_ERROR_MESSAGE);
				}
				
				if(Lname.isValid()==false){
					getWindow().showNotification("Enter Last name", Window.Notification.TYPE_ERROR_MESSAGE);
					}
				
			//fname= Fname.getValue().toString();
			//lname = Lname.getValue().toString();
			//email =Email.getValue().toString();
			//phone = Phone.getValue().toString();
			
			if(Password.getValue().toString().equals(P2.getValue().toString())){
				if(Password.isValid()){
					password = Password.getValue().toString();
					//Password.setValue("");
					//P2.setValue("");
					}
					else{
						Password.setValue("");
						P2.setValue("");
						getWindow().showNotification("Invalid Password", Window.Notification.TYPE_ERROR_MESSAGE);
					}
				
				
			}
			else{
				Password.setValue("");
				P2.setValue("");
				getWindow().showNotification("Password Doesn't Match", Window.Notification.TYPE_ERROR_MESSAGE);
			}
		//	password = Password.getValue().toString();
		//	pt.addnurse(ssn,fname,lname,email,phone,password);
			if(SSN.isValid()==true && Fname.isValid()==true && Lname.isValid()==true && Password.isValid()==true && Password.getValue().toString().equals(P2.getValue().toString())==true)
			{
			
				ssn= SSN.getValue().toString();
				fname= Fname.getValue().toString();
				lname = Lname.getValue().toString();
				email =Email.getValue().toString();
				phone = Phone.getValue().toString();
				password = Password.getValue().toString();
				pt.addnurse(ssn,fname,lname,email,phone,password);
				SSN.setValue("");
				Fname.setValue("");
				Lname.setValue("");
				Password.setValue("");
				P2.setValue("");
				Email.setValue("");
				Phone.setValue("");
				getWindow().showNotification("Welcome To Smart Dosing", Window.Notification.TYPE_HUMANIZED_MESSAGE
						);
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
        save.setWidth("40%");
        cancel.setWidth("40%");
		bar.addComponent(save);
		bar.addComponent(cancel);
		adn.addComponent(adnurse);
		setContent(navigationView);
		
	}
}
