
package fcfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class FCFS {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        ArrayList<Process> processes = new ArrayList<>();
        ArrayList<Process> cProcesses = new ArrayList<>();
        double atat = 0;
        double awt = 0;
        
        System.out.println("Enter the number of processes: ");
        int numOfProcesses = input.nextInt();
        
        for(int i = 0; i < numOfProcesses; i++){
            processes.add(new Process(input.nextInt(), input.nextInt()));
        }
        
        for(Process p : processes){
            System.out.println(p.process + " " + p.cpuTime);
        }
        
        System.out.println("after sorting: ");
        for(Process p : processes){
            System.out.println(p.process + " " + p.cpuTime);
        }
        
        processes.get(0).startingTime = 0;
        processes.get(0).waitingTime = 0;
        processes.get(0).turnAroundTime = processes.get(0).cpuTime;
        
        cProcesses.add(processes.get(0));
        processes.remove(0);
        
        int temp = 0;
        while(!processes.isEmpty()){
            processes.get(0).startingTime = cProcesses.get(temp).turnAroundTime;
            processes.get(0).waitingTime = cProcesses.get(temp).turnAroundTime;
            processes.get(0).turnAroundTime = processes.get(0).cpuTime + processes.get(0).startingTime;
            
            cProcesses.add(processes.get(0));
            processes.remove(0);
            
            temp++;
        }
        
        System.out.println("gantt chart");
        for(int i = 0; i < cProcesses.size(); i++){
            System.out.println(cProcesses.get(i).process + " " + cProcesses.get(i).startingTime + " "
                + cProcesses.get(i).turnAroundTime + " " 
                   + cProcesses.get(i).waitingTime);
            
            atat += cProcesses.get(i).turnAroundTime;
            awt += cProcesses.get(i).waitingTime;
        }
       
        System.out.println("awt: " + (awt/cProcesses.size()));
        System.out.println("atat: " + (atat/cProcesses.size()));
        
    }
    
}
