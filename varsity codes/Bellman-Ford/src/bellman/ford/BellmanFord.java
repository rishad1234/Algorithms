
package bellman.ford;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BellmanFord {
    private static List<Vertex> vertices = new ArrayList<>();
    private static List<Edge> edges = new ArrayList<>();
    private static List<Vertex> shortestPath = new ArrayList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices:");
        int numberOfVertices = input.nextInt();
        for(int i = 0; i < numberOfVertices; i++){
            vertices.add(new Vertex(i + 1));
        }
        
        System.out.println("Enter the number of edges: ");
        int numberOfEdges = input.nextInt();
        
        for(int i = 0; i < numberOfEdges; i++){
            int start = input.nextInt();
            int end = input.nextInt();
            int weight = input.nextInt();
            Edge e = new Edge(start, end, weight);
            edges.add(e);
        } 
        
        vertices.get(0).key = 0;
        for(int i = 0; i < vertices.size() - 1; i++){
            for(Edge e : edges){
                Vertex u = vertices.get(e.start - 1);
                Vertex v = vertices.get(e.end - 1);
                
                if(u.key == Integer.MAX_VALUE){
                    continue;
                }
                int distance = u.key + e.weight;
                
                if(distance < v.key){
                    v.key = distance;
                    v.parent = u.vertexName;
                }
            }
        }
        
        for(Edge e : edges){
            if(vertices.get(e.start - 1).key != Integer.MAX_VALUE){
                
                Vertex u = vertices.get(e.start - 1);
                Vertex v = vertices.get(e.end - 1);
                int distance = u.key + e.weight;
                if(distance< v.key){
                    System.out.println("There is a negative cycle in this graph");
                    return;
                }
            }
        }
    }
    
    public static void shortestPathTo(Vertex target){
        for(Vertex v = target; v.parent != -1; v = vertices.get(v.parent - 1)){
            shortestPath.add(v);
        }
        Collections.reverse(shortestPath);
    }
}

class Edge{
    int start;
    int end;
    int weight;
    
    public Edge(int start, int end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

class Vertex{
    int vertexName;
    int key = Integer.MAX_VALUE;
    int parent  = -1;
    Edge minEdge;
    boolean visited = false;

    public Vertex(int vertexName) {
        this.vertexName = vertexName;
    }
}