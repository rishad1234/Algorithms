
package hamilnoniancyclebacktrack;

import java.util.Scanner;

public class HamilnonianCycleBacktrack {
    static int[] x;
    static int[][] graph;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices: ");
        int vertices = input.nextInt();
        
        graph = new int[vertices][vertices];
        x =  new int[vertices];
        
        System.out.println("Enter the number of edges: ");
        int edges = input.nextInt();
        
        System.out.println("Enter the edges one by one: ");
        int i = 0;
        while(i < edges){
            int src = input.nextInt();
            int dest = input.nextInt();
            graph[src][dest] = 1;
            graph[dest][src] = 1;
            System.out.println("Dhukse " + i);
            i++;
        }
        
        hamCycle(vertices);
    }
    
    public static boolean isSafe(int v, int position){ 
      
        if(graph[x[position - 1]][v] == 0) {
            return false;
        }

        for(int i = 0; i < position; i++) 
            if (x[i] == v) {
                return false;
            }

        return true; 
    }
    
    public static boolean hamCycleUtil(int position, int vertices){ 
        
        if(position == vertices){  
            
            if(graph[x[position - 1]][x[0]] == 1){
                return true;
            }else{
                return false;
            } 
        } 
  
        for(int v = 1; v < vertices; v++){ 
            
            if(isSafe(v, position)){ 
                
                x[position] = v; 
                if(hamCycleUtil(position + 1, vertices) == true){
                    return true;
                }  

                x[position] = -1; 
            } 
        } 
        return false; 
    } 
    
    public static void hamCycle(int vertices){
       
        for(int i = 0; i < vertices; i++){
            x[i] = -1;
        } 
  
        x[0] = 0; 
        if(hamCycleUtil(1, vertices) == false){
            
            System.out.println("Solution does not exist"); 
            return;
        } 
  
        for(int i = 0; i < vertices; i++){
            System.out.print(x[i] + " ");
        }
        System.out.println("");
    } 
}
