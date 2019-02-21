
package stronglyconnectedcomponents;

import java.util.Stack;

public class DFS {
    
    private Stack<Vertex> stack = new Stack<>();
    
    public void dfs(Vertex root){
        root.setVisited(true);
        for(Vertex v : root.getAdjacent()){
            if(!v.isVisited()){
                v.setVisited(true);
                System.out.println("dfs: " + v.getVertexName());
                dfs(v);
            }
        }
    }
    
    public void topSort(Vertex root){
        root.setVisited(true);
        for(Vertex v : root.getAdjacent()){
            if(!v.isVisited()){
                v.setVisited(true);
                topSort(v);
            }
        }
        stack.push(root);
    }
    
    public Stack getStack(){
        return this.stack;
    }
}
