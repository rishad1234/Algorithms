
package activityselectiontest;

import java.util.Scanner;

public class ActivitySelectionTest {
    public static void main(String[] args) {
        ActivitySelection activitySelection = new ActivitySelection();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of activities: ");
        int numberOfActivities = input.nextInt();
        for(int i = 0; i < numberOfActivities; i++){
            int activityName = input.nextInt();
            int startTime = input.nextInt();
            int finishTime = input.nextInt();
            
            activitySelection.addActivity(new Activity(activityName, startTime, finishTime));
        }
        
        activitySelection.calculateActivity();
        System.out.println(activitySelection.numberOfResults());
        System.out.println("Sorted List: ");
        
        for(Activity activity : activitySelection.getActivities()){
            System.out.println(activity);
        }
        
        System.out.println("Activity List");
        for(Activity activity : activitySelection.getSelectedActivity()){
            System.out.println(activity);
        }
    }
}
/*
1 1 3
2 0 4
3 1 2
4 4 6
5 2 9
6 5 8
7 3 5
8 4 5
ans 3
*/