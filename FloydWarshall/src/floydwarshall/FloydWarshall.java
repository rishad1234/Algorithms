
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
        
//        for(int k = 1; k <= nodes; k++){
//            for(int i = 1; i <= nodes; i++){
//                for(int j = 1; j <= nodes; j++){
//                    distance[i][j] = Math.min(distance[i][j], (distance[i][k] + distance[k][j]));
//                }
//            }
//        }

int from,to,via;
        for(from=1;from<=nodes;from++)
        {
                for(to=1;to<=nodes;to++)
                {
                        for(via=1;via<=nodes;via++)
                        {
                                distance[from][to] = Math.min(distance[from][to],
                                                         distance[from][via]+distance[via][to]);
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
