package sample;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Random;

public class Opponent implements Serializable{
    public static int BedTimeHour = 1;
    public static int BedTimeMin = 00;
    private int skill;
    private int elapsedTime;

    public Opponent(int skill){
        this.skill = skill;
        this.elapsedTime = 0;
    }

    public int getSkill(){
        return this.skill;
    }
    public int getElapsedTime(){
        return this.elapsedTime;
    }
    public void setSkill(int a){
        this.skill = a;
    }
    public void setElapsedTime(int a){
        this.elapsedTime = a;
    }
    /** go to sleep adds time to an opponent's elapsedTime variable based on the current time
     * bound1 - ie. 5AM
     * bound2 - ie. 9PM (21)*/
    public void goToSleep(int currHour, int currMin, int bound1, int bound2){
        LocalDateTime rightNow = LocalDateTime.now();
        int accumHour = 0;
        int accumMin = 0;
        int a = currHour; //rightNow.getHour();
        int b = currMin; //rightNow.getMinute();
        if(a >= bound1 && a < bound2){
            System.out.println("Not a valid bed time");
        }
        else if(a >= bound2 && a <= 23){ //21 will eventually be a variable
            if (BedTimeHour >= 0 && BedTimeHour < bound1) { //case 1 (only negative)
                accumHour += -((23 - a) + BedTimeHour);
                accumMin += -((60 - b) + BedTimeMin);
            }
            else if(Math.abs(BedTimeHour - a) == 1) {// case 2 (variable)
                if(a > BedTimeHour){
                    accumMin += (60 - BedTimeMin) + b;
                } else {
                    accumMin += -(BedTimeMin + (60 - b));
                }
            }
            else { //also part of case 2
                accumHour += a - BedTimeHour;
                accumMin += b - BedTimeMin;
            }
        }
        else{ //midnight to 4:59AM
            if (BedTimeHour >= bound2 && BedTimeHour <= 23) { //case 3 (only positive)
                accumHour += (23 - BedTimeHour) + a;
                accumMin += (60 - BedTimeMin) + b;
            }
            else if(Math.abs(BedTimeHour - a) == 1) {// case 4 (variable)
                if(a > BedTimeHour){
                    accumMin += (60 - BedTimeMin) + b;
                } else {
                    accumMin += -(BedTimeMin + (60 - b));
                }
            }
            else { //also part of case 4
                accumHour += a - BedTimeHour;
                accumMin += b - BedTimeMin;
            }
        }
        this.elapsedTime = this.elapsedTime + accumMin + (60 * accumHour);
    }

    public boolean willSleepEarly(){
        Random rand = new Random();
        int random = rand.nextInt(111) + 1;
        if(random > this.skill) {
            return false;
        }
        return true;
    }
}
