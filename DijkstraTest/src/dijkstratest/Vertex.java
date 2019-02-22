
package dijkstratest;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{
    private int vertexName;
    private List<Edge> adjacencies;
    private boolean visied;
    private int distance = Integer.MAX_VALUE;
    private Vertex predecessor;

    public Vertex(int vertexName, boolean visied) {
        this.adjacencies = new ArrayList<>();
        this.vertexName = vertexName;
        this.visied = visied;
    }

    public int getVertexName() {
        return vertexName;
    }

    public void setVertexName(int vertexName) {
        this.vertexName = vertexName;
    }

    public List<Edge> getAdjacencies() {
        return adjacencies;
    }

    public void setAdjacencies(List<Edge> adjacencies) {
        this.adjacencies = adjacencies;
    }

    public boolean isVisied() {
        return visied;
    }

    public void setVisied(boolean visied) {
        this.visied = visied;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    
    public void addAdjacent(Edge e){
        this.adjacencies.add(e);
    }

    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    @Override
    public String toString() {
        return "" + vertexName + " ";
    }

    @Override
    public int compareTo(Vertex o) {
        return this.getDistance() - o.getDistance();
    } 
}
