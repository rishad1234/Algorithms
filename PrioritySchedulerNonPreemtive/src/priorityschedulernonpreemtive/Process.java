
package priorityschedulernonpreemtive;

public class Process {
    int processName;
    int cpuTime;
    int priority;
    int waitingTime;
    int turnArroundTime;
    

    public Process(int processName, int cpuTime, int priority) {
        this.processName = processName;
        this.cpuTime = cpuTime;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
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
    
}
