package com.example.smartdispenser.data;


import java.io.Serializable;

import com.vaadin.data.util.BeanItemContainer;

public class treatmentcontainer extends BeanItemContainer<filltable>  implements Serializable{
	
public treatmentcontainer() {
		super(filltable.class);
		// TODO Auto-generated constructor stub
	}
	public static final Object[] col = new Object[]{"FirstName","LastName","Ward","Room","Medicine","Amount","Unit","Posology"};
	public static final String[] col1 = new String[]{"FirstName","LastName","Ward","Room","Medicine","Amount","Unit","Posology"};

}
