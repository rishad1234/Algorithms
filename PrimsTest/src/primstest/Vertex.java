
package primstest;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private int vertexName;
    private boolean visited;
    private int cost;
    private int parent;
    private List<Edge> adjacencies;

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public List<Edge> getAdjacencies() {
        return adjacencies;
    }

    public void setAdjacencies(List<Edge> adjacencies) {
        this.adjacencies = adjacencies;
    }

    public Vertex(int vertexName, boolean visited, int cost, int parent) {
        this.vertexName = vertexName;
        this.visited = visited;
        this.cost = cost;
        this.parent = parent;
        this.adjacencies = new ArrayList<>();
        this.visited = false;
    }

    public int getVertexName() {
        return vertexName;
    }

    public void setVertexName(int vertexName) {
        this.vertexName = vertexName;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    
    public void addEdge(Edge e){
        this.adjacencies.add(e);
    }

    @Override
    public String toString() {
        return "" + vertexName + " ";
    }
    
    
}
