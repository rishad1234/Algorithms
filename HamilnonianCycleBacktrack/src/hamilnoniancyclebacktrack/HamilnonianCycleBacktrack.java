
package hamilnoniancyclebacktrack;

import java.util.Scanner;

public class HamilnonianCycleBacktrack {
    static int[] x;
    static int[][] graph;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number of vertices: ");
        int vertices = input.nextInt();
        
        graph = new int[vertices + 1][vertices + 1];
        x =  new int[vertices + 1];
        
        System.out.println("Enter the number of edges: ");
        int edges = input.nextInt();
        
        System.out.println("Enter the edges one by one: ");
        for(int i = 0; i < edges; i++){
            int src = input.nextInt();
            int dest = input.nextInt();
            graph[src][dest] = 1;
            graph[dest][src] = 1;
        }
        
        hamiltonian(1, vertices);
        
    }
    
    public static int nextValue(int vertex, int vertices){
        
        while(true){
            
            x[vertex] = (x[vertex] + 1) % (vertices + 1);
            if(x[vertex] == 0){
                return 0;
            }
            
            if(graph[x[vertex - 1]][x[vertex]] != 0){
                
                for(int j = 1; j <= vertex - 1; j++){
                    
                    if(j == vertex){
                        if((vertex < vertices || vertex == vertices) && graph[x[vertices]][x[1]] != 0){
                            return vertex;
                        }
                    }
                }
            }
        }
    }
    
    public static void hamiltonian(int vertex, int vertices){
        
        while(true){
            
            int k = nextValue(vertex, vertices);
            if(k != 0){
                if(x[k] == 0){
                    return;
                }
                if(k == vertices){
                    
                    for(int i = 1; i <= vertices; i++){
                        System.out.print(x[i] + " ");
                    }
                    System.out.println("");
                    
                }else{
                    hamiltonian(k + 1, vertices);
                }
            }
        }
    }
    
}
