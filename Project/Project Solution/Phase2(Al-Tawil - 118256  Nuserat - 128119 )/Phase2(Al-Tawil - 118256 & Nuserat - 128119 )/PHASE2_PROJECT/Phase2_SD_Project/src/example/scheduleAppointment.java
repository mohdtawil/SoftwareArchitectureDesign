/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import static example.DoctorWorkingSchdule.DoctorWorkingSchduleCounter;
import static example.DoctorWorkingSchdule.List_of_DoctorWorkingSchdule;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author USER
 */
public class scheduleAppointment {
    public Patient patient;
    private String Date;
    private String Time; 
   

    
     scheduleAppointment(Patient p ,String date , String time) {
            
            this.patient = p;
            this.Time = time; 
            this.Date = date; 
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }
    
}

