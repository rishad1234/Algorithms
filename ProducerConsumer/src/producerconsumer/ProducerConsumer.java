
package producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    public static Queue<Integer> buffer = new LinkedList<>();
    public static final int BUFFERSIZE = 10;
    public static void main(String[] args) {
        Thread producer = new Thread(new Producer(1));
        Thread producer1 = new Thread(new Producer(2));
        Thread consumer = new Thread(new Consumer(1));
        Thread consumer1 = new Thread(new Consumer(2));
        
        producer.start();
        producer1.start();
        consumer.start();
        consumer1.start();
    }
    
}
