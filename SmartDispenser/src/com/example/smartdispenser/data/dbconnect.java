package com.example.smartdispenser.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.sql.Connection;
import java.sql.Time;
import java.sql.SQLException;
import java.sql.Statement;


import com.example.smartdispenser.SmartdispenserUI;
import com.vaadin.data.Property;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.FreeformQuery;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;


public class dbconnect {
	
	//WebBrowser wb = new WebBrowser();
	dbhelper db = new dbhelper();
	SimpleJDBCConnectionPool connectionpool;
	int ID;
	String TraySlot;
	Table td = new Table();
	Table etd= new Table();
	String NurseSSn =(String) (SmartdispenserUI.getCurrent()).getData();
	DateFormat dateformat= new SimpleDateFormat("yyyy/MM/DD HH:MM:SS");
	Date date= new Date();
	
	Calendar cal = Calendar.getInstance();
	Integer Treatment_TreatmentID;
	private SQLContainer fillid = null;
	private SQLContainer component = null;
	private SQLContainer equid = null;
	
	
	
	dbhelper conn= new dbhelper();
	
	public dbconnect(){
		String dbhost = System.getProperty("smart_dispenser.db.host", "localhost");
		String dbport = System.getProperty("smart_dispenser.db.port", "3306");
		
		String connectionString = "jdbc:mysql://" + 
				dbhost + ':' + dbport + "/dispencerapplication";
		
		
try {
	connectionpool = new SimpleJDBCConnectionPool(
		         "com.mysql.jdbc.Driver", connectionString,
		         "root", "rani", 2, 30);
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	

	
	Connection connect = null;

try {
	connect = connectionpool.reserveConnection();


Statement statement;

	statement = connect.createStatement();

	statement.executeUpdate("DELETE FROM filltray");
	statement.close();
    connect.commit();

} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}finally {
    connectionpool.releaseConnection(connect);
}





	}
	
//	SimpleJDBCConnectionPool connectionpool = conn.getConnectionPool();
	
	
	public void filltable(Integer value, int count)  {
		// TODO Auto-generated method stub
		
		
		settrayslot(count);
		
		//DateofFilling = ;
		Connection connect = null;
		
            try {
				connect = connectionpool.reserveConnection();
			
			
            Statement statement;
			
				statement = connect.createStatement();
				long a = date.getTime();
				statement.executeUpdate("INSERT INTO FillTray VALUES(DEFAULT,NOW(), '"
						+TraySlot+ "','"+ NurseSSn+"',"+ value+")");
				
			//	statement.executeUpdate("INSERT INTO FillTray VALUES(DEFAULT,'"
			//						+TraySlot+ "','"+ NurseSSn+"',"+ value+")");
							
				
				
				statement.close();
	            connect.commit();
            
            } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
			    connectionpool.releaseConnection(connect);
			}
            
		
		
		
		
	}
	
	
	
private void settrayslot(int count) {
	// TODO Auto-generated method stub
	
	if(count==0){
		TraySlot = "A1";
	}
	if(count==1){
		TraySlot = "A2";
	}
	if(count==2){
		TraySlot = "A3";
	}
	if(count==3){
		TraySlot = "B1";
	}
	if(count==4){
		TraySlot = "B2";
	}

	if(count==5){
		TraySlot = "B3";
	}
	if(count==6){
		TraySlot = "C1";
	}
	if(count==7){
		TraySlot = "C2";
	}
	if(count==8){
		TraySlot = "C3";
	}
	if(count==9){
		TraySlot = "D1";
	}
	if(count==10){
		TraySlot = "D2";
	}
	if(count== 11){
		TraySlot = "D3";
	}
	if(count== 12){
		TraySlot = "E1";
	}
	if(count==13){
		TraySlot = "E2";
	}
	if(count== 14){
		TraySlot = "E3";
	}
}

public void fillhistoy(Integer x) {
	// TODO Auto-generated method stub
	int id;
	Connection connect = null;
	
    try {
		connect = connectionpool.reserveConnection();
	
	
    Statement statement;
	
		statement = connect.createStatement();
		id=filledid();
		statement.executeUpdate("INSERT INTO History (ID,filltime,FillBy,TreatmentID,FillTrayID) VALUES (DEFAULT,NOW(), '"
				+ NurseSSn+"',"+ x+","+id+")");
		
		statement.close();
        connect.commit();
    
    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
	    connectionpool.releaseConnection(connect);
	}

 }
public void fillequid(Integer x,String name) {
	// TODO Auto-generated method stub
	int id;
	Connection connect = null;
	
    try {
		connect = connectionpool.reserveConnection();
	
	
    Statement statement;
	
		statement = connect.createStatement();
		
		statement.executeUpdate("Update History Set equivalent='"+name+"' where  ID ="+x ) ;
		
		statement.close();
        connect.commit();
    
    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
	    connectionpool.releaseConnection(connect);
	}

 }



public int filledid(){
	String value;
	
	FreeformQuery q5 = new FreeformQuery("SELECT Auto_increment FROM information_schema.tables WHERE table_name='Filltray'",connectionpool);


	try {
			fillid=new SQLContainer(q5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	td.setContainerDataSource(fillid);
	
	Object id = td.firstItemId();
	 value = td.getContainerProperty(id, "Auto_increment").getValue().toString();
	
	return Integer.parseInt(value);
}
public int equid(){
	String value;
	
	FreeformQuery q5 = new FreeformQuery("SELECT * from History order by ID desc limit 1",connectionpool);


	try {
			equid=new SQLContainer(q5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	etd.setContainerDataSource(equid);
	
	Object id = etd.firstItemId();
	 value = etd.getContainerProperty(id, "ID").getValue().toString();
	
	return Integer.parseInt(value);
}

public SQLContainer getequivalent(String medicinename) {
	// TODO Auto-generated method stub
	
	String value;
	
	FreeformQuery q6 = new FreeformQuery("SELECT * FROM medicine WHERE Name='"+medicinename+"'",connectionpool);


	try {
			component=new SQLContainer(q6);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	td.setContainerDataSource(component);
	
	Object id = td.firstItemId();
	 value = td.getContainerProperty(id, "Component").getValue().toString();

	 FreeformQuery q7 = new FreeformQuery("SELECT * FROM medicine WHERE Component='"+value+"'",connectionpool);
	 try {
			component=new SQLContainer(q7);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 return component;
}

public void fillofs(String name1,String quantity1) {
	// TODO Auto-generated method stub
Connection connect = null;
	
    try {
		connect = connectionpool.reserveConnection();
	
	
		Statement statement;
	
		statement = connect.createStatement();
		
		statement.executeUpdate("INSERT INTO outofstock (MedicineName,Date,mid,UnitsDemanded) VALUES ('"+ name1 +"',NOW(),DEFAULT,'"+quantity1+"')");
		statement.close();
        connect.commit();
    
    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
	    connectionpool.releaseConnection(connect);
	}

}


	
}
