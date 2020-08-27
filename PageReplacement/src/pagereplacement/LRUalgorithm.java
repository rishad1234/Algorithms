
package pagereplacement;

public class LRUalgorithm {
    int numberOfpages;
    int pageRef;
    int pageFrames;
    int[] references;
    int[] weights;
    int[] checkReferences;
            
    int pageFaults;
    int[] buffer;
    public LRUalgorithm(int numberOfpages, int pageRef, int pageFrames, int[] references) {
        this.numberOfpages = numberOfpages;
        this.pageRef = pageRef;
        this.pageFrames = pageFrames;
        this.references = references;
        this.weights = new int[numberOfpages];
        buffer = new int[pageFrames];
        this.checkReferences = new int[numberOfpages];
    }
    
    public void LRU(){
        
        int positionBuffer = 0;
        int positionReference;
        int position = -1;
        for(int i = 0; i < pageRef; i++){
            if(i < pageFrames && checkReferences[references[i]] == 0){
                pageFaults++;
                buffer[i] = references[i];
                checkReferences[references[i]] = 1;
            }else if(checkReferences[references[i]] == 0){
                pageFaults++;
                positionReference = pageRef;
                for(int j = 0; j < pageFrames; j++){
                    for(int k = i - 1; k >= 0; k--){
                        if(buffer[j] == references[k]){
                            position = k;
                            break;
                        }
                    }
                    if(positionReference > position){
                        positionReference = position;
                        positionBuffer = j;
                    }
                }
                checkReferences[buffer[positionBuffer]] = 0;
                buffer[positionBuffer] = references[i];
                checkReferences[references[i]] = 1;
            }
        }
        
        System.out.println("Number of page faults in LRU Replacement Algorithm: " + pageFaults);
        System.out.println("Page Fault rate: " + calculate());
        
    }
    
    private double calculate(){
        return ((double)pageFaults / (double) pageRef) * 100;
    }
}
