
package topological_sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Topological_sort {

    public static Stack<Vertex> stack = new Stack<>();
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        int numberOfVertices = input.nextInt();
        
        List<Vertex> vertices = new ArrayList<>();
        
        for(int i = 0; i < numberOfVertices; i++){
            vertices.add(new Vertex(i + 1));
        }
        System.out.println("Enter the number of edges: ");
        int numberOfEdges = input.nextInt();
        
        for(int i = 0; i < numberOfEdges; i++){
            int src = input.nextInt();
            int des = input.nextInt();
            
            vertices.get(src - 1).addAdjacentVertex(vertices.get(des - 1));
        }
        
        dfs(vertices.get(0));
        System.out.println("top sort: ");
        
        while(!stack.isEmpty()){
            System.out.println(stack.pop().toString());
        }
    }
    
    public static void dfs(Vertex root){ 
        for(Vertex v : root.getAdjacent()){
            if(!v.isVisited()){
                v.setVisited(true);
                dfs(v);
            }
        }
        stack.push(root);
    }   
}
