
package activityselection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ActivitySelection {

    static List<Activity> activities = new ArrayList<>();
    static List<Activity> selectedActivities = new ArrayList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of activities: ");
        int numberOfActivities = input.nextInt();
        for(int i = 0; i < numberOfActivities; i++){
            input.nextInt();
            int startTime = input.nextInt();
            int finishTime = input.nextInt();
            
            activities.add(new Activity(startTime, finishTime));
        }
        
        calculateActivity();
        System.out.println("total selected activities: " + selectedActivities.size());
        System.out.println("Selected activities: ");
        for(Activity activity : selectedActivities){
            System.out.println(activity.startTime + " " + activity.finishTime);
        }
    }
    
    public static void calculateActivity(){
        Collections.sort(activities);
        int length = activities.size();
        selectedActivities.add(activities.get(0));
        Activity temp = activities.get(0);
        for(int i = 1; i < length; i++){
            if(activities.get(i).startTime >= temp.finishTime){
                selectedActivities.add(activities.get(i));
                temp = activities.get(i);
            }
        }
    }
}

class Activity implements Comparable<Activity>{
    int startTime;
    int finishTime;

    public Activity(int startTime, int finishTime) {
        this.startTime = startTime;
        this.finishTime = finishTime;
    }

    @Override
    public int compareTo(Activity o) {
        if(this.finishTime != o.finishTime){
            return this.finishTime - o.finishTime;
        }else if(this.startTime != o.startTime){
            return this.startTime - o.startTime;
        }else{
            return this.finishTime - o.finishTime;
        }
    }
}
