/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

/**
 *
 * @author USER
 */
public class Doctor {
    
    private String Name;
    private String ID;
    
    public Doctor(String name , String id) {
    	this.Name=name;
    	this.ID=id;
    }

	public String getName() {
		return this.Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getID() {
		return this.ID;
	}

	public void setID(String iD) {
		this.ID = iD;
	}
    
    
    
}
