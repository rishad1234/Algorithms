
package kahnstopologicalsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rishad
 */
public class KahnsTopologicalSort {

    static int[][] graph;
    static int[] incomingEdgeCount;
    static List<Integer> verticesToPerform = new ArrayList<>();
    static List<Integer> results = new ArrayList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices: ");
        int numOfVertex = input.nextInt();
        
        graph = new int[numOfVertex + 1][numOfVertex + 1];
        incomingEdgeCount = new int[numOfVertex + 1];
        
        System.out.println("Enter the number of edges: ");
        int numOfEdge = input.nextInt();
        
        System.out.println("Enter the edges one by one: ");
        for(int i = 0; i < numOfEdge; i++){
            int start = input.nextInt();
            int end = input.nextInt();
            graph[start][end] = 1;
            incomingEdgeCount[end] += 1;
        }
        
        //main algorithm starts from here
        for(int i = 1; i <= numOfVertex; i++){
            if(incomingEdgeCount[i] == 0){
                verticesToPerform.add(i);
            }
        }
        
        while(!verticesToPerform.isEmpty()){
            int vertex = verticesToPerform.remove(0);
            results.add(vertex);
            
            List<Integer> neighbors = new ArrayList<>();
            
            for(int i = 1; i <= numOfVertex; i++){
                if(graph[vertex][i] == 1){
                    neighbors.add(i);
                }
            }
            
            for(int neighbor : neighbors){
                graph[vertex][neighbor] = 0;
                incomingEdgeCount[neighbor] -= 1;
                
                if(incomingEdgeCount[neighbor] == 0){
                    verticesToPerform.add(neighbor);
                }
            }
        }
        
        System.out.println("top sort: ");
        for(int result : results){
            System.out.println(result);
        }
        
    }
    
}
