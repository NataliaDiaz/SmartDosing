package com.example.smart_dispenser;

import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Map;


import com.vaadin.addon.touchkit.ui.HorizontalComponentGroup;
import com.vaadin.addon.touchkit.ui.NavigationButton;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.Popover;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.data.Container;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;

import com.vaadin.Application;
import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;
import com.vaadin.terminal.Resource;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import data.dbhelper;


public class dispenserview extends NavigationView implements Component {
	 public static int x=0;
	 public static String choice = null;
	 OptionGroup optiongroup = new OptionGroup();
	
    dispenserview()
{
    	setCaption("Smart Dosing");
    	}

    public void attach(){
    	    
    	        super.attach();
    	        x=0;
    	        this.setHeight("100%");
    	        buildview();
    	    
    		
    	}
    void buildview()
    {	
    	
    	CssLayout cs= new CssLayout();
    	
    	VerticalComponentGroup verticalComponentGroup =new VerticalComponentGroup();
    	VerticalComponentGroup vcg = new VerticalComponentGroup();
    	
    	NavigationButton navigationbutton =new NavigationButton();
    	HorizontalComponentGroup hg = new HorizontalComponentGroup();
    	HorizontalComponentGroup hg1 = new HorizontalComponentGroup();
    	HorizontalComponentGroup hg2 = new HorizontalComponentGroup();
    	
    	navigationbutton.setHeight("3cm");
    	navigationbutton.setWidth("100%");
    	
    	navigationbutton.setCaption("Fill Tray");
    	navigationbutton.setStyleName("filltray");
    	
    	optiongroup.setStyleName("optiongrp");
    	optiongroup.addItem("Fill Tray by Patient");
    	optiongroup.addItem("Fill Tray by Medicine");
    	optiongroup.setHeight("2cm");
    	optiongroup.setVisible(true);
    	verticalComponentGroup.addComponent(navigationbutton);
    	verticalComponentGroup.addComponent(new Label (""));
    	NavigationButton Dispense = new NavigationButton();
    	Dispense.setHeight("3cm");
    	Dispense.setWidth("100%");
    	Dispense.setCaption("Dispense");
    	Dispense.setStyleName("dispense");
    	
    	vcg.addComponent(Dispense);
    	navigationbutton.addListener(new ClickListener(){

    		public void buttonClick(ClickEvent event) {
    				// TODO Auto-generated method stub
    			
    			getNavigationManager().navigateTo(new FillTray());
    			optiongroup.setVisible(true);
    			//filloption();
    		//	getNavigationManager().navigateTo(new FillTray());
    			
    				
    			}
    			
    		});
    	Dispense.addListener(new ClickListener(){

    		public void buttonClick(ClickEvent event) {
    			// TODO Auto-generated method stub
    			dbhelper db = new dbhelper();
    			Container dispensing = db.getDispenser();
    			Table table = new Table();
    			table.setContainerDataSource(dispensing);
    			if(table.firstItemId()==null)
    			{
    				getApplication().getMainWindow().showNotification("Tray is Empty !");
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
    	//verticalComponentGroup.setHeight("100%");
    	
    	optiongroup.addListener(new Property.ValueChangeListener() {
			
			public void valueChange(ValueChangeEvent event) {
				// TODO Auto-generated method stub
				choice= optiongroup.getValue().toString();
				//getNavigationManager().navigateTo(new FillTray());
			}
		});
    	
    	
    	Embedded b = new Embedded("",new ThemeResource("fill1.JPG"));
    	b.setHeight("100%");
    	b.setWidth("100%");
    	Embedded c = new Embedded("",new ThemeResource("fill2.JPG"));
    	c.setHeight("100%");
    	c.setWidth("100%");
    	Embedded d = new Embedded("",new ThemeResource("fill3.JPG"));
    	d.setHeight("100%");
    	d.setWidth("100%");
    	hg.addComponent(b);
    	hg.setHeight("100%");
    	hg.setWidth("33%");
    	hg1.addComponent(c);
    	hg1.setHeight("100%");
    	hg1.setWidth("33%");
    	
    	hg2.addComponent(d);
    	hg2.setHeight("100%");
    	hg2.setWidth("33%");
    //	vcg.addComponent(optiongroup);
    	cs.addComponent(optiongroup);
    	cs.addComponent(verticalComponentGroup);
    	cs.addComponent(vcg);
    	cs.addComponent(hg);
    	cs.addComponent(hg1);
    	cs.addComponent(hg2);
    	setContent(cs);
		

		
		//CssLayout log= new CssLayout();
		
		
		//log.addComponent(new tabmenu());
		
		
		//log.addComponent(new LoginWindow());
		//setContent(new tabmenu());
		//setContent(log);
		
}

	protected void filloption() {
		// TODO Auto-generated method stub
		
		FillOption foption= new FillOption(); 
		foption.setWidth("70%");
		foption.showRelativeTo(getNavigationBar());
		
		getNavigationManager().navigateTo(new FillTray());
	}
}
