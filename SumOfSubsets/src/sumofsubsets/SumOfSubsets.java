
package sumofsubsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SumOfSubsets {

    static int[] sets;
    static int[] x;
    static List<Integer> answerSets = new ArrayList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number of checks: ");
        int length = input.nextInt();
        sets = new int[length];
        x = new int[length];
        
        System.out.println("Enter the sets one by one: ");
        for(int i = 0; i < length; i++){
            sets[i] = input.nextInt();
        }
        
        System.out.println("Maximum: ");
        int maximum = input.nextInt();
        Arrays.sort(sets);
        for(int i : sets){
            System.out.print(i + " ");
        }
        System.out.println("");
        sumOfSub(0, 0, maximum, maximum);
    }
    
    public static void sumOfSub(int s, int k, int r, int maximum){
        if(k < x.length - 1){
            x[k] = 1;
            if(s + sets[k] == maximum){
                printSolution(k);
            }else if(s + sets[k] + sets[k + 1] <= maximum){
                sumOfSub(s + sets[k], k + 1, r - sets[k], maximum);
            }
            if((s + r - sets[k] >= maximum) || (s + sets[k + 1] <= maximum)){
                x[k] = 0;
                sumOfSub(s, k + 1, r - sets[k], maximum);
            }   
        }
        
    }
    
    public static void printSolution(int k){
        for(int i  = 0; i < x.length; i++){
            System.out.print(x[i]);
            if(k == i){
                x[i] = 0;
            }
        }
        System.out.println("");
        
    }
}
