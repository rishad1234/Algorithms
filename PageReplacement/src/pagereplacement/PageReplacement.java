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
            references[i] = input.nextInt();
        }
        
//        System.out.println("testing: ");
//        for(int i = 0; i < pageRef; i++){
//            System.out.println(references[i]);
//        }

        FifoAlgorithm fifo = new FifoAlgorithm(numberOfPages, pageRef, pageFrames, references);
        fifo.fifo();
    }
    
}
