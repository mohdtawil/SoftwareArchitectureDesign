/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;
import java.util.*;
/**
 *
 * @author Mohammad Tawil
 */
public class DigitalLogicHorizonTypes {

    private static final String companyName = "DigitalLogicHorizon";
    List<DigitalLogicHorizonTypes> DLHtypes = new LinkedList<DigitalLogicHorizonTypes>();
    /**
     * @param args the command line arguments
     */
    DigitalLogicHorizonTypes() {
      DLHtypes.add(new DigitalLogicHorizonBrake());
      DLHtypes.add(new DigitalLogicHorizonEngine());
      DLHtypes.add(new DigitalLogicHorizonThrottle());
      DLHtypes.add(new DigitalLogicHorizonShaft());
    }

    public void printInfo() {
      for (DigitalLogicHorizonTypes currentDLHtype : DLHtypes) 
      {
         System.out.println(" [" + companyName + " " + currentDLHtype.getProductInfo() + " ] " + "\n");
      }
    }
    
    public String getProductInfo() {
		return "";
    }
}

