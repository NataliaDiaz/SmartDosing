package com.example.smart_dispenser;

import com.vaadin.addon.touchkit.ui.NavigationView;
import com.vaadin.data.Container;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Table;

import data.dbhelper;

public class Medicines extends NavigationView{
	dbhelper medicinetable= new dbhelper();
	Table table = new Table();
	Container container = medicinetable.getMedicine();
	public void attach()
	{
		super.attach();
		setCaption("Medications");
		buildview();
		
	}
	private void buildview() {
		// TODO Auto-generated method stub
		CssLayout cd= new CssLayout();
		
		//table.setSizeFull();
			
			table.setContainerDataSource(container);
			table.setVisibleColumns(new Object[]{"Name","Component","Indication","Comment","MethodofAdministration"});
			table.setColumnHeader("MethodofAdministration", "Method of Administration");
			
			table.setWidth("100%");
			cd.addComponent(table);
			cd.setSizeFull();
			setContent(cd);
		
	}
	


}
