
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
        for(int i = 0; i < requestSize; i++){
            int index = -1;
            for(int j = 0; j < holeSize - 1; j++){
                if(holes[j] >= request[i]){
                    if(index == -1){
                        index = j;
                    }else if(holes[index] > holes[j]){
                        index = j;
                        served[i] = 1;
                    }
                }
            }
            if(index == -1){
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
