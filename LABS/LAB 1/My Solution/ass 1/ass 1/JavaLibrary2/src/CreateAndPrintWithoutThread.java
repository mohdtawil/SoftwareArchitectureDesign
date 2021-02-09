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

public class CreateAndPrintWithoutThread {
    public int Run(int Array[]) {
        fillArray(Array);
        int Sum = sumArray(Array);
        return Sum;
    }
    public void fillArray(int A[]) {
        for(int i=0 ; i<A.length ; i++) {
            A[i]=i;
        }
    }
    public int sumArray(int A[]) {
        int sum = 0;
        for(int i=0 ; i<A.length ; i++) {
            if(i%2==0) {
              sum += i;  
            }
              
        }
        return sum;
    }
}
