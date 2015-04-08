package edu.daffodils.studentmanagement.model;

import java.util.Date;

public class Student {
	private long regID;
    private String firstName;
    private String lastName;
    private Date birthDate;
    
    public Student(){
    	
    }
    public Student(long regID, String firstName, String lastName, Date birthDate){
    	this.regID = regID;
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.birthDate = birthDate;
    }
    public String getFirstName() {
		return this.firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public long getRegID() {
        return regID;
    }
    public void setRegID(long regID) {
        this.regID = regID;
    }
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
     
    @Override
    public String toString(){
        return "{ID=" + this.regID + ",Name=" + getFullName() + "Birth=" + getBirthDate().toString() +"}";
    }
}
