
package pagereplacement;

import java.util.LinkedList;


public class LRUalgorithm {
    int numberOfpages;
    int pageRef;
    int pageFrames;
    int[] references;
    int[] weights;
    int[] flags;
            
    int pageFaults;
    int[] buffer;
    public LRUalgorithm(int numberOfpages, int pageRef, int pageFrames, int[] references) {
        this.numberOfpages = numberOfpages;
        this.pageRef = pageRef;
        this.pageFrames = pageFrames;
        this.references = references;
        this.weights = new int[numberOfpages];
        buffer = new int[pageFrames];
        this.flags = new int[numberOfpages];
    }
    
    public void LRU(){
        
        int minPosition = 0;
        int range;
        int position = -1;
        for(int i = 0; i < pageRef; i++){
            if(i < pageFrames && flags[references[i]] == 0){
                pageFaults++;
                buffer[i] = references[i];
                flags[references[i]] = 1;
            }else if(flags[references[i]] == 0){
                pageFaults++;
                range = pageRef;
                for(int j = 0; j < pageFrames; j++){
                    for(int k = i - 1; k >= 0; k--){
                        if(buffer[j] == references[k]){
                            position = k;
                            break;
                        }
                    }
                    if(range > position){
                        range = position;
                        minPosition = j;
                    }
                }
                flags[buffer[minPosition]] = 0;
                buffer[minPosition] = references[i];
                flags[references[i]] = 1;
            }
        }
        
        System.out.println("Number of page faults in LRU Replacement Algorithm: " + pageFaults);
        System.out.println("Page Fault rate: " + calculate());
        
    }
    
    private double calculate(){
        return ((double)pageFaults / (double) pageRef) * 100;
    }
}
