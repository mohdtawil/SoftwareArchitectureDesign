package example;

import static example.DoctorWorkingSchdule.DoctorWorkingSchduleCounter;
import static example.DoctorWorkingSchdule.List_of_DoctorWorkingSchdule;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author USER
 */
public class controller {
    public DoctorWorkingSchdule DWS;
    public Appointment A;
    
    public static HashMap <Integer, HashMap> List_of_Files = new HashMap <Integer , HashMap>();
    public static int FilesCounter = 1;
 
    
    controller() {
        System.out.println("Hello !!........");
    }
    
    
    // check the list is empty
    public boolean checkAppointmentListIsEmpty() {
        if(A.List_of_Appointments.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
    
    // check the doctor has appointment
    boolean checkAppointmentDoctorIsEmpty(String DoctorID) {
        boolean check = true;
        for (int appoin_index : A.List_of_Appointments.keySet()) {
            if(A.List_of_Appointments.get(appoin_index).get("doctorID").equals(DoctorID)) {
                check = false;
            }
        }
        return check;
    }
    
    int HowManyAppointmentToDoctor(String DoctorID) {
        int x=0;
        for (int index : A.List_of_Appointments.keySet()) {
            if(A.List_of_Appointments.get(index).get("doctorID").equals(DoctorID)) {
                x++;
            }
        }
        return x;
    }
    
    void IndexesAppointmentToDoctor(int [] numbers , String DoctorID) {
        int x=0;
        for (int index : A.List_of_Appointments.keySet()) {
            if(A.List_of_Appointments.get(index).get("doctorID").equals(DoctorID)) {
                numbers[x++] = index;
            }
        }
    }
    
    
  
    // create a file for patient 
    void CreateFile(scheduleAppointment SA ) {
        HashMap <String, String> newFile = new HashMap<>();
        newFile.put("File: Patient Name",SA.patient.getName());
        newFile.put("File: Patient ID",SA.patient.getID());
        newFile.put("File: Patient Phone Number",SA.patient.getPhoneNumber());
        newFile.put("File: Patient Woed Balance",Double.toString(SA.patient.getOwed_balance()));
        newFile.put("File: Patient Total Balance",Double.toString(SA.patient.getTotal_of_payed_balance()));
        newFile.put("File: Previous Visit List","");
        
            
        // insert new file to list of files
        List_of_Files.put(FilesCounter++, newFile);
    }
    
    void SetNewPVtoFile(scheduleAppointment SA ) {
        
        for (int index : List_of_Files.keySet()) {
            if((List_of_Files.get(index).get("File: Patient ID").equals(SA.patient.getID()))) {
                double COST = SA.patient.getTotal_of_payed_balance() - SA.patient.getOwed_balance();
                String LAST_PV = List_of_Files.get(index).get("File: Previous Visit List").toString();
                String NEW_DESCRIPTION = "Description: The Patient " + List_of_Files.get(index).get("File: Patient Name").toString()+" Have a Appointment ";
                previousVisit PV = new previousVisit(NEW_DESCRIPTION,COST);
                String NEW_PV = "  ( " + PV.getDescription() + " Cost: " + PV.getCost() + " )  ";
                String ALL_PV = LAST_PV + NEW_PV;
                List_of_Files.get(index).put("File: Previous Visit List",ALL_PV);
            }
        }
    }
    public String checkAndInsertNewAppoinment(scheduleAppointment SA , String DOCTOR_ID) {
        
        String MESSAGE_RETURN = "";
        
        boolean validTime = false , validDate = false;
        
        // check to create file or not
        if(checkAppointmentListIsEmpty()) {
            CreateFile(SA);
        } else {
            boolean found = false;
            for (int index : A.List_of_Appointments.keySet()) {
                if(A.List_of_Appointments.get(index).get("patientID").equals(SA.patient.getID())) {
                    found = true;
                }
            }
            if(!found) {
                CreateFile(SA);
            } 
        }
        
        
        
        
        
        // split the date of pateint
        String [] patentDateParts = SA.getDate().split("/");
        int patientDay = Integer.parseInt(patentDateParts[0]);
        int patientMonth = Integer.parseInt(patentDateParts[1]);
        int patientYear = Integer.parseInt(patentDateParts[2]);
        
        // split the time of patient
        String [] patentTimeParts = SA.getTime().split(":"); 
        int patientTime = Integer.parseInt(patentTimeParts[0] + patentTimeParts[1]);

            
            int doctorIndex = 0;
            for (int index : DWS.List_of_DoctorWorkingSchdule.keySet()) {
                
                if(DWS.List_of_DoctorWorkingSchdule.get(index).get("doctorID").equals(DOCTOR_ID)) {
                    doctorIndex = index;
                        // split the date of doctor
                        String [] doctorDateParts = DWS.List_of_DoctorWorkingSchdule.get(index).get("doctorScheduleUntilDate").toString().split("/");
                        int doctorDay = Integer.parseInt(doctorDateParts[0]);
                        int doctorMonth = Integer.parseInt(doctorDateParts[1]);
                        int doctorYear = Integer.parseInt(doctorDateParts[2]);

                        // split the start time of doctor
                        String [] doctorStartTimeParts = DWS.List_of_DoctorWorkingSchdule.get(index).get("doctorStartTime").toString().split(":");
                         int doctorStartTime = Integer.parseInt(doctorStartTimeParts[0] + doctorStartTimeParts[1]);
                         
                        // split the end time of doctor
                        String [] doctorEndHoursParts = DWS.List_of_DoctorWorkingSchdule.get(index).get("doctorEndTime").toString().split(":");
                       int doctorEndTime = Integer.parseInt(doctorEndHoursParts[0] + doctorEndHoursParts[1]);
                       
                       
                       // first check is the schedule Appointment for patient with date and time is valid about Doctor Working Schdule
                        if( !(patientTime > doctorStartTime && patientTime < doctorEndTime )){
                             //System.out.println("Time of patient not valid for time doctor schedule");
                             MESSAGE_RETURN = "TIME of patient not valid for schedule time doctor ( " + DWS.List_of_DoctorWorkingSchdule.get(index).get("doctorName").toString() + " ) .";  
                        } else {
                            validTime = true;
                        }
                        
                        if(!(patientDay <= doctorDay && patientMonth <= doctorMonth && patientYear <= doctorYear)) {
                            //System.out.println("Date of patient not valid for date doctor schedule");
                            MESSAGE_RETURN = "DATE of patient not valid for schedule date doctor ( " + DWS.List_of_DoctorWorkingSchdule.get(index).get("doctorName").toString() + " ) .";  

                        } else {
                            validDate = true;
                        }      
                } 
            }   
            boolean VB = false;
            if(doctorIndex == 0 ) {
                //System.out.println("check 1");
                //System.out.println("Doctor ID " + DOCTOR_ID + " Not Found");
                MESSAGE_RETURN = "Doctor ID " + DOCTOR_ID + " Not Found";
            } else if(checkAppointmentListIsEmpty() && validTime && validDate) { 
                //System.out.println("check 2");
                //System.out.println("DOCTOR_ID " + DOCTOR_ID +  " validTime " + validTime + " validDate "  + validDate + " doctorIndex "+doctorIndex);
               MESSAGE_RETURN = appendToListOfAppointment(SA,DOCTOR_ID , validTime , validDate , doctorIndex);
               
             } else if(checkAppointmentDoctorIsEmpty(DOCTOR_ID)&& validTime && validDate) {
                //System.out.println("check 3");
               MESSAGE_RETURN = appendToListOfAppointment(SA,DOCTOR_ID , validTime , validDate , doctorIndex);
            } else {
                //System.out.println("check 4");
                int size =  HowManyAppointmentToDoctor(DOCTOR_ID);
                int []indexes = new int[size];
                IndexesAppointmentToDoctor(indexes , DOCTOR_ID);
                boolean validAppointment = false;
                for(int i=0 ;i<indexes.length ;i++) {
                    
                    String [] patentAppontmentTimeParts = A.List_of_Appointments.get(indexes[i]).get("patientTime").toString().split(":");
                    int patientAppontmentTime = Integer.parseInt(patentAppontmentTimeParts[0] + patentAppontmentTimeParts[1]);
                                   
                    if(patientTime == patientAppontmentTime) {
                        validAppointment = false;
                        //System.out.println("New Patient Time is already registered with onther patient");
                        MESSAGE_RETURN = "New Patient Time is already registered with onther patient";
                        } else {
                        if(patientTime > patientAppontmentTime) {
                        if(patientTime-30 >= patientAppontmentTime) {
                            validAppointment = true;
                        } else {
                            validAppointment = false;
                            //System.out.println("New Patient Time is already registered with onther patient");
                            MESSAGE_RETURN = "New Patient Time is already registered with onther patient";
                        }
                        } else {
                        if(patientTime+30 <= patientAppontmentTime) {
                            validAppointment = true;
                        } else {
                            validAppointment = false;
                            //System.out.println(" New Patient Time is already registered with onther patient");
                            MESSAGE_RETURN = "New Patient Time is already registered with onther patient";
                        }
                        }
                    } 
                }
                if(validAppointment && validTime && validDate) {
                   MESSAGE_RETURN = appendToListOfAppointment(SA,DOCTOR_ID , validTime , validDate , doctorIndex);
                    
                }
                
         
            }  
            
            
            
       return MESSAGE_RETURN;     
    }
     
    String appendToListOfAppointment(scheduleAppointment SA ,String DoctorID , boolean validTime , boolean validDate  , int index) {
        String RETURN = "";
        if( validDate && validTime ) {
                           
        HashMap<String, String> newAppointment = new HashMap<>();
          
        newAppointment.put("patientName",SA.patient.getName());
        newAppointment.put("patientID",SA.patient.getID());
        newAppointment.put("patientPhoneNumber",SA.patient.getPhoneNumber());
        newAppointment.put("patientTime",SA.getTime());     
        newAppointment.put("patientDate",SA.getDate());
        newAppointment.put("patientEmail",SA.patient.getEmail());
        newAppointment.put("doctorName",DWS.List_of_DoctorWorkingSchdule.get(index).get("doctorName").toString());
        newAppointment.put("doctorID",DWS.List_of_DoctorWorkingSchdule.get(index).get("doctorID").toString());
        newAppointment.put("doctorScheduleDays",DWS.List_of_DoctorWorkingSchdule.get(index).get("doctorScheduleDays").toString());
        newAppointment.put("doctorScheduleUntilDate",DWS.List_of_DoctorWorkingSchdule.get(index).get("doctorScheduleUntilDate").toString());
        newAppointment.put("doctorStartTime",DWS.List_of_DoctorWorkingSchdule.get(index).get("doctorStartTime").toString());
        newAppointment.put("doctorEndTime",DWS.List_of_DoctorWorkingSchdule.get(index).get("doctorEndTime").toString());



            A = new Appointment(newAppointment);
            SetNewPVtoFile(SA);
            RETURN = "New Appointemt Inserted Successfully to Doctor ID : " + DoctorID;
        } 
        return RETURN;
    }
    public int getMaches(String [] a , String [] b) {
        int counter = 0 ;
        for(int i=0;i<a.length;i++) {
                    for(int j=0;j<b.length;j++) {
                        if((a[i].equals(b[j]))) {
                            counter++;
                        }
                    }
                }
        return counter;
    }
    public String GetfinalString(String [] a) {
        String DNR="";
        for(int i=0;i<a.length;i++) {
                    if(i!=a.length - 1) {
                        DNR += a[i] + ",";
                    } else {
                        DNR += a[i];
                    }
                }
        return DNR;
    }
    String [] Cancel_Specific_Doctor(String cancelDoctorID) {
        for (int doctor_index : DWS.List_of_DoctorWorkingSchdule.keySet()) {
            if(DWS.List_of_DoctorWorkingSchdule.get(doctor_index).get("doctorID").equals(cancelDoctorID)) {
                DWS.List_of_DoctorWorkingSchdule.get(doctor_index).clear();
            }
        }
        int numberOfAppintment = HowManyAppointmentToDoctor(cancelDoctorID);
         String [] CancelNumbersList = new String[numberOfAppintment];
         int s=0;
        for (int appoini : A.List_of_Appointments.keySet()) {
            if(A.List_of_Appointments.get(appoini).get("doctorID").equals(cancelDoctorID)) {
                 CancelNumbersList[s++] = (A.List_of_Appointments.get(appoini).get("patientName").toString() + " : " + A.List_of_Appointments.get(appoini).get("patientPhoneNumber").toString()).toString();
                 A.List_of_Appointments.get(appoini).clear();
            }
        }

        return CancelNumbersList;
    }
    String [] Cancel_Specific_Day_Or_Group_Of_Days(String cancelDoctorID,String [] cancelDoctorDays){ 
        String DaysNotRemove = "";
        
        
        for (int doctor_index : DWS.List_of_DoctorWorkingSchdule.keySet()) {
            if(DWS.List_of_DoctorWorkingSchdule.get(doctor_index).get("doctorID").equals(cancelDoctorID)) {
                String [] doctorDaysPartsSchdule = A.List_of_Appointments.get(doctor_index).get("doctorScheduleDays").toString().split(",");
                
                String [] NotMaches = new String[getMaches(doctorDaysPartsSchdule , cancelDoctorDays)];
                int x=0;
                for(int i=0;i<doctorDaysPartsSchdule.length;i++) {
                    for(int j=0;j<cancelDoctorDays.length;j++) {
                        if((doctorDaysPartsSchdule[i].equals(cancelDoctorDays[j]))) {
                           NotMaches[x++] = doctorDaysPartsSchdule[i];
                        }
                    }
                }
                String [] a;
                for(int i=0;i<doctorDaysPartsSchdule.length;i+=2) {
                    for(int j=0;j<NotMaches.length;j++) {
                        if(doctorDaysPartsSchdule[i].equals(NotMaches[j])) {
                            doctorDaysPartsSchdule = removeTheElement(doctorDaysPartsSchdule , i);
                        }
                    }
                }
                
                DaysNotRemove = GetfinalString(doctorDaysPartsSchdule);
                // here remove days from Doctor Working Schdule list
                DWS.List_of_DoctorWorkingSchdule.get(doctor_index).put("doctorScheduleDays", DaysNotRemove);
            }  
        }
        
      
        
        int indexes = HowManyAppointmentToDoctor(cancelDoctorID);
        int [] pointes = new int [indexes];
        int x=0;
        for (int appoin_index : A.List_of_Appointments.keySet()) {
            if(A.List_of_Appointments.get(appoin_index).get("doctorID").equals(cancelDoctorID)) {
                pointes[x++] = appoin_index;
            }  
         }
         String [] CancelNumbersList= new String[pointes.length];
         int s=0;
         
           boolean found = false;
            for(int i=0;i<pointes.length;i++) {
                
                   String [] doctorDaysParts = A.List_of_Appointments.get(pointes[i]).get("doctorScheduleDays").toString().split(",");
                    for(int ii=0;ii<doctorDaysParts.length;ii++) {
                        String temp = doctorDaysParts[ii];
                        for(int j=0;j<cancelDoctorDays.length;j++) {
                            if(cancelDoctorDays[j].equals(temp)) {
                                found = true;
                                
                            }
                        }
                     }
                    if(found) {
                        CancelNumbersList[s++] = A.List_of_Appointments.get(pointes[i]).get("patientName").toString() + " : " + A.List_of_Appointments.get(pointes[i]).get("patientPhoneNumber").toString();
                        // here remove days from appointment list
                        A.List_of_Appointments.get(pointes[i]).put("doctorScheduleDays", DaysNotRemove);
                    }
                }
            
            return CancelNumbersList;
    }
    public String[] removeTheElement(String [] arr, int index){ 
  
        if (arr == null || index < 0 || index >= arr.length) { 
  
            return arr; 
            } 
  
        String [] anotherArray = new String[arr.length - 1]; 
        
        for (int i = 0, k = 0; i < arr.length; i++) { 
            if (i == index) { 
                continue;  
                } 
            
            anotherArray[k++] = arr[i]; 
        } 
 
        return anotherArray; 
    }
    
    
    boolean CheckToFindEmail(String PatientEmail) {
    	String regex = "^(.+)@(.+)$";
    	boolean email=false;
    	if(PatientEmail.matches(regex)) {
            email=true;
        }
    		
    	
    	return email;
    }
    boolean CheckEmailTime(int PatientDay,int PatientMonth,int PatientYear) {
	LocalDate myObj = LocalDate.now();
	String [] S = myObj.toString().split("-");
	int Year = Integer.parseInt(S[0]);
	int Month = Integer.parseInt(S[1]);
	int Day = Integer.parseInt(S[2]);
    	boolean soon=false;
    	if(PatientYear == Year &&  PatientMonth == Month && PatientDay == (Day-1)) {
             soon=true;
        }
           
    		
    	return soon;
    }
    /*
    void SendMessageToEmail(String Eamil) {
            String to = Eamil;//change accordingly    
	      String host = "localhost";//or IP address  
	  
	     //Get the session object  
	      Properties properties = System.getProperties();  
	      properties.setProperty("mail.smtp.host", host);  
	      Session session = Session.getDefaultInstance(properties);  
	  
	     //compose the message  
	      try{  
	         MimeMessage message = new MimeMessage(session);  
	         message.setFrom(new InternetAddress("192.168.8.100"));  
	         message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
	         message.setSubject("Ping");  
	         message.setText("Hello, this is example of sending email  ");  
	  
	         // Send message  
	         Transport.send(message);  
	         System.out.println("message sent successfully....");  
	  
	      } catch (MessagingException mex) {mex.printStackTrace();}
    }
    */
    String SendReminders() {
        String REMINDER = "";
    	String [] PDate;
    	String PatientEmail="";
    	for (int appoin_index : A.List_of_Appointments.keySet()) {
            //System.out.println(A.List_of_Appointments.get().get("patientEmail"));
            if(!(A.List_of_Appointments.get(appoin_index).get("patientEmail") == null) ) {
               PatientEmail = A.List_of_Appointments.get(appoin_index).get("patientEmail").toString();
            
                if(CheckToFindEmail(PatientEmail)) {
                    PDate = A.List_of_Appointments.get(appoin_index).get("patientDate").toString().split("/");
                    int patientDay = Integer.parseInt(PDate[0]);
                    int patientMonth = Integer.parseInt(PDate[1]);
                    int patientYear = Integer.parseInt(PDate[2]);
                        if(CheckEmailTime(patientDay,patientMonth,patientYear)) {
                            // send message to email with SendMessageToEmail function  Line: 471
                           //SendMessageToEmail(A.List_of_Appointments.get(appoin_index).get("patientEmail").toString());  
                            REMINDER += "   " + "Reminders to " + A.List_of_Appointments.get(appoin_index).get("patientName").toString() + " by using his Email : " + PatientEmail + "   ";
                            
                        }
                }
            } 
            
    	}
        return REMINDER;
    }
    String getAllAppintment(){
        String APPOINTMENT= "";
        for (int index : A.List_of_Appointments.keySet()) {
            APPOINTMENT += "  (  Appintment [ " + index + " ] =  Patient Name: " +  A.List_of_Appointments.get(index).get("patientName") +"  Patient ID : " + A.List_of_Appointments.get(index).get("patientID") +"  Patient Phone : " + A.List_of_Appointments.get(index).get("patientPhoneNumber") +"  Patient Time : " + A.List_of_Appointments.get(index).get("patientTime") +"  Patient Date : " + A.List_of_Appointments.get(index).get("patientDate") +"  Patient Email : " + A.List_of_Appointments.get(index).get("patientEmail") 
                    + "  Doctor ID : " + A.List_of_Appointments.get(index).get("doctorID") + "  Doctor Days : " + A.List_of_Appointments.get(index).get("doctorScheduleDays") + "  Doctor Until Date : " + A.List_of_Appointments.get(index).get("doctorScheduleUntilDate") + "  Doctor Start Time : " + A.List_of_Appointments.get(index).get("doctorStartTime") + "  Doctor End Time : " + A.List_of_Appointments.get(index).get("doctorEndTime") +"  )    &   ";
        }
        return APPOINTMENT;
    }
    String getAllDoctorWorkingSchdule(){
        
        String DoctorWorkingSchdules= "";
        for (int index : DWS.List_of_DoctorWorkingSchdule.keySet()) {
            DoctorWorkingSchdules += "  (  Doctor Schdule [ " + index + " ] =  Name: " +  DWS.List_of_DoctorWorkingSchdule.get(index).get("doctorName") +"  ID : " + DWS.List_of_DoctorWorkingSchdule.get(index).get("doctorID") +"  Days : " + DWS.List_of_DoctorWorkingSchdule.get(index).get("doctorScheduleDays") +"  Untile Date : " + DWS.List_of_DoctorWorkingSchdule.get(index).get("doctorScheduleUntilDate") +"  Start Time : " + DWS.List_of_DoctorWorkingSchdule.get(index).get("doctorStartTime") +"  End Time : " + DWS.List_of_DoctorWorkingSchdule.get(index).get("doctorEndTime") + "  )   &   ";
        }
        return DoctorWorkingSchdules;
    }
    String getAllPatientFiles(){
        return List_of_Files.toString();
    }
    
    
    
}


