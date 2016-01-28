package com.example.smart_dispenser;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.data.Container;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Table;

import data.dbhelper;

public class Nurse extends NavigationView {
	
	Shiftshow sv= new Shiftshow();
	dbhelper medicinetable= new dbhelper();
	Table table = new Table();
	Button shift= new Button("Shift");
	Container container = medicinetable.getNursetable();
	
	dbhelper patienttable= new dbhelper();
			
			
			
			public void attach()
	{
		super.attach();
		setCaption("Nurses");
		buildview();
		
	}
	private void buildview() {
		// TODO Auto-generated method stub
		CssLayout cd= new CssLayout();
		shift.setEnabled(false);
		//table.setSizeFull();
			
			table.setContainerDataSource(container);
			table.setWidth("100%");
			table.setColumnHeader("NurseSSN", "Nurse SSN");
			table.setColumnHeader("FirstName", "First Name");
			table.setColumnHeader("LastName", "Last Name");
			table.setSelectable(true);
			table.addListener(new ItemClickListener(){

				public void itemClick(ItemClickEvent event) {
					// TODO Auto-generated method stub
					shift.setEnabled(true);
				}});
			
			shift.addListener(new ClickListener(){

				public void buttonClick(ClickEvent event) {
					// TODO Auto-generated method stub
					Object id = table.getValue();
					String ssn = (String)table.getContainerProperty(id,"NurseSSN").getValue();
					sv.showtreatment(ssn);
					sv.setWidth("80%");
					sv.showRelativeTo(getNavigationBar());
				}});
			shift.setWidth("30%");
			cd.addComponent(table);
			cd.addComponent(shift);
			cd.setSizeFull();
			setContent(cd);
		
	}

}
