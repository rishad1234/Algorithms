
package zerooneknapsack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZeroOneKnapsack {

    static List<Item> items = new ArrayList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of items: ");
        int numberOfItems = input.nextInt();
        System.out.println("Enter the maximum capacity: ");
        int capacity = input.nextInt();

        
        System.out.println("Enter the items: ");
        for(int i = 0; i < numberOfItems; i++){
            int weight = input.nextInt();
            int profit = input.nextInt();
            
            items.add(new Item(weight, profit));
        }
        
        int[][] table = knapSack(numberOfItems, capacity);
        
        System.out.println("Knapsack table values: ");
        for(int i = 0; i < numberOfItems + 1; i++){
            for(int j = 0; j < capacity + 1; j++){
                System.out.print(table[i][j] + "\t");
            }
            System.out.println("");
        }
        
        getItems(numberOfItems, capacity, table);
        
    }
    
    public static int[][] knapSack(int numberOfItems, int capacity){
        
        int[][] knapSackTable = new int[numberOfItems + 1][capacity + 1];
        
        for(int i = 1; i <= numberOfItems; i++){
            for(int j = 1; j <= capacity; j++){
                if(items.get(i - 1).weight > j){
                    knapSackTable[i][j] = knapSackTable[i - 1][j];
                }else{
                    knapSackTable[i][j] = Integer.max(items.get(i - 1).profit + knapSackTable[i - 1][j - items.get(i - 1).weight],
                            knapSackTable[i - 1][j]);
                }
            }
        }   
        return knapSackTable;
    }
    
    public static void getItems(int numberOfItems, int capacity, int[][] table){
        int j = capacity;
        
        for(int i = numberOfItems; i >= 1; i--){
            if(table[i][j] > table[i - 1][j]){
                System.out.println("item : " + items.get(i - 1));
                j = j - items.get(i - 1).weight;
            }
        }
    }   
}

class Item {
    int weight;
    int profit;

    public Item(int weight, int profit) {
        this.weight = weight;
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "Item{" + "weight=" + weight + ", profit=" + profit + '}';
    }
}
