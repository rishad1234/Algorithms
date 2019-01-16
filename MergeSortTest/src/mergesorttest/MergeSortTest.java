
package mergesorttest;

import java.util.ArrayList;
import java.util.Scanner;

public class MergeSortTest {

    static ArrayList<Integer> inputArray = new ArrayList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number of elements to sort: ");
        int listSize = input.nextInt();
        
        for(int i = 0; i < listSize; i++){
            inputArray.add(input.nextInt());
        }
        
        mergeSortArraylist(0, inputArray.size() - 1);
        System.out.println("sorted array: ");
        inputArray.forEach((number) -> {
            System.out.println(number);
        });
//        int[] numbers = new int[listSize];
//        
//        for(int i = 0; i < listSize; i++){
//            numbers[i] = input.nextInt();
//        }
//        numbers = mergeSort(numbers, 0, listSize - 1);
//        
//        System.out.println("sorted array: ");
//        for(int number : numbers){
//            System.out.println(number);
//        }
        
    }
    
    private static int[] mergeSort(int[] a, int low, int high){
        if(low < high){
            int mid = (low + high)/2;
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
        return a;
    }
    
    private static void merge(int[] a, int low, int mid, int high){
        int length1 = mid - low + 1;
        int length2 = high - mid;
        
        int[] left = new int[length1 + 1];
        int[] right = new int[length2 + 1];
        
        for(int i = 0; i < length1; i++){
            left[i] = a[low + i];
        }
        
        for(int j = 0; j < length2; j++){
            right[j] = a[mid + j + 1];
        }
        
        left[length1] = Integer.MAX_VALUE;
        right[length2] = Integer.MAX_VALUE;
        
        int i = 0, j = 0;
        
        for(int k = low; k <= high; k++){
            if(left[i] < right[j]){
                a[k] = left[i];
                i++;
            }else{
                a[k] = right[j];
                j++;
            }
        }
    }
    
    public static void mergeSortArraylist(int low, int high){
        if(low < high && (high - low) >= 1){
            int mid = (high + low)/2;
            mergeSortArraylist(low, mid);
            mergeSortArraylist(mid+1, high);        

            //merging Sorted array produce above into one sorted array
            mergeArraylist(low,mid,high);            
        } 
    }
    
    public static void mergeArraylist(int low, int mid, int high){
        ArrayList<Integer> mergedSortedArray = new ArrayList<>();
         
        int left = low;
        int right = mid + 1;
         
        while(left <= mid && right <= high){
            if(inputArray.get(left) <= inputArray.get(right)){
                mergedSortedArray.add(inputArray.get(left));
                left++;
            }else{
                mergedSortedArray.add(inputArray.get(right));
                right++;
            }
        }       
         
        while(left <= mid){
            mergedSortedArray.add(inputArray.get(left));
            left++;
        }
         
        while(right <= mid){
            mergedSortedArray.add(inputArray.get(right));
            right++;
        }
         
        int i = 0;
        int j = low;
        while(i < mergedSortedArray.size()){
            inputArray.set(j, mergedSortedArray.get(i));
            i++;
            j++;
        }
    }
}
