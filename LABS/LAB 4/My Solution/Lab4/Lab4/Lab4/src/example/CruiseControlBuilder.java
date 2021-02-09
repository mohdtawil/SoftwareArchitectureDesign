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
public class CruiseControlBuilder {
    private IBrake brake;
    private IEngine engine;
    private IShaft shaft;
    
    public CruiseControl build() {
        return new CruiseControl(brake , engine , shaft);
    }
    
    public CruiseControlBuilder buildBrake(IBrake brake ) {
        this.brake = brake;
        return this;
    }
    
    public CruiseControlBuilder buildEngine(IEngine engine ) {
        this.engine = engine;
        return this;
    }
     
    public CruiseControlBuilder buildShaft(IShaft shaft ) {
        this.shaft = shaft;
        return this;
    }
    
    
}
