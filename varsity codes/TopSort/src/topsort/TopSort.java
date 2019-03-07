
package topsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TopSort {
    
    static int[] color = new int[100];
    static List<Integer>[] adjacent = (List<Integer>[]) new List[100];
    static Stack stack = new Stack();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);     
        for(int i = 0; i < adjacent.length; i++){
            adjacent[i] = new ArrayList<>();
        }
        System.out.println("Enter the number of nodes: ");
        int nodes = input.nextInt();
        System.out.println("Enter the number of edges: ");
        int edges = input.nextInt();
        for(int i = 0; i < edges; i++){
            int src = input.nextInt();
            int des = input.nextInt();
            
            adjacent[src].add(des);
            adjacent[des].add(src);
        }
        for(int i = 1; i <= nodes; i++){
            if(color[i] == 0){
                dfs(i);
            }
        }
        System.out.println("top sort");
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
    public static void dfs(int root){
        color[root] = 1;
        int size = adjacent[root].size();    
        for(int i = 0; i < size; i++){
            int vertex = adjacent[root].get(i);      
            if(color[vertex] == 0){
                dfs(vertex);
            }
        }
        color[root] = 2;
        stack.push(root);
    }
}
