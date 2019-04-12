
package editdistance;

import java.util.Scanner;

public class EditDistance {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the 1st string: ");
        String string1 = input.nextLine();
        System.out.println("Enter the 2nd string: ");
        String string2 = input.nextLine();
        
        int[][]table = calculateEditDistance(string1, string2);
        System.out.println("Edit distance: " + printTable(table));
        printActualEdits(table, string1, string2);
        
    }

    private static int[][] calculateEditDistance(String str1, String str2) {
        
        int[][] table = new int[str1.length() + 1][str2.length() + 1];
        for(int i = 0; i < table[0].length; i++){
            table[0][i] = i;
        }

        for(int i = 0; i < table.length; i++){
            table[i][0] = i;
        }
        
        for(int i = 1; i < table.length; i++){
            for(int j = 1; j < table[i].length; j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    table[i][j] = table[i - 1][j - 1];
                }else{
                    int min = Math.min(table[i - 1][j], table[i][j - 1]);
                    table[i][j] = Math.min(min, table[i - 1][j - 1]) + 1;
                }
            }
        }
        return table;
    }
    
    public static int printTable(int[][] table){
        for(int i = 0; i < table.length; i++){
            for(int j = 0; j < table[i].length; j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println("");
        }
        return table[table.length - 1][table[0].length - 1];
    }
    
    public static void printActualEdits(int T[][], String str1, String str2) {
        int i = T.length - 1;
        int j = T[0].length - 1;
        while(true) {
            if (i == 0 || j == 0) {
                break;
            }
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                i = i-1;
                j = j-1;
            } else if (T[i][j] == T[i-1][j-1] + 1){
                System.out.println("Edit " + str2.charAt(j - 1) + " in string2 to " + str1.charAt(i - 1) + " in string1");
                i = i-1;
                j = j-1;
            } else if (T[i][j] == T[i-1][j] + 1) {
                System.out.println("Delete in string1 " + str1.charAt(i - 1));
                i = i-1;
            } else if (T[i][j] == T[i][j-1] + 1){
                System.out.println("Delete in string2 " + str2.charAt(j - 1));
                j = j -1;
            } else {
                
            }

        }
    }
    
}
