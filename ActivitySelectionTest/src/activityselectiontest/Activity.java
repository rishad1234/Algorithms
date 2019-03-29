
package activityselectiontest;

public class Activity implements Comparable<Activity>{
    private int activityName;
    private int startTime;
    private int finishTime;

    public Activity(int activityName, int startTime, int finishTime) {
        this.activityName = activityName;
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    public int getActivityName() {
        return activityName;
    }

    public void setActivityName(int activityName) {
        this.activityName = activityName;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public int compareTo(Activity o) {
        return this.getFinishTime() - o.getFinishTime();
    }

    @Override
    public String toString() {
        return "Activity{" + "activityName=" + activityName + ", startTime=" + startTime + ", finishTime=" + finishTime + '}';
    }
}
