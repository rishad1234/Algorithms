
package mergesort;


public class MergeSort {

    static int[] numbers = {5, 2, 1, 2, 4, 4};
    public static void main(String[] args) {
        mergeSort(0, numbers.length - 1);
        for(int i : numbers){
            System.out.println(i);
        }       
    }
    
    public static void mergeSort(int low, int high){
        if(low < high){
            int mid = (low + high) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }
    
    public static void merge(int low, int mid, int high){
        int length1 = mid - low + 1;
        int length2 = high - mid;
        
        int[] left = new int[length1 + 1];
        int[] right = new int[length2 + 1];
        left[length1] = Integer.MAX_VALUE;
        right[length2] = Integer.MAX_VALUE;
        
        for(int i = 0; i < length1; i++){
            left[i] = numbers[low + i];
        }
        for(int i = 0; i < length2; i++){
            right[i] = numbers[mid + i + 1];
        }
        
        int i = 0, j = 0;
        
        for(int k = low; k <= high ; k++){
            if(left[i] < right[j]){
                numbers[k] = left[i];
                i++;
            }else{
                numbers[k] = right[j];
                j++;
            }
        }
    }
    
}
