
package primstest;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private int vertexName;
    private int cost;
    private List<Edge> adjacencies;

    public List<Edge> getAdjacencies() {
        return adjacencies;
    }

    public void setAdjacencies(List<Edge> adjacencies) {
        this.adjacencies = adjacencies;
    }

    public Vertex(int vertexName, int cost) {
        this.vertexName = vertexName;
        this.cost = cost;
        this.adjacencies = new ArrayList<>();
    }

    public int getVertexName() {
        return vertexName;
    }

    public void setVertexName(int vertexName) {
        this.vertexName = vertexName;
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
