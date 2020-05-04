/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 *
 * @author Admin
 */
public class PercolationStats {

    private double[] treshold;
    private int t;

    public PercolationStats(int N, int T) {
        if (N < 1 || T < 1) {
            throw new IllegalArgumentException();
        }
        t = T;
        treshold = new double[t];

        for (int i = 0; i < treshold.length; i++) {
            treshold[i] = calcTreshold(N);
        }
    }

    private double calcTreshold(int n) {
        double counter = 0;
        int i, j;
        Percolation perc = new Percolation(n);
        while (!perc.percolates()) {
            i = StdRandom.uniform(n) + 1;
            j = StdRandom.uniform(n) + 1;
            if (!perc.isOpen(i, j)) {
                counter++;
                perc.open(i, j);
            }
        }
        return counter / (n * n);
    }

    public double mean() {
        return StdStats.mean(treshold);
    }

    public double stddev() {
        return StdStats.stddev(treshold);
    }

    public double confidenceLo() {
        return mean() - (1.96 * stddev()) / (Math.sqrt(t));
    }

    public double confidenceHi() {
        return mean() + (1.96 * stddev()) / (Math.sqrt(t));
    }
}
