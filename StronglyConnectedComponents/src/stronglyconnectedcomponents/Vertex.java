
package stronglyconnectedcomponents;

import java.util.ArrayList;
import java.util.List;

public class Vertex {
    int vertexName;
    List<Vertex> adjacent;
    boolean visited;

    public Vertex(int vertexName, boolean visited) {
        this.vertexName = vertexName;
        this.visited = visited;
        this.adjacent = new ArrayList<>();
    }
    
    public void addAdjacentVertex(Vertex v){
        this.adjacent.add(v);
    }

    public int getVertexName() {
        return vertexName;
    }

    public void setVertexName(int vertexName) {
        this.vertexName = vertexName;
    }

    public List<Vertex> getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(List<Vertex> adjacent) {
        this.adjacent = adjacent;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public String toString() {
        return  this.vertexName + "";
    }
    
}
