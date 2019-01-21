
package heapsorttest;

public class HeapSortTest {

    public static void main(String[] args) {
        int[] heapArray = new int[5];
        for(int i = 0; i < 5; i++){
            heapArray[i] = (int) (Math.random() * 1000);
        }
        
        heapSortDesc(heapArray);
        
        for(int i = 0; i < 5; i++){
            System.out.println(heapArray[i]);
        }
    }
    
    public static int leftChild(int i){
        return 2 * i + 1;
    }
    
    public static int rightChild(int i){
        return 2 * i + 2;
    }
    
    public static void maxHeapify(int[] heapArray, int length, int i){
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
            maxHeapify(heapArray, length, largest);
        }
    }
    
    public static void minHeapify(int[] heapArray, int length, int i){
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;
        
        if(left < length && heapArray[left] < heapArray[smallest]){
            smallest = left;
        }
        
        if(right < length && heapArray[right] < heapArray[smallest]){
            smallest = right;
        }
        
        if(smallest != i){
            swap(heapArray, i, smallest);
            minHeapify(heapArray, length, smallest);
        }
    }
    
    public static void swap(int[] a, int i,  int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static void buildMaxHeap(int[] heapArray){
        int length = heapArray.length;
        for(int i = (length / 2) - 1; i >= 0; i--){
            maxHeapify(heapArray, length, i);
        }
    }
    
    public static void buildMinHeap(int[] heapArray){
        int length = heapArray.length;
        for(int i = (length / 2) - 1; i >= 0; i--){
            minHeapify(heapArray, length, i);
        }
    }
    
    public static void heapSortAsc(int[] heapArray){
        buildMaxHeap(heapArray);
        
        for(int i = heapArray.length - 1; i >= 0; i--){
            swap(heapArray, i, 0);
            maxHeapify(heapArray, i, 0);
        }
    }
    
    public static void heapSortDesc(int[] heapArray){
        buildMinHeap(heapArray);
        
        for(int i = heapArray.length - 1; i >= 0; i--){
            swap(heapArray, i, 0);
            minHeapify(heapArray, i, 0);
        }
    }
}
