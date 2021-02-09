/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author USER
 */
public class Appointment {
     public static HashMap<Integer, HashMap> List_of_Appointments = new HashMap<Integer , HashMap>();
     public static int appinmentCounter = 1;
    
    Appointment(HashMap newApp) {
         
            // insert new appinment to list of appinments
            List_of_Appointments.put(appinmentCounter++, newApp);
            
    }
}
