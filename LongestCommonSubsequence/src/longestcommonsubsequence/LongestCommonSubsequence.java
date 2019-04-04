
package longestcommonsubsequence;

import java.util.Scanner;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the 1st String: ");
        String string1 = input.nextLine();
        System.out.println("Enter the 2nd String: ");
        String string2 = input.nextLine();
        
        int[][] array = new int[string1.length() + 1][string2.length() + 1];
        String lcs = "";
        for(int i = 1; i <= string1.length(); i++){
            for(int j = 1; j <= string2.length(); j++){
                if(string1.charAt(i - 1) == string2.charAt(j - 1)){
                    array[i][j] = array[i - 1][j - 1] + 1;
                }else{
                    array[i][j] = Integer.max(array[i - 1][j], array[i][j - 1]);
                }
            }
        }
        
        //testing
        System.out.println("Array: ");
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println("");
        }
        
        //preparing the lcs string
        int i = string1.length();
        int j = string2.length();
        while(i >= 1 && j >= 1){
            if(string1.charAt(i - 1) == string2.charAt(j - 1)){
                lcs += string1.charAt(i - 1);
                i--;
                j--;
            }else if(array[i - 1][j] >= array[i][j - 1]){
                i--;
            }else{
                j--;
            }
        }
        System.out.println(new StringBuilder(lcs).reverse().toString());
    } 
}
