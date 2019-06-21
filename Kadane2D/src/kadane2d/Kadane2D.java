
package kadane2d;

/**
 *
 * @author rishad
 */
public class Kadane2D {

    public static void main(String[] args) {
        
        int matrix[][] = {
          {   6, -5,  -7,  4, -4 },
          {  -9,  3,  -6,  5,  2 },
          { -10,  4,   7, -6,  3 },
          {  -8,  9,  -3,  3, -7 }};
        
        int maxLeft = -1, maxRight = -1, maxTop = -1, maxBottom = -1, rectangularSum = 0;
        
        int[] kadanesArray = new int[matrix.length];
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        for(int left = 0; left < col; left++){
            
            for(int i = 0; i < row; i++){
                kadanesArray[i] = 0;
            }
            
            for(int right = left; right < col; right++){
               
                for(int i = 0; i < row; i++){
                    kadanesArray[i] += matrix[i][right];
                }
                
                int[] temp = kadane(kadanesArray);
                
                if(temp[0] > rectangularSum){
                    
                    rectangularSum = temp[0];
                    maxLeft = left;
                    maxRight = right;
                    
                    maxTop = temp[1];
                    maxBottom = temp[2];
                }
            }
        }
        
        System.out.println(rectangularSum);
        System.out.println(maxLeft);
        System.out.println(maxRight);
        System.out.println(maxTop);
        System.out.println(maxBottom);
    }
    
    public static int[] kadane(int[] array){
        int currentMax = 0;
        int globalMax = 0;
        
        int maxStart = -1;
        int maxEnd = -1;
        
        int currentStart = 0;
        
        for(int i = 0; i < array.length; i++){
            
            currentMax += array[i];
            
            if(currentMax < 0){
                currentMax = 0;
                currentStart = i + 1;
            }
            
            if(currentMax > globalMax){
                
                globalMax = currentMax;
                maxStart = currentStart;
                maxEnd = i;
            }
        }
        
        int[] ar = {globalMax, maxStart, maxEnd};
        return ar;
    } 
    
}
