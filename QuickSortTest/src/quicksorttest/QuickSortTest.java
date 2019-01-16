
package quicksorttest;

import java.util.ArrayList;
import java.util.Scanner;

public class QuickSortTest {

    static ArrayList<Integer> inputArray = new ArrayList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements to sort: ");
        int listSize = input.nextInt();
        
        for(int i = 0; i < listSize; i++){
            inputArray.add(input.nextInt());
        }
        
        quickSortArrayList(0, listSize - 1);
        System.out.println("sorted array: ");
        for(Integer number : inputArray){
            System.out.println(number);
        }
        
//        int[] numbers = new int[listSize];
//        
//        for(int i = 0; i < listSize; i++){
//            numbers[i] = input.nextInt();
//        }
//        quickSort(numbers, 0, listSize - 1);
//        
//        System.out.println("sorted array: ");
//        for(int number : numbers){
//            System.out.println(number);
//        }   
    }
    
    public static void quickSort(int[] a, int low, int high){
        if(low < high){
            int part = partition(a, low, high);
            quickSort(a, low, part - 1);
            quickSort(a, part + 1, high);
        }
    }
    
    public static int partition(int[] a, int low, int high){
        int pivot = a[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(a[j] < pivot){
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, high);
        return i + 1;
    }
    
    public static void swap(int[] a , int i , int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static void quickSortArrayList(int low, int high){
        if(low < high){
            int part = partitionArrayList(low, high);
            quickSortArrayList(low, part - 1);
            quickSortArrayList(part + 1, high);
        }
    }
    
    public static int partitionArrayList(int low, int high){
        int pivot = inputArray.get(high);
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(inputArray.get(j) < pivot){
                i++;
                int temp = inputArray.get(i);
                inputArray.set(i, inputArray.get(j));
                inputArray.set(j, temp);
            }
        }
        int temp = inputArray.get(i + 1);
        inputArray.set(i + 1, inputArray.get(high));
        inputArray.set(high, temp);
        
        return i + 1;
    }
}
