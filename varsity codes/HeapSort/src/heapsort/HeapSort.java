
package heapsort;

public class HeapSort {

    static int[] numbers = {5, 2, 1, 2, 4, 4};
    //static int[] numbers = new int[5];
    public static void main(String[] args) {
        heapSort(numbers);
        for(int i : numbers){
            System.out.println(i);
        }
    }
    
    public static int leftChild(int i){
        return 2 * i + 1;
    }
    
    public static int rightChild(int i){
        return 2 * i + 2;
    }
    
    public static void maxHeapify(int[] ar, int length, int i){
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;
        
        if(left < length && ar[left] > ar[largest]){
            largest = left;
        }
        if(right < length && ar[right] > ar[largest]){
            largest = right;
        }
        
        if(largest != i){
            swap(ar, i, largest);
            maxHeapify(ar, length, largest);
        }
    }
    
    public static void swap(int[] ar, int i, int j){
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
    
    public static void buildMaxHeap(int[] ar){
        int length = ar.length;
        for(int i = length/2 - 1; i >= 0; i--){
            maxHeapify(ar, length, i);
        }
    }
    
    public static void heapSort(int[] ar){
        buildMaxHeap(ar);
        for(int i = ar.length - 1; i >= 1; i--){
            swap(ar, i, 0);
            maxHeapify(ar, i, 0);
        }
    } 
}
