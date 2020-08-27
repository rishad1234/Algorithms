/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pagereplacement;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class PageReplacement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Number of pages: ");
        int numberOfPages = input.nextInt();
        System.out.println("Number of page references: ");
        int pageRef = input.nextInt();
        System.out.println("Page Frames: ");
        int pageFrames = input.nextInt();
        
        int[] references = new int[pageRef];

        System.out.println("Input references: ");
        for(int i = 0; i < pageRef; i++){
            int ref = input.nextInt();
            if(ref >= numberOfPages){
                System.err.println("Out of page Frames");
                System.exit(ref);
            }
            references[i] = ref;
        }

        FifoAlgorithm fifo = new FifoAlgorithm(numberOfPages, pageRef, pageFrames, references);
        fifo.fifo();
        
        System.out.println("");
        System.out.println("");
        
        LRUalgorithm lru = new LRUalgorithm(numberOfPages, pageRef, pageFrames, references);
        lru.LRU();
    }
    
}
//8
//22
//3
//7 0 1 2 0 3 0 4 2 3 0 3 0 3 2 1 2 0 1 7 0 1