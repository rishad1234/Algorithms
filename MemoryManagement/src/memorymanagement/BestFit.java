
package memorymanagement;

import java.util.Arrays;

public class BestFit {
    int holeSize;
    int[] holes;
    int requestSize;
    int[] request;
    int[] served;

    public BestFit(int holeSize, int[] holes, int requestSize, int[] request) {
        this.holeSize = holeSize;
        this.holes = holes;
        this.requestSize = requestSize;
        this.request = request;
        this.served = new int[requestSize];
    }
    
    public void BestFitAlgorithm(){
        Arrays.sort(holes);
        for(int i = 0; i < requestSize; i++){
            int difference = Integer.MAX_VALUE;
            int index = -1;
            for(int j = holeSize - 1; j >= 0; j--){
                if(holes[j] >= request[i] && difference > (holes[j] - request[i])){
                    difference = holes[j] - request[i];
                    index = j;
                    served[i] = 1;
                }
            }
            if(served[i] == 0){
                System.out.println("No holes found for " + request[i]);
                break;
            }
            System.out.println("Request " + request[i] + " served hole " + holes[index]);
            holes[index] -= request[i];
            
        }
        
        int fragment = 0;
        for(int i = 0; i < holeSize; i++){
            fragment += holes[i];
        }
        System.out.println("External Fragmentation: " + fragment);
    }
    
}
