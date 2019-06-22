
package longestincreasingsubsequence;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author rishad
 */
public class LongestIncreasingSubSequence {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number of elements: ");
        int numOfElements = input.nextInt();
        
        System.out.println("Enter the sequence: ");
        int[] array = new int[numOfElements];
        
        for(int i = 0; i < numOfElements; i++){
            array[i] = input.nextInt();
        }
        
        System.out.println("longest sequence: " + dpSequence(array));
                
    }
    
    public static int dpSequence(int[] array){
        
        int[] table = new int[array.length];
        Arrays.fill(table, 1);
        
        for(int i = 1; i < array.length; i++){ 
            for(int j = 0; j < i; j++){
                if(array[j] <= array[i]){
                    table[i] = Math.max(table[i], table[j] + 1);
                }
            }
        } 
        Arrays.sort(table);
        return table[table.length - 1];
    }
    
}
