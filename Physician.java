package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPPACompliantUser{
//... imports class definition...
    
    // Inside class:    
    private ArrayList<String> patientNotes;
	
    // TO DO: Constructor that takes an ID
    public Physician(Integer id) {
    	super(id);
    }
    // TO DO: Implement HIPAACompliantUser!
    public boolean assignPin(int pin) {
    	int len = String.valueOf(pin).length();
    	if(len == 4){
    		this.setPin(pin);
    		return true;
    		
    	}
    	else {
    		return false;
    	}
    }
    
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	int physId = this.getId();
    	if(confirmedAuthID == physId) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	
    // TO DO: Setters & Getters

}
