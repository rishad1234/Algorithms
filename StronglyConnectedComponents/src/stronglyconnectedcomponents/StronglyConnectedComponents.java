
package stronglyconnectedcomponents;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StronglyConnectedComponents {

    static int mark = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices: ");
        int numberOfVertex = input.nextInt();
        
        List<Vertex> vertices = new ArrayList<>();
        List<Vertex> reversed = new ArrayList<>();
        //List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < numberOfVertex; i++){
            vertices.add(new Vertex(i + 1, false));
        }
        for(int i = 0; i < numberOfVertex; i++){
            reversed.add(new Vertex(i + 1, false));
        }
        
        System.out.println("Enter the number of edges: ");
        int numberOfEdges = input.nextInt();
        
        for(int i = 0; i < numberOfEdges; i++){
            int startVertex = input.nextInt();
            int endVertex = input.nextInt();
            //weight is set to 1
            //edges.add(new Edge(vertices.get(startVertex - 1), vertices.get(endVertex - 1), 1));
            
            vertices.get(startVertex - 1).addAdjacentVertex(vertices.get(endVertex - 1));
        }
        
        
        DFS dfs = new DFS();
        for(Vertex v : vertices){
            if(!v.isVisited()){
                dfs.topSort(v);
            }
        }
        
        //List<Vertex> reversed = reverseEdges(vertices, numberOfVertex);
        
        
        System.out.println("tesing: ");
        
        for(Vertex v : vertices){
            System.out.println("adjacent of " + v.getVertexName());
            for(Vertex temp : v.getAdjacent()){
                System.out.print(" " + temp.getVertexName() + " ");
            }
            System.out.println("");
        }
        
//        System.out.println("testing: ");
//        for(Vertex v : reversed){
//            System.out.println("adjacent of " + v.getVertexName());
//            for(Vertex temp : v.getAdjacent()){
//                System.out.print(" " + temp.getVertexName() + " ");
//            }
//            System.out.println("");
//        }
        
        
        
        
        Stack<Vertex> stack = dfs.getStack();
        while(!stack.isEmpty()){
            Vertex v = stack.pop();
            if(!reversed.get(v.getVertexName() - 1).isVisited()){
                //reversed.get(v.getVertexName() - 1).setMark(reversed.get(v.getVertexName() - 1).getMark() + 1);
                mark = mark + 1;
                dfs.dfs(reversed.get(v.getVertexName() - 1));
            }
        }
        System.out.println("mark: " + mark);
        for(int i = 0; i < reversed.size(); i++){
            System.out.println("vertex name: " + reversed.get(i).getVertexName() + " mark: " + reversed.get(i).getMark());
        }
        
    }
    
    public static List<Vertex> reverseEdges(List<Vertex> vertices, int numberOfVertex){
        List<Vertex> reversed = new ArrayList<>();
        for(int i = 0; i < numberOfVertex; i++){
            reversed.add(new Vertex(i+1, false));
        }
        for(int i = 0; i < vertices.size(); i++){
            for(Vertex v : vertices.get(i).getAdjacent()){
                reversed.get(v.getVertexName() - 1).addAdjacentVertex(reversed.get(i));
            }
        }
        return reversed;
    }
    
}
