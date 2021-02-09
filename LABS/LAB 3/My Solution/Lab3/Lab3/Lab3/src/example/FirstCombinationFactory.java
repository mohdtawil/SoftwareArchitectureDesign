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
public class FirstCombinationFactory implements CombinationPartsFactory {
    @Override
    public IBrake createBrake() {
        return new GMBrake();
    }
    
    @Override
    public IEngine createEngine() {
        return new GMEngine();
    }
    
    @Override
    public IShaft createShaft() {
        return new ChevyShaft();
    }
}
