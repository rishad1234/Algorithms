
package kruskaltest;

public class Vertex {
    private int vertexName;
    private int parent;

    public Vertex(int vertexName, int parent) {
        this.vertexName = vertexName;
        this.parent = parent;
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

    @Override
    public String toString() {
        return  vertexName + "";
    }
    
    
    
}
