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

public class ThreadHalf2 implements Runnable {
    
    Assingment1 ass1 = new Assingment1();
    public int value = sumSecondHalf(ass1.arr);
    
    @Override
    public void run() {
      
        System.out.println("the half tow is: " + sumSecondHalf(ass1.arr) );
    }
    public int sumSecondHalf(int [] Array) {
        
        int sum_second_half = 0;
        
        for(int i=499 ; i< 1000 ;i++) {
            if(i%2==0) {
              sum_second_half +=i; 
            }
            
        }
        
        return sum_second_half;
        
    }
}
