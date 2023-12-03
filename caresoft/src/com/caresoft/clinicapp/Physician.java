package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	private ArrayList<String> patientNotes;
	
	// TO DO: Constructor that takes an IDcopy
    // TO DO: Implement HIPAACompliantUser!
	
	public Physician(int i) {
		this.id = i;
	}

	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(super.id == confirmedAuthID) {
			return true;
		}
		return false;
	}

	@Override
	public boolean assignPin(int pin) {
		if(pin>999 && pin <10000) {
			super.pin = pin;
			return true;
		}
		return false;
	}
	
    // TO DO: Setters & Getters
}
