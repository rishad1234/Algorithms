
package memorymanagement;

public class FirstFit {
    int holeSize;
    int[] holes;
    int requestSize;
    int[] request;
    int[] served;

    public FirstFit(int holeSize, int[] holes, int requestSize, int[] request) {
        this.holeSize = holeSize;
        this.holes = holes;
        this.requestSize = requestSize;
        this.request = request;
        this.served = new int[requestSize];
    }
    
    public void FirstFitAlgorithm(){
        for(int i = 0; i < requestSize; i++){
            for(int j = 0; j < holeSize; j++){
                if(request[i] <= holes[j]){
                    System.out.println("request " + request[i] + " served hole " + holes[j]);
                    holes[j] -= request[i];
                    served[i] = 1;
                    break;
                }
            }
            if(served[i] == 0){
                System.out.println("No holes found for " + request[i]);
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
