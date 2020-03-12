
package deadlock;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Admin
 */
public class DeadLock {

    static ArrayList<Integer>[] graph = new ArrayList[1000];
    static ArrayList<Integer> L = new ArrayList<>();
    static int[] color = new int[1000];
    static int cycleCount = 0;
    static Stack<Integer> stack = new Stack<>();
    static ArrayList<Integer> cycle = new ArrayList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        for(int i = 0; i < 1000; i++){
            graph[i] = new ArrayList<>();
        }
       int numberOfNode = input.nextInt();
       int numberOfedges = input.nextInt();
        
       for(int i = 0; i < numberOfedges; i++){
           int start = input.nextInt();
           int end = input.nextInt();
           
           graph[start].add(end);
       }
       
       for(int i = 1; i <= numberOfNode; i++){
           if(color[i] == 0){
               dfs(i);
           }
       }
    }
    
    public static void dfs(int node){
        color[node] = 1;
        L.add(node);
        
        for(int i = 0; i < graph[node].size(); i++){
            
            int temp = graph[node].get(i);
            if(color[temp] == 0){
                dfs(temp);
            }else if(color[temp] == 1){
                cycleCount++;
                
                for(int j = L.size() - 1; j >= 0; j--){
                    
                    stack.push(L.get(j));
                    cycle.add(L.get(j));
                    
                    if(L.get(j) == temp){
                        break;
                    }
                }
                System.out.println("Cycle: "  + cycleCount);
                while(!stack.isEmpty()){
                    System.out.print(stack.pop() + " ");
                }
                System.out.println("");
                while(!cycle.isEmpty()){
                    
                    System.out.print(cycle.get(cycle.size() - 1) + " ");
                    cycle.remove(cycle.size() - 1);
                }
                System.out.println("");
            }
        }
//        L.remove(L.size() - 1);
        color[node] = 2;
    }
    
}
