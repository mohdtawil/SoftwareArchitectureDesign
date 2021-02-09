/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import java.util.HashMap;
import java.util.jar.Attributes.Name;

/**
 *
 * @author USER
 */
public class Patient {
    private String Name;
    private String phoneNumber;
    private String ID;
    private String Email;
    private double owed_balance;
    private double total_of_payed_balance;
   
  
    public Patient(String name , String phone , String id , String email , double OB , double TOPB) {
    	this.Name=name;
    	this.phoneNumber=phone;
    	this.ID=id;
    	this.Email=email;
    	this.owed_balance=OB;
    	this.total_of_payed_balance=TOPB;
    }
    
    public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public String getPhoneNumber() {
		return this.phoneNumber;
	}



	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getID() {
		return ID;
	}



	public void setID(String iD) {
		ID = iD;
	}



	public String getEmail() {
		return Email;
	}



	public void setEmail(String email) {
		Email = email;
	}



	public double getOwed_balance() {
		return owed_balance;
	}



	public void setOwed_balance(double owed_balance) {
		this.owed_balance = owed_balance;
	}



	public double getTotal_of_payed_balance() {
		return total_of_payed_balance;
	}
        
	public void setTotal_of_payed_balance(double total_of_payed_balance) {
		this.total_of_payed_balance = total_of_payed_balance;
	}
    
}
