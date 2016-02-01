package com.example.smartdispenser.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.smartdispenser.SmartdispenserUI;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;

public class dbdispense {
	
	SimpleJDBCConnectionPool connectionpool;
	String nurseSSn= (String) (SmartdispenserUI.getCurrent()).getData();
	
	public dbdispense(){
		
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
	}
	
	
	public void dispencetable(String lname, Integer id2) {
		// TODO Auto-generated method stub
		Connection connect = null;
		
	    try {
			connect = connectionpool.reserveConnection();
		
		
	    Statement statement;
		
			statement = connect.createStatement();
			
			statement.executeUpdate("INSERT INTO Dispensation VALUES(DEFAULT,'" +lname+"' ,NOW(),'"+ id2 +"','"+nurseSSn+"' )");
			statement.close();
	        connect.commit();
	    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		    connectionpool.releaseConnection(connect);
		}
	    
	}


	public void historytable(Integer treatmentid, Integer fillid) {
		// TODO Auto-generated method stub
Connection connect = null;
		
	    try {
			connect = connectionpool.reserveConnection();
		
		
	    Statement statement;
		
			statement = connect.createStatement();
			//statement.executeUpdate("Delete from history");
			statement.executeUpdate("UPDATE History SET DispenseBy='"+nurseSSn+"',DispenseTime = NOW() Where FillTrayID ="+fillid+" AND TreatmentID ="+treatmentid );
			statement.close();
	        connect.commit();
	    
	    } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		    connectionpool.releaseConnection(connect);
		}
	    
	}


	public void skipfill(Integer treatmentid, Integer fillid, String reason) {
		// TODO Auto-generated method stub
Connection connect = null;
		
	    try {
			connect = connectionpool.reserveConnection();
		
		
	    Statement statement;
		
			statement = connect.createStatement();
			//statement.executeUpdate("Delete from history");
			statement.executeUpdate("UPDATE History SET SkipBy='"+nurseSSn+"',SkipTime = NOW(),Reason='"+reason+"'  Where FillTrayID ="+fillid+" AND TreatmentID ="+treatmentid );
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
