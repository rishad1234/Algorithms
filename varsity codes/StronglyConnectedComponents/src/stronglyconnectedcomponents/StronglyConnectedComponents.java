
package stronglyconnectedcomponents;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StronglyConnectedComponents {

    static int mark = 0;
    static Stack stack = new Stack();
    static List<Integer>[] forward = (List<Integer>[]) new List[1000];
    static List<Integer>[] reverse = (List<Integer>[]) new List[1000];
    static int[]color1 = new int[1000];
    static int[] color2 = new int[1000];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of vertex: ");
        int numberOfVertex = input.nextInt();
        for(int i = 0; i < 1000; i++){
            forward[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }
        System.out.println("Enter the number of edges: ");
        int numberOfEdge = input.nextInt();
        
        for(int i = 0; i < numberOfEdge; i++){
            int start = input.nextInt();
            int end = input.nextInt();
            forward[start].add(end);
            reverse[end].add(start);
        }
        findSSC(numberOfVertex);
        System.out.println("mark: " + mark);
    }
    public static void dfs(int root){
        color1[root] = 1;
        for(int i = 0; i < forward[root].size(); i++){
            int temp = forward[root].get(i);
            if(color1[temp] == 0){
                dfs(temp);
            }
        }
        stack.push(root);
    }
    public static void dfs2(int root){
        color2[root] = 1;
        for(int i = 0; i < reverse[root].size(); i++){
            int temp = reverse[root].get(i);
            if(color2[temp] == 0){
                dfs2(temp);
            }
        }
    }
    public static void findSSC(int numberOfVertex){
        for(int i = 1; i <= numberOfVertex; i++){
            if(color1[i] == 0){
                dfs(i);
            }
        }
        while(!stack.isEmpty()){
            int temp = (int)stack.pop();
            if(color2[temp] == 0){
                mark++;
                dfs2(temp);
            }
        }
    } 
}
