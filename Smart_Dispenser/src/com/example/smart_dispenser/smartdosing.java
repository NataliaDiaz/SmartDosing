package com.example.smart_dispenser;

import com.vaadin.addon.touchkit.ui.NavigationButton;
import com.vaadin.addon.touchkit.ui.NavigationManager;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.Popover;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;


public class smartdosing extends NavigationManager {
	
	//private static ClassificationGroup root;
	
	smartdosing(){
		
		navigateTo(new dispenserview());
		
	}
	
	
	}
