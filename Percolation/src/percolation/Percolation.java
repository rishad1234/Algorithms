package percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 *
 * @author Admin
 */
public class Percolation {

    private final int n;
    private final int top;
    private final int bottom;
    private final WeightedQuickUnionUF unionFind;
    private byte[] site;
    private int numberOfOpen;

    public Percolation(int N) {
        n = N;
        unionFind = new WeightedQuickUnionUF(n * n + 2);
        top = n * n;
        bottom = n * n + 1;
        site = new byte[n * n];
        numberOfOpen = 0;
    }
    
    private void increase(){
        numberOfOpen++;
    }

    public void open(int i, int j) {
        if (i < 1 || i > n || j < 1 || j > n) {
            throw new IndexOutOfBoundsException();
        }
        if (isOpen(i, j)) {
            return;
        }
        int currentSite = convert2dTo1dCoord(i, j);
        this.site[currentSite] = 1;
        increase();
        if (i == 1 && !connected(currentSite, j)) {
            unionFind.union(currentSite, top);
        }

        if (i == n) {
            unionFind.union(currentSite, bottom);
        }

        if (i < n) {
            if (isOpen(i + 1, j)) {
                unionFind.union(currentSite, convert2dTo1dCoord(i + 1, j));
            }
        }
        if (i > 1) {
            if (isOpen(i - 1, j)) {
                unionFind.union(currentSite, convert2dTo1dCoord(i - 1, j));
            }
        }
        if (j > 1) {
            if (isOpen(i, j - 1)) {
                unionFind.union(currentSite, convert2dTo1dCoord(i, j - 1));
            }
        }
        if (j < n) {
            if (isOpen(i, j + 1)) {
                unionFind.union(currentSite, convert2dTo1dCoord(i, j + 1));
            }
        }
    }

    public boolean isOpen(int i, int j) {
        if (i < 1 || i > n || j < 1 || j > n) {
            throw new IndexOutOfBoundsException();
        }
        if (site[convert2dTo1dCoord(i, j)] == 1) {
            return true;
        }
        return false;
    }

    private int convert2dTo1dCoord(int i, int j) {
        int pos = n * (i - 1) + j - 1;
        return pos;
    }

    public boolean isFull(int i, int j) {
        if (i < 1 || i > n || j < 1 || j > n) {
            throw new IndexOutOfBoundsException();
        }
        if (!isOpen(i, j)) {
            return false;
        }
        int currentSite = convert2dTo1dCoord(i, j);
        if (connected(top, currentSite)) {
            return true;
        }
        return false;
    }

    public boolean percolates() {
        if (connected(top, bottom)) {
            return true;
        }
        return false;
    }
    
    private boolean connected(int i, int j){
        int root = unionFind.find(i);
        int root1 = unionFind.find(j);
        
        if(root == root1){
            return true;
        }
        return false;
    }

    public int numberOfOpenSites(){
        return numberOfOpen;
    }
}
