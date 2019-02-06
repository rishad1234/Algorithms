
package topological_sort;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    private int vertexName;
    private boolean visited;
    private List<Vertex> adjacent;

    public Vertex(int vertexName) {
        this.vertexName = vertexName;
        this.visited = false;
        adjacent = new ArrayList<>();
    }
    
    public void addAdjacentVertex(Vertex vertex){
        this.adjacent.add(vertex);
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

    public List<Vertex> getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(List<Vertex> adjacent) {
        this.adjacent = adjacent;
    }

    @Override
    public String toString() {
        return "" + vertexName + "";
    }  
}
