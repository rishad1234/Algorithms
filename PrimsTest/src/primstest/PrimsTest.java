
package primstest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimsTest {

   
    private static List<Vertex> vertices = new ArrayList<>();
    private static PriorityQueue<Edge> edges = new PriorityQueue<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int numberOfVertices = input.nextInt();
        
        for(int i = 0; i < numberOfVertices; i++){
            vertices.add(new Vertex(i + 1, false, Integer.MAX_VALUE));
        }
        
        System.out.println("Enter the number of edges: ");
        int numberOfEdges = input.nextInt();
        
        for(int i = 0; i < numberOfEdges; i++){
            int startVertex = input.nextInt();
            int endVertex = input.nextInt();
            int weight = input.nextInt();
            
            edges.add(new Edge(vertices.get(startVertex - 1), vertices.get(endVertex - 1), weight));
        }
        
        //main algorithm
        
//        for(Vertex v : vertices){
//        
//        }

        while(!edges.isEmpty()){
            System.out.println(edges.poll().getWeight());
        }
        
    }
    
}
