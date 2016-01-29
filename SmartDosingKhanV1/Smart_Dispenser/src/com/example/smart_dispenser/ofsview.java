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

public class ofsview extends Popover
{
	dbhelper shifttable= new dbhelper();
	Table table = new Table();
	Container container = shifttable.getofs();
	Label lb= new Label("Out Of Stock");
	CssLayout cd= new CssLayout();
	NavigationView navigationView = new NavigationView(cd);
	public void attach()
	{
		super.attach();
		//cd.setCaption("Out Of Stock");
		buildview();
		navigationView.setCaption("Out Of Stock");
		this.setClosable(true);
		this.setModal(true);
		this.setWidth("80%");
		setHeight("85%");
		
	}
	private void buildview() {
		// TODO Auto-generated method stub
		
		
		//table.setSizeFull();
			lb.setStyleName("ofs");
			cd.addComponent(lb);
			
			table.setContainerDataSource(container);
			table.setVisibleColumns(new Object[]{"MedicineName","Date","UnitsDemanded"});
			table.setColumnHeader("MedicineName", "Medicine Name");
			table.setColumnHeader("UnitsDemanded", "Units Demanded");
			
			Button close = new Button(null, new ClickListener() {

	            public void buttonClick(ClickEvent event) {
	                event.getButton().getWindow().getParent()
	                        .removeWindow(event.getButton().getWindow());
	            }
	        });
	        close.setIcon(new ThemeResource("logout.png"));

	        navigationView.setRightComponent(close);
			
			
			
			table.setWidth("100%");
			cd.setMargin(true);
			cd.addComponent(table);
			//cd.setSizeFull();
			setContent(navigationView);
		
	}
	

}
