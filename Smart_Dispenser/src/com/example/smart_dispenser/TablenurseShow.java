package com.example.smart_dispenser;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.addon.touchkit.ui.Popover;
import com.vaadin.data.Container;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.terminal.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import data.dbhelper;

public class TablenurseShow extends Popover{

	dbhelper medicinetable= new dbhelper();
	Table table = new Table();
	Container container = medicinetable.getNursetable();
	CssLayout cd= new CssLayout();
	NavigationView navigationView = new NavigationView(cd);
	public void attach()
	{
		super.attach();
		this.setCaption("Equivalence");
		setWidth("100%");
		setHeight("80%");
		buildview();
		
	}
	private void buildview() {
		// TODO Auto-generated method stub
		
		
		//table.setSizeFull();
			table.setSelectable(true);
			table.setContainerDataSource(container);
			table.setVisibleColumns(new Object[]{"Name","Component","Indication","Comment","MethodofAdministration"});
			table.setColumnHeader("Name", "Medicine Name");
			table.setColumnHeader("MethodofAdministration", "Method Of Administration");
			table.setWidth("100%");
			Button close = new Button(null, new ClickListener() {

	            public void buttonClick(ClickEvent event) {
	                event.getButton().getWindow().getParent()
	                        .removeWindow(event.getButton().getWindow());
	            }
	        });
			
	        close.setIcon(new ThemeResource("logout.png"));
	        Button save = new Button("Save", new ClickListener(){

				public void buttonClick(ClickEvent event) {
					// TODO Auto-generated method stub
					
				}}); 
	        Button cancel = new Button("Cancel", new ClickListener(){

				public void buttonClick(ClickEvent event) {
					// TODO Auto-generated method stub
					event.getButton().getWindow().getParent()
                    .removeWindow(event.getButton().getWindow());
       
				}}); 
	        table.addListener(new ItemClickEvent.ItemClickListener() {
				
				public void itemClick(ItemClickEvent event) {
					// TODO Auto-generated method stub
				
					String name;
					Object id = event.getItemId();
					name= (String)table.getContainerProperty(id, "Name").getValue();
					FillTray.equiname = name ;
				}
			});
	        save.addListener(new ClickListener(){

	    		public void buttonClick(ClickEvent event) {
	    			// TODO Auto-generated method stub
	    			if(table.getValue()==null)
	    			{
	    				getWindow().showNotification("Please Select", Window.Notification.TYPE_ERROR_MESSAGE);
	    				
	    			}
	    			else
	    			{
	    				//message=optiongroup.getValue().toString();
	    				//FillTray.skipmessage=optiongroup.getValue().toString();
	    					    				close();
	    				
	    			}
	    		}});
	    	
	        navigationView.setRightComponent(close);
	        
	        save.setWidth("20%");
	        cancel.setWidth("20%");
	        table.setWidth("100%");
			
			cd.addComponent(save);
			cd.addComponent(cancel);
			cd.addComponent(table);
			setContent(navigationView);
		
		
	}
	public void setcontainer(SQLContainer equi) {
		// TODO Auto-generated method stub
		container = equi;
	}
}
