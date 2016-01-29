package com.example.smart_dispenser;


import data.dbhelper;

import com.vaadin.addon.touchkit.ui.HorizontalComponentGroup;
import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.data.Container;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Table;

public class Patient extends NavigationView {
	
	TableShow tb = new TableShow();
	TablehistoryShow th= new TablehistoryShow();
	HorizontalComponentGroup hg= new HorizontalComponentGroup();
	dbhelper patienttable= new dbhelper();
	Table table = new Table();
	Container container = patienttable.getPatient();
	Button treatment = new Button("See Treatment");
	Button history = new Button("See History");
	public void attach()
	{
		super.attach();
		setCaption("Patients");
		buildview();
		
	}
	private void buildview() {
		// TODO Auto-generated method stub
		CssLayout cd= new CssLayout();
	//	treatment.setVisible(false);
	//	history.setVisible(false);
		treatment.setEnabled(false);
		history.setEnabled(false);
		//table.setSizeFull();
		treatment.setIcon(new ThemeResource("seetreatment.png"));
		history.setIcon(new ThemeResource("history.png"));
			treatment.setStyleName("seetreatment");
			history.setStyleName("seehistory");
			treatment.setWidth("10%");
			history.setWidth("10%");
			table.setContainerDataSource(container);
			table.setWidth("100%");
			table.setColumnHeader("FirstName", "First Name");
			table.setColumnHeader("LastName", "Last Name");
			table.setSelectable(true);
			cd.addComponent(table);
			table.addListener(new ItemClickListener(){

				public void itemClick(ItemClickEvent event) {
					// TODO Auto-generated method stub
					treatment.setEnabled(true);
					history.setEnabled(true);
					
				}});
			treatment.addListener(new ClickListener(){

				public void buttonClick(ClickEvent event) {
					// TODO Auto-generated method stub
					Object id = table.getValue();
					String ssn = (String)table.getContainerProperty(id,"SSN").getValue();
					tb.showtreatment(ssn);
					tb.setWidth("80%");
					tb.showRelativeTo(getNavigationBar());
				}
				
			});
			history.addListener(new ClickListener(){

				public void buttonClick(ClickEvent event) {
					// TODO Auto-generated method stub
					Object id = table.getValue();
					String ssn = (String)table.getContainerProperty(id,"SSN").getValue();
					th.showtreatment(ssn);
					th.setWidth("95%");
					th.showRelativeTo(getNavigationBar());
				}
				
			});
			history.setWidth("25%");
			treatment.setWidth("25%");
			hg.setWidth("100%");
			cd.setSizeFull();
			hg.addComponent(history);
			
			hg.addComponent(treatment);
			cd.addComponent(hg);
			setContent(cd);
		
	}
	

}
