
package kadanesalgorithm;

import java.util.Scanner;

/**
 *
 * @author rishad
 */
public class KadanesAlgorithm {

    static int[] array;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the size of the array: ");
        int size = input.nextInt();
        array = new int[size];
        
        System.out.println("Enter the elements one by one: ");
        for(int i = 0; i < size; i++){
            array[i] = input.nextInt();
        }
        
        int[] ar = kadane();
        for(int i = 0; i < ar.length; i++){
            System.out.println(ar[i]);
        }
      
    }
    
    public static int[] kadane(){
        int currentMax = 0;
        int globalMax = 0;
        
        int maxStart = -1;
        int maxEnd = -1;
        
        int currentStart = 0;
        
        for(int i = 0; i < array.length; i++){
            
            currentMax += array[i];
            
            if(currentMax < 0){
                currentMax = 0;
                currentStart = i + 1;
            }
            
            if(currentMax > globalMax){
                
                globalMax = currentMax;
                maxStart = currentStart;
                maxEnd = i;
            }
        }
        
        int[] ar = {globalMax, maxStart, maxEnd};
        return ar;
    }  
}
