package Timer;

/**
 * Implementation of a Timer class that adds minutes to a given time.
 * I have also pushed my code to github @ https://github.com/leemichael831/AffiniPay_Timer
 * The test cases are located in TimerTest.java in the Test package
 */
public class Timer {
    /**
     * MAIN FUNCTION: addMinutes
     * Updates a given time when minutes are added
     * @param currentTime: a string representation of the current time
     * @param addedMinutes: signed integer that represents the minutes to be added
     * @return a string representation of the new, updated time
     */
    public static String addMinutes(String currentTime, int addedMinutes){
        //parsing the string of given time into 1) period string and 2) hour/minute ints
        String[] lst = currentTime.split(" ");
        String period = lst[1];
        int originalHour = Integer.parseInt(lst[0].split(":")[0]);
        int originalMinute = Integer.parseInt(lst[0].split(":")[1]);

        //needed later when checking if final minute < 10
        String addedZero = "";

        //converting added minutes to hours and finding remaining addedMinutes
        int addedHours = addedMinutes/60;
        addedMinutes %= 60;

        //accounting for case when original + added minutes overflows/underflows
        int newMinute = originalMinute + addedMinutes;
        addedHours = checkMinuteOverFlow(addedHours, newMinute)[0];
        newMinute = checkMinuteOverFlow(addedHours, newMinute)[1];

        //if newMinute < 10, add "0" in front of it for correct time string format
        if(newMinute < 10){
            addedZero = "0";
        }

        //adding addedHours to the given time's hour
        int newHour = originalHour + addedHours;

        //checking if we need to switch from "PM" to "AM" or vise versa
        String newPeriod = switchPeriod(newHour, originalHour, period);

        //accounting for cases when original + added hours overflows/underflows
        newHour = modifyNewHour(newHour);

        return newHour + ":" + addedZero + newMinute + " " + newPeriod;
    }

    /**
     * HELPER FUNCTION for addMinutes
     * Checks whether minute overflows (>60) or underflows (<0) and modifies accordingly
     * @param addedHours: the number of hours to be added to original hour
     * @param newMinute: original minute + added minutes
     * @return an array containing the modified number of addedHours and modified newMinute
     */
    public static int[] checkMinuteOverFlow(int addedHours, int newMinute){
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

        return new int[]{addedHours, newMinute};
    }

    /**
     * HELPER FUNCTION for addMinutes
     * Switches time from AM to PM or vise versa if needed
     * @param newHour: originalHour + addedHours
     * @param originalHour: the original given time's hour
     * @param period: the original given time's period (AM or PM)
     * @return period: a modified version of period (if not needed, return same period)
     */
    public static String switchPeriod(int newHour, int originalHour, String period){
        //finds the respective interval (period) of the new hour and the old hour
        int newHourInterval = Math.abs((int)(Math.floor((float)newHour/12)))%2;
        int originalHourInterval = (int)Math.floor((float)originalHour/12)%2;

        //if the interval (period) of the new hour and the old hour differs, switch period
        if(newHourInterval != originalHourInterval){
            if(period.equals("AM")){
                period = "PM";
            }
            else{
                period = "AM";
            }
        }

        return period;
    }

    /**
     * HELPER FUNCTION for addMinutes
     * Checks whether newHour overflows (>12) or underflows (<0) and modifies accordingly
     * @param newHour: originalHour + addedHours
     * @return newHour: a modified version of newHour (if not needed, return same newHour)
     */
    private static int modifyNewHour(int newHour){
        //if newHour is divisible by 12, set it equal to 12 instead of letting it be 0
        if(newHour % 12 == 0){
            newHour = 12;
        }
        //else, let it be the remainder from dividing by 12
        else {
            newHour %= 12;
        }

        //if newHour is still negative, add 12 hours to it to get correct time format
        if(newHour < 0){
            newHour += 12;
        }

        return newHour;
    }
}


