/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sjf;

/**
 *
 * @author student
 */
public class Process {
    public String process;
    public int cpuTime;
    public int startingTime;
    public int endingTime;
    public int taTime;
    public int wTime;

    public int getTaTime() {
        return taTime;
    }

    public void setTaTime(int taTime) {
        this.taTime = taTime;
    }

    public int getwTime() {
        return wTime;
    }

    public void setwTime(int wTime) {
        this.wTime = wTime;
    }
    
    public int getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(int endingTime) {
        this.endingTime = endingTime;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public int getCpuTime() {
        return cpuTime;
    }

    public void setCpuTime(int cpuTime) {
        this.cpuTime = cpuTime;
    }

    public int getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(int startingTime) {
        this.startingTime = startingTime;
    }

    public Process(String process, int cpuTime) {
        this.process = process;
        this.cpuTime = cpuTime;
    }  
}
