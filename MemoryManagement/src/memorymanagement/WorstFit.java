
package memorymanagement;

import java.util.Arrays;

public class WorstFit {
    int holeSize;
    int[] holes;
    int requestSize;
    int[] request;
    int[] served;

    public WorstFit(int holeSize, int[] holes, int requestSize, int[] request) {
        this.holeSize = holeSize;
        this.holes = holes;
        this.requestSize = requestSize;
        this.request = request;
        this.served = new int[requestSize];
    }
    
    public void WorstFitAlgorithm(){
        Arrays.sort(holes);
        for(int i = 0; i < requestSize; i++){
            if(holes[holeSize - 1] >= request[i]){
                System.out.println("request " + request[i] + " served hole " + holes[holeSize - 1]);
                holes[holeSize - 1] -= request[i];
                Arrays.sort(holes);
                served[i] = 1;
            }
            if(served[i] == 0){
                System.out.println("No holes Found for " + request[i]);
                break;
            }
        }
        
        int fragment = 0;
        for(int i = 0; i < holeSize; i++){
            fragment += holes[i];
        }
        System.out.println("External Fragmentation: " + fragment);
    }
}
