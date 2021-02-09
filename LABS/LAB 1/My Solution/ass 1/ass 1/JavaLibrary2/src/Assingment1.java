/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */


/*
Mohammad Tawil
118256
ses 3
*/

public class Assingment1 {

    /**
     * @param args the command line arguments
     */
   static int [] arr = new int[1000];
   
   static int SumWithThreads = 0;
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Without Thread
        CreateAndPrintWithoutThread withoutThread = new CreateAndPrintWithoutThread();
        int Sum_Without_Thread = withoutThread.Run(arr);
        System.out.println("The Summation Without Thread: " + Sum_Without_Thread);
        
        
        // With Threads
        ThreadHalf1 half1 = new ThreadHalf1();
        new Thread(half1).start();
        
        ThreadHalf2 half2 = new ThreadHalf2();
        new Thread(half2).start();
        
        int SummationOfTowThread = half1.value + half2.value;
        System.out.println("The Summation For Thread 1 & Thread 2 is: " + SummationOfTowThread );
        
    }
    
}
