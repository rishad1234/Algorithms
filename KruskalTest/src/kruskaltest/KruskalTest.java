
package kruskaltest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class KruskalTest {

    public static List<Vertex> vertices = new ArrayList<>();
    public static List<Edge> edges = new ArrayList<>();
    public static int cost = 0;
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int numberOfvertices = input.nextInt(); 
        
        for(int i = 1; i <= numberOfvertices; i++){
            vertices.add(new Vertex(i, i));
        }
        
        System.out.println("Enter the number of edges: ");
        int numberOfEdges = input.nextInt();
        for(int i = 0; i < numberOfEdges; i++){
            int startVertex = input.nextInt();
            int endVertex = input.nextInt();
            int weight = input.nextInt();
            
            edges.add(new Edge(vertices.get(startVertex - 1), 
                               vertices.get(endVertex - 1), 
                               weight));
        }
        
        Collections.sort(edges, new Comparator<Edge>(){
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.getWeight() - o2.getWeight();
            }
            
        });
        
//        System.out.println("sorted edges: ");
        
//        for(int i = 0; i < edges.size(); i++){
//            System.out.println(edges.get(i).getStartVertex() +
//                    " " + edges.get(i).getEndVertex() +
//                    " " + edges.get(i).getWeight());
//        }

        System.out.println("shortest path: ");
        for(int i = 0; i < numberOfEdges; i++){
            int u = findParent(edges.get(i).getStartVertex());
            int v = findParent(edges.get(i).getEndVertex());
            
            if(u != v){
                vertices.get(v - 1).setParent(u);
                cost += edges.get(i).getWeight();
                System.out.println(edges.get(i).getStartVertex() + " " +
                                    edges.get(i).getEndVertex() + " " + 
                                    edges.get(i).getWeight());
            }
        }
        
        System.out.println("Cost: " + cost);
    }
    public static int findParent(Vertex v){
        if(v.getParent() == v.getVertexName()){
            return v.getParent();
        }else{
            return findParent(vertices.get(v.getParent() - 1));
        }
    } 
    
}
