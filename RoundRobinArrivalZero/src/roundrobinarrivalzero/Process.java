/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roundrobinarrivalzero;

/**
 *
 * @author Admin
 */
public class Process {
    int processName;
    int cpuTime;
    int waitingTime;
    int turnArroundTime;
    int arrivalTime;

    public Process(int processName, int cpuTime) {
        this.processName = processName;
        this.cpuTime = cpuTime;
    }

    public int getProcessName() {
        return processName;
    }

    public void setProcessName(int processName) {
        this.processName = processName;
    }

    public int getCpuTime() {
        return cpuTime;
    }

    public void setCpuTime(int cpuTime) {
        this.cpuTime = cpuTime;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getTurnArroundTime() {
        return turnArroundTime;
    }

    public void setTurnArroundTime(int turnArroundTime) {
        this.turnArroundTime = turnArroundTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    
    
}
