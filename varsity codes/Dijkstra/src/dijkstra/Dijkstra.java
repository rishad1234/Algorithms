
package dijkstra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkstra {
    static List<Edge>[] adjacents = (List<Edge>[]) new List[1000];
    static List<Vertex> vertices = new ArrayList<>();
    static PriorityQueue<Vertex> queue = new PriorityQueue<>();
    static List<Vertex> shortestPath = new ArrayList<>();
    
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
                if(temp.visited == true){
                    continue;
                }
                int distance = v.key + e.weight;
                if(distance < temp.key){
                    temp.parent = v.vertexName;
                    temp.key = distance;
                    temp.minEdge = e;
                    
                    if(queue.contains(temp)){
                        queue.remove(temp);
                    }
                    queue.add(temp);
                }
            }
        }
        System.out.println("Enter the destination: ");
        int dest = input.nextInt();
        shortestPathTo(vertices.get(dest - 1));
        System.out.println("Shortest path: ");
        for(Vertex v : shortestPath){
            System.out.println(v.vertexName);
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
