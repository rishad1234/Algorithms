
package dijkstratest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class DijkstraTest {

    private static List<Vertex> shortestPath = new ArrayList<>();
    private static List<Vertex> vertices = new ArrayList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices: ");
        int numberOfVertices = input.nextInt();
        for(int i = 0; i < numberOfVertices; i++){
            vertices.add(new Vertex(i + 1, false));
        }
        
        System.out.println("Enter the number of edges: ");
        int numberOfEdges = input.nextInt();
        
        for(int i = 0; i < numberOfEdges; i++){
            int start = input.nextInt();
            int end = input.nextInt();
            int weight = input.nextInt();
            
            vertices.get(start - 1).addAdjacent(new Edge(vertices.get(start - 1), vertices.get(end - 1), weight));
        }
        
        System.out.println("Enter the source vertex: ");
        int source = input.nextInt();
        
        System.out.println("Enter the destination vertex: ");
        int destination = input.nextInt();
        
        dijkstra(vertices.get(source - 1));
        shortestPathTo(vertices.get(destination - 1));
        
        System.out.println("paths: ");
        for(Vertex v : shortestPath){
            System.out.println("vertex name: " + v.getVertexName() + " distance: " + v.getDistance());
        }   
    }
    
    public static void dijkstra(Vertex source){
        source.setDistance(0);
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        
        queue.add(source);
        while(!queue.isEmpty()){
            Vertex vertex = queue.remove();
            
            for(Edge e : vertex.getAdjacencies()){
                Vertex temp = e.getEndVertex();
                
                int distance = vertex.getDistance() + e.getWeight();
                
                if(distance < temp.getDistance()){
                    queue.remove(temp);
                    temp.setDistance(distance);
                    temp.setPredecessor(vertex);
                    queue.add(temp);
                }
            }
            vertex.setVisied(true);
        }
    }
    
    public static void shortestPathTo(Vertex target){
   
        for(Vertex v = target; v!= null; v = v.getPredecessor()){
            shortestPath.add(v);
        }
        
        Collections.reverse(shortestPath);
    }
}
