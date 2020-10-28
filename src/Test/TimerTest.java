package Test;
import Timer.Timer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimerTest {
    /**
     * Tests addMinutes for a adding positive minutes
     */
    @Test
    void testAddPositive() {
        assertEquals("12:33 PM", Timer.addMinutes("9:13 AM", 200));
    }

    /**
     * Tests addMinutes for result to be 1:33 PM and not 13:33 PM
     */
    @Test
    void testCorrectFormat1() {
        assertEquals("1:33 PM", Timer.addMinutes("10:13 AM", 200));
    }

    /**
     * Tests addMinutes for subtracting minutes from a time
     */
    @Test
    void testAddNegative() {
        assertEquals("6:53 AM", Timer.addMinutes("10:13 AM", -200));
    }

    /**
     * Tests that addMinutes does not change the given time when 0 minutes is added
     */
    @Test
    void testAddZero() {
        assertEquals("12:00 AM", Timer.addMinutes("12:00 AM", 0));
    }

    /**
     * Tests that adding 12 hours to a given time changes the period
     */
    @Test
    void testChangePeriod1() {
        assertEquals("12:00 PM", Timer.addMinutes("12:00 AM", 720));//AM to PM);
    }

    /**
     * Tests that subtracting 12 hours to a given time changes the period
     */
    @Test
    void testChangePeriod2() {
        assertEquals("12:00 PM", Timer.addMinutes("12:00 AM", -720));//AM to PM);
    }

    /**
     * Tests that adding 24 hours to a given time does not change the period nor the time
     */
    @Test
    void testNoChangePeriod1() {
        assertEquals("12:00 AM", Timer.addMinutes("12:00 AM", 1440));//AM to PM);
    }

    /**
     * Tests that subtracting 24 hours to a given time does not change the period nor the time
     */
    @Test
    void testNoChangePeriod2() {
        assertEquals("12:00 AM", Timer.addMinutes("12:00 AM", -1440));//AM to PM);
    }

    /**
     * Test subtracting minutes from midnight will result in going from AM to PM
     */
    @Test
    void testChangePeriod3() {
        assertEquals("8:40 PM", Timer.addMinutes("12:00 AM", -200));//AM to PM);
    }

    /**
     * Tests that period changes when going from before noon to after noon
     */
    @Test
    void testAfterNoon() {
        assertEquals("11:50 AM", Timer.addMinutes("1:00 PM", -70));//AM to PM);
    }

    /**
     * Tests that period changes when going from before midnight to after midnight
     */
    @Test
    void testAfterMidnight() {
        assertEquals("12:10 AM", Timer.addMinutes("11:00 PM", 70));//AM to PM);
    }

    /**
     * Tests that period does not change when going from midnight to a time before noon
     */
    @Test
    void testAfterMidnight2() {
        assertEquals("12:00 AM", Timer.addMinutes("1:00 AM", -60));//AM to PM);
    }

    /**
     * Tests that period changes when going from before midnight to midnight
     */
    @Test
    void testMidnight3() {
        assertEquals("12:00 AM", Timer.addMinutes("11:00 PM", 60));//AM to PM);
    }

    /**
     * Tests that period changes when going from midnight to before midnight
     */
    @Test
    void testMidnight4() {
        assertEquals("12:00 AM", Timer.addMinutes("11:00 PM", 60));//AM to PM);
    }

    /**
     * Tests that the correct time format for minutes is returned (12:01 AM not 12:1 AM)
     */
    @Test
    void testCorrectFormat3() {
        assertEquals("12:01 AM", Timer.addMinutes("11:02 PM", 59));//AM to PM);
    }
}
