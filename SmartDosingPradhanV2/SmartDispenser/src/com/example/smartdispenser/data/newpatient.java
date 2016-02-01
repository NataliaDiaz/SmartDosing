package com.example.smartdispenser.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.ui.TextField;

public class newpatient {
	
	SimpleJDBCConnectionPool connectionpool;
	
	public newpatient() {
		super();
		String dbhost = System.getProperty("smart_dispenser.db.host", "localhost");
		String dbport = System.getProperty("smart_dispenser.db.port", "3306");
		
		String connectionString = "jdbc:mysql://" + 
				dbhost + ':' + dbport + "/dispencerapplication";
		try {
			connectionpool = new SimpleJDBCConnectionPool(
				         "com.mysql.jdbc.Driver", connectionString,
				         "root", "rani", 2, 2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	public void adddata(String ssn, String fname, String lname, String ward,
			String room) {
		// TODO Auto-generated method stub
		Connection connect = null;
		
	    try {
			connect = connectionpool.reserveConnection();
		
		
	    Statement statement;
		
			statement = connect.createStatement();
			
			statement.executeUpdate("INSERT INTO Patient VALUES('"+ssn+"','" +fname+"','"+lname+"',CURDATE(),CURTIME(),'"+ward+"','"+room+"' )");
			statement.close();
	        connect.commit();
	    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		    connectionpool.releaseConnection(connect);
		}
	}



	public void addnurse(String ssn, String fname, String lname,
			String email, String phone, String password) {
		// TODO Auto-generated method stub
Connection connect = null;
		
	    try {
			connect = connectionpool.reserveConnection();
		
		
	    Statement statement;
		
			statement = connect.createStatement();
			
			statement.executeUpdate("INSERT INTO nurse(NurseSSN,FirstName,LastName,Email,Phone,Password) VALUES('"+ssn+"','" +fname+"','"+lname+"','"+email+"','"+phone+"','"+password+"')" );
			statement.close();
	        connect.commit();
	    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		    connectionpool.releaseConnection(connect);
		}
	}



	public void addmedicine(String name, String component,String indication, String comment) {
		// TODO Auto-generated method stub
Connection connect = null;
		
	    try {
			connect = connectionpool.reserveConnection();
		
		
	    Statement statement;
		
			statement = connect.createStatement();
			
			statement.executeUpdate("INSERT INTO Medicine(MedicineID,Name,Component,Indication,Comment) VALUES(DEFAULT,'"+name+"','" +component+"','"+indication+"','"+comment+"')" );
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
