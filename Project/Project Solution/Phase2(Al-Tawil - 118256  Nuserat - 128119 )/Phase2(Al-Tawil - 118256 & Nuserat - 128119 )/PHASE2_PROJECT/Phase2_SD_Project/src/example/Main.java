package example;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
       
	public static void main(String args[]) throws InterruptedException {
            
            
            /*
            Notes:
            
            - Send Email Function inseide class controller method name SendMessageToEmail                                 Line 423
            - Cancel specific day Function inseide class controller method name Cancel_Specific_Day_Or_Group_Of_Days      Line 310
            
            */
            
            
            
            controller C = new controller();
            
            
            
            // insert doctor info & schedule for doctor 1
            String [] Doctor_1_Days = {"sunday" , "monday" , "friday"};
            String Doctor_1_ID = "10";
            Doctor Doctor_1 = new Doctor("mohammad" , Doctor_1_ID);
            DoctorWorkingSchdule DWS_1 = new DoctorWorkingSchdule(Doctor_1, "20/02/2021" , Doctor_1_Days , "10:25" , "20:00");
            
            
            // insert doctor info & schedule for doctor 2
            String [] Doctor_2_Days = {"tuseday" , "thersday"};
            String Doctor_2_ID = "20";
            Doctor Doctor_2 = new Doctor("ahmad" , Doctor_2_ID);
            DoctorWorkingSchdule DWS_2 = new DoctorWorkingSchdule(Doctor_2, "25/02/2021" , Doctor_2_Days , "12:00" , "16:00");
            
            
            // insert patient info and make a shedule apptointment with date and time
            Patient mohammad = new Patient("Mohammad Al-Tawil" , "0787876625" ,"118256" , "mohdaltawil@outlook.com" , 50, 100);
            scheduleAppointment mohammad_SA = new scheduleAppointment(mohammad,"13/01/2021" , "11:30");
            // take new apptointment
            C.checkAndInsertNewAppoinment(mohammad_SA , Doctor_1_ID);
            
            
            
            // insert patient info and make a shedule apptointment with date and time
            Patient huzifa = new Patient("Huzaifa Nserat" , "0780000000" ,"128119" , "huzaifa@gmail.com" , 50, 100);
            scheduleAppointment huzifa_SA = new scheduleAppointment(huzifa,"19/01/2021" , "14:00");
            // take new apptointment
            C.checkAndInsertNewAppoinment(huzifa_SA , Doctor_2_ID);
            
            
    
            
            // make object from printer interface to print
            IPrinter print = new Printer();
            
            // print all Appointment in file
            print.PrintAppointmentInFile();
            
            // print all Doctor Schedule in file
            print.PrintSchduleInFile();
            
            // print all Files in file
            print.PrintAllPatientFiles();
            
            
            // make cancel for days or one day just chage to array CancelDays bellow       for Dr 1  
            String [] CancelDays = {"sunday","monday"};
            String [] PatientName_AndNumbers_FOR_DAY_OR_DAYS = C.Cancel_Specific_Day_Or_Group_Of_Days(Doctor_1_ID, CancelDays);
            System.out.println("Cancel :  PatientName_AndNumbers_FOR_DAY_OR_DAYS");
            for(int i=0;i<PatientName_AndNumbers_FOR_DAY_OR_DAYS.length;i++) {
                System.out.println(PatientName_AndNumbers_FOR_DAY_OR_DAYS[i]);
            }
            
            
            // make cancel for specific doctor        for Dr 2
            String [] PatientName_AndNumbers_FOR_SPECIFIC_DR = C.Cancel_Specific_Doctor(Doctor_2_ID);
            System.out.println("Cancel :  PatientName_AndNumbers_FOR_SPECIFIC_DR");
            for(int i=0;i<PatientName_AndNumbers_FOR_SPECIFIC_DR.length;i++) {
                System.out.println(PatientName_AndNumbers_FOR_SPECIFIC_DR[i]);
            }
            
            
            
            // send reminders 
            String Reminders = C.SendReminders();
            System.out.println("Reminders : " + Reminders);
            
            
            
            
            
	}
       
}
