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
public interface CombinationPartsFactory {
    
    public IBrake createBrake();
    
    
    public IEngine createEngine();
    
   
    public IShaft createShaft();
}
