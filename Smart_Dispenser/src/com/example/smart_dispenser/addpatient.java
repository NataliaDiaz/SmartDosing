package com.example.smart_dispenser;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;



import com.vaadin.Application;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.Popover;
import com.vaadin.data.Validator;
import com.vaadin.data.Validator.EmptyValueException;
import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;
import com.vaadin.terminal.Resource;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import data.newpatient;

public class addpatient extends Popover implements Component {

	newpatient pt= new newpatient();
	CssLayout adn= new CssLayout();
	Form adpatient = new Form();
	TextField SSN = new TextField("Patient SSN"); 
	TextField Fname = new TextField("First Name"); 
	TextField Lname = new TextField("Last Name"); 
	TextField Ward = new TextField("Ward"); 
	TextField Room = new TextField("Room"); 
	 String ssn,fname,lname,ward,room;
	
	Button save = new Button("Save",adpatient,"commit");

	Button cancel = new Button("Cancel");
	NavigationView navigationView = new NavigationView(adn);
	
	public void attach(){
		
		buildview();
		//this.setCaption("New Patient");
		//getWindow().setClosable(true);
		navigationView.setCaption("New Patient");
		setWidth("100%");
		setHeight("80%");
		this.setClosable(true);
		this.setModal(true);
	}

	private void buildview() {
		// TODO Auto-generated method stub
		adpatient.setCaption("Add Patient");
		SSN.setRequired(true);
		
		//SSN.setRequiredError("Please Enter The Name");
		/* Added 
		 * 
		 
		Validator postalCodeValidator = new Validator() {

		    // The isValid() method returns simply a boolean value, so
		    // it can not return an error message.
		    public boolean isValid(Object value) {
		        if (value == null || !(value instanceof String)) {
		            return false;
		        }

		        return ((String) value).matches("[1-9][0-9]{4}");
		    }

		    // Upon failure, the validate() method throws an exception
		    // with an error message.
		    public void validate(Object value)
		                throws InvalidValueException {
		        if (!isValid(value)) {
		            if (value != null &&
		                value.toString().startsWith("0")) {
		                throw new InvalidValueException(
		                    "Postal code must not start with a zero.");
		            } else {
		                throw new InvalidValueException(
		                    "Postal code must be a number 10000-99999.");
		            }
		        }
		    }
		};
			*/
		Validator ssnValidator = new RegexpValidator(
			    "[0-9]{6}-[0-9]{3}[0-9a-zA-Z]", "SSN must be in the form 123456-123X.");
		//String ssn_regexp = "[0-9]{6}-[0-9]{3}[0-9a-zA-Z]"; 
       // ssn.setRegExp(ssn_regexp, "000000-000A");
				
		adpatient.setValidationVisibleOnCommit(true);
		adpatient.setValidationVisible(true);
		SSN.addValidator(ssnValidator);
		/* Added 
		 * 
		 */
		adpatient.getLayout().addComponent(SSN);
		adpatient.getLayout().addComponent(Fname);
		Fname.setRequired(true);
		Fname.setRequiredError("First Name is missing");
		adpatient.getLayout().addComponent(Lname);
		Lname.setRequired(true);
		adpatient.getLayout().addComponent(Ward);
		Ward.setRequired(true);
		adpatient.getLayout().addComponent(Room);
		Room.setRequired(true);
		adpatient.setFooter(new VerticalLayout());
		HorizontalLayout bar = new HorizontalLayout();
		adpatient.getFooter().addComponent(bar);
		
		save.addListener(new ClickListener(){

			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				/*try{
					adpatient.commit();
				}
				catch (EmptyValueException e){
					
				}
				
				*/
				if(SSN.isValid()==true && Fname.isValid()==true && Lname.isValid() ==true && Ward.isValid()==true && Room.isValid()==true){
					ssn= SSN.getValue().toString();
					fname= Fname.getValue().toString();
					lname = Lname.getValue().toString();
					ward = Ward.getValue().toString();
					room = Room.getValue().toString();
					pt.adddata(ssn,fname,lname,ward,room);
					getWindow().showNotification("Patient Succesfully Added", Window.Notification.TYPE_HUMANIZED_MESSAGE);
					Room.setValue("");
					SSN.setValue("");
					Fname.setValue("");
					Lname.setValue("");
					Ward.setValue("");
				}
				if(SSN.isValid()==true){
					
				}
				else{
					//getWindow().showNotification("INCORRECT SSN");
					getWindow().showNotification("Incorrect SSN", Window.Notification.TYPE_ERROR_MESSAGE);
				}
				if(Fname.isValid()==true){
					
					
				}
				else{
					getWindow().showNotification("Enter first name", Window.Notification.TYPE_ERROR_MESSAGE);
				}
				if(Lname.isValid()){
				
				
				}
				else{
					getWindow().showNotification("Enter Last name", Window.Notification.TYPE_ERROR_MESSAGE);
				}
				if(Ward.isValid()==true){
				
				
				}
				else{
					getWindow().showNotification("Enter Ward ", Window.Notification.TYPE_ERROR_MESSAGE);
				}
				if(Room.isValid()==true){
				
				
				}
				else{
					getWindow().showNotification("Enter Room Number", Window.Notification.TYPE_ERROR_MESSAGE);
				}
				adpatient.getRequiredError();
				//pt.adddata(ssn,fname,lname,ward,room);

							
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
		adn.addComponent(adpatient);
		setContent(navigationView);
		
	}
}
