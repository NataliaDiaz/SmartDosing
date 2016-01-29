package com.example.smart_dispenser;

import com.vaadin.addon.touchkit.ui.HorizontalComponentGroup;
import com.vaadin.addon.touchkit.ui.NavigationButton;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.VerticalComponentGroup;
import com.vaadin.data.Container;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.Select;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

import data.dbhelper;

public class Settings extends NavigationView{
	dbhelper medicationtable= new dbhelper();
	Table table = new Table();
	ListSelect stable= new ListSelect("Select Table");
	Button signout = new Button("Logout");
	Button patient = new Button("New Patient");
	Button nurse = new Button("New Nurse");
	Button medicine = new Button("New Medicine");
	Button shift = new Button("Nurse Shift");
	Button ofs = new Button("Out Of Stock");
	
	Button showtable = new Button ("Show Table");
	CssLayout cd= new CssLayout();
	VerticalLayout vcg = new VerticalLayout();
	HorizontalComponentGroup h1 = new HorizontalComponentGroup();
	HorizontalComponentGroup h2 = new HorizontalComponentGroup();
	HorizontalComponentGroup h3 = new HorizontalComponentGroup();
	VerticalComponentGroup v = new VerticalComponentGroup();
	VerticalComponentGroup v1 = new VerticalComponentGroup();
	Container container = medicationtable.getMedication(); 
	String check;
	
	public void attach()
	{
		super.attach();
		buildview();
		this.setHeight("100%");
		this.setCaption("Settings");
	}
	private void buildview() {
		// TODO Auto-generated method stub
		//table.setSizeFull();
			
		patient.setIcon(new ThemeResource("newpatient.png"));
		nurse.setIcon(new ThemeResource("newnurse.png"));
		medicine.setIcon(new ThemeResource("newmedicine.png"));
		shift.setIcon(new ThemeResource("nurseshift.png"));
		ofs.setIcon(new ThemeResource("ofs.png"));
		signout.setIcon(new ThemeResource("logout.png"));
			patient.addListener(new ClickListener(){

				public void buttonClick(ClickEvent event) {
					// TODO Auto-generated method stub
					pview();
				}});
			
			nurse.addListener(new ClickListener(){

				public void buttonClick(ClickEvent event) {
					// TODO Auto-generated method stub
					newview();
				}});
			medicine.addListener(new ClickListener(){

				public void buttonClick(ClickEvent event) {
					// TODO Auto-generated method stub
					mview();
				}
				
			});
			shift.addListener(new ClickListener(){

				public void buttonClick(ClickEvent event) {
					// TODO Auto-generated method stub
					sview();
				}});
			ofs.addListener(new ClickListener(){

				public void buttonClick(ClickEvent event) {
					// TODO Auto-generated method stub
					ofsview();
				}});
			showtable.addListener(new ClickListener(){

				public void buttonClick(ClickEvent event) {
					// TODO Auto-generated method stub
					
					check = stable.getValue().toString();
				tshow(check);
					/* if(check.equals("Treatment Table")){
					 
				 }
				 if(check.equals("History Table")){
					 
				 }
				 if(check.equals("Nurse Table")){
					 
				 }
				 */
				}
				
			});
			signout.addListener(new ClickListener(){

				public void buttonClick(ClickEvent event) {
					// TODO Auto-generated method stub
					getWindow().getApplication().close();
				}
				
			});
			
			stable.addItem("Treatment Table");
			stable.addItem("History Table");
			stable.addItem("Nurse Table");
			signout.addStyleName("s1");
			signout.setWidth("20%");
			patient.addStyleName("s2");
			patient.setWidth("20%");
			nurse.addStyleName("s3");
			nurse.setWidth("20%");
			medicine.addStyleName("s4");
			medicine.setWidth("20%");
			shift.setWidth("20%");
			ofs.setWidth("20%");
			vcg.addStyleName("settingsview");
			vcg.addComponent(signout);
			vcg.setComponentAlignment(signout, Alignment.TOP_RIGHT);
			vcg.addComponent(patient);
			vcg.setComponentAlignment(patient, Alignment.MIDDLE_LEFT);
			vcg.addComponent(nurse);
			vcg.setComponentAlignment(nurse, Alignment.MIDDLE_LEFT);
			vcg.addComponent(medicine);
			vcg.setComponentAlignment(medicine, Alignment.MIDDLE_LEFT);
			vcg.addComponent(shift);
			vcg.setComponentAlignment(medicine, Alignment.MIDDLE_LEFT);
			vcg.addComponent(ofs);
			vcg.setComponentAlignment(medicine, Alignment.MIDDLE_LEFT);
			
			
			
			//h1.addComponent(patient);
		//	h1.setWidth("100%");
			//h2.addComponent(nurse);
			//h2.setWidth("100%");
			//h3.addComponent(medicine);
			//h3.setWidth("100%");
		    cd.addComponent(vcg);
		//	cd.addComponent(h1);
			//cd.addComponent(h2);
	//		cd.addComponent(h3);
			//v1.addComponent(h1);
			//v1.addComponent(h2);
			//v1.addComponent(h3);
		    stable.setWidth("100%");
		    stable.setHeight("20%");
			//cd.addComponent(stable);
			//cd.addComponent(v1);
			//cd.addComponent(v);
			showtable.setWidth("20%");
			//cd.addComponent(showtable);
			this.setContent(cd);
			
		
	}
	protected void ofsview() {
		// TODO Auto-generated method stub
		final ofsview Ofsview = new ofsview();
		Ofsview.setWidth("100%");
		Ofsview.showRelativeTo(getNavigationBar());
	}
	protected void sview() {
		// TODO Auto-generated method stub
		final shiftview Shiftview = new shiftview();
		Shiftview.setWidth("100%");
		Shiftview.showRelativeTo(getNavigationBar());
	}
	protected void tshow(String check2) {
		// TODO Auto-generated method stub
		if(check2.equals("Treatment Table"))
		{
			final TableShow tableshow= new TableShow();
			tableshow.setWidth("100%");
			tableshow.showRelativeTo(getNavigationBar());
		}
		if(check2.equals("Nurse Table"))
		{
			final TablenurseShow nshow= new TablenurseShow();
			nshow.setWidth("100%");
			nshow.showRelativeTo(getNavigationBar());
		}
		if(check2.equals("History Table"))
		{
			final TablehistoryShow hshow= new TablehistoryShow();
			hshow.setWidth("100%");
			hshow.showRelativeTo(getNavigationBar());
		}
		
	}
	protected void mview() {
		// TODO Auto-generated method stub
		final addmedicine Addmedicine= new addmedicine();
		Addmedicine.setWidth("100%");
		Addmedicine.showRelativeTo(getNavigationBar());
		
	}
	protected void pview() {
		// TODO Auto-generated method stub
		final addpatient Addpatient = new addpatient();
		Addpatient.setWidth("100%");
		Addpatient.showRelativeTo(getNavigationBar());
		
	}
	protected void newview() {
		// TODO Auto-generated method stub
		final addnurse Addnurse = new addnurse();
		Addnurse.setWidth("100%");
		Addnurse.showRelativeTo(getNavigationBar());
	}

}
