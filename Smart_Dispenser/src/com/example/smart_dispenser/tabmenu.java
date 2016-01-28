package com.example.smart_dispenser;

import java.util.Collection;
import java.util.Locale;
import java.util.Map;


import com.vaadin.Application;
import com.vaadin.addon.touchkit.ui.TabBarView;
import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;
import com.vaadin.terminal.Resource;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Component;
import com.vaadin.ui.Window;
import com.vaadin.ui.TabSheet.Tab;

public class tabmenu extends TabBarView implements Component {
	public tabmenu() {
		// TODO Auto-generated constructor stub
	
	Settings settings =new Settings();
	Medicines medication =new Medicines();
	Patient patient = new Patient();
	//Bginfo bginfo = new Bginfo();
	smartdosing sd = new smartdosing();
	Nurse nurse= new Nurse();
	
	
	Tab addTab = addTab(sd);
	addTab.setStyleName("style1");
	addTab.setCaption("Smart Dosing");
	addTab.setIcon(new ThemeResource("smd.png"));
	addTab =addTab(patient);
	addTab.setStyleName("style2");
	addTab.setCaption("Patients");
	addTab.setIcon(new ThemeResource("patien.png"));
	addTab = addTab(medication);
	addTab.setStyleName("style3");
	addTab.setCaption("Medications");
	addTab.setIcon(new ThemeResource("medicine.png"));
	addTab = addTab(nurse);
	addTab.setStyleName("style4");
	addTab.setCaption("Nurses");
	addTab.setIcon(new ThemeResource("nurse.png"));
	addTab = addTab(settings);
	addTab.setStyleName("style5");
	addTab.setCaption("Settings");
	addTab.setIcon(new ThemeResource("settings.jpg"));
	
	setSelectedTab(sd);

	
	}

}
