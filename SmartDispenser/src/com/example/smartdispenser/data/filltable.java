package com.example.smartdispenser.data;

import java.util.Date;

public class filltable {

	
int ID;
String TraySlot;
String NurseSSn;
Date DateofFilling;
Integer Treatment_TreatmentID;
public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getTraySlot() {
	return TraySlot;
}
public void setTraySlot(String traySlot) {
	TraySlot = traySlot;
}
public String getNurseSSn() {
	return NurseSSn;
}
public void setNurseSSn(String nurseSSn) {
	NurseSSn = nurseSSn;
}
public Date getDateofFilling() {
	return DateofFilling;
}
public void setDateofFilling(Date dateofFilling) {
	DateofFilling = dateofFilling;
}
public Integer getTreatment_TreatmentID() {
	return Treatment_TreatmentID;
}
public void setTreatment_TreatmentID(Integer treatment_TreatmentID) {
	Treatment_TreatmentID = treatment_TreatmentID;
}


}
