package com.example.smartdispenser.data;
import java.sql.SQLException;

import com.vaadin.data.Container;
import com.vaadin.data.util.filter.And;
import com.vaadin.data.util.filter.SimpleStringFilter;
import com.vaadin.data.util.sqlcontainer.SQLContainer;
import com.vaadin.data.util.sqlcontainer.connection.SimpleJDBCConnectionPool;
import com.vaadin.data.util.sqlcontainer.query.FreeformQuery;
import com.vaadin.data.util.sqlcontainer.query.TableQuery;



public class dbhelper {
	private SQLContainer patient= null;
	private SQLContainer medicine= null;
	private SQLContainer medication= null;
	private SQLContainer fmedication= null;
	private SQLContainer medication0= null;
	private SQLContainer medication1= null;
	private SQLContainer medication2= null;
	private SQLContainer medication3= null;
	private SQLContainer nurse= null;
	private SQLContainer Dispenser= null;
	private SQLContainer nursetable= null;
	private SQLContainer shifttable= null;
	private SQLContainer ofs = null;
	
	
	SimpleJDBCConnectionPool connectionPool;
	SimpleJDBCConnectionPool connectionPool1;

	SimpleJDBCConnectionPool connectionPool2;
	public dbhelper(){
		init();
		//initcontainer();		
	}
	
	private void init() {
		// TODO Auto-generated method stub
		String dbhost = System.getProperty("smart_dispenser.db.host", "localhost");
		String dbport = System.getProperty("smart_dispenser.db.port", "3306");
		
		String connectionString = "jdbc:mysql://" + 
				dbhost + ':' + dbport + "/dispencerapplication";
		try {
			connectionPool = new SimpleJDBCConnectionPool(
			         "com.mysql.jdbc.Driver", connectionString,
			         "root","rani", 2, 10);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
		connectionPool1 = new SimpleJDBCConnectionPool(
		         "com.mysql.jdbc.Driver", connectionString,
		         "root", "rani", 2, 2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public SQLContainer getMedication0() {
		FreeformQuery m0 = new FreeformQuery("SELECT t.TreatmentID,p.FirstName,p.LastName,p.Ward,p.Room,p.Bed,m.Name,t.AmountandDosage,t.Unit,t.posology "
				+"FROM treatment t INNER JOIN patient p ON t.PatientSSN = p.SSN"
				+" INNER JOIN medicine m ON t.MedicineID= m.MedicineID"
				+" WHERE t.posology LIKE '%08:00%' ORDER BY p.SSN  ",connectionPool);
		try {
		
			medication0 = new SQLContainer(m0);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return medication0;
	}

public SQLContainer getshifttable(){
	FreeformQuery m0 = new FreeformQuery("SELECT s.date,s.day,s.time,n.Firstname,n.LastName,n.email "
			+"FROM Shift s INNER JOIN nurse n ON s.NurseSSN = n.NurseSSN ",connectionPool);
	
	try {
		
		shifttable = new SQLContainer(m0);
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return shifttable;
	
}
public SQLContainer getofs(){
	
	FreeformQuery q1 = new FreeformQuery("SELECT * FROM OutofStock ",connectionPool);
	
	try {
		ofs= new SQLContainer(q1);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	return ofs;
}
	public void setMedication0(SQLContainer medication0) {
		this.medication0 = medication0;
	}


	public SQLContainer getMedication1() {
		FreeformQuery m1 = new FreeformQuery("SELECT t.TreatmentID,p.FirstName,p.LastName,p.Ward,p.Room,p.Bed,m.Name,t.AmountandDosage,t.Unit,t.posology "
				+"FROM treatment t INNER JOIN patient p ON t.PatientSSN = p.SSN"
				+" INNER JOIN medicine m ON t.MedicineID= m.MedicineID"
				+" WHERE t.posology LIKE '%12:00%' ORDER BY p.SSN  ",connectionPool);
		try {
			
			medication1 = new SQLContainer(m1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return medication1;
	}


	public void setMedication1(SQLContainer medication1) {
		this.medication1 = medication1;
	}


	public SQLContainer getMedication2() {
		FreeformQuery m2 = new FreeformQuery("SELECT t.TreatmentID,p.FirstName,p.LastName,p.Ward,p.Room,p.Bed,m.Name,t.AmountandDosage,t.Unit,t.posology "
				+"FROM treatment t INNER JOIN patient p ON t.PatientSSN = p.SSN"
				+" INNER JOIN medicine m ON t.MedicineID= m.MedicineID"
				+" WHERE t.posology LIKE '%16:00%' ORDER BY p.SSN  ",connectionPool);
		try {
			
			medication2 = new SQLContainer(m2);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return medication2;
	}


	public void setMedication2(SQLContainer medication2) {
		this.medication2 = medication2;
	}


	public SQLContainer getMedication3() {
		FreeformQuery m3 = new FreeformQuery("SELECT t.TreatmentID,p.FirstName,p.LastName,p.Ward,p.Room,p.Bed,m.Name,t.AmountandDosage,t.Unit,t.posology "
				+"FROM treatment t INNER JOIN patient p ON t.PatientSSN = p.SSN"
				+" INNER JOIN medicine m ON t.MedicineID= m.MedicineID"
				+" WHERE t.posology LIKE '%20:00%'ORDER BY p.SSN  ",connectionPool);
		try {
			
			medication3 = new SQLContainer(m3);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return medication3;
	}


	public void setMedication3(SQLContainer medication3) {
		this.medication3 = medication3;
	}
	private SQLContainer History= null;
	private SQLContainer fillid = null;
	private SQLContainer selectedtreatment = null;
	private SQLContainer selectedshift = null;
	
	
	
	public SQLContainer getPatient() {
		TableQuery q1 = new TableQuery("Patient",connectionPool);
		try {
			patient= new SQLContainer(q1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return patient;
	}


	public void setPatient(SQLContainer patient) {
		this.patient = patient;
	}


	public SQLContainer getMedicine() {
		TableQuery q2 = new TableQuery("Medicine",connectionPool);
		try {
			medicine = new SQLContainer(q2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return medicine;
	}


	public void setMedicine(SQLContainer medicine) {
		this.medicine = medicine;
	}
	

	
	public SimpleJDBCConnectionPool getConnectionPool() {
		return connectionPool;
	}


	public void setConnectionPool(SimpleJDBCConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}


	/* 29-01-2013
	  public void initcontainer(){
	 
		TableQuery q1 = new TableQuery("Patient",connectionPool);
		try {
			patient= new SQLContainer(q1);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		TableQuery q2 = new TableQuery("Medicine",connectionPool);
		try {
			medicine = new SQLContainer(q2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FreeformQuery q3 = new FreeformQuery("SELECT t.TreatmentID,p.FirstName,p.LastName,p.Ward,p.Room,p.Bed,m.Name,t.Amount,t.Unit,t.posology "
				 							+"FROM treatment t INNER JOIN patient p ON t.PatientSSN = p.SSN"
											+" INNER JOIN medicine m ON t.MedicineID= m.MedicineID"
				 							+" ORDER BY p.SSN  ",connectionPool);
		
		
		FreeformQuery m0 = new FreeformQuery("SELECT t.TreatmentID,p.FirstName,p.LastName,p.Ward,p.Room,p.Bed,m.Name,t.Amount,t.Unit,t.posology "
											+"FROM treatment t INNER JOIN patient p ON t.PatientSSN = p.SSN"
											+" INNER JOIN medicine m ON t.MedicineID= m.MedicineID"
											+" WHERE t.posology LIKE '%08:00%' ORDER BY p.SSN  ",connectionPool);
		FreeformQuery m1 = new FreeformQuery("SELECT t.TreatmentID,p.FirstName,p.LastName,p.Ward,p.Room,p.Bed,m.Name,t.Amount,t.Unit,t.posology "
											+"FROM treatment t INNER JOIN patient p ON t.PatientSSN = p.SSN"
											+" INNER JOIN medicine m ON t.MedicineID= m.MedicineID"
											+" WHERE t.posology LIKE '%12:00%' ORDER BY p.SSN  ",connectionPool);
		FreeformQuery m2 = new FreeformQuery("SELECT t.TreatmentID,p.FirstName,p.LastName,p.Ward,p.Room,p.Bed,m.Name,t.Amount,t.Unit,t.posology "
											+"FROM treatment t INNER JOIN patient p ON t.PatientSSN = p.SSN"
											+" INNER JOIN medicine m ON t.MedicineID= m.MedicineID"
											+" WHERE t.posology LIKE '%16:00%' ORDER BY p.SSN  ",connectionPool);
		FreeformQuery m3 = new FreeformQuery("SELECT t.TreatmentID,p.FirstName,p.LastName,p.Ward,p.Room,p.Bed,m.Name,t.Amount,t.Unit,t.posology "
											+"FROM treatment t INNER JOIN patient p ON t.PatientSSN = p.SSN"
											+" INNER JOIN medicine m ON t.MedicineID= m.MedicineID"
											+" WHERE t.posology LIKE '%20:00%'ORDER BY p.SSN  ",connectionPool);
		
		
		try {
			medication = new SQLContainer(q3);
			medication0 = new SQLContainer(m0);
			medication1 = new SQLContainer(m1);
			medication2= new SQLContainer(m2);
			medication3 = new SQLContainer(m3);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FreeformQuery qn = new FreeformQuery("SELECT n.NurseSSN,n.FirstName,n.LastName,n.Email,n.Phone "
					+"FROM Nurse n",connectionPool);
		try {
			nursetable= new SQLContainer(qn);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	

	FreeformQuery q4 = new FreeformQuery("SELECT t.TreatmentID,p.FirstName,p.LastName,p.Ward,p.Room,m.Name,t.Amount,t.Unit,f.ID,f.TraySlot"
			 							+" FROM filltray f  INNER JOIN treatment t ON f.Treatment_TreatmentID = t.TreatmentID"
										+" INNER JOIN patient p ON t.PatientSSN = p.SSN"
			 							+" INNER JOIN medicine m ON t.MedicineID= m.MedicineID"
			 							+" ORDER BY f.TraySlot ",connectionPool1);
	
	
	try {
		Dispenser=new SQLContainer(q4);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	FreeformQuery q5 = new FreeformQuery("SELECT Auto_increment FROM information_schema.tables WHERE table_name='Filltray'",connectionPool1);


	try {
			fillid=new SQLContainer(q5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	*/
	public SQLContainer getFillid() {
		FreeformQuery q5 = new FreeformQuery("SELECT Auto_increment FROM information_schema.tables WHERE table_name='Filltray'",connectionPool1);


		try {
				fillid=new SQLContainer(q5);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return fillid;
	}


	public void setFillid(SQLContainer fillid) {
		this.fillid = fillid;
	}


	public SQLContainer getNursetable() {
		FreeformQuery qn = new FreeformQuery("SELECT n.NurseSSN,n.FirstName,n.LastName,n.Email,n.Phone "
				+"FROM Nurse n",connectionPool);
	try {
		nursetable= new SQLContainer(qn);
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		return nursetable;
	}


	public void setNursetable(SQLContainer nursetable) {
		this.nursetable = nursetable;
	}


	public SQLContainer getHistory(String ssn) {
		
		FreeformQuery hist = new FreeformQuery("SELECT m.Name,t.AmountandDosage,t.Unit,h.FillBy,h.filltime,h.DispenseBy,h.dispensetime,h.SkipBy,h.SkipTime,h.Reason,h.equivalent "
					+"FROM history h INNER JOIN treatment t  ON h.treatmentID = t.treatmentID INNER JOIN medicine m ON t.MedicineID= m.MedicineID WHERE t.PatientSSN = '"+ssn+"'"
					,connectionPool);
		try {
			History= new SQLContainer(hist);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return History;
	}


	public void setHistory(SQLContainer history) {
		History = history;
	}


	public SQLContainer getDispenser() {
		FreeformQuery q4 = new FreeformQuery("SELECT t.TreatmentID,p.FirstName,p.LastName,p.Ward,p.Room,p.Bed,m.Name,t.AmountandDosage,t.Unit,t.Posology,f.ID,f.TraySlot"
					+" FROM filltray f  INNER JOIN treatment t ON f.Treatment_TreatmentID = t.TreatmentID"
					+" INNER JOIN patient p ON t.PatientSSN = p.SSN"
					+" INNER JOIN medicine m ON t.MedicineID= m.MedicineID"
					+" ORDER BY f.TraySlot ",connectionPool1);


		try {
			Dispenser=new SQLContainer(q4);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Dispenser;
	}


	public void setDispenser(SQLContainer dispenser) {
		Dispenser = dispenser;
	}


	public SQLContainer getMedication() {
		FreeformQuery q3 = new FreeformQuery("SELECT t.TreatmentID,p.SSn,p.FirstName,p.LastName,p.Ward,p.Room,p.Bed,m.Name,t.AmountandDosage,t.Unit,t.posology "
					+"FROM treatment t INNER JOIN patient p ON t.PatientSSN = p.SSN"
				+" INNER JOIN medicine m ON t.MedicineID= m.MedicineID"
					+" ORDER BY p.SSN  ",connectionPool);
		try {
			medication = new SQLContainer(q3);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return medication;
	}
	public SQLContainer getfMedication() {
		FreeformQuery q3 = new FreeformQuery("SELECT t.TreatmentID,p.SSn,p.FirstName,p.LastName,p.Ward,p.Room,p.Bed,m.Name,t.AmountandDosage,t.Unit,t.posology "
					+"FROM treatment t INNER JOIN patient p ON t.PatientSSN = p.SSN"
				+" INNER JOIN medicine m ON t.MedicineID= m.MedicineID"
					+" ORDER BY m.Name  ",connectionPool);
		try {
			fmedication = new SQLContainer(q3);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return fmedication;
	}


	public void setMedication(SQLContainer medication) {
		this.medication = medication;
	}


	public Container getPatients() {
		// TODO Auto-generated method stub
		return patient;
	}
	public SQLContainer authenticate(String SSN,String Password)
	{
		String dbhost = System.getProperty("smart_dispenser.db.host", "localhost");
		String dbport = System.getProperty("smart_dispenser.db.port", "3306");
		
		String connectionString = "jdbc:mysql://" + 
				dbhost + ':' + dbport + "/dispencerapplication";
		try {
			connectionPool2 = new SimpleJDBCConnectionPool(
			         "com.mysql.jdbc.Driver", connectionString,
			         "root", "rani", 2, 2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FreeformQuery q5 = new FreeformQuery("SELECT * From nurse Where NurseSSN = '"+SSN +"' and Password = '"+Password+"'"
					,connectionPool2);
		try {
			nurse = new SQLContainer(q5);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nurse;

	}


	public Container getselectedtreatment(String ssn) {
		// TODO Auto-generated method stub
		FreeformQuery q5 = new FreeformQuery("SELECT p.firstname,p.lastname,t.*,m.name From Treatment t INNER JOIN medicine m ON t.MedicineID= m.MedicineID INNER JOIN patient p ON p.SSN = t.patientSSN Where PatientSSN = '"+ssn +"'"
				,connectionPool);
	
		try {
			selectedtreatment = new SQLContainer(q5);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return selectedtreatment;
	}
	public Container getselectedshift(String ssn) {
		// TODO Auto-generated method stub
		FreeformQuery q5 = new FreeformQuery("SELECT * from shift Where NurseSSN = '"+ssn +"'"
				,connectionPool);
	
		try {
			selectedshift = new SQLContainer(q5);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return selectedshift;
	}
	
	
}
