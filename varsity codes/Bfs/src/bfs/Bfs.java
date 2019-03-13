
package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Bfs {
    static List<Vertex> vertices = new ArrayList<>();
    static List<Integer>[] adjacents = new List[100];
    static Queue<Vertex> queue = new LinkedList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int nodes = input.nextInt();
        System.out.println("Enter the number of edges: ");
        int edges = input.nextInt();
        for(int i = 0; i < 100; i++){
            adjacents[i] = new ArrayList<>();
        }
        for(int i = 0; i < nodes; i++){
            vertices.add(new Vertex(i + 1));
        }
        for(int i = 0; i < edges; i++){
            int source = input.nextInt();
            int dest = input.nextInt();
            
            adjacents[source].add(dest);
            adjacents[dest].add(source);
        }
        
        System.out.println("Enter the root: ");
        int root = input.nextInt();
        
        vertices.get(root  - 1).visited = true;
        queue.add(vertices.get(root - 1));
        while(!queue.isEmpty()){
            Vertex temp = queue.remove();
            for(int v : adjacents[temp.name]){
                if(vertices.get(v - 1).visited == false){
                    System.out.println(v);
                    vertices.get(v - 1).visited = true;
                    queue.add(vertices.get(v - 1));
                }
            }
        }
        
        
    }
    
}

class Vertex{
    int name;
    boolean visited = false;

    public Vertex(int name) {
        this.name = name;
    }  
}
