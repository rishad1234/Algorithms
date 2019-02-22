
package egersprimstest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class EgersPrimsTest {

    private static PriorityQueue<Vertex> queue = new PriorityQueue();
    private static List<Vertex> vertices = new ArrayList<>();
    private static List<Edge> edges = new ArrayList<>();
    private static int cost = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices: ");
        int numberOfVertices = input.nextInt();
        
        for(int i = 0; i < numberOfVertices; i++){
            vertices.add(new Vertex(i + 1, Integer.MAX_VALUE, Integer.MAX_VALUE));
        }
        
        System.out.println("Enter the number of edges: ");
        int numberOfEdges = input.nextInt();
        
        for(int i = 0; i < numberOfEdges; i++){
            int start = input.nextInt();
            int end = input.nextInt();
            int weight = input.nextInt();
            
            //edges.add(new Edge(vertices.get(start - 1), vertices.get(end - 1), weight));
            vertices.get(start - 1).addAdjaent(new Edge(vertices.get(start - 1), vertices.get(end - 1), weight));
            vertices.get(end - 1).addAdjaent(new Edge(vertices.get(end - 1), vertices.get(start - 1), weight));
        }
        
        System.out.println("Enter the source vertex: ");
        int sourceVertex = input.nextInt();
        
        //main algorithm
        vertices.get(sourceVertex - 1).setKey(0);
        
        for(Vertex v : vertices){
            queue.add(v);
            //System.out.println(v.getVertexName());
        }
        
//        while(!queue.isEmpty()){
//            System.out.println(queue.remove().getVertexName());
//        }
        
        while(!queue.isEmpty()){
            Vertex temp = queue.remove();
            
            for(Edge e : temp.getAdjacentices()){
                if(queue.contains(e.getEndVertex()) && (e.getWeight() < e.getEndVertex().getKey())){
                    e.getEndVertex().setParent(temp.getVertexName());
                    e.getEndVertex().setKey(e.getWeight());
                    edges.add(e);
                    cost += e.getWeight();
                }
            }
        }
        
        System.out.println("cost: " + cost);
        for(Edge e: edges){
            System.out.println(e.getStartVertex().getVertexName() 
                    + " " + e.getEndVertex().getVertexName() 
                    + " " + e.getWeight() 
                    + " " + e.getStartVertex().getParent() 
                    + " " + e.getEndVertex().getParent());
            System.out.println("StartVertex " + e.getStartVertex().getKey() + " endVertex " + e.getEndVertex().getKey());
        }
        
    }
    
}
