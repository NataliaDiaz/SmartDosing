package com.example.smart_dispenser;

import com.vaadin.addon.touchkit.ui.HorizontalComponentGroup;
import com.vaadin.addon.touchkit.ui.NavigationManager;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.TouchKitWindow;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.data.Container;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Form;
import com.vaadin.ui.Label;
import com.vaadin.ui.LoginForm;
import com.vaadin.ui.LoginForm.LoginEvent;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import data.dbhelper;

public class LoginWindow extends NavigationView {
	NavigationManager navigationmanager = new NavigationManager();
	SQLContainer sql = null;
	dbhelper db= new dbhelper();
	String SSN= null;
	String pw= null;
	public static String name= null;
	public Object ssn= null;
	
	CssLayout lay1= new CssLayout();
	HorizontalComponentGroup hg = new HorizontalComponentGroup();
	HorizontalComponentGroup hg1 = new HorizontalComponentGroup();
	VerticalComponentGroup vcg = new VerticalComponentGroup();
	VerticalLayout log = new VerticalLayout();
	TextField user= new TextField("Nurse Username");
	PasswordField Login= new PasswordField("Password");
	Table td = new Table();
	//Form f = new Form();
	Button Logbutton= new Button ("Login");
	Button newnurse= new Button("New Nurse");
	Label message = new Label();
	public LoginWindow(){
		
	}
	public void attach()
	{
		super.attach();
		this.setHeight("100%");
		buildview();
		setCaption("Smart Dosing Application");
		
	}
	private void buildview() {
		// TODO Auto-generated method stub
		Logbutton.setWidth("30%");
		Logbutton.addStyleName("logbutton");
		Logbutton.addListener(new ClickListener(){

			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				SSN = (String)user.getValue();
				pw = (String)Login.getValue();
				sql =db.authenticate(SSN, pw);
				td.setContainerDataSource(sql);
				Object id = td.firstItemId();
				
		//		f.setItemDataSource(td.getItem(id));
				
				if(td.firstItemId() !=null){
					getApplication().getMainWindow().setContent(new tabmenu());
					
					name = (String) td.getContainerProperty(id, "FirstName").getValue() + (String) td.getContainerProperty(id, "LastName").getValue();
					ssn  =  td.getContainerProperty(id, "NurseSSN").getValue();
				
					Smart_dispenserApplication.get().setUser(user.getValue());
					//getApplication().setUser(user.getValue());
				}
				else 
				{
				user.setValue("");
				Login.setValue("");
				getApplication().getMainWindow().showNotification("Invalid SSN or Password");
				}
				/*
				name= (String)td.getContainerProperty(id, "FirstName").getValue();
				if(name.equals(null)){
					//this.getApplication().getMainWindow().showNotification("All the medicines are filled.");
				
				}
				else 
					getApplication().getMainWindow().setContent(new smartdosing());
			*/
			
			}

			private void load() {
				// TODO Auto-generated method stub
				/*if(db.authenticate((String)user.getValue(),(String)Login.getValue())!=null)
				{
				this.getApplication().setMainWindow(new dispenserview());	
				}*/
			}

			
			
		});
		
		newnurse.addListener(new ClickListener(){

			public void buttonClick(ClickEvent event) {
				// TODO Auto-generated method stub
				newnurseview();
			}
			
		});
		log.addComponent(user);
		log.addComponent(Login);
		log.addComponent(Logbutton);
		log.addComponent(newnurse);
		Logbutton.setWidth("20%");
		newnurse.setWidth("20%");
	/*	hg.addComponent(user);
		hg.addComponent(Login);
		hg.addComponent(Logbutton);
		hg.addComponent(newnurse);*/
		log.setComponentAlignment(user, Alignment.MIDDLE_CENTER);
		log.setComponentAlignment(Login, Alignment.MIDDLE_CENTER);
		log.setComponentAlignment(Logbutton, Alignment.MIDDLE_CENTER);
		log.setComponentAlignment(newnurse, Alignment.MIDDLE_CENTER);
		
		//hg.addComponent(log);
		Embedded pic = new Embedded( "",new ThemeResource("startup.JPG"));
		 pic.setWidth("100%");
		 pic.setHeight("10cm");
		 vcg.addComponent(pic);
		 lay1.addComponent(log);
		 lay1.addComponent(vcg);
		/*hg1.addComponent(pic);
		hg.setWidth("50%");
		hg1.setWidth("50%");*/
	//	hg.setHeight("10cm");
		//hg1.setHeight("10cm");
		//lay1.setWidth("100%");
		//lay1.setHeight("100%");
		//lay1.addComponent(hg);
		//lay1.addComponent(hg1);
		//lay1.addComponent(vcg); 
		setContent(lay1);
		
		
		
		
		
		
	}
	protected void newnurseview() {
		// TODO Auto-generated method stub
		final addnurse Addnurse = new addnurse();
		Addnurse.setWidth("100%");
		Addnurse.showRelativeTo(getNavigationBar());
	}
	protected void loadresource() {
		// TODO Auto-generated method stub
		
		
	}
	

}
