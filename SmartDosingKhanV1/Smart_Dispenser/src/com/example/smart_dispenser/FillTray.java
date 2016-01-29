package com.example.smart_dispenser;

import java.awt.List;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TimeZone;
import java.util.Vector;





import com.vaadin.addon.touchkit.ui.HorizontalComponentGroup;
import com.vaadin.addon.touchkit.ui.NavigationButton;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.data.Container;
import com.vaadin.data.Property;
import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.IndexedContainer;
import com.vaadin.data.util.sqlcontainer.SQLContainer;

import com.vaadin.Application;
import com.vaadin.terminal.ClassResource;
import com.vaadin.terminal.ExternalResource;
import com.vaadin.terminal.PaintException;
import com.vaadin.terminal.PaintTarget;
import com.vaadin.terminal.Resource;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.terminal.gwt.server.WebBrowser;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import data.dbconnect;
import data.dbhelper;


public class FillTray extends NavigationView implements Component {
	public static Container dispense;
	public static String skipmessage;
	public static String equiname;
	int equid;
	int firstpic =0;
	String prevbutton ="nothing";
	TableShow tb = new TableShow();
	Skipmenu skipmenu= new Skipmenu();
	Object previd;
	String []ssn=new String[15];
	public static String quantity;
	Stack sk = new Stack();
	LinkedList l= new LinkedList();
	ArrayList al= new ArrayList();
	int timecheck;
	java.util.Date dt;
	Embedded light = new Embedded( "",new ThemeResource("trafficlights/1.png"));
	String lname1,nameb1;
	boolean flag = false;
	boolean backcheck = true;
	String lname2,pbutton;
	TablenurseShow tn= new TablenurseShow();
	Ofspop ofspop = new Ofspop();
	dbconnect db = new dbconnect();
	Button skip = new Button("Skip");
	public static int count;
	int firstclick=0;
	dbhelper patienttable= new dbhelper();
	Iterator i,b,temp ;
	Vector stack = new Vector();
	//SQLContainer container = null;
	ListIterator itr,tempitr;
	SQLContainer container = patienttable.getMedication();
	SQLContainer container0 = patienttable.getfMedication();
	SQLContainer container1 = patienttable.getMedication1();
	SQLContainer container2 = patienttable.getMedication2();
	SQLContainer container3 = patienttable.getMedication3();
	Object id1,bid;
	boolean bkck = false;
	VerticalComponentGroup glass = new VerticalComponentGroup();
	SQLContainer equi= null;
	HorizontalComponentGroup pic= new HorizontalComponentGroup();
	HorizontalComponentGroup hg3= new HorizontalComponentGroup();
	HorizontalComponentGroup lights= new HorizontalComponentGroup();
	public Container p = null;
	Table patientinfo= new Table();
	Button streatment = new Button("See Treatment");
	
	Button next =new Button("Next");
	Button back =new Button("Back");
	Button Dispense = new Button("Dispense");
	Button equivalence = new Button("Equivalence");
	Button ofs = new Button("Out of Stock");
	WebBrowser wb = new WebBrowser();
	public Table todispense = new Table();	
	OptionGroup optiongroup = new OptionGroup();
	//VerticalComponentGroup hg1= new VerticalComponentGroup();
	//VerticalComponentGroup vcg= new VerticalComponentGroup();
	HorizontalComponentGroup hg1= new HorizontalComponentGroup();
	Form fm = new Form();
	
	public FillTray() {
		this.setCaption("Fill Tray");
	
		this.setIcon(new ThemeResource("trafficlights/1.png"));
		
//	buildview();	
	}

	public void attach()
	{
		super.attach();
		this.setHeight("100%");
		opt();
		//buildview();
		
	}
	
	void opt(){
		
		
		/*
		optiongroup.addItem("Fill Tray by Patient");
    	optiongroup.addItem("Fill Tray by Medicine");

    	
    	
    	optiongroup.addListener(new Property.ValueChangeListener() {
			
			public void valueChange(ValueChangeEvent event) {
				// TODO Auto-generated method stub
				 String choice= optiongroup.getValue().toString();
				//getNavigationManager().navigateTo(new FillTray());
				
				 
				 */
				 	if(dispenserview.choice.equals("Fill Tray by Medicine")){
						patientinfo.setContainerDataSource(container0);
					}
					
				 	else 
				 		patientinfo.setContainerDataSource(container);
					buildview();
			
			}
			
			
			
			
		
		
    	//this.setContent(optiongroup);
		
	
	
	
	
	
	
	void buildview (){
		//this.removeAllComponents();
	//	checktime();
	//	settimecheck();
		/*if(timecheck == 0){
			patientinfo.setContainerDataSource(container0);
		}
		if(timecheck == 1){
			patientinfo.setContainerDataSource(container1);
		}
		if(timecheck == 2){
			patientinfo.setContainerDataSource(container2);
		}
		if(timecheck == 3){
			patientinfo.setContainerDataSource(container3);
		}
		*/
		
		next.addStyleName("fillnext");
		Dispense.addStyleName("filldispense");
		equivalence.addStyleName("fillequivalence");
		streatment.addStyleName("streatment");
		skip.addStyleName("fillskip");
		back.addStyleName("fillback");
		ofs.addStyleName("outofstock");
		count =0;
		pbutton="nothing";
		dt = wb.getCurrentDate();
		CssLayout trayview= new CssLayout ();
		HorizontalSplitPanel sp = new HorizontalSplitPanel();		
		HorizontalComponentGroup hg= new HorizontalComponentGroup();
		
		
		trayview.setSizeFull();
		 i=patientinfo.getItemIds().iterator();
		 temp = patientinfo.getItemIds().iterator();
		 while(temp.hasNext()){
			 al.add(temp.next());
		 }
		 
		 tempitr= al.listIterator();
		streatment.setIcon(new ThemeResource("seetreatment1.png"));
		next.setIcon(new ThemeResource("play.png"));
		skip.setIcon(new ThemeResource("skip_forward.png"));
		back.setIcon(new ThemeResource("rewind.png"));
		equivalence.setIcon(new ThemeResource("preferences.png"));
		ofs.setIcon(new ThemeResource("delete.png"));
		//final Object id = patientinfo.getCurrentPageFirstItemId();
		//fm.setItemDataSource(patientinfo.getItem(id));
		//showdata();
		
		fm.setVisibleItemProperties(new Object[]{"FirstName","LastName","Ward","Room","Bed","Name","AmountandDosage","Unit","posology"});
		//fm.getField("Name").setCaption("Medicine Name");
		fm.setReadOnly(true);
		fm.setWidth("50%");
		next.addStyleName("buttonstyle");
		next.setWidth("100%");
		hg.addComponent(fm);
		 id1 = patientinfo.getCurrentPageFirstItemId();
		 bid=id1;
		 lname1=(String)patientinfo.getContainerProperty(id1, "SSn").getValue();
		 iteratedata();
		// itr=(ListIterator) patientinfo.getItemIds().iterator();
		next.addListener(new ClickListener(){

			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Object temp;
				sofs();
				equi();
				pbutton="next";
			/*	Object c= new Object();
				c= patientinfo.firstItemId();
				if(patientinfo.isLastId(c)){
					lastdata();
					popmessage();
				}
			/*	if(flag == true){
					popmessage();
					
					
				}*/
			/*	else
				{
					firstclick++;	
					showdata();
				}
			*/
				//changes made recently
			//	Object id1 = patientinfo.getCurrentPageFirstItemId();
				if(prevbutton.equals("back")){
					temp= tempitr.next();
				}
				
				lname1=(String)patientinfo.getContainerProperty(previd, "SSn").getValue();
				iteratedata();
				prevbutton= "next";
				
				
				//Object id4=tempitr.next();
				//data(id4);
				//fm.setItemDataSource(patientinfo.getItem(id4));
				//fm.setVisibleItemProperties(new Object[]{"FirstName","LastName","Ward","Room","Bed","Name","Amount","Unit","Posology"});

				//fm.setReadOnly(true);
			}});	
		
	
		streatment.addListener(new ClickListener(){

			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				sofs();
				equi();
				pbutton="seetreatment";
				Object id12 = patientinfo.getCurrentPageFirstItemId();
				String SSn = (String)patientinfo.getContainerProperty(bid,"SSn").getValue();
				
				tb.showtreatment(SSn);
				tb.setWidth("80%");
				tb.showRelativeTo(getNavigationBar());
			}
			
		});
		/*
		
		//treatment.addListener(new ClickListener(){

			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
			
				String lname1 = (String)patientinfo.getContainerProperty(id1,"lname1").getValue();
				tb.showtreatment(lname1);
				tb.setWidth("80%");
				tb.showRelativeTo(getNavigationBar());
			}
			
		});*/
		Dispense.addListener(new ClickListener(){

			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				sofs();
				equi();
				pbutton="dispense";
				if(firstclick==0){
					
				}
				else{
					lastdata();
					getNavigationManager().navigateTo(new Dispense());
				
				}
				
			}});
		skip.addListener(new ClickListener(){

			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				/*Object id= patientinfo.firstItemId();
				Object id1 = patientinfo.nextItemId(id);
				Object id2=patientinfo.lastItemId();
		//		p.addItem(id);
				//patientinfo.addItemAfter(id2);
				patientinfo.removeItem(id);
				*/
				//prevbutton ="skip";
				sofs();
				equi();
				pbutton="skip";
				skip();
				//fm.setItemDataSource(patientinfo.getItem(id1));
				//fm.setReadOnly(true);
				
				
				//	sk.push(id1);
				
				//	sk.push(id1);
				
				
			//	iterateskipdata();
				
				
			}});
	
		equivalence.addListener(new ClickListener(){
			

			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				sofs();
				equi();
				pbutton="equivalence";
				String medicinename;
				equid = db.equid();
				//Object id1 = patientinfo.getCurrentPageFirstItemId();
				medicinename=(String)patientinfo.getContainerProperty(bid, "Name").getValue();
				equi=db.getequivalent(medicinename);
				tn.setcontainer(equi);
				tn.setWidth("50%");
				tn.showRelativeTo(getNavigationBar());
			}
			
		});
		
		ofs.addListener(new ClickListener(){

			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if(pbutton.equals("ofs")){
					sofs();
				}
				equi();
				pbutton="ofs";
				String name;
		//		ofspop.setWidth("50%");
		//		ofspop.showRelativeTo(getNavigationBar());
				
				OFS();
				 //name = (String)patientinfo.getContainerProperty(bid, "Name").getValue();
				 //db.fillofs(name,quantity);
			
			}});
		
		
		back.addListener(new ClickListener(){

			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				sofs();
				equi();
				pbutton="back";
				/*16-01-2013
				back();
				
				prevbutton= "back";
				bkck = true;
			16-01-2013*/
				Object temp;
				if(tempitr.hasPrevious())
			{
					if(prevbutton.equals("next")){
						temp=tempitr.previous();
					}
				
				//bid=tempitr.previous();
				
					nameb1= (String)patientinfo.getContainerProperty(previd, "SSn").getValue();
					
				//Object id3 = tempitr.previous();
				//fm.setItemDataSource(patientinfo.getItem(id3));
				//fm.setVisibleItemProperties(new Object[]{"FirstName","LastName","Ward","Room","Bed","Name","Amount","Unit","Posology"});

				//fm.setReadOnly(true);
			back();
			prevbutton="back";
			}
			
			
			else 
				backpop();
			}
			
			
		});
		
		this.setRightComponent(Dispense);
		
		next.setWidth("40%");
		skip.setWidth("30%");
		
		equivalence.setWidth("60%");
		back.setWidth("40%");
		ofs.setWidth("60%");
		streatment.setWidth("60%");
		
		hg.addComponent(next);
		
//		hg.addComponent(skip);
		hg.addComponent(back);
	//	hg.addComponent(bu);
//		hg.addComponent(equivalence);
//		hg.addComponent(ofs);
		hg.setWidth("100%");
		//Embedded b = new Embedded("",new ThemeResource("medicine/burana.jpg"));
		//b.setHeight("100%");
		//b.setWidth("100%");
	//	hg1.addComponent(b);
		glass.setHeight("30%");
		hg1.addComponent(equivalence);
		hg1.addComponent(streatment);
		
		hg1.addComponent(ofs);
		
		
		pic.setWidth("35%");
		pic.setHeight("100%");
		hg.setWidth("30%");
		hg.setHeight("100%");
		hg1.setWidth("100%");
		hg1.setHeight("40%");
		hg3.setWidth("30%");
		hg3.setHeight("100%");
		
		lights.setWidth("5%");
		lights.setHeight("100%");
		pic.setHeight("100%");
		hg.setHeight("100%");
		trayview.setSizeFull();
		trayview.addComponent(hg);
		light.setWidth("100%");
		light.setHeight("100%");
		lights.addComponent(light);
		
		hg3.addComponent(glass);
		hg3.addComponent(hg1);
		hg3.addComponent(equivalence);
		hg3.addComponent(streatment);
		
		hg3.addComponent(ofs);
		
		trayview.addComponent(pic);
		//trayview.addComponent(glass);
		trayview.addComponent(hg3);
		trayview.addComponent(lights);
		this.setContent(trayview);
		
				
				
	
	}

	protected void sofs(){
		if(pbutton.equals("ofs")){
			String name;
			name = (String)patientinfo.getContainerProperty(bid, "Name").getValue();
			db.fillofs(name,quantity);
		 }
	}
	protected void equi(){
		if(pbutton.equals("equivalence"))
		{
			String medicine;
			
			medicine= FillTray.equiname;
			
			db.fillequid(equid, medicine);
		}
	}
	

	protected void OFS() {
		// TODO Auto-generated method stub
		ofspop.setWidth("50%");
		ofspop.showRelativeTo(getNavigationBar());
		
	}

	protected void backpop() {
		// TODO Auto-generated method stub
		this.getApplication().getMainWindow().showNotification("No Medicines to Display");
		id1=bid;
	}
	void newpatient(){
		this.getApplication().getMainWindow().showNotification("New Patient");
	}

	protected void iterateskipdata() {
		// TODO Auto-generated method stub
		Object temp;
		String medicine;
		tempitr.remove();
		id1=tempitr.next();
		//temp = tempitr.previous();
		//tempitr.remove();
		bid=id1;
		//Integer x= (Integer)patientinfo.getContainerProperty(id1,"TreatmentID").getValue();
		//Object id1 = i.next();
		
		lname2=(String)patientinfo.getContainerProperty(id1, "SSn").getValue();
		//db.fillhistoy(x);
		
		medicine = (String)patientinfo.getContainerProperty(id1, "Name").getValue();
		stack.add(0,id1);
		
		l.add(id1);
	
		setmedicine(medicine);
		
		// todispense.setData(c);
		//patientinfo.getContainerProperty(itemId, propertyId)
		
	//	p.addItemAfter(c);
		
		
		fm.setItemDataSource(patientinfo.getItem(id1));
		fm.setVisibleItemProperties(new Object[]{"FirstName","LastName","Ward","Room","Bed","Name","AmountandDosage","Unit","posology"});
		
		fm.setReadOnly(true);
		//}
		if(lname1.equals(lname2)){
			count=count;
		}
		else 
			count--;
		settray(count);
		//tempitr.remove();
		//db.filltable(x,count);
		/*2-11-2013
		  	if(i.hasNext()==false){
		 
				if(sk.empty()==false)
				{
				Object id2 = sk.pop();
				fm.setItemDataSource(patientinfo.getItem(id2));
				fm.setReadOnly(true);
				}
				else
				{
					popmessage();
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
			
			
			fm.setItemDataSource(patientinfo.getItem(id1));
			fm.setVisibleItemProperties(new Object[]{"FirstName","LastName","Ward","Room","Bed","Name","Amount","Unit","Posology"});

			fm.setReadOnly(true);
			}
			
			2-11-2013*/
	}

	protected void skip() {
	//	final Skipmenu skipmenu= new Skipmenu();
		skipmenu.setWidth("50%");
		skipmenu.showRelativeTo(getNavigationBar());
//		skipmessage = skipmenu.getMessage();
		iterateskipdata();
		
	}

	private void settimecheck() {
		// TODO Auto-generated method stub
		if(timecheck == 0){
			patientinfo.setContainerDataSource(container0);
		}
		if(timecheck == 1){
			patientinfo.setContainerDataSource(container1);
		}
		if(timecheck == 2){
			patientinfo.setContainerDataSource(container2);
		}
		if(timecheck == 3){
			patientinfo.setContainerDataSource(container3);
		}
		
	}

	protected void back() {
		// TODO Auto-generated method stub
		/* 22-01-2013
		  if(backcheck == true)
		 
		{
		int x = l.size();
		itr= stack.listIterator();
		backcheck=false;
		}
		if(l.isEmpty()){
			this.getApplication().getMainWindow().showNotification("This is the first Medicine");
		}
		else{
		//	itr = l.listIterator();
		Object id5 = itr.next();
		
		fm.setItemDataSource(patientinfo.getItem(id5));
		fm.setVisibleItemProperties(new Object[]{"FirstName","LastName","Ward","Room","Bed","Name","Amount","Unit","Posology"});

		fm.setReadOnly(true);
		count--;
		settray();
		backcheck = false;
		}22-01-2013*/
		bid = tempitr.previous();
		fm.setItemDataSource(patientinfo.getItem(bid));
		fm.setVisibleItemProperties(new Object[]{"FirstName","LastName","Ward","Room","Bed","Name","AmountandDosage","Unit","posology"});
		fm.getField("Name").setCaption("Medicine Name");
		fm.getField("FirstName").setCaption("First Name");
		fm.getField("LastName").setCaption("Last Name");
		fm.getField("AmountandDosage").setCaption("Amount & Dosage");
		//fm.getField("AmountandDosage").setWidth("100%");
		fm.setReadOnly(true);
		fm.setReadOnly(true);
		String nameb2 = (String)patientinfo.getContainerProperty(bid, "SSn").getValue();
		String medicine = (String)patientinfo.getContainerProperty(bid, "Name").getValue();
		
		setmedicine(medicine);
		if(nameb1.equals(nameb2)){
			count=count;
		}
		else 
			count--;
		settray(count);
		//db.filltable(x,count);
		previd=bid;
	}

	private void checktime() {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getTimeZone("EET"));
		int hour = cal.get(Calendar.HOUR);
		int am_pm =cal.get(Calendar.AM_PM);
		//if(cal.get(Calendar.AM_PM))
		
		if(am_pm==1)
		{
		
		
			if(hour<4)
			{
				timecheck=2;
			}
			if(hour<8)
			{
				timecheck=3;
			}
			if(hour<12 && hour >8)
			{
				timecheck=0;
			}
			
		}
		if(am_pm==0)
		{
		
			
			if(hour<8)
			{
				timecheck=0;
			}
			if(hour<12 && hour >8)
			{
				timecheck=1;
			}
			
		}
	}

	protected void popmessage() {
		// TODO Auto-generated method stub
		dispenserview.x=1;
		this.getApplication().getMainWindow().showNotification("All the medicines are filled.");
		
		
		//getNavigationManager().navigateTo(new Dispense());;
		
	}

	private void showdata() {
		// TODO Auto-generated method stub
		if(firstclick==0){
			
			Object id1 = patientinfo.getCurrentPageFirstItemId();
			Integer x= (Integer)patientinfo.getContainerProperty(id1,"TreatmentID").getValue();
			count=0;
			db.fillhistoy(x);
			db.filltable(x,count);
			lname1=(String)patientinfo.getContainerProperty(id1, "SSn").getValue();
			fm.setItemDataSource(patientinfo.getItem(id1));
			fm.setReadOnly(true);
			settray(count);
		}
		else {
		Object id1 = patientinfo.getCurrentPageFirstItemId();
		//todispense.setData(id1);
			
		Integer x= (Integer)patientinfo.getContainerProperty(id1,"TreatmentID").getValue();
		
		db.fillhistoy(x);
		db.filltable(x,count);
		lname1=(String)patientinfo.getContainerProperty(id1, "SSn").getValue();
		
		patientinfo.removeItem(id1);
		
		Object c= new Object();
		 c= patientinfo.firstItemId();
		 
		
		// todispense.setData(c);
		//patientinfo.getContainerProperty(itemId, propertyId)
		
	//	p.addItemAfter(c);
		
		lname2=(String)patientinfo.getContainerProperty(c, "SSn").getValue();
		
		fm.setItemDataSource(patientinfo.getItem(c));
		fm.setReadOnly(true);
		//dispense.
		//tf.setPropertyDataSource(lname1);
		
		if(lname1.equals(lname2)){
			count=count;
		}
		else 
			count++;
		settray(count);
		
		
		flag= patientinfo.isLastId(c);		

		}
	}
	void lastdata()
	{
		Object id1 = patientinfo.getCurrentPageFirstItemId();
		//todispense.setData(id1);
		
		Integer x= (Integer)patientinfo.getContainerProperty(id1,"TreatmentID").getValue();
		
		db.fillhistoy(x);
		db.filltable(x,count);
		lname1=(String)patientinfo.getContainerProperty(id1, "SSn").getValue();
		
		//patientinfo.removeItem(id1);
		
		
		
		// todispense.setData(c);
		//patientinfo.getContainerProperty(itemId, propertyId)
		
	//	p.addItemAfter(c);
		
		//lname2=(String)patientinfo.getContainerProperty(c, "LastName").getValue();
		//fm.setItemDataSource(patientinfo.getItem(c));
		//fm.setReadOnly(true);
		//dispense.
		//tf.setPropertyDataSource(lname1);
		
		if(lname1.equals(lname2)){
			count=count;
		}
		else 
			count++;
		settray(count);
		
		
			
		
	}
	
	void iteratedata()
		{
		
		
		if(tempitr.hasNext()==false){
			if(sk.empty()==false)
			{
			Object id2 = sk.pop();
			
			data(id2);
			fm.setItemDataSource(patientinfo.getItem(id2));
			fm.setReadOnly(true);
			}
			else{
				popmessage();
			}
			dispenserview.x=1;
		}
		
		else{
		
		//for (Iterator i  =patientinfo.getItemIds().iterator(); i.hasNext();){
			 //id1 = i.next();
			
	
			data(tempitr.next());
			 //changes made on 29-11
		/*	 
			Integer x= (Integer)patientinfo.getContainerProperty(id1,"TreatmentID").getValue();
		
		
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
		String p;
		String medicine;
		id1=id2;
		bid=id1;
		Integer x= (Integer)patientinfo.getContainerProperty(id1,"TreatmentID").getValue();
		//Object id1 = i.next();
		
		lname2=(String)patientinfo.getContainerProperty(id1, "SSn").getValue();
		db.fillhistoy(x);
		
		p=(String)patientinfo.getContainerProperty(id1, "posology").getValue();
		
			medicine = (String)patientinfo.getContainerProperty(id1, "Name").getValue();
		
		stack.add(0,id1);
		
		l.add(id1);
	
		setmedicine(medicine);
		
		// todispense.setData(c);
		//patientinfo.getContainerProperty(itemId, propertyId)
		
	//	p.addItemAfter(c);
		
		
		fm.setItemDataSource(patientinfo.getItem(id1));
		fm.setVisibleItemProperties(new Object[]{"FirstName","LastName","Ward","Room","Bed","Name","AmountandDosage","Unit","posology"});
		fm.getField("Name").setCaption("Medicine Name");
		fm.getField("FirstName").setCaption("First Name");
		fm.getField("LastName").setCaption("Last Name");
		fm.getField("AmountandDosage").setCaption("Amount & Dosage");
		//fm.getField("AmountandDosage").setWidth("100%");
		
		fm.setReadOnly(true);
		//}
		if(lname1.equals(lname2)){
			count=count;
			
			settray(count);
			if(count==0){
				
				ssn[count]=lname1;
			}
		}
		else {
			Boolean chk = false;
			int xyz = count;
			for(int i= 0;i <= xyz;i++ )
			{
				if(lname2.equals(ssn[i]))
				{
					
					settray(i);
					chk=true;
				}
				
			}
			if(chk==false){
				
				count++;
				ssn[count]=lname2;
				
				
				newpatient();
				settray(count);	
				
			}
			
			
		//	ssn[count]=lname2;
		//	count++;
		//	newpatient();
		//	settray(count);
		}
		setglass(p);
		db.filltable(x,count);
		previd=id1;
	}

	

	private void setmedicine(String medicine) {
		// TODO Auto-generated method stub
		if(medicine.equals("Burana 200 mg")){
			hg1.removeAllComponents();
			Embedded b = new Embedded("",new ThemeResource("medicine/xl_burana.jpg"));
			b.setHeight("100%");
			b.setWidth("100%");
			hg1.addComponent(b);
			
		}
		if(medicine.equals("Burana 400 mg")){
			hg1.removeAllComponents();
			Embedded b = new Embedded("",new ThemeResource("medicine/burana.jpg"));
			b.setHeight("100%");
			b.setWidth("100%");
			hg1.addComponent(b);	
			
		}
		if(medicine.equals("Panadol")){
			hg1.removeAllComponents();
			Embedded b = new Embedded("",new ThemeResource("medicine/PanadolEO.jpg"));
			b.setHeight("100%");
			b.setWidth("100%");
			hg1.addComponent(b);
			
		}
		if(medicine.equals("Ciproxin")){
			hg1.removeAllComponents();
			Embedded b = new Embedded("",new ThemeResource("medicine/Ciproxin.jpg"));
			b.setHeight("100%");
			b.setWidth("100%");
			hg1.addComponent(b);
			
		}
		if(medicine.equals("Brufen")){
			hg1.removeAllComponents();
			Embedded b = new Embedded("",new ThemeResource("medicine/brufen.jpg"));
			b.setHeight("100%");
			b.setWidth("100%");
			hg1.addComponent(b);
			
		}
		if(medicine.equals("Paracetamol"))
		{
			hg1.removeAllComponents();
			Embedded b = new Embedded("",new ThemeResource("medicine/Paracetamol.jpg"));
			b.setHeight("100%");
			b.setWidth("100%");
			hg1.addComponent(b);
			
			
		}
		if(medicine.equals("Flagyl"))
		{
			hg1.removeAllComponents();
			Embedded b = new Embedded("",new ThemeResource("medicine/flagyl.jpg"));
			b.setHeight("100%");
			b.setWidth("100%");
			hg1.addComponent(b);
			
		}
		if(medicine.equals("Imodium")){
			hg1.removeAllComponents();
			Embedded b = new Embedded("",new ThemeResource("medicine/imodium.jpg"));
			b.setHeight("100%");
			b.setWidth("100%");
			hg1.addComponent(b);
			
		}
	}

	private void settray(int count){
		if(count ==0)
		{
			if(firstpic==0){
				
				pic.removeAllComponents();
				//pic.removeComponent(e);
				Embedded a = new Embedded("",new ThemeResource("traypics/0.png"));
				a.setHeight("100%");
				a.setWidth("100%");
				pic.addComponent(a);
				firstpic++;	
			}
			//pic.addComponent(a);
			else{
				pic.removeAllComponents();
				//pic.removeComponent(e);
				Embedded a = new Embedded("",new ThemeResource("traypics/1.png"));
				a.setHeight("100%");
				a.setWidth("100%");
				pic.addComponent(a);
				
			}
		}
		if(count ==1)
		{
			pic.removeAllComponents();
			Embedded b = new Embedded("",new ThemeResource("traypics/2.png"));
			b.setHeight("100%");
			b.setWidth("100%");
			pic.addComponent(b);
		}
		if(count ==2)
		{
			pic.removeAllComponents();
			Embedded c = new Embedded("",new ThemeResource("traypics/3.png"));
			c.setHeight("100%");
			c.setWidth("100%");
			pic.addComponent(c);
		}
		if(count ==3)
		{
			pic.removeAllComponents();
			Embedded d = new Embedded("",new ThemeResource("traypics/4.png"));
			 d.setHeight("100%");
			 d.setWidth("100%");
			 pic.addComponent(d);
		}
		if(count == 4){
			pic.removeAllComponents();
			Embedded e = new Embedded("",new ThemeResource("traypics/5.png"));
			e.setHeight("100%");
			e.setWidth("100%");
			pic.addComponent(e);
			}
		if(count ==5)
		{
			pic.removeAllComponents();
			Embedded  f = new Embedded("",new ThemeResource("traypics/6.png"));
			f.setHeight("100%");
			f.setWidth("100%");
			pic.addComponent(f);
		}
		if(count ==6)
		{
			pic.removeAllComponents();
			Embedded g = new Embedded("",new ThemeResource("traypics/7.png"));
			g.setHeight("100%");
			g.setWidth("100%");
			pic.addComponent(g);
		}
		if(count ==7)
		{
			pic.removeAllComponents();
			 Embedded h = new Embedded("",new ThemeResource("traypics/8.png"));
			 h.setHeight("100%");
			 h.setWidth("100%");
			 pic.addComponent(h);
		}
		if(count ==8)
		{
			pic.removeAllComponents();
			Embedded i = new Embedded("",new ThemeResource("traypics/9.png"));
			i.setHeight("100%");
			i.setWidth("100%");
			pic.addComponent(i);
		}
		if(count ==9)
		{
			pic.removeAllComponents();
			Embedded j= new Embedded("",new ThemeResource("traypics/10.png"));
			j.setHeight("100%");
			j.setWidth("100%");
			pic.addComponent(j);
		}
		if(count ==10)
		{
			pic.removeAllComponents();
			Embedded k = new Embedded("",new ThemeResource("traypics/11.png"));
			k.setHeight("100%");
			k.setWidth("100%");
			pic.addComponent(k);
		}
		if(count ==11)
		{
			pic.removeAllComponents();
			Embedded l = new Embedded("",new ThemeResource("traypics/12.png"));
			l.setHeight("100%");
			l.setWidth("100%");
			pic.addComponent(l);
		}
		if(count ==12)
		{
			pic.removeAllComponents();
			Embedded m = new Embedded("",new ThemeResource("traypics/13.png"));
			m.setHeight("100%");
			m.setWidth("100%");
			pic.addComponent(m);
		}
		if(count ==13)
		{
			pic.removeAllComponents();
			Embedded n = new Embedded("",new ThemeResource("traypics/14.png"));
			n.setHeight("100%");
			n.setWidth("100%");
			pic.addComponent(n);
		}
		if(count ==14)
		{
			pic.removeAllComponents();
			Embedded o = new Embedded("",new ThemeResource("traypics/15.png"));
			o.setHeight("100%");
			o.setWidth("100%");
			pic.addComponent(o);
		}
		if(count ==15)
		{
			pic.removeAllComponents();
			Embedded o = new Embedded("",new ThemeResource("traypics/16.png"));
			o.setHeight("100%");
			o.setWidth("100%");
			pic.addComponent(o);
			count=0;
			
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
	


