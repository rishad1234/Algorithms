
package intervalschedulingbasic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author rishad
 */
public class IntervalSchedulingBasic {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the number of elements: ");
        int elements = input.nextInt();
        
        System.out.println("Enter the starting time and finishing time one by one: ");
        ArrayList<Time> list = new ArrayList<>();
        
        for(int i = 0; i < elements; i++){
            list.add(new Time(input.nextInt(), -1));
            list.add(new Time(input.nextInt(), 1));
        }
        
        list.sort(new Comparator<Time>(){
            @Override
            public int compare(Time o1, Time o2) {
                if(o1.time == o2.time){
                    if(o1.status == -1){
                        return o1.status - o2.status;
                    }else{
                        return o2.status - o1.status;
                    }
                }
                return o1.time - o2.time;
            }
            
        });
        
        list.forEach((t) -> {
            System.out.println(t);
        });
        
        int temp = 0;
        int ans = 0;
        
        for(Time t : list){
            
            temp = temp - t.status;
            ans = Math.max(ans, temp);
        }
        
        System.out.println("ans is: " + ans);
    }
    
}

class Time{
    int time;
    int status;

    public Time(int time, int status) {
        this.time = time;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Time{" + "time=" + time + ", status=" + status + '}';
    }
    
}
