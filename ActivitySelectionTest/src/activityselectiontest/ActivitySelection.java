
package activityselectiontest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class ActivitySelection {
    private List<Activity> activities;
    private List<Activity> selectedActivities;

    public ActivitySelection() {
        this.activities = new ArrayList<>();
        this.selectedActivities = new ArrayList<>();
    }
    
    public void addActivity(Activity activity){
        this.activities.add(activity);
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public List<Activity> getSelectedActivity() {
        return selectedActivities;
    }

    public void setSelectedActivity(List<Activity> selectedActivities) {
        this.selectedActivities = selectedActivities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
    
    public void calculateActivity(){
        Collections.sort(activities);
        int length = this.activities.size();
        selectedActivities.add(activities.get(0));
        Activity temp = activities.get(0);
        for(int i = 1; i < length; i++){
            if(activities.get(i).getStartTime() >= temp.getFinishTime()){
                selectedActivities.add(activities.get(i));
                temp = activities.get(i);
            }
        }
    }
    
    public int numberOfResults(){
        return selectedActivities.size();
    }
    
}
