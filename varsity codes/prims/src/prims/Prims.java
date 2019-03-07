
package prims;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prims {
    static List<Edge>[] adjacents = (List<Edge>[]) new List[1000];
    static List<Vertex> vertices = new ArrayList<>();
    static PriorityQueue<Vertex> queue = new PriorityQueue<>();
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        for(int i = 0; i < 100; i++){
            adjacents[i] = new ArrayList<>();
        }
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
            Edge e1 = new Edge(end, start, weight);
            adjacents[start].add(e);
            adjacents[end].add(e1);
        }
        
        Vertex vertex = vertices.get(0);
        if(vertex.visited == false){
            vertex.key = 0;
            queue.add(vertex);
        }
        
        while(!queue.isEmpty()){
            Vertex v = queue.remove();
            v.visited = true;
            for(Edge e : adjacents[v.vertexName]){
                Vertex temp = vertices.get(e.end - 1);

                if(e.weight < temp.key){
                    temp.parent = v.vertexName;
                    temp.key = e.weight;
                    temp.minEdge = e;
                    
                    if(queue.contains(temp)){
                        queue.remove(temp);
                    }
                    queue.add(temp);
                }
            }
        }
        System.out.println("mst");
        for(Vertex v : vertices){
            if(v.minEdge != null){
                Edge e = v.minEdge;
                System.out.println(e.start + " " + e.end + " " + e.weight);
            }
        }
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

class Vertex implements Comparable<Vertex>{
    int vertexName;
    int key = Integer.MAX_VALUE;
    int parent  = -1;
    Edge minEdge;
    boolean visited = false;

    public Vertex(int vertexName) {
        this.vertexName = vertexName;
    }

    @Override
    public int compareTo(Vertex o) {
        return this.key - o.key;
    }
}
    

