package Timer;
import java.util.*;

/**
 * Implementation of an object that adds minutes to a given time
 */
public class Timer {
    /**
     * Updates a given time when minutes are added
     * @param currentTime: a string representation of the current time
     * @param addedMinutes: signed integer that represents the minutes to be added
     * @return a string representation of the new, updated time
     */
    public static String addMinutes(String currentTime, int addedMinutes){
        String[] lst = currentTime.split(" ");
        String period = lst[1];
        int originalHour = Integer.parseInt(lst[0].split(":")[0]);
        int originalMinute = Integer.parseInt(lst[0].split(":")[1]);

        String addedZero = "";
        boolean changePeriod = false;

        int addedHours;

        //converting minutes to hours
        addedHours = (int)(addedMinutes/60);
        addedMinutes %= 60;

        //looking at minutes now
        int newMinute = originalMinute + addedMinutes;

        //if the total final minute overflow > 1 hour
        if(newMinute >= 60){
            addedHours++;
            newMinute -= 60;
        }
        //if the total final minute is negative
        else if(newMinute < 0) {
            addedHours--;
            newMinute += 60;
        }
        if(newMinute < 10){
            addedZero = "0";
        }

        //looking at hours now
        int newHour = originalHour + addedHours;
        System.out.println(newHour);
        if(Math.abs((int)(Math.floor((float)newHour/12)))%2 != (int)Math.floor((float)originalHour/12)%2){
            changePeriod = true;
        }
        if(newHour % 12 == 0){
            newHour = 12;
        }
        else {
            newHour %= 12;
        }

        if(newHour < 0){
            newHour += 12;
        }


//        else if(newHour == 12 && originalHour < 12){//we don't want to mod
//            changePeriod = true;
//        }
//        else if(newHour < 12 && originalHour >= 12){
//            changePeriod = true;
//        }

        if(changePeriod){
            if(period.equals("AM")){
                period = "PM";
            }
            else{
                period = "AM";
            }
        }

        return newHour + ":" + addedZero + newMinute + " " + period;
    }
}


