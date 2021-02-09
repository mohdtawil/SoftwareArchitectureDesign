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
public class previousVisit {
	
    private String Description;
    private double Cost;
    
    public previousVisit(String Desc , double cost) {
    	this.Description=Desc;
    	this.Cost=cost;
    }
	public String getDescription() {
		return this.Description;
	}
	public void setDescription(String description) {
		this.Description = description;
	}
	public double getCost() {
		return this.Cost;
	}
	public void setCost(double cost) {
		this.Cost = cost;
	}
    
    
    
}
