/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundrobinarrivalzero;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class RoundRobinArrivalZero {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number of processes: ");
        int numOfProcesses = input.nextInt();
        
        ArrayList<Process> processes = new ArrayList<>();
        Queue<Integer> readyQueue = new LinkedList<>();
        
        System.out.println("Enter the processes: ");
        for(int i = 0; i < numOfProcesses; i++){
            int processName = input.nextInt();
            int cpuTime = input.nextInt();
            processes.add(new Process(processName, cpuTime));
            processes.get(i).turnArroundTime += cpuTime;
        }
        System.out.println("Enter time quantum: ");
        int timeQuantum = input.nextInt();
        
        
        for(int i = 0; i < processes.size(); i++){
            readyQueue.add(i);
        }
        
        int time = 0;
        int totalWaitingTime = 0;
        int totalTurnAroundTIme = 0;
        
        System.out.print(0);
        while(!readyQueue.isEmpty()){
            int runningProcessIndex = readyQueue.remove();
            
            if(processes.get(runningProcessIndex).cpuTime == 0){
                continue;
            }else if(processes.get(runningProcessIndex).cpuTime <= timeQuantum){
                processes.get(runningProcessIndex).waitingTime += time - processes.get(runningProcessIndex).arrivalTime;
                
                time += processes.get(runningProcessIndex).cpuTime;
                processes.get(runningProcessIndex).cpuTime = 0;
                
                processes.get(runningProcessIndex).arrivalTime = time;
                
            }else{
                processes.get(runningProcessIndex).waitingTime += time - processes.get(runningProcessIndex).arrivalTime;                

                time += timeQuantum;
                processes.get(runningProcessIndex).cpuTime -= timeQuantum;
                readyQueue.add(runningProcessIndex);
                
                processes.get(runningProcessIndex).arrivalTime = time;
            }
            
            System.out.print("------ " + processes.get(runningProcessIndex).processName + " ------" + time + " | ");
        }
        System.out.println("");
        for(int i = 0; i < numOfProcesses; i++){
            processes.get(i).turnArroundTime += processes.get(i).waitingTime;
            totalWaitingTime += processes.get(i).waitingTime;
            totalTurnAroundTIme += processes.get(i).turnArroundTime;
            
            System.out.println(processes.get(i).processName + " " + processes.get(i).waitingTime + " " + processes.get(i).turnArroundTime);
        }
        
        System.out.println("");
    }
    
}
