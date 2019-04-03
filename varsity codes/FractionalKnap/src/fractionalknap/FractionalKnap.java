
package fractionalknap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class FractionalKnap {
    
    public static List<Item> items = new ArrayList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number of items: ");
        int numberOfItems = input.nextInt();
        
        System.out.println("Enter the maximum capacity: ");
        int capacity = input.nextInt();
        
        for(int i = 0; i < numberOfItems; i++){
            double weight = input.nextDouble();
            double profit = input.nextDouble();
            
            items.add(new Item(weight, profit));
        }
        
        items.sort(new Comparator<Item>(){
            @Override
            public int compare(Item o1, Item o2) {
                return Double.compare(o2.profitPerWeight, o1.profitPerWeight);
            }
        });
        
        fractionalKnapsack(capacity, numberOfItems);
        
        double totalWeight = 0.0;
        double totalProfit = 0.0;
        for(Item item : items){
            System.out.println("fraction: " + item.fraction);
            System.out.println("weight taken: " + item.weightTaken);
            totalWeight += item.weightTaken;
            totalProfit += item.fraction * item.profit;
        }
        System.out.println("Total weight: " + totalWeight);
        System.out.println("Total profit: " + totalProfit);
        
    }
    
    public static void fractionalKnapsack(int capacity, int numberOfItems){
        int i;
        for(i = 0; i < items.size(); i++){
            if(items.get(i).weight > capacity){
                break;
            }
            items.get(i).fraction = 1.0;
            capacity -= items.get(i).weight;
        }
        if(i <= numberOfItems){
            items.get(i).fraction = capacity / items.get(i).weight;
        }
        
        for(Item item : items){
            item.weightTaken = item.fraction * item.weight;
        }
    }
}

class Item {
    double weight;
    double profit;
    double profitPerWeight;
    double fraction = 0.0;
    double weightTaken = 0.0;

    public Item(double weight, double profit) {
        this.weight = weight;
        this.profit = profit;
        this.profitPerWeight = profit / weight;
    }
}
