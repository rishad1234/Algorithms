
package quicksort;

public class QuickSort {

    static int[] numbers = {5, 2, 1, 2, 4, 4};
    public static void main(String[] args) {
        quickSort(0, numbers.length - 1);
        for(int i : numbers){
            System.out.println(i);
        }
    }
    
    public static void quickSort(int low, int high){
        if(low < high){
            int partition = partition(low, high);
            quickSort(low, partition - 1);
            quickSort(partition + 1, high);
        }
    }
    
    public static int partition(int low, int high){
        int pivot = numbers[high];
        int i = low - 1;
        for(int j = low; j < high; j++){
            if(numbers[j] < pivot){
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }
    
    public static void swap(int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
    
}
