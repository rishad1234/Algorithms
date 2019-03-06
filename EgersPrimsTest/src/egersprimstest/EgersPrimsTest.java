
package egersprimstest;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class EgersPrimsTest {

    private static PriorityQueue<Vertex> queue = new PriorityQueue();
    private static List<Vertex> vertices = new ArrayList<>();
    
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
            
            vertices.get(start - 1).addAdjaent(new Edge(vertices.get(start - 1), vertices.get(end - 1), weight));
            vertices.get(end - 1).addAdjaent(new Edge(vertices.get(end - 1), vertices.get(start - 1), weight));
        }
        
        //main algorithm
        for(Vertex vertex: vertices){
            if(!vertex.isVisited()){
                vertex.setKey(0);
                queue.add(vertex);
                
                while(!queue.isEmpty()){
                    Vertex v = queue.remove();
                    v.setVisited(true);
                    
                    for(Edge e : v.getAdjacentices()){
                        Vertex w = e.getEndVertex();
                        if(w.isVisited()){
                            continue;
                        }
                        if(e.getWeight() < w.getKey()){
                            w.setParent(v.getVertexName());
                            w.setKey(e.getWeight());
                            w.setMinEdge(e);
                            
                            if(queue.contains(w)){
                                queue.remove(w);
                            }
                            
                            queue.add(w);
                        }
                    }
                }
            }
        }
        
        for(Vertex v :  vertices){
            if(v.getMinEdge() != null){
                Edge e = v.getMinEdge();
                System.out.println(e.getStartVertex().getVertexName() + " "
                                    + e.getEndVertex().getVertexName() + " "
                                    + e.getWeight());
            }
        }
    }
}
