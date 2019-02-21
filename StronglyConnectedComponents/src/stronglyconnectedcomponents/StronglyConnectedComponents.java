
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
        for(int i = 0; i < numberOfVertex; i++){
            vertices.add(new Vertex(i + 1, false));
            reversed.add(new Vertex(i + 1, false));
        }
        //reversed.addAll(vertices);
        
        System.out.println("Enter the number of edges: ");
        int numberOfEdges = input.nextInt();
        
        for(int i = 0; i < numberOfEdges; i++){
            int startVertex = input.nextInt();
            int endVertex = input.nextInt();
            vertices.get(startVertex - 1).addAdjacentVertex(vertices.get(endVertex - 1));
            reversed.get(endVertex - 1).addAdjacentVertex(reversed.get(startVertex - 1));
        }
        
        DFS dfs = new DFS();
        for(Vertex v : vertices){
            if(!v.isVisited()){
                dfs.topSort(v);
            }
        }
//        Stack stack = dfs.getStack();
//        
//        System.out.println("Stack: ");
//        while(!stack.isEmpty()){
//            Vertex v = (Vertex)stack.pop();
//            System.out.println(v.getVertexName());
//        }
        
//        System.out.println("vertices: ");
//        for(int i = 0; i < vertices.size(); i++){
//            System.out.println("Vetex name: " + vertices.get(i).getVertexName());
//            for(Vertex v : vertices.get(i).getAdjacent()){
//                System.out.print(v.getVertexName() + " ");
//            }
//            System.out.println("");
//        }
//        
//        System.out.println("reversed: ");
//        for(int i = 0; i < reversed.size(); i++){
//            System.out.println("Vetex name: " + reversed.get(i).getVertexName());
//            for(Vertex v : reversed.get(i).getAdjacent()){
//                System.out.print(v.getVertexName() + " ");
//            }
//            System.out.println("");
//        }   
        
        Stack<Vertex> stack = dfs.getStack();
        while(!stack.isEmpty()){
            Vertex v = stack.pop();
            System.out.println(v.getVertexName());
            if(!reversed.get(v.getVertexName() - 1).isVisited()){
                mark++;
                System.out.println("vertex: "+ reversed.get(v.getVertexName() - 1).getVertexName());
                dfs.dfs(reversed.get(v.getVertexName() - 1));
            }
        }
        System.out.println("mark: " + mark);
    }
}
