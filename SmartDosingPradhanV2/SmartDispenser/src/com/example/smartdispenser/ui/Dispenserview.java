package com.example.smartdispenser.ui;

import com.vaadin.addon.touchkit.ui.HorizontalButtonGroup;
import com.vaadin.addon.touchkit.ui.NavigationButton;
import com.vaadin.addon.touchkit.ui.NavigationManager;
import com.vaadin.addon.touchkit.ui.Popover;
import com.vaadin.addon.touchkit.ui.NavigationButton.NavigationButtonClickEvent;
import com.vaadin.addon.touchkit.ui.NavigationButton.NavigationButtonClickListener;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.data.Container;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.example.smartdispenser.SmartdispenserUI;
import com.example.smartdispenser.data.dbhelper;

public class Dispenserview extends NavigationView implements Component {
	 public static int x=0;
	 public static String choice = null;
	 OptionGroup optiongroup = new OptionGroup();
	
	 public Dispenserview()
{
		 this.setHeight("100%");
   	setCaption("Smart Dosing Application");
   	}
	
	 public void attach(){
 	    
	        super.attach();
	        x=0;
	        this.setHeight("100%");       
	        buildview();	    
		
	}

	@SuppressWarnings("serial")
	private void buildview() {
		// TODO Auto-generated method stub
		CssLayout cs= new CssLayout();
    	
    	VerticalComponentGroup verticalComponentGroup =new VerticalComponentGroup();
    	VerticalComponentGroup vcg = new VerticalComponentGroup();
   //HorizontalControlGroup to HorizontalButtonGroup by ranji
    	NavigationButton filltray =new NavigationButton();
    	HorizontalButtonGroup hg = new HorizontalButtonGroup();
    	HorizontalButtonGroup hg1 = new HorizontalButtonGroup();
    	HorizontalButtonGroup hg2 = new HorizontalButtonGroup();
    	
    	filltray.setHeight("3cm");
    	filltray.setWidth("100%");
    	
    	filltray.setCaption("Fill Tray");
    	filltray.setStyleName("filltray");
    	
    	//optiongroup.setStyleName("optiongrp");
    	//optiongroup.addItem("Fill Tray by Patient");
    	//optiongroup.addItem("Fill Tray by Medicine");
    	//optiongroup.setHeight("2cm");
    	//optiongroup.setVisible(true);
    	verticalComponentGroup.addComponent(filltray);
    	verticalComponentGroup.addComponent(new Label (""));
    	NavigationButton Dispense = new NavigationButton();
    	Dispense.setHeight("3cm");
    	Dispense.setWidth("100%");
    	Dispense.setCaption("Dispense");
    	Dispense.setStyleName("dispense");
    	
    	vcg.addComponent(Dispense);

    	filltray.addClickListener(new NavigationButtonClickListener() {
			
			@Override
			public void buttonClick(NavigationButtonClickEvent event) {
				// TODO Auto-generated method stub
				getNavigationManager().navigateTo(new FillTray());
    			//optiongroup.setVisible(true);
			}
		});

    	Dispense.addClickListener(new NavigationButtonClickListener(){
    		
    		@Override
			public void buttonClick(NavigationButtonClickEvent event) {
				// TODO Auto-generated method stub
				dbhelper db = new dbhelper();
    			Container dispensing = db.getDispenser();
    			Table table = new Table();
    			table.setContainerDataSource(dispensing);
    			if(table.firstItemId()==null)
    			{
    				UI.getCurrent().setDescription("Tray is Empty !");
    			}
    			else{
    			getNavigationManager().navigateTo(new Dispense());
    			}	popmessage();
			}

			
			private void popmessage() {
				// TODO Auto-generated method stub
				Popover message = new Popover();
    			message.setCaption("Please Fill the Tray First");
			}});	
    	//Embedded b = new Embedded("",new com.vaadin.server.ThemeResource("fill1.JPG"));
    	//b.setHeight("100%");
    	//b.setWidth("100%");
    	//Embedded c = new Embedded("",new com.vaadin.server.ThemeResource("fill2.JPG"));
    	//c.setHeight("100%");
    	//c.setWidth("100%");
    	//Embedded d = new Embedded("",new com.vaadin.server.ThemeResource("fill3.JPG"));
    	//d.setHeight("100%");
    	//d.setWidth("100%");
    	//hg.addComponent(b);
    	hg.setHeight("100%");
    	hg.setWidth("33%");
    	//hg1.addComponent(c);
    	hg1.setHeight("100%");
    	hg1.setWidth("33%");
    	
    	//hg2.addComponent(d);
    	hg2.setHeight("100%");
    	hg2.setWidth("33%");
    //	vcg.addComponent(optiongroup);
    //  cs.addComponent(optiongroup);
    	cs.addComponent(verticalComponentGroup);
    	cs.addComponent(vcg);
    	cs.addComponent(hg);
    	cs.addComponent(hg1);
    	cs.addComponent(hg2);
    	setContent(cs);
		
    		    	
	}
}
