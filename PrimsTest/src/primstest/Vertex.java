
package primstest;

public class Vertex {
    private int vertexName;
    private boolean visited;
    private int cost;

    public Vertex(int vertexName, boolean visited, int cost) {
        this.vertexName = vertexName;
        this.visited = visited;
        this.cost = cost;
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
    
}
