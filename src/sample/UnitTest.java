package sample;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Random;
import java.time.LocalDateTime;


public class UnitTest {
    @Test
    public void testHour(){
        LocalDateTime rightnow = LocalDateTime.now();
        int a = rightnow.getHour();
        int b = rightnow.getMinute();
        int c = rightnow.getSecond();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    @Test
    public void testMe(){
        Opponent Eric = new Opponent(100);
        Eric.goToSleep(3, 2, 5, 21); //whatever times
        int after = Eric.getElapsedTime();
        System.out.println(after);
    }

    /*Tests for 1 o clock*/
    @Test
    public void testGoToSleep(){
        Opponent William = new Opponent(50); //20 to 23
        William.goToSleep(21, 30, 5, 21);
        int after = William.getElapsedTime();
        assertEquals(after, -210);

        Opponent Helen  = new Opponent(40); //0 to 5
        Helen.goToSleep(3, 0, 5, 21);
        int after2 = Helen.getElapsedTime();
        assertEquals(after2, 120);

        Opponent Dan  = new Opponent(40); //5 to 20
        Dan.goToSleep(5, 0, 5, 21); //try 20 o clock later too
        int after3 = Dan.getElapsedTime();
        assertEquals(after3, 0);
    }

    @Test
    public void testGoToSleep2() { //10:30pm bedtime
        Opponent guy = new Opponent(50);
        guy.goToSleep(23, 35, 5, 21);
        int after = guy.getElapsedTime();
        assertEquals(after, 65);

        Opponent guy2 = new Opponent(50);
        guy2.goToSleep(23, 25,5, 21);
        int after2 = guy2.getElapsedTime();
        assertEquals(after2, 55);

        Opponent guy3 = new Opponent(50);
        guy3.goToSleep(21, 25,5, 21);
        int after3 = guy3.getElapsedTime();
        assertEquals(after3, -65);

        Opponent guy4 = new Opponent(50);
        guy4.goToSleep(3, 30,5,21);
        int after4 = guy4.getElapsedTime();
        assertEquals(after4, 300);
    }
    @Test
    public void testWillSleepEarly(){
        Opponent Ryota = new Opponent(100);
        for(int i=0; i<100; i++){
            System.out.println(Ryota.willSleepEarly());
        }
    }
    @Test
    public void testPrintBoard(){

    }
}
