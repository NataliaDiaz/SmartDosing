package com.example.smart_dispenser;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;


import com.vaadin.addon.touchkit.ui.HorizontalComponentGroup;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.data.Container;

import com.vaadin.Application;
import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;
import com.vaadin.terminal.Resource;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Table;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import data.dbconnect;
import data.dbdispense;
import data.dbhelper;

public class Dispense extends NavigationView implements Component {
	Skipmenu skipmenu= new Skipmenu();
	String lname = "";
	String ward,room,nameb1,pbutton,posology;
	Iterator i ;
	public static String reason ;
	ListIterator itr;
	dbdispense DB= new dbdispense();
	dbhelper db = new dbhelper();
	Embedded pic;
	
	Container dispensing = db.getDispenser();
	Button next= new Button("Next");
	Button skip = new Button("Skip");
	Button back = new Button("Back");
	Form dispenseform = new Form();
	Table dispensetable = new Table ("Dispense");
	HorizontalComponentGroup hg1= new HorizontalComponentGroup();
	HorizontalComponentGroup hg= new HorizontalComponentGroup();
	HorizontalComponentGroup hg2= new HorizontalComponentGroup();
	HorizontalComponentGroup hg3= new HorizontalComponentGroup();
	VerticalComponentGroup hg4 = new VerticalComponentGroup();
	VerticalComponentGroup glass = new VerticalComponentGroup();
	Embedded light;
	String tslot,NurseSSn;
	Integer treatmentid,fillid;
	Integer treatmentid1,fillid1;
	int x;
	Object id1,bid,previd;
	ArrayList al= new ArrayList();
	Stack sk = new Stack();
	
	ComboBox select = new ComboBox("Reason To Skip");
	public Dispense() {
		// TODO Auto-generated constructor stub
		this.setCaption("Dispense");
	}

	public void attach(){
	    
	        super.attach();
	        x=0;
	        this.setHeight("100%");
	        buildView();
	    
		
	}
	private void buildView() {
		// TODO Auto-generated method stub
		pbutton = "null";
		next.addStyleName("dispensenext");
		skip.addStyleName("dispenseskip");
		back.addStyleName("dispenseback");
		 CssLayout dview= new CssLayout();
		 VerticalComponentGroup vcg= new VerticalComponentGroup();
		 dispensetable.setContainerDataSource(dispensing);
		//emptycontainer();
		 select.addItem("Later");
		 select.addItem("operation ");
		 select.addItem("not time");
		 
		 select.setVisible(false);
		 i=dispensetable.getItemIds().iterator();
		 while(i.hasNext()){
			 al.add(i.next());
		 }
		 itr= al.listIterator();
		 if(itr.hasNext()==false){
			 emptycontainer();
		 }
		 lightselect();
		 next.setIcon(new ThemeResource("play.png"));
		 skip.setIcon(new ThemeResource("skip_forward.png"));
		 back.setIcon(new ThemeResource("rewind.png"));
		 
		 next.setWidth("30%");
			skip.setWidth("30%");
			
			
			back.setWidth("30%");
			id1 = dispensetable.getCurrentPageFirstItemId();
			 bid=id1;
			//dispenseform.setItemDataSource(dispensetable.getItem(id));
			dispenseform.setVisibleItemProperties(new Object[]{"FirstName","LastName","Ward","Room","Name","Posology","AmountandDosage","Unit","TraySlot"});
			dispenseform.setReadOnly(true);
			iteratedata();
/* 12-2-2013			
		 id1=dispensetable.firstItemId();
		 if(emptycontainer() ==false){
			dispenseform.setReadOnly(true);
		
		dispenseform.setItemDataSource(dispensetable.getItem(dispensetable.firstItemId()));
		Embedded a = new Embedded("Tray View",new ThemeResource("dispensepics/1.png"));
		dispenseform.setVisibleItemProperties(new Object[]{"FirstName","LastName","Ward","Room","Name","Amount","Unit","TraySlot"});
		dispenseform.setReadOnly(true);
		Object id= dispensetable.firstItemId();
		treatmentid =(Integer) dispensetable.getContainerProperty(id, "TreatmentID").getValue();
		fillid =(Integer) dispensetable.getContainerProperty(id, "ID").getValue();
		lname=(String)dispensetable.getContainerProperty(id, "TraySlot").getValue();
		DB.dispencetable(lname,treatmentid);
		DB.historytable(treatmentid,fillid);
		setpic("A1");
		a.setHeight("15cm");
		a.setWidth("100%");
		//hg1.addComponent(a);
		
		}12-2-2013*/
		 Embedded map = new Embedded( "",new ThemeResource("map.png"));
		 map.setWidth("100%");
		 map.setHeight("50%");
		 hg4.addComponent(map);
		
		 next.addListener(new ClickListener(){

			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
	/*			
				if(emptycontainer()==false)
		{
				if(x==0){
					dispensetable.removeItem(dispensetable.firstItemId());
				}
				Object id= dispensetable.firstItemId();
				//dispensetable.setVisibleColumns(new Object[]{"FirstName","LastName","Amount"});
				lname=(String)dispensetable.getContainerProperty(id, "TraySlot").getValue();
			//	NurseSSn =(String)dispensetable.getContainerProperty(id, "Nurse_NurseSSN").getValue();
				treatmentid =(Integer) dispensetable.getContainerProperty(id, "TreatmentID").getValue();
				fillid =(Integer) dispensetable.getContainerProperty(id, "ID").getValue();
				DB.dispencetable(lname,treatmentid);
				DB.historytable(treatmentid,fillid);
				ward = (String)dispensetable.getContainerProperty(id, "Ward").getValue();
				room= (String)dispensetable.getContainerProperty(id, "Room").getValue();
				x++;
				setpic(lname);
				setlocation(ward,room);
				formdata(id);
		}	
			*/	
				
				Object temp;
				
				if(pbutton.equals("back")){
					temp= itr.next();
				}
				if(itr.hasNext()==false){
					
					
					if(sk.empty()==false)
					{
						skipmessage();
					}
				}
				if(pbutton.equals("skip")){
					if(reason.equals("Later")){
						sk.add(previd);
					}
					else
					DB.skipfill(treatmentid,fillid,reason);
				}
			save();
			iteratedata();
			pbutton = "next";
			}
			

			
				
			 
		 });
		 back.addListener(new ClickListener(){

			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if(pbutton.equals("skip")){
					if(reason.equals("Later"))
					{
						sk.add(previd);
					}
					else
					DB.skipfill(treatmentid,fillid,reason);
				}
				Object temp;
				
				if(itr.hasPrevious()){
					if(pbutton.equals("next")){
						temp=itr.previous();
					}
					
					nameb1= (String)dispensetable.getContainerProperty(bid, "LastName").getValue();
				back();
				pbutton = "back";
				}
				else 
					backpop();
				
				
			}});
		 skip.addListener(new ClickListener(){

			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if(pbutton.equals("skip")){
					if(reason.equals("Later"))
					{
						sk.add(previd);
					}
					else
					DB.skipfill(treatmentid,fillid,reason);
				}
				skip();
				pbutton = "skip";
				/*12-02-2013
				 sk.push(id1);
				 
				iterateskipdata(); 12-02-2013*/
			}});
		 dispenseform.setWidth("50%");
		 //dispenseform.setReadOnly(true);
		 //pic.setWidth("75%");
		 hg1.setWidth("30%");
		 hg1.setHeight("100%");
		 hg2.setWidth("35%");
		 hg.setWidth("30%");
		 //dispenseform.setReadOnly(true);
		 hg2.addComponent(dispenseform);
		 next.setWidth("30%");
		 hg2.addComponent(next);
		 hg2.addComponent(back);
		 hg2.addComponent(skip);
		 hg2.addComponent(select);
		
		 skip.setWidth("30%");
		 hg2.setHeight("100%");
		 hg3.setWidth("5%");
		 hg3.setHeight("100%");
		 hg.setHeight("100%");
		 hg4.setHeight("50%");
		 glass.setHeight("50%");
		 
		 hg.addComponent(hg4);
		 hg.addComponent(glass);
		 //hg3.addComponent(light);
		// hg1.addComponent(pic);
		 dview.addComponent(hg2);
		 dview.addComponent(hg1);
		 dview.addComponent(hg);
		 dview.addComponent(hg3);
		 
		 //dview.addComponent(hg2);
		 //vcg.addComponent(next);
		 //dview.addComponent(vcg);
		 vcg.setWidth("100%");
		 //dview.addComponent(dispenseform);
		 //dview.addComponent(next);
		// dview.addComponent(vcg);
		 dview.setSizeFull();
		 setContent(dview);
	
		
	}

	protected void skipmessage() {
		// TODO Auto-generated method stub
		this.getApplication().getMainWindow().showNotification("There are some medicines left to dispense");
		
	}

	protected void save() {
		// TODO Auto-generated method stub
		lname=(String)dispensetable.getContainerProperty(previd, "TraySlot").getValue();
	//	posology=(String)dispensetable.getContainerProperty(previd, "Posology").getValue();
//		NurseSSn =(String)dispensetable.getContainerProperty(id, "Nurse_NurseSSN").getValue();
		treatmentid =(Integer) dispensetable.getContainerProperty(previd, "TreatmentID").getValue();
		fillid =(Integer) dispensetable.getContainerProperty(previd, "ID").getValue();
		DB.dispencetable(lname,treatmentid);
		DB.historytable(treatmentid,fillid);
	}

	protected void skip() {
		// TODO Auto-generated method stub
		skipmenu.setWidth("50%");
		
		skipmenu.showRelativeTo(getNavigationBar());
//		skipmessage = skipmenu.getMessage();
		/*select.setVisible(true);
		select.addListener(new Listener(){

			//public void componentEvent(Event event) {
				// TODO Auto-generated method stub
				reason= select.getValue().toString();
			}});
		*/
		
		iterateskipdata();
	}

	protected void backpop() {
		// TODO Auto-generated method stub
		this.getApplication().getMainWindow().showNotification("First Medicine to Dispense");
		id1=bid;
	}

	protected void back() {
		// TODO Auto-generated method stub
		bid = itr.previous();
		dispenseform.setItemDataSource(dispensetable.getItem(bid));
		dispenseform.setVisibleItemProperties(new Object[]{"FirstName","LastName","Ward","Room","Bed","Name","AmountandDosage","Unit","Posology"});
		dispenseform.getField("Name").setCaption("Medicine Name");
		dispenseform.getField("FirstName").setCaption("First Name");
		dispenseform.getField("LastName").setCaption("Last Name");
		dispenseform.getField("AmountandDosage").setCaption("Amount & Dosage");
		dispenseform.setReadOnly(true);
		 lname = (String)dispensetable.getContainerProperty(bid, "TraySlot").getValue();
		 ward = (String)dispensetable.getContainerProperty(bid, "Bed").getValue();
		 room= (String)dispensetable.getContainerProperty(bid, "Room").getValue();
		
		//setmedicine(medicine);
		setpic(lname);
		setlocation(ward,room);
		formdata(bid);
	}

	protected void iterateskipdata() {
		// TODO Auto-generated method stub
		Object temp;
		String medicine;
		treatmentid =(Integer) dispensetable.getContainerProperty(id1, "TreatmentID").getValue();
		fillid =(Integer) dispensetable.getContainerProperty(id1, "ID").getValue();
		
	//	DB.skipfill(treatmentid,fillid,reason);
		itr.remove();
		id1=itr.next();
		//temp = tempitr.previous();
		//tempitr.remove();
		bid=id1;
		//Integer x= (Integer)patientinfo.getContainerProperty(id1,"TreatmentID").getValue();
		//Object id1 = i.next();
		
		
		lname=(String)dispensetable.getContainerProperty(id1, "TraySlot").getValue();
//		NurseSSn =(String)dispensetable.getContainerProperty(id, "Nurse_NurseSSN").getValue();
		//treatmentid =(Integer) dispensetable.getContainerProperty(id1, "TreatmentID").getValue();
		//fillid =(Integer) dispensetable.getContainerProperty(id1, "ID").getValue();
		//DB.dispencetable(lname,treatmentid);
		//DB.historytable(treatmentid,fillid);
		ward = (String)dispensetable.getContainerProperty(id1, "Bed").getValue();
		room= (String)dispensetable.getContainerProperty(id1, "Room").getValue();
		x++;
		setpic(lname);
		setlocation(ward,room);
		formdata(id1);
		
		
		
	
		previd= id1;
		
		
		/*  12-02-2013
		  if(i.hasNext()==false){
		 
			if(sk.empty()==false)
			{
			Object id2 = sk.pop();
			dispenseform.setItemDataSource(dispensetable.getItem(id2));
			dispenseform.setReadOnly(true);
			}
			else
			{
				//popmessage();
			}
		}
		else{
		//String medicine;
		//for (Iterator i  =patientinfo.getItemIds().iterator(); i.hasNext();){
			 id1 = i.next();
			
			//Integer x= (Integer)patientinfo.getContainerProperty(id1,"TreatmentID").getValue();
		//Object id1 = i.next();
		
	//	lname2=(String)patientinfo.getContainerProperty(id1, "LastName").getValue();
		//db.fillhistoy(x);
		//db.filltable(x,count);
		//medicine = (String)patientinfo.getContainerProperty(id1, "Name").getValue();
		//stack.push(id1); 
		
	//	setmedicine(medicine);
		
		// todispense.setData(c);
		//patientinfo.getContainerProperty(itemId, propertyId)
		
	//	p.addItemAfter(c);
		
		
		dispenseform.setItemDataSource(dispensetable.getItem(id1));
		dispenseform.setReadOnly(true);
		} 12-02-2013 */
	}

	private void formdata(Object id) {
		// TODO Auto-generated method stub
		dispenseform.setItemDataSource(dispensetable.getItem(id));
		dispenseform.setVisibleItemProperties(new Object[]{"FirstName","LastName","Room","Bed","Name","AmountandDosage","Posology","TraySlot"});
		dispenseform.getField("Name").setCaption("Medicine Name");
		dispenseform.getField("FirstName").setCaption("First Name");
		dispenseform.getField("LastName").setCaption("Last Name");
		dispenseform.getField("AmountandDosage").setCaption("Amount & Dosage");
		
		dispenseform.setReadOnly(true);
		if(dispensetable.isLastId(id)){
			lastitem();
		};
		
		
	}
	protected void setlocation(String ward2, String room2) {
		// TODO Auto-generated method stub
	if(ward2.equals("1"))
	{
		if(room2.equals("1"))
		{
			hg4.removeAllComponents();
			Embedded map1 = new Embedded( "",new ThemeResource("location/1.png"));
			 map1.setWidth("100%");
			 map1.setHeight("100%");
			 hg4.addComponent(map1);
		}
	
		if(room2.equals("2"))
		{
			hg4.removeAllComponents();
			Embedded map2 = new Embedded( "",new ThemeResource("location/2.png"));
			 map2.setWidth("100%");
			 map2.setHeight("100%");
			 hg4.addComponent(map2);
		}
	
		if(room2.equals("3"))
		{
			hg4.removeAllComponents();
			Embedded map3 = new Embedded( "",new ThemeResource("location/3.png"));
			 map3.setWidth("100%");
			 map3.setHeight("100%");
			 hg4.addComponent(map3);
		}
	
		if(room2.equals("5"))
		{
			hg4.removeAllComponents();
			Embedded map4 = new Embedded( "",new ThemeResource("location/5.png"));
			 map4.setWidth("100%");
			 map4.setHeight("100%");
			 hg4.addComponent(map4);
		}
		if(room2.equals("6"))
		{
			hg4.removeAllComponents();
			Embedded map4 = new Embedded( "",new ThemeResource("location/6.png"));
			 map4.setWidth("100%");
			 map4.setHeight("100%");
			 hg4.addComponent(map4);
		}
		if(room2.equals("7"))
		{
			hg4.removeAllComponents();
			Embedded map4 = new Embedded( "",new ThemeResource("location/7_1.png"));
			 map4.setWidth("100%");
			 map4.setHeight("100%");
			 hg4.addComponent(map4);
		}
		if(room2.equals("8"))
		{
			hg4.removeAllComponents();
			Embedded map4 = new Embedded( "",new ThemeResource("location/8_1.png"));
			 map4.setWidth("100%");
			 map4.setHeight("100%");
			 hg4.addComponent(map4);
		}
		if(room2.equals("9"))
		{
			hg4.removeAllComponents();
			Embedded map4 = new Embedded( "",new ThemeResource("location/9_1.png"));
			 map4.setWidth("100%");
			 map4.setHeight("100%");
			 hg4.addComponent(map4);
		}
		if(room2.equals("10"))
		{
			hg4.removeAllComponents();
			Embedded map4 = new Embedded( "",new ThemeResource("location/10_1.png"));
			 map4.setWidth("100%");
			 map4.setHeight("100%");
			 hg4.addComponent(map4);
		}
		if(room2.equals("11"))
		{
			hg4.removeAllComponents();
			Embedded map4 = new Embedded( "",new ThemeResource("location/11_1.png"));
			 map4.setWidth("100%");
			 map4.setHeight("100%");
			 hg4.addComponent(map4);
		}
		if(room2.equals("12"))
		{
			hg4.removeAllComponents();
			Embedded map4 = new Embedded( "",new ThemeResource("location/12_1.png"));
			 map4.setWidth("100%");
			 map4.setHeight("100%");
			 hg4.addComponent(map4);
		}
	
	
	}
	else
	{
			if(room2.equals("7"))
			{
				hg4.removeAllComponents();
				Embedded map5 = new Embedded( "",new ThemeResource("location/7_2.png"));
				 map5.setWidth("100%");
				 map5.setHeight("100%");
				 hg4.addComponent(map5);
			}
			if(room2.equals("8"))
			{
				hg4.removeAllComponents();
				Embedded map6 = new Embedded( "",new ThemeResource("location/8_2.png"));
				 map6.setWidth("100%");
				 map6.setHeight("100%");
				 hg4.addComponent(map6);
			}
		
			if(room2.equals("9"))
			{
				hg4.removeAllComponents();
				Embedded map6 = new Embedded( "",new ThemeResource("location/9_2.png"));
				 map6.setWidth("100%");
				 map6.setHeight("100%");
				 hg4.addComponent(map6);
			}
			if(room2.equals("10"))
			{
				hg4.removeAllComponents();
				Embedded map6 = new Embedded( "",new ThemeResource("location/10_2.png"));
				 map6.setWidth("100%");
				 map6.setHeight("100%");
				 hg4.addComponent(map6);
			}
			if(room2.equals("11"))
			{
				hg4.removeAllComponents();
				Embedded map6 = new Embedded( "",new ThemeResource("location/11_2.png"));
				 map6.setWidth("100%");
				 map6.setHeight("100%");
				 hg4.addComponent(map6);
			}
			if(room2.equals("12"))
			{
				hg4.removeAllComponents();
				Embedded map6 = new Embedded( "",new ThemeResource("location/12_2.png"));
				 map6.setWidth("100%");
				 map6.setHeight("100%");
				 hg4.addComponent(map6);
			}
		
			
	}
	
}

	protected void lastitem() {
		this.getApplication().getMainWindow().showNotification("Last Medicine to Dispense");
		dispenserview.x=2;
		hg3.removeAllComponents();
		 Embedded green = new Embedded( "",new ThemeResource("trafficlights/3.png"));
		 green.setWidth("100%");
		 hg3.addComponent(green);
		// next.setVisible(false);
		//this.getNavigationManager().navigateBack();
	}

	private void emptycontainer() {
		// TODO Auto-generated method stub
			this.getApplication().getMainWindow().showNotification("Tray is Empty !");
			next.setEnabled(false);
			getNavigationManager().navigateBack();
			
			
	}
	void iteratedata()
	{
	
	
	if(itr.hasNext()==false){
		if(sk.empty()==false)
		{
		Object id2 = sk.pop();
		
		data(id2);
		dispenseform.setItemDataSource(dispensetable.getItem(id2));
		dispenseform.setVisibleItemProperties(new Object[]{"FirstName","LastName","Room","Bed","Name","AmountandDosage","Posology","TraySlot"});
		dispenseform.getField("Name").setCaption("Medicine Name");
		dispenseform.getField("FirstName").setCaption("First Name");
		dispenseform.getField("LastName").setCaption("Last Name");
		dispenseform.getField("AmountandDosage").setCaption("Amount & Dosage");
		
		dispenseform.setReadOnly(true);
		}
		else{
			//popmessage();
		}
		dispenserview.x=2;
		lightselect();
	}
	else{
	
	//for (Iterator i  =patientinfo.getItemIds().iterator(); i.hasNext();){
		 //id1 = i.next();

		data(itr.next());
		 //changes made on 29-11
	/*	 
		Integer x= (Integer)patientinfo.getContainerProperty(id1,"TreatmentID").getValue();*/
	//Object id= dispensetable.firstItemId();
				
	/*
	lname2=(String)patientinfo.getContainerProperty(id1, "LastName").getValue();
	db.fillhistoy(x);
	db.filltable(x,count);
	medicine = (String)patientinfo.getContainerProperty(id1, "Name").getValue();
	stack.push(id1); 
	
	setmedicine(medicine);
	
	
	
	fm.setItemDataSource(patientinfo.getItem(id1));
	fm.setReadOnly(true);
	
	if(lname1.equals(lname2)){
		count=count;
	}
	else 
		count++;
	settray();
	}
	*/}
}
private void data(Object id2) {
	// TODO Auto-generated method stub
	//dispensetable.setVisibleColumns(new Object[]{"FirstName","LastName","Amount"});
	id1=id2;
	bid = id1;
	lname=(String)dispensetable.getContainerProperty(id1, "TraySlot").getValue();
	posology=(String)dispensetable.getContainerProperty(id1, "Posology").getValue();
//	NurseSSn =(String)dispensetable.getContainerProperty(id, "Nurse_NurseSSN").getValue();
	treatmentid =(Integer) dispensetable.getContainerProperty(id1, "TreatmentID").getValue();
	fillid =(Integer) dispensetable.getContainerProperty(id1, "ID").getValue();
//	DB.dispencetable(lname,treatmentid);
//	DB.historytable(treatmentid,fillid);
	ward = (String)dispensetable.getContainerProperty(id1, "Bed").getValue();
	room= (String)dispensetable.getContainerProperty(id1, "Room").getValue();
	x++;
	setpic(lname);
	setlocation(ward,room);
	formdata(id1);
	setglass(posology);
	previd = id1;
	lightselect();
	
}

	

	private void lightselect() {
		// TODO Auto-generated method stub
		 if(dispenserview.x==0){
			 hg3.removeAllComponents();
			 Embedded red = new Embedded( "",new ThemeResource("trafficlights/1.png"));
			 red.setWidth("100%");
			 red.setHeight("100%");
			 hg3.addComponent(red);

		 }
		 if(dispenserview.x==1){
			 hg3.removeAllComponents();
			 Embedded yellow = new Embedded( "",new ThemeResource("trafficlights/2.png"));
			 yellow.setWidth("100%");
			 yellow.setHeight("100%");
			 hg3.addComponent(yellow);

		 }
		 if(dispenserview.x==2){
			 hg3.removeAllComponents();
			 Embedded green = new Embedded( "",new ThemeResource("trafficlights/3.png"));
			 green.setWidth("100%");
			 green.setHeight("100%");
			 hg3.addComponent(green);
		 }
		
	}

	protected void setpic(String lname2) {
		// TODO Auto-generated method stub
		
	if(lname.equals("A1")){
		hg1.removeAllComponents();
		Embedded a = new Embedded("",new ThemeResource("dispensepics/1.png"));
		a.setHeight("100%");
		a.setWidth("100%");
		hg1.addComponent(a);
	}
	if(lname.equals("A2")){
		
		hg1.removeAllComponents();
		Embedded b = new Embedded("",new ThemeResource("dispensepics/2.png"));
		b.setHeight("100%");
		b.setWidth("100%");
		
		hg1.addComponent(b);
	}
	if(lname.equals("A3")){
		hg1.removeAllComponents();
		Embedded c = new Embedded("",new ThemeResource("dispensepics/3.png"));
		c.setHeight("100%");
		c.setWidth("100%");
		
		hg1.addComponent(c);
	}
	if(lname.equals("B1")){
		hg1.removeAllComponents();
		Embedded d = new Embedded("",new ThemeResource("dispensepics/4.png"));
		d.setHeight("100%");
		d.setWidth("100%");
		
		hg1.addComponent(d);
	}
	if(lname.equals("B2")){
		hg1.removeAllComponents();
		Embedded e = new Embedded("",new ThemeResource("dispensepics/5.png"));
		e.setHeight("100%");
		e.setWidth("100%");
		
		hg1.addComponent(e);
	}
	if(lname.equals("B3")){
		hg1.removeAllComponents();
		Embedded f = new Embedded("",new ThemeResource("dispensepics/6.png"));
		f.setHeight("100%");
		f.setWidth("100%");
		
		hg1.addComponent(f);
	}
	if(lname.equals("C1")){
		hg1.removeAllComponents();
		Embedded g = new Embedded("",new ThemeResource("dispensepics/8.png"));
		g.setHeight("100%");
		g.setWidth("100%");
		
		hg1.addComponent(g);
	}
	if(lname.equals("C2")){
		hg1.removeAllComponents();
		Embedded h = new Embedded("",new ThemeResource("dispensepics/9.png"));
		h.setHeight("100%");
		h.setWidth("100%");
		
		hg1.addComponent(h);
	}
	if(lname.equals("C3")){
		hg1.removeAllComponents();
		Embedded i = new Embedded("",new ThemeResource("dispensepics/10.png"));
		i.setHeight("100%");
		i.setWidth("100%");
		
		hg1.addComponent(i);
	}
	if(lname.equals("D1")){
		hg1.removeAllComponents();
		Embedded j = new Embedded("",new ThemeResource("dispensepics/11.png"));
		j.setHeight("100%");
		j.setWidth("100%");
		
		hg1.addComponent(j);
	}
	if(lname.equals("D2")){
		hg1.removeAllComponents();
		Embedded k = new Embedded("",new ThemeResource("dispensepics/12.png"));
		k.setHeight("100%");
		k.setWidth("100%");
		
		hg1.addComponent(k);
	}
	if(lname.equals("D3")){
		hg1.removeAllComponents();
		Embedded l = new Embedded("",new ThemeResource("dispensepics/13.png"));
		l.setHeight("100%");
		l.setWidth("100%");
		
		hg1.addComponent(l);
	}
	if(lname.equals("E1")){
		hg1.removeAllComponents();
		Embedded m = new Embedded("",new ThemeResource("dispensepics/14.png"));
		m.setHeight("100%");
		m.setWidth("100%");
		
		hg1.addComponent(m);
	}
	if(lname.equals("E2")){
		hg1.removeAllComponents();
		Embedded n = new Embedded("",new ThemeResource("dispensepics/15.png"));
		n.setHeight("100%");
		n.setWidth("100%");
		
		hg1.addComponent(n);
	}
	if(lname.equals("E3")){
		hg1.removeAllComponents();
		Embedded o = new Embedded("",new ThemeResource("dispensepics/16.png"));
		o.setHeight("100%");
		o.setWidth("100%");
		
		hg1.addComponent(o);
	}
	
	
	
	}
	private void setglass(String posology2) {
		// TODO Auto-generated method stub
		
			
		if(posology2.equals("08:00,20:00")){
			glass.removeAllComponents();
			Embedded o = new Embedded("",new ThemeResource("glasspics/2.png"));
			o.setHeight("100%");
			o.setWidth("100%");
			
			glass.addComponent(o);
		}
		
		if(posology2.equals("14:00,20:00")){
			glass.removeAllComponents();
			Embedded a = new Embedded("",new ThemeResource("glasspics/3.png"));
			a.setHeight("100%");
			a.setWidth("100%");
			
			glass.addComponent(a);
		}
		
		if(posology2.equals("14:00")){
			glass.removeAllComponents();
			Embedded b = new Embedded("",new ThemeResource("glasspics/4.png"));
			b.setHeight("100%");
			b.setWidth("100%");
			
			glass.addComponent(b);
		}
		
		if(posology2.equals("20:00")){
			glass.removeAllComponents();
			Embedded c = new Embedded("",new ThemeResource("glasspics/5.png"));
			c.setHeight("100%");
			c.setWidth("100%");
			
			glass.addComponent(c);
		}
		
		if(posology2.equals("22:00")){
			glass.removeAllComponents();
			Embedded d = new Embedded("",new ThemeResource("glasspics/6.png"));
			d.setHeight("100%");
			d.setWidth("100%");
			
			glass.addComponent(d);
		}
		
		if(posology2.equals("08:00,22:00")){
			glass.removeAllComponents();
			Embedded e = new Embedded("",new ThemeResource("glasspics/7.png"));
			e.setHeight("100%");
			e.setWidth("100%");
			
			glass.addComponent(e);
		}
			
			
			
	}
	
	
	
	
	
}
