
package sstfdisk;

import java.util.Scanner;

public class SSTFDisk {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int movement = 0;
        
        System.out.println("Number of heads: ");
        int numOfHeads = input.nextInt();
        
        System.out.println("number of cylinder request: ");
        int cylinderRequest = input.nextInt();
        
        System.out.println("Cylinder request: ");
        int[] cylinders = new int[cylinderRequest];
        int[] flag = new int[cylinderRequest];
        
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
            int index = 0;
            int min = Integer.MAX_VALUE;
            
            for(int j = 0; j < cylinderRequest; j++){
                int temp = Math.abs(head - cylinders[j]);
                if(temp < min && flag[j] == 0){
                    index = j;
                    min = temp;
                }
            }
            flag[index] = 1;
            movement += min;
            head = cylinders[index];
            System.out.print(head + " ");
        }
        System.out.println("");
        System.out.println("total head movement: " + movement);

    }
    
}
//200
//8
//98 183 37 122 14 124 65 67
//53