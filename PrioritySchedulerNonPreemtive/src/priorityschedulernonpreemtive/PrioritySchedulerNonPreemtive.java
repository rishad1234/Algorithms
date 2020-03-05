
package priorityschedulernonpreemtive;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class PrioritySchedulerNonPreemtive {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number of processes: ");
        int numberOfProcesses = input.nextInt();
        
        ArrayList<Process> tempProcesses = new ArrayList<>();
        
        PriorityQueue<Process> processes = new PriorityQueue<>(new Comparator<Process>(){
            @Override
            public int compare(Process o1, Process o2) {
                return o1.priority > o2.priority ? 1 : -1;
            }
            
        });
        
        for(int i = 0; i < numberOfProcesses; i++){
            int processName = input.nextInt();
            int cpuTime = input.nextInt();
            int priority = input.nextInt();
            
            processes.add(new Process(processName, cpuTime, priority));
        }
        
        int time = 0;
        System.out.print(time);
        while(!processes.isEmpty()){
            Process p = processes.remove();
            
            p.waitingTime = time;
            time += p.cpuTime;
            p.turnArroundTime = p.cpuTime;
            
            tempProcesses.add(p);
            
            System.out.print("----- " + p.processName + " -----" + time + " |");
        }
    }
    
}
