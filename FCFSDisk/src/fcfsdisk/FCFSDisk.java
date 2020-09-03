
package fcfsdisk;

import java.util.ArrayList;
import java.util.Scanner;

public class FCFSDisk {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int movement = 0;
        
        System.out.println("Number of heads: ");
        int numOfHeads = input.nextInt();
        
        System.out.println("number of cylinder request: ");
        int cylinderRequest = input.nextInt();
        
        System.out.println("Cylinder request: ");
        int[] cylinders = new int[cylinderRequest];
        for(int i = 0; i < cylinderRequest; i++){
            int temp = input.nextInt();
            if(temp > numOfHeads){
                System.out.println("Enter again: ");
                temp = input.nextInt();
                cylinders[i] = input.nextInt();
            }else{
                cylinders[i] = temp;
            }
            
        }
        
        System.out.println("Current head position: ");
        int head = input.nextInt();
        
        System.out.print(head + " ");
        for(int i = 0; i < cylinderRequest; i++){
            System.out.print(cylinders[i] + " ");
            if(i == 0){
                movement += Math.abs(head - cylinders[i]);
                //System.out.println("movement: " + movement);
            }else{
                movement += Math.abs(cylinders[i] - cylinders[i - 1]);
                //System.out.println("movement: " + movement);
            }
        }
        System.out.println("");
        System.out.println("total head movement: " + movement);
        
    }
    
}
//200
//8
//98 183 37 122 14 124 65 67
//53