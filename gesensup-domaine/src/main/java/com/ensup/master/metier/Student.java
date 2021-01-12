package com.ensup.master.metier;

import java.util.Date;

/**
 * Class Student
 * 
 * @author Student
 *
 */
public class Student extends Person {

	private String dateOfBirth;

	public Student(Integer id, String firstName, String lastName, String mailAdresse, String adress, String numberPhone,
			String dateOfBirth) {
		super(id, firstName, lastName, mailAdresse, adress, numberPhone);
		this.dateOfBirth = dateOfBirth;
	}

	
	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	@Override
	public String toString() {
		return "Student [dateOfBirth=" + dateOfBirth + ", getId()=" + getId() + ", getFirstName()=" + getFirstName()
				+ ", getLastName()=" + getLastName() + ", getMailAdresse()=" + getMailAdresse() + ", getAdress()="
				+ getAdress() + ", getNumberPhone()=" + getNumberPhone() + "]";
	}

}
