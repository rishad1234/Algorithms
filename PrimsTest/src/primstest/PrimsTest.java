
package primstest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PrimsTest {

   
    private static List<Vertex> vertices = new ArrayList<>();
    private static List<Edge> edges = new ArrayList<>();
    private static PriorityQueue<Edge> edgeHeap = new PriorityQueue<>();
    private static int cost = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int numberOfVertices = input.nextInt();
        
        for(int i = 0; i < numberOfVertices; i++){
            vertices.add(new Vertex(i + 1, 0));
        }
        
        System.out.println("Enter the number of edges: ");
        int numberOfEdges = input.nextInt();
        
        for(int i = 0; i < numberOfEdges; i++){
            int startVertex = input.nextInt();
            int endVertex = input.nextInt();
            int weight = input.nextInt();
            
            Vertex v = vertices.get(startVertex - 1);
            vertices.get(startVertex - 1).addEdge(new Edge(vertices.get(startVertex - 1), vertices.get(endVertex - 1), weight));
            vertices.get(endVertex - 1).addEdge(new Edge(vertices.get(endVertex - 1), vertices.get(startVertex - 1), weight));
        }
//        Vertex v1 = new Vertex(1, false, Integer.MAX_VALUE, 0);
//        Vertex v2 = new Vertex(2, false, Integer.MAX_VALUE, 0);
//        Vertex v3 = new Vertex(3, false, Integer.MAX_VALUE, 0);
//        
//        vertices.add(v1);
//        vertices.add(v2);
//        vertices.add(v3);
//        
//        v1.addEdge(new Edge(v1, v2, 1));
//        v2.addEdge(new Edge(v1, v3, 1));
//        v3.addEdge(new Edge(v2, v3, 10));
//        
//        v1.addEdge(new Edge(v2, v1, 1));
//        v2.addEdge(new Edge(v3, v1, 1));
//        v3.addEdge(new Edge(v3, v2, 10));
        
        
        prims(vertices.get(0));
        showMst();
    }
    
    public static void prims(Vertex v){
        vertices.remove(v);
        
        while(!vertices.isEmpty()){
            for(Edge edge : v.getAdjacencies()){
                if(vertices.contains(edge.getEndVertex())){
                    edgeHeap.add(edge);
                }
            }
            
            Edge minEdge = edgeHeap.remove();
            
            edges.add(minEdge);
            cost += minEdge.getWeight();
            v = minEdge.getEndVertex();
            v.setCost(minEdge.getWeight());
            vertices.remove(v);
        }
    }
    
    public static void showMst(){
        System.out.println("cost of mst: " + cost);
        for(Edge e : edges){
            System.out.println(e.getStartVertex() + " " + e.getEndVertex() + " " + e.getWeight());
            System.out.println("startVertex " + e.getStartVertex().getCost() + " Endvertex " + e.getEndVertex().getCost());
        }
        
        
    }
    
}
