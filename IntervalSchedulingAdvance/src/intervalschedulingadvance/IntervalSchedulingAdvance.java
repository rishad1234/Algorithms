
package intervalschedulingadvance;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author rishad
 */
public class IntervalSchedulingAdvance {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number of jobs: ");
        int jobs = input.nextInt();
        
        System.out.println("Enter the start time and end time one by one: ");
        ArrayList<Job> list = new ArrayList<>();
        
        for(int i = 0; i < jobs; i++){
            list.add(new Job(input.nextInt(), input.nextInt()));
        }
        
        list.sort(new Comparator<Job>(){
            @Override
            public int compare(Job o1, Job o2) {
                if(o1.startTime == o2.startTime){
                    return o1.endTime - o2.endTime;
                }
                return o1.startTime - o2.startTime;
            }
            
        });
        
        list.forEach((t)->{
            System.out.println(t);
        });
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(list.get(0).endTime);
        
        for(int i = 1; i < jobs; i++){
            
            int top = queue.peek();
            
            if(list.get(i).startTime <= top){
                queue.add(list.get(i).endTime);
            }else{
                queue.remove();
                queue.add(list.get(i).endTime);
            }
        }
        
        System.out.println("ans is: " + queue.size());
        
    }
    
}

class Job{
    int startTime;
    int endTime;

    public Job(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Job{" + "startTime=" + startTime + ", endTime=" + endTime + '}';
    }
    
}