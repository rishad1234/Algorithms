
package sumofsubsetdynamic;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author rishad
 */
public class SumOfSubsetDynamic {
    static final int TRUE = 1;
    static final int FALSE = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number of items: ");
        int length = input.nextInt();
        
        System.out.println("Enter the items: ");
        int[] items = new int[length];
        for(int i = 0; i < length; i++){
            items[i] = input.nextInt();
        }
        
        Arrays.sort(items);
        
        System.out.println("Enter the sum of set to check: ");
        int sum = input.nextInt();
        
        ///main algorithm
        boolean [][]table = new boolean[length + 1][sum + 1];
        
        
        for(int i = 0; i <= length; i++){
            table[i][0] = true;
        }
        
        
        if(sum == 0){
            System.out.println("empty set found");
            return;
        }
        
        for(int i = 1; i <= length; i++){
            
            for(int j = 1; j <= sum; j++){
                
                if(j >= items[i - 1]){
                    table[i][j] = table[i - 1][j] || table[i - 1][j - items[i - 1]];
                }else{
                    table[i][j] = table[i - 1][j];
                }
            }
        }
        
        for(int i = 0; i <= length; i++){
            
            for(int j = 0; j <= sum; j++){
                
                if(table[i][j] == true){
                    System.out.print("T ");
                }else{
                    System.out.print("F ");
                }              
            }
            System.out.println("");
        }
        
        if(table[length][sum]){
            System.out.println("Subset is found");
        }else{
            System.out.println("No subset is found");
        }
    }
    
}
