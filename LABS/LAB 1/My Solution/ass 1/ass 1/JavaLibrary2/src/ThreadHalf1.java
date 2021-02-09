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

public class ThreadHalf1 implements Runnable {
    Assingment1 ass1 = new Assingment1();
 public int value = sumFirstHalf(ass1.arr);
 
    @Override
    public void run() {
        
        System.out.println("the half one is: " + sumFirstHalf(ass1.arr) );
    }
   
    public int sumFirstHalf(int [] Array) {
        
        int sum_first_half = 0;
        
        for(int i=0 ; i< 499 ;i++) {
            if(i%2==0) {
              sum_first_half += i;  
            }
        }
        
        
        return sum_first_half;
        
    }
}
