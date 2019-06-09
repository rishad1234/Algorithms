
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
        
        System.out.println(kadane());
    }
    
    public static int kadane(){
        int currentMax = array[0];
        int globalMax = array[0];
        
        for(int i = 1; i < array.length; i++){
            currentMax = Math.max(array[i], currentMax + array[i]);
            
            if(currentMax > globalMax){
                globalMax = currentMax;
            }
        }
        return globalMax;
    }  
}
