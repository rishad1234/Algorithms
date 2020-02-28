/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sjf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author student
 */
public class SJF {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        ArrayList<Process> processes = new ArrayList<>();
        ArrayList<Process> cprocesses = new ArrayList<>();
        double atat = 0;
        double awt = 0;
        
        System.out.println("process num: ");
        int numP = input.nextInt();
        
        for(int i = 0; i < numP; i++){
            int pName = input.nextInt();
            int cpuTime = input.nextInt();
            
            processes.add(new Process(String.valueOf(pName), cpuTime));
        }
        
        processes.get(0).startingTime = 0;
        processes.get(0).endingTime = processes.get(0).cpuTime;
        processes.get(0).wTime = 0;
        
        cprocesses.add(processes.get(0));
        processes.remove(0);
        
        int temp = 0;
        while(!processes.isEmpty()){
            
            Collections.sort(processes, new Comparator<Process>(){
                @Override
                public int compare(Process t, Process t1) {
                    return t.cpuTime > t1.cpuTime ? 1 : 0;
                }
            });
            
            processes.get(0).startingTime = cprocesses.get(temp).endingTime;
            processes.get(0).endingTime = processes.get(0).cpuTime + processes.get(0).startingTime;
            processes.get(0).wTime = cprocesses.get(temp).endingTime;

            cprocesses.add(processes.get(0));
            processes.remove(0);
            temp++;
        }
        
        System.out.println("gantt chart");
        for(int i = 0; i < cprocesses.size(); i++){
            System.out.println(cprocesses.get(i).process + " " + cprocesses.get(i).startingTime + " "
                + cprocesses.get(i).endingTime + " " 
                    + cprocesses.get(i).endingTime + " " + cprocesses.get(i).wTime);
            
            atat += cprocesses.get(i).endingTime;
            awt += cprocesses.get(i).wTime;
        }
       
        System.out.println("awt: " + (awt/cprocesses.size()));
        System.out.println("atat: " + (atat/cprocesses.size()));
       
    }
    
}
