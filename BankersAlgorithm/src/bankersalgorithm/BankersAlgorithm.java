
package bankersalgorithm;

import java.util.Scanner;

public class BankersAlgorithm {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int numberOfProcess = input.nextInt();
        int numberOfResource = input.nextInt();
        
        int[] maxResource = new int[numberOfResource];
        int[] freeResources = new int[numberOfResource];
        int[] currentAllocatedResource = new int[numberOfResource];
        int[][] allocation = new int[numberOfProcess][numberOfResource];
        int[][] maxAllocation = new int[numberOfProcess][numberOfResource];
        int[][] need = new int[numberOfProcess][numberOfResource];
        int[] flag = new int[numberOfProcess];
        String path = "";
        int deadlock = 0;
        
        
        System.out.println("Enter max resourcecs: ");
        for(int i = 0; i < numberOfResource; i++){
            maxResource[i] = input.nextInt();
        }
        
        System.out.println("Enter allocation list: ");
        for(int i = 0; i < numberOfProcess; i++){
            for(int j = 0; j < numberOfResource; j++){
                allocation[i][j] = input.nextInt();
            }
        }
        
        System.out.println("Enter Max Allocation list: ");
        for(int i = 0; i < numberOfProcess; i++){
            for(int j = 0; j < numberOfResource; j++){
                maxAllocation[i][j] = input.nextInt();
            }
        }
        
        //need calculation
        for(int i = 0; i < numberOfProcess; i++){
            for(int j = 0; j < numberOfResource; j++){
                need[i][j] = maxAllocation[i][j] - allocation[i][j];
            }
        }
        
        //current resource calculation
        for(int i = 0; i < numberOfResource; i++){
            for(int j = 0; j < numberOfProcess; j++){
                currentAllocatedResource[i] += allocation[j][i];
            }
        }
        
        //free resource calculation
        for(int i = 0; i < numberOfResource; i++){
            freeResources[i] = maxResource[i] - currentAllocatedResource[i];
        }
        
        for(int i = 0; i < numberOfProcess; i++){
            
            for(int j = 0; j < numberOfProcess; j++){
                if(flag[j] != 4){
                    flag[j] = 0;
                    for(int k = 0; k < numberOfResource; k++){

                        if(freeResources[k] >= need[j][k]){
                            flag[j] += 1;
                        }
                    }   
                }
            }
            
            for(int j = 0; j < numberOfProcess; j++){
                if(flag[j] == 3){
                    deadlock = 1;
                }
            }
            
            if(deadlock == 0){
                System.out.println("deadlock detected");
                break;
            }
            
            for(int j = 0; j < numberOfProcess; j++){
                if(flag[j] == 3){
                    for(int k = 0; k < numberOfResource; k++){
                        freeResources[k] += allocation[j][k];
                    }
                    flag[j] = 4;
                    path = path + "P" + (j + 1) + "->";
                    System.out.println(j + 1);
                    break;
                }
            }
        }
        
        
        System.out.println(path);
        
        
    }
    
}

//5 3
//
//10 5 7
//
//0 1 0
//2 0 0
//3 0 2
//2 1 1
//0 0 2
//
//7 5 3
//3 2 2
//9 0 2
//4 2 2
//5 3 3