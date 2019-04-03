
package fractionalknapsack;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class FractionalKnapsack {
    
    private static List<Item> items = new ArrayList<>();
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
                return Double.compare(o2.getProfitPerWeight(), o1.getProfitPerWeight());
            }
        });
        
        // testing
        for(Item item : items){
            System.out.println(item);
        }
        
        fractionalKnapsack(capacity, numberOfItems);
        
        double totalWeight = 0.0;
        double totalProfit = 0.0;
        for(Item item : items){
            System.out.println("fraction: " + item.getFraction());
            System.out.println("weight taken: " + item.getWeightTaken());
            totalWeight += item.getWeightTaken();
            totalProfit += item.getFraction() * item.getProfit();
        }
        System.out.println("Total weight: " + totalWeight);
        System.out.println("Total profit: " + totalProfit);
    }
    
    public static void fractionalKnapsack(int capacity, int numberOfItems){
        int i;
        for(i = 0; i < items.size(); i++){
            if(items.get(i).getWeight() > capacity){
                break;
            }
            items.get(i).setFraction(1.0);
            capacity -= items.get(i).getWeight();
        }
        if(i <= numberOfItems){
            items.get(i).setFraction(capacity / items.get(i).getWeight());
        }
        
        for(Item item : items){
            item.setWeightTaken(item.getFraction() * item.getWeight());
        }
    }
}
