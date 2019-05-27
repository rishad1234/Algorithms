
package mcoloringbacktracking;

import java.util.Scanner;

/**
 *
 * @author rishad
 */
public class MColoringBacktracking {

    static  int[] color;
    public static void main(String[] args) {
        //Scanner input = new Scanner(System.in);
        
        int graph[][] = {{0, 1, 1, 1}, 
            {1, 0, 1, 0}, 
            {1, 1, 0, 1}, 
            {1, 0, 1, 0}, 
        };
        int numColors = 3;
        int numVertex = 4;
        color = new int[numVertex];
        for(int i = 0; i < numVertex; i++){
            color[i] = -1;
        }
        
        for(int i = 1; i <= numColors; i++){
            mColoring(graph, 0, numColors, numVertex);
        }    
    }
    
    static boolean isSafe(int[][] graph, int selectedVertex, int selectedColor, int numVertex){
        for(int i = 0; i < numVertex; i++){
            if(graph[selectedVertex][i] == 1 && selectedColor == color[i]){
                return false;
            }
        }
        return true;
    }
    
    static void mColoring(int[][] graph, int selectedVertex, int numColors, int numVertex){
        
        if(selectedVertex == numVertex){
            
            for(int i = 0; i < numVertex; i++){
                System.out.print(color[i] + " ");
            }
            System.out.println("");
  
            return;
        }
        
        for(int selectedColor = 1; selectedColor <= numColors; selectedColor++){
            if(isSafe(graph, selectedVertex, selectedColor, numVertex)){
                color[selectedVertex] = selectedColor;
                mColoring(graph, selectedVertex + 1, numColors, numVertex);
                color[selectedVertex] = 0;
            }
            
        }
    }
    
}
