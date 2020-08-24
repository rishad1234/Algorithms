
package producerconsumer;

public class Producer implements Runnable{
 
    
    private int producerNumber;

    public Producer(int producerNumber) {
        this.producerNumber = producerNumber;
    }
    
    @Override
    public void run() {
        try{
            while(true){
                synchronized(ProducerConsumer.buffer){
                    while(ProducerConsumer.buffer.size() == ProducerConsumer.BUFFERSIZE){
                        ProducerConsumer.buffer.wait();
                    }
                }
                synchronized(ProducerConsumer.buffer){
                    int randomNumber = (int) (Math.random() * (400 - 10 + 1) + 10) ;
                    System.out.println("Producer" + producerNumber + " has created a product named " + randomNumber);
                    System.out.println("Empty: " + (ProducerConsumer.BUFFERSIZE - ProducerConsumer.buffer.size()));
                    ProducerConsumer.buffer.add(randomNumber);
                    ProducerConsumer.buffer.notifyAll();
                    Thread.sleep(500); 
                }                  
            }
        }catch(Exception e){
            System.out.println("Producer has been interrepted");
        }   
    }
}
