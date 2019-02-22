
package egersprimstest;
public class Edge implements Comparable<Edge>{
    private Vertex startVertex;
    private Vertex endVertex;
    private int weight;

    public Edge(Vertex startVertex, Vertex endVertex,  int weight) {
        this.startVertex = startVertex;
        this.weight = weight;
        this.endVertex = endVertex;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getEndVertex() {
        return endVertex;
    }

    public void setEndVertex(Vertex endVertex) {
        this.endVertex = endVertex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.getWeight() - o.getWeight();
    }
    
    
}
