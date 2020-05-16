/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package permutation;

import edu.princeton.cs.algs4.StdIn;
/**
 *
 * @author Admin
 */
public class Permutation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);

        RandomizedQueue<String> queue = new RandomizedQueue<String>();

        while (!StdIn.isEmpty()) {
            queue.enqueue(StdIn.readString());
        }
        
        for (int i = 0; i < k; i++) {
            System.out.println(queue.dequeue());
        }
    }
    
}
