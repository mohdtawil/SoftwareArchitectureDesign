/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import static example.controller.List_of_Files;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author USER
 */
public class Printer implements IPrinter {
    public controller C;
   
    Printer() {
        C = new controller();
    }
    
    @Override
    public void PrintSchduleInFile()
    {
        String schedule = C.getAllDoctorWorkingSchdule();
        try {  
		      File myObj = new File("allSchdule.txt");  
		      if (myObj.createNewFile()) {  
		        System.out.println("File created: " + myObj.getName());  
		      } 
		          FileWriter myWriter = new FileWriter("allSchdule.txt");
                          
		          myWriter.write(schedule);
		          myWriter.close();
		          System.out.println("Successfully wrote to the file.");
		     
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();  
		    }
        System.out.println(schedule);
    }
    
    @Override
    public void PrintAppointmentInFile()
    {
       
        String APPointment = C.getAllAppintment();
        try {  
		      File myObj = new File("allAppointment.txt");  
		      if (myObj.createNewFile()) {  
		        System.out.println("File created: " + myObj.getName());  
		      }  
		          FileWriter myWriter = new FileWriter("allAppointment.txt");
                          
		          myWriter.write(APPointment);
		          myWriter.close();
		          System.out.println("Successfully wrote to the file.");
		       
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();  
		    }
        System.out.println(APPointment);
    }
    
    @Override
    public void PrintAllPatientFiles(){
        
        try {  
		      File myObj = new File("PatientsFiles.txt");  
		      if (myObj.createNewFile()) {  
		        System.out.println("File created: " + myObj.getName());  
		      }  
		          FileWriter myWriter = new FileWriter("PatientsFiles.txt");
                          String patient_files = C.getAllPatientFiles();
		          myWriter.write(patient_files);
		          myWriter.close();
		          System.out.println("Successfully wrote to the file.");
		       
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();  
		    }
        
        System.out.println(List_of_Files);
    }
    
    
    
}
