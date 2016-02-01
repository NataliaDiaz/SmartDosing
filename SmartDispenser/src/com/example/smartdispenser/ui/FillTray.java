package com.example.smartdispenser.ui;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import org.json.JSONException;
import org.json.JSONObject;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.NumberField;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.server.ClientMethodInvocation;
import com.vaadin.server.ErrorHandler;
import com.vaadin.server.Extension;
import com.vaadin.server.Resource;
import com.vaadin.server.ServerRpcManager;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinResponse;
import com.vaadin.shared.communication.SharedState;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HasComponents;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Notification.Type;

public class FillTray extends NavigationView implements Component {

	private Button fillButton = new Button("Next");
	final NativeButton sample = new NativeButton("Save");
	private NumberField number = new NumberField("Number of Patients: ");
	public FillTray(){
		//super();
		setCaption("Filling tray");		
		
	}
	 
	private void FillingTray() {
		
		CssLayout content = new CssLayout();
        setContent(content);
        
        VerticalComponentGroup group =
                new VerticalComponentGroup();
        content.addComponent(group);
        
       // group.addComponent(new NumberField("Number of Patients you would like to fill the tray for:"));
       
            sample.addClickListener(new Button.ClickListener() {
        	public void buttonClick(ClickEvent event) {
              // sample.setCaption("You made me click!"); 
        		sample.setEnabled(true);
                Notification.show("The button was clicked",
                      Type.HUMANIZED_MESSAGE);               
            }
        });
            group.addComponent(sample);
            group.addComponent(number);
	      sample.setWidth("100px");
	      sample.setHeight("50px");
        
           
		}
}
