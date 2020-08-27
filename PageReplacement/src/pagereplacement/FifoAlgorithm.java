
package pagereplacement;

import java.util.LinkedList;
import java.util.Queue;


public class FifoAlgorithm {
    int numberOfpages;
    int pageRef;
    int pageFrames;
    int[] references;
    int[] checkReferences;
    
    int pageFaults;
    
    private Queue<Integer> frames;

    public FifoAlgorithm(int numberOfpages, int pageRef, int pageFrames, int[] references) {
        this.numberOfpages = numberOfpages;
        this.pageRef = pageRef;
        this.pageFrames = pageFrames;
        this.references = references;
        this.frames = new LinkedList<>();
        this.checkReferences = new int[numberOfpages];
    }
    
    public void fifo(){
        
        for(int i = 0; i < references.length; i++){
            if(checkReferences[references[i]] == 0){
                frames.add(references[i]);
                pageFaults++;
                checkReferences[references[i]] = 1;
            }
            
            if(frames.size() > pageFrames){
                checkReferences[frames.poll()] = 0;
            }
        }
        
        System.out.println("Number of page faults in Fifo Replacement Algorithm: " + pageFaults);
        
        System.out.println("Page Fault rate: " + calculate());
    }
    
    private double calculate(){
        return ((double)pageFaults / (double) pageRef) * 100;
    }
}
