
package egersprimstest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Vertex implements Comparable<Vertex>{
    private int vertexName;
    private int parent;
    private int key;
    private PriorityQueue<Edge> adjacentices;
    private boolean visited;

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex(int vertexName, int parent, int key) {
        this.vertexName = vertexName;
        this.parent = parent;
        this.key = key;
        adjacentices = new PriorityQueue<>();
    }

    public int getVertexName() {
        return vertexName;
    }

    public void setVertexName(int vertexName) {
        this.vertexName = vertexName;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public PriorityQueue<Edge> getAdjacentices() {
        return adjacentices;
    }

    public void setAdjacentices(PriorityQueue<Edge> adjacentices) {
        this.adjacentices = adjacentices;
    }
    
    public void addAdjaent(Edge e){
        this.adjacentices.add(e);
    }

    @Override
    public int compareTo(Vertex o) {
        return this.getKey() - o.getKey();
    }
}
