
package roundrobin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class RoundRobin {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number of processes: ");
        int numberOfprocesses = input.nextInt();
        
        ArrayList<Process> processes = new ArrayList<>();
        
        System.out.println("Enter the processes one by one: ");
        for(int i = 0; i < numberOfprocesses; i++){
            processes.add(new Process(input.nextInt(), input.nextInt(), input.nextInt()));
        }
        
        ArrayList<Process> tempProcesses = new ArrayList<>();
        
        tempProcesses.addAll(processes);
        
        Collections.sort(tempProcesses, new Comparator<Process>(){
            @Override
            public int compare(Process o1, Process o2) {
                return o1.arrivalTime > o2.arrivalTime ? 1 : -1;
            }
            
        });
        
        System.out.println("Enter time quantum");
        int timeQuantum = input.nextInt();

//        test purpose
//        for(Process p : tempProcesses){
//            System.out.println(p.arrivalTime + " " + p.burstTime + " " + p.processName);
//        }

        Queue<Integer> readyQueue = new LinkedList<>();
        ArrayList<Process> running = new ArrayList<>();
        
        readyQueue.add(0);
        
        int totalTime = 0;
        while(!readyQueue.isEmpty()){

            int runningProcessIndex = readyQueue.remove();
            
            if(tempProcesses.get(runningProcessIndex).burstTime <= timeQuantum){
                totalTime += tempProcesses.get(runningProcessIndex).burstTime;
                tempProcesses.get(runningProcessIndex).burstTime = 0;
                tempProcesses.get(runningProcessIndex).isFinished = true;
            }else{
                totalTime += timeQuantum;
                tempProcesses.get(runningProcessIndex).burstTime -= timeQuantum;
                tempProcesses.get(runningProcessIndex).isRunning = true;
            }
            
            //running.add(tempProcesses.get(runningProcessIndex));
            
            
            System.out.println(tempProcesses.get(runningProcessIndex).processName + " " + tempProcesses.get(runningProcessIndex).arrivalTime + " " 
                    + tempProcesses.get(runningProcessIndex).burstTime + " " + totalTime);
           
            
            for(int i = 0; i < numberOfprocesses; i++){
                if(tempProcesses.get(i).arrivalTime <= totalTime && !tempProcesses.get(i).isFinished && !tempProcesses.get(i).isRunning){
                    readyQueue.add(i);
                }
            }
            
            if(tempProcesses.get(runningProcessIndex).burstTime > 0){
                readyQueue.add(tempProcesses.indexOf(tempProcesses.get(runningProcessIndex)));
            }
        }
        
//        for(Process r : running){
//            System.out.println(r.processName + " " + r.arrivalTime + " " + r.burstTime);
//        }
//        
        
    }
    
}
