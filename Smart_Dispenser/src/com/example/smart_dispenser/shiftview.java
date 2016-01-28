package com.example.smart_dispenser;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.Popover;
import com.vaadin.data.Container;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Form;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import data.dbhelper;
import data.newpatient;

public class shiftview extends Popover {

	dbhelper shifttable= new dbhelper();
	Table table = new Table();
	Container container = shifttable.getshifttable();
	//Label lb= new Label("Shift View");
	CssLayout cd= new CssLayout();
	NavigationView navigationView = new NavigationView(cd);
	public void attach()
	{
		super.attach();
		buildview();
		navigationView.setCaption("Shift View");
		setWidth("100%");
		setHeight("80%");
		this.setClosable(true);
		this.setModal(true);
		
	}
	private void buildview() {
		// TODO Auto-generated method stub
		
		
		//table.setSizeFull();
		//	lb.setStyleName("Shiftlabel");
		//	cd.addComponent(lb);
			table.setContainerDataSource(container);
			table.setColumnHeader("date", "Date");
			table.setColumnHeader("day", "Day");
			table.setColumnHeader("time", "Time");
			table.setColumnHeader("Firstname", "First Name");
			table.setColumnHeader("LastName", "Last Name");
			table.setColumnHeader("email", "Email");
			table.setWidth("100%");
			
			Button close = new Button(null, new ClickListener() {

	            public void buttonClick(ClickEvent event) {
	                event.getButton().getWindow().getParent()
	                        .removeWindow(event.getButton().getWindow());
	            }
	        });
	        close.setIcon(new ThemeResource("logout.png"));

	        navigationView.setRightComponent(close);
	        
			cd.addComponent(table);
			cd.setSizeFull();
			setContent(navigationView);
		
	}
	
		
	


}
