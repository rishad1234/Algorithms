
package kruskal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class Kruskal {
    static List<Edge> edges = new ArrayList<>();
    static int[] parent = new int[1000];
    static int cost = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int vertexNum = input.nextInt();
        for(int i = 0; i <= vertexNum; i++){
            parent[i] = i;
        }
        System.out.println("Enter the number of edges: ");
        int edgeNum = input.nextInt();
        
        for(int i = 0; i < edgeNum; i++){
            int start = input.nextInt();
            int end = input.nextInt();
            int weight = input.nextInt();
            
            edges.add(new Edge(start, end, weight));
        }
        Collections.sort(edges, new Comparator<Edge>(){
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }  
        });
        System.out.println("shortest path: ");
        for(int i = 0; i < edgeNum; i++){
            int u = find_parent(edges.get(i).startVertex);
            int v = find_parent(edges.get(i).endVertex);
            if(u != v){
                parent[v] = u;
                cost += edges.get(i).weight;
                System.out.println(edges.get(i).startVertex + " " + 
                        edges.get(i).endVertex + " " +
                        edges.get(i).weight + " ");
            }
        }
    }
    public static int find_parent(int node){
        if(parent[node] == node){
            return node;
        }
        return find_parent(parent[node]);
    }
}
class Edge{
    int startVertex;
    int endVertex;
    int weight;

    public Edge(int startVertex, int endVertex, int weight) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weight = weight;
    }
}