package com.example.smart_dispenser;


import com.vaadin.Application;
import com.vaadin.addon.touchkit.ui.NavigationManager;
import com.vaadin.addon.touchkit.ui.TouchKitApplication;
import com.vaadin.addon.touchkit.ui.TouchKitWindow;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

import data.dbhelper;

public class Smart_dispenserApplication extends TouchKitApplication {
	
    NavigationManager navigationmanager = new NavigationManager();
    TouchKitWindow mainwindow = new TouchKitWindow();
    
    
    
   	     
	@Override
	
	 

	public void init() {
	setTheme("smart_dispensertheme");
	TouchKitWindow mainwindow = new TouchKitWindow();
	NavigationManager navigationmanager = new NavigationManager();
	navigationmanager.setCurrentComponent(new dispenserview() );
	setMainWindow(mainwindow);
	mainwindow.setContent(new LoginWindow());
	mainwindow.setPersistentSessionCookie(true);
	mainwindow.setWebAppCapable(true);
		
	}
	
	
	@Override
	public void onBrowserDetailsReady() {
		// TODO Auto-generated method stub
		
	
	
	}

}
