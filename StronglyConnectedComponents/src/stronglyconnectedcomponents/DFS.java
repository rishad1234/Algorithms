
package stronglyconnectedcomponents;

import java.util.Stack;

public class DFS {
    
    private Stack<Vertex> stack = new Stack<>();
    
    public void dfs(Vertex root){
        for(Vertex v : root.getAdjacent()){
            if(!v.isVisited()){
                v.setVisited(true);
                dfs(v);
            }
        }
        root.setVisited(true);
    }
    
    public void topSort(Vertex root){
        for(Vertex v : root.getAdjacent()){
            if(!v.isVisited()){
                v.setVisited(true);
                dfs(v);
            }
        }
        stack.push(root);
        root.setVisited(true);
    }
    
    public Stack getStack(){
        return this.stack;
    }
}
