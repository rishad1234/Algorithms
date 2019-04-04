
package matrixchainmultiplication;

import java.util.Scanner;

public class MatrixChainMultiplication {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of matrix to: ");
        int numberOfMatrix = input.nextInt();
        
        int[][] matrix = new int[numberOfMatrix + 1][numberOfMatrix + 1];
        int[][] bracketsMatrix = new int[numberOfMatrix + 1][numberOfMatrix + 1];
        int[] sizes = new int[numberOfMatrix + 1];
        int j, min, q;
       
        System.out.println("Enter the size of the matrix one by one: ");
        sizes[0] = input.nextInt();
        sizes[1] = input.nextInt();
        for(int i = 2; i < sizes.length; i++){
            input.nextInt();
            sizes[i] = input.nextInt();
        }
        //testing
        System.out.println("Sizes Matrix: ");
        for(int i : sizes){
            System.out.print(i + " ");
        }
        System.out.println("");
        
	for(int d = 1; d < sizes.length - 1; d++){
            for(int i = 1; i < sizes.length - d; i++){
                j = i + d;
                min = 32767;
                for(int k = i; k <= j - 1; k++){
                        q = matrix[i][k] + matrix[k + 1][j] + sizes[i - 1] * sizes[k] * sizes[j];
                        if(q < min){
                                min = q;
                                bracketsMatrix[i][j] = k;
                        }
                }
                matrix[i][j] = min;
            }
	}
        System.out.println("Total minimum multiplications: " + matrix[1][sizes.length - 1]);
        
        System.out.println("Matrix: ");
        for(int i = 0; i < matrix.length; i++){
            for(j = 0; j < matrix[i].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
        
        System.out.println("Brackets Matrix: ");
        for(int i = 0; i < bracketsMatrix.length; i++){
            for(j = 0; j < bracketsMatrix[i].length; j++){
                System.out.print(bracketsMatrix[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");     
        
        System.out.println("the equations: ");
        printOptimalParenthesizations(bracketsMatrix);
       
    }
    
    //straight from wikipedia
    public static void printOptimalParenthesizations(int[][] s) {
        boolean[] inAResult = new boolean[s.length];
        printWithParenthesizations(s, 0, s.length - 1, inAResult);
    }

    public static void printWithParenthesizations(int[][]s, int i, int j,  /* for pretty printing: */ boolean[] inAResult) {
        if (i != j) {
            printWithParenthesizations(s, i, s[i][j], inAResult);
            printWithParenthesizations(s, s[i][j] + 1, j, inAResult);
            String istr = inAResult[i] ? "_result " : " ";
            String jstr = inAResult[j] ? "_result " : " ";
            System.out.println(" A_" + i + istr + "* A_" + j + jstr);
            inAResult[i] = true;
            inAResult[j] = true;
        }
    }
    /////
}
