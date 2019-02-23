
package bellman.fordtest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BellmanFordTest {

    private static List<Vertex> vertices = new ArrayList<>();
    private static List<Edge> edges = new ArrayList<>();
    private static List<Vertex> shortestPath = new ArrayList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices: ");
        int numberOfVertices = input.nextInt();
        
        for(int i = 0; i < numberOfVertices; i++){
            vertices.add(new Vertex(i + 1));
        }
        
        System.out.println("Enter the number of edges: ");
        int numberOfEdges = input.nextInt();
        
        for(int i = 0; i < numberOfEdges; i++){
            int start = input.nextInt();
            int end = input.nextInt();
            int weight  = input.nextInt();
            
            edges.add(new Edge(vertices.get(start - 1), vertices.get(end - 1), weight));
        }
        
        System.out.println("Enter the source Vertex: ");
        int source =input.nextInt();
        
        bellmanFord(vertices.get(source - 1));
        
        System.out.println("Enter the target Vertex: ");
        int target = input.nextInt();
        
        shortestPathTo(vertices.get(target - 1));
        
        System.out.println("shortest path: ");
        for(Vertex v : shortestPath){
            System.out.println(v.getVertexName() + " " + v.getDistance());
        }
        
        
        System.out.println("All results: ");
        for(Vertex v : vertices){
            System.out.println(v.getVertexName() + " " + v.getDistance() + " " + v.getPredecessor());
        }
    }
    
    public static void bellmanFord(Vertex source){
        source.setDistance(0);
        for(int i = 0; i < vertices.size() - 1; i++){
            for(Edge e : edges){
                Vertex u = e.getStartVertex();
                Vertex v = e.getEndVertex();
                
                if(u.getDistance() == Integer.MAX_VALUE){
                    continue;
                }
                
                int distance = u.getDistance() + e.getWeight();
                
                if(distance < v.getDistance()){
                    v.setDistance(distance);
                    v.setPredecessor(u);
                }
            }
        }
        
        for(Edge e : edges){
            if(e.getStartVertex().getDistance() != Integer.MAX_VALUE){
                
                if(hasCycle(e)){
                    System.out.println("There is a negative cycle in this graph");
                    return;
                }
            }
        }
    }

    private static boolean hasCycle(Edge e) {
        return e.getStartVertex().getDistance() + e.getWeight() < e.getEndVertex().getDistance();
    }
    
    public static void shortestPathTo(Vertex target){
        for(Vertex v = target; v!= null; v = v.getPredecessor()){
            shortestPath.add(v);
        }

        Collections.reverse(shortestPath);
    }
}
