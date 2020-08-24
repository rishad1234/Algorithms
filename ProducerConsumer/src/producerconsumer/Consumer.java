
package producerconsumer;

public class Consumer implements Runnable{

    private int consumerNumber;

    public Consumer(int consumerNumber) {
        this.consumerNumber = consumerNumber;
    }
    
    @Override
    public void run() {
        try{
            while(true){
                synchronized(ProducerConsumer.buffer){
                    while(ProducerConsumer.buffer.isEmpty()){
                        ProducerConsumer.buffer.wait();
                    } 
                }
                synchronized(ProducerConsumer.buffer){
                    int consumed = ProducerConsumer.buffer.remove();
                    System.out.println("Consumer" + consumerNumber + " has consumed " + consumed);
                    System.out.println("Empty: " + (ProducerConsumer.BUFFERSIZE - ProducerConsumer.buffer.size()));
                    ProducerConsumer.buffer.notifyAll();
                    Thread.sleep(500);
                }
            }
        }catch(Exception e){
            System.out.println("Consumer has been interrepted");
        }
    }
}
