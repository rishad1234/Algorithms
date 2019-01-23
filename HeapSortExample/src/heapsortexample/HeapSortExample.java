
package heapsortexample;

import java.util.Scanner;

public class HeapSortExample {

    public static String[] name;
    public static double[] cgpa;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of elements : ");
        int size = input.nextInt();
        name = new String[size];
        cgpa = new double[size];
        System.out.println("enter the name and cgpa: ");
        for(int i = 0; i < size; i++){
            name[i] = input.next();
            cgpa[i] = input.nextDouble();
        }
        
        heapSortAsc(cgpa);
        
        for(int i = 0; i < size; i++){
            System.out.println(name[i] + " " + cgpa[i]);
        }
        
    }
    
    public static int leftChild(int i){
        return 2 * i + 1;
    }
    
    public static int rightChild(int i){
        return 2 * i + 2;
    }
    
    public static void maxHeapify(double[] heapArray, int length, int i){
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;
        
        if(left < length && heapArray[left] > heapArray[largest]){
            largest = left;
        }
        
        if(right < length && heapArray[right] > heapArray[largest]){
            largest = right;
        }
        
        if(largest != i){
            swap(heapArray, i, largest);
            swapName(name, i, largest);
            maxHeapify(heapArray, length, largest);
        }
    }
    
//    public static void minHeapify(int[] heapArray, int length, int i){
//        int left = leftChild(i);
//        int right = rightChild(i);
//        int smallest = i;
//        
//        if(left < length && heapArray[left] < heapArray[smallest]){
//            smallest = left;
//        }
//        
//        if(right < length && heapArray[right] < heapArray[smallest]){
//            smallest = right;
//        }
//        
//        if(smallest != i){
//            swap(heapArray, i, smallest);
//            minHeapify(heapArray, length, smallest);
//        }
//    }
    
    public static void swap(double[] a, int i,  int j){
        double temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static void swapName(String[] a, int i,  int j){
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static void buildMaxHeap(double[] heapArray){
        int length = heapArray.length;
        for(int i = (length / 2) - 1; i >= 0; i--){
            maxHeapify(heapArray, length, i);
        }
    }
    
//    public static void buildMinHeap(int[] heapArray){
//        int length = heapArray.length;
//        for(int i = (length / 2) - 1; i >= 0; i--){
//            minHeapify(heapArray, length, i);
//        }
//    }
    
    public static void heapSortAsc(double[] heapArray){
        buildMaxHeap(heapArray);
        
        for(int i = heapArray.length - 1; i >= 0; i--){
            swap(heapArray, i, 0);
            swapName(name, i, 0);
            maxHeapify(heapArray, i, 0);
        }
    }
    
//    public static void heapSortDesc(int[] heapArray){
//        buildMinHeap(heapArray);
//        
//        for(int i = heapArray.length - 1; i >= 0; i--){
//            swap(heapArray, i, 0);
//            minHeapify(heapArray, i, 0);
//        }
//    }
}
