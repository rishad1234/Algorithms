
package memorymanagement;

import java.util.Scanner;

public class MemoryManagement {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int holeSize = input.nextInt();

        int[] holes = new int[holeSize];
        for(int i = 0; i < holeSize; i++){
            holes[i] = input.nextInt();
        }
        
        int requestSize = input.nextInt();
        int[] request = new int[requestSize];
        
        for(int i = 0; i < requestSize; i++){
            request[i] = input.nextInt();
        }
        
//        System.out.println("First Fit Algorithm: ");
//        FirstFit first = new FirstFit(holeSize, holes, requestSize, request);
//        first.FirstFitAlgorithm();
//        System.out.println("");
//        System.out.println("");
        
//        System.out.println("Worst Fit Algorithm : ");
//        WorstFit worst = new WorstFit(holeSize, holes, requestSize, request);
//        worst.WorstFitAlgorithm();
//        System.out.println("");
//        System.out.println("");

        System.out.println("Best Fit Algorithm: ");
        BestFit best = new BestFit(holeSize, holes, requestSize, request);
        best.BestFitAlgorithm();
        System.out.println("");
        System.out.println("");
    }
    
}

//5
//50 200 70 115 15
//10
//100 10 35 15 23 6 25 55 88 40
