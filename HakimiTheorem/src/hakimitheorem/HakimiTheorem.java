
package hakimitheorem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author rishad
 */
public class HakimiTheorem {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("enter the number of nodes: ");
        int nodes = input.nextInt();
        
        System.out.println("Enter the degres: ");
        //ArrayList<Integer> list = new ArrayList<>();
        Integer[] array = new Integer[nodes];
        
        for(int i = 0; i < nodes; i++){
            array[i] = input.nextInt();
            //list.add(input.nextInt());
        }
        
        hakimi(array);
    }
    
    public static void hakimi(Integer[] list){
        
        //Collections.reverse(list);
        Arrays.sort(list, Collections.reverseOrder());
        
        while(true){
            int largestDegree = list[0];
            list = Arrays.copyOfRange(list, 1, list.length);
            if(largestDegree < list.length + 1){
                
                for(int i = 0; i < largestDegree; i++){
                    list[i] = list[i] - 1;
                }
                
                Arrays.sort(list, Collections.reverseOrder());
                if(checkZero(list)){
                    System.out.println("Simple graph is possible");
                    break;
                }
                
                if(checkNegative(list)){
                    System.out.println("No simple graph is possible");
                    break;
                }
                
                if(list.length == 0){
                    break;
                }
                
            }else{
                System.out.println("No simple graph is possible");
                break;
            }
        }
    }
    
    public static boolean checkNegative(Integer[] list){
        
        for(Integer degree : list){
            if(degree < 0){
                return true;
            }
        }
        return false;
    }
    
    public static boolean checkZero(Integer[] list){
        
        for(Integer degree : list){
            if(degree != 0){
                return false;
            }
        }
        return true;
    }
    
}
