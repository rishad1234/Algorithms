
package floydwarshall;

import java.util.Scanner;

public class FloydWarshall {

    public static int[][] distance;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes: ");
        int nodes = input.nextInt();
        distance = new int[nodes + 1] [nodes + 1];
        for(int i = 0; i <= nodes; i++){
            for(int j = 0; j <= nodes; j++){
                if(i == j){
                    distance[i][j] = 0;
                }else{
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        System.out.println("Enter the number of edges: ");
        int edges = input.nextInt();
        
        for(int i = 1; i <= edges; i++){
            int start = input.nextInt();
            int end = input.nextInt();
            int weight = input.nextInt();
            
            distance[start][end] = weight;
        }
        
        System.out.println("Distance matrix: ");
        for(int i = 1; i <= nodes; i++){
            for(int j = 1; j <= nodes; j++){
                System.out.print(distance[i][j] + " ");
            }
            System.out.println("");
        }
        
        for(int k = 1; k <= nodes; k++){
            for(int i = 1; i <= nodes; i++){
                for(int j = 1; j <= nodes; j++){
                    if(distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE){
                        distance[i][j] = Math.min(distance[i][j], (distance[i][k] + distance[k][j]));
                    }
                }
            }
        }
        
        for(int i = 1; i <= nodes; i++){
            for(int j = 1; j <= nodes; j++){
                System.out.print(distance[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
/*
1 2 3
2 1 8
1 4 7
4 1 2
3 4 1
3 1 5
2 3 2
*/