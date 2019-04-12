
package nqueen;

import java.util.Scanner;

public class Nqueen {

    static int[][] board;
    static int counter = 1;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the board size: ");
        int n = input.nextInt();
        board = new int[n][n];
        nQueen(0, n);
        
    }
    
    public static boolean nQueen(int col, int n){
        if(col == n){
            System.out.println(counter++ + ": ");
            printBoard();
            System.out.println("");
            return true;
        }
        for(int row = 0; row < n; row++){
            if(check(row, col, n)){
                board[row][col] = 1;
                nQueen(col + 1, n);
                board[row][col] = 0;
            }
        }
        return false;
    }

    public static void printBoard(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }
    
    public static boolean check(int row, int col, int n){
        //lower digonal
        for(int i = row, j = col; i < n && j >= 0; i++, j--){
            if(board[i][j] == 1){
                return false;
            }
        }
        
        //upper diagonal
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 1){
                return false;
            }
        }
        //row
        for(int i = 0; i < col; i++){
            if(board[row][i] == 1){
                return false;
            }
        }
        return true;
    }  
}
