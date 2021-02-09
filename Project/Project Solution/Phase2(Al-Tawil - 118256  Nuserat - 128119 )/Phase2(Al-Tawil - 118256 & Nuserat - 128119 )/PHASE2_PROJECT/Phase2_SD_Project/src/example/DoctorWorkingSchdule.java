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
public class DoctorWorkingSchdule {
    //public Doctor doctor;
   Doctor doctor;
    private String untilDate;
    private String [] days; 
    private String startTime; 
    private String endTime;
    public static HashMap<Integer, HashMap> List_of_DoctorWorkingSchdule = new HashMap<Integer , HashMap>();
    public static int DoctorWorkingSchduleCounter = 1;
    
    DoctorWorkingSchdule(Doctor doctor, String uDate , String [] days , String sTime , String eTime) {
            
            HashMap<String, String> newSchedule = new HashMap<>();
          
            // give the values and set them in DoctorWorkingSchdule attributes
            this.doctor    = doctor;
            this.untilDate = uDate;
            this.days      = days; 
            this.startTime = sTime; 
            this.endTime   = eTime;
            

            // give the days and set them in one string
            String DAYS = String.join(",", this.days);
           
            
            newSchedule.put("doctorName",this.doctor.getName());
            newSchedule.put("doctorID",this.doctor.getID());
            newSchedule.put("doctorScheduleDays",DAYS);
            newSchedule.put("doctorScheduleUntilDate",this.untilDate);
            newSchedule.put("doctorStartTime",this.startTime);
            newSchedule.put("doctorEndTime",this.endTime);
            
            // insert new appinment to list of appinments
            List_of_DoctorWorkingSchdule.put(DoctorWorkingSchduleCounter++, newSchedule);
    }

	public String getUntilDate() {
		return untilDate;
	}

	public void setUntilDate(String untilDate) {
		this.untilDate = untilDate;
	}

	public String[] getDays() {
		return days;
	}

	public void setDays(String[] days) {
		this.days = days;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public static HashMap<Integer, HashMap> getList_of_DoctorWorkingSchdule() {
		return List_of_DoctorWorkingSchdule;
	}

	public static void setList_of_DoctorWorkingSchdule(HashMap<Integer, HashMap> list_of_DoctorWorkingSchdule) {
		List_of_DoctorWorkingSchdule = list_of_DoctorWorkingSchdule;
	}

    
    
    
}
