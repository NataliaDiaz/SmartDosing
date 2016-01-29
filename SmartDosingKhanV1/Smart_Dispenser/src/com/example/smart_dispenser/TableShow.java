package com.example.smart_dispenser;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.Popover;
import com.vaadin.data.Container;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import data.dbhelper;

public class TableShow extends Popover {
	dbhelper medicinetable= new dbhelper();
	Table table = new Table();
	Container container = medicinetable.getMedication();
	//Label lb= new Label("Treatment View");
	CssLayout cd= new CssLayout();
	NavigationView navigationView = new NavigationView(cd);
	public void attach()
	{
		super.attach();
		buildview();
		//this.setCaption("Treatment View");
	
		navigationView.setCaption("Treatment View");
		setWidth("100%");
		setHeight("80%");
		this.setClosable(true);
		this.setModal(true);
	}
	private void buildview() {
		// TODO Auto-generated method stub
		
		
		//table.setSizeFull();
		//lb.setStyleName("treatmentlabel");
		//cd.addComponent(lb);
			table.setContainerDataSource(container);
			table.setVisibleColumns(new Object[]{"PatientSSN","firstname","lastname","name","Amount","Unit","Posology","StartDate","EndDate","DoctorName","Comment"});
//			table.setVisibleItemProperties(new Object[]{"FirstName","LastName","Ward","Room","Name","Amount","Unit","TraySlot"});
			table.setColumnHeader("firstname", "First Name");
			table.setColumnHeader("lastname", "Last Name");
			table.setColumnHeader("PatientSSN", "Patient SSN");
			table.setColumnHeader("name", "Medicine Name");
			table.setColumnHeader("StartDate", "Start Date");
			table.setColumnHeader("EndDate", "End Date");
			table.setColumnHeader("DoctorName", "Doctor Name");
			Button close = new Button(null, new ClickListener() {

	            public void buttonClick(ClickEvent event) {
	                event.getButton().getWindow().getParent()
	                        .removeWindow(event.getButton().getWindow());
	            }
	        });
	        close.setIcon(new ThemeResource("logout.png"));
	        navigationView.setRightComponent(close);
			table.setWidth("100%");
			cd.addComponent(table);
			cd.setSizeFull();
			setContent(navigationView);
		
	}
	public void showtreatment(String ssn) {
		// TODO Auto-generated method stub
		container = medicinetable.getselectedtreatment(ssn);
	
	}
	
	
	

}