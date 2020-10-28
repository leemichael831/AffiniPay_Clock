package Test;
import Timer.Timer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TimerTest {
    /**
     * Tests getValue() on an empty string.
     */
    @Test
    void testAddPositive() {
        assertEquals("12:33 PM", Timer.addMinutes("9:13 AM", 200));
    }

    /**
     * Tests getValue() on an empty string.
     */
    @Test
    void testAddPositive2() {
        assertEquals("1:33 PM", Timer.addMinutes("10:13 AM", 200));//AM to PM);
    }

    /**
     * Tests getValue() on an empty string.
     */
    @Test
    void testAddPositive3() {
        assertEquals("6:53 AM", Timer.addMinutes("10:13 AM", -200));//AM to PM);
    }

    /**
     * Tests getValue() on an empty string.
     */
    @Test
    void testAddPositive4() {
        assertEquals("12:00 AM", Timer.addMinutes("12:00 AM", 0));//AM to PM);
    }

    /**
     * Tests getValue() on an empty string.
     */
    @Test
    void testAddPositive5() {
        assertEquals("12:00 PM", Timer.addMinutes("12:00 AM", 720));//AM to PM);
    }

    /**
     * Tests getValue() on an empty string.
     */
    @Test
    void testAddPositive5_2() {
        assertEquals("12:00 PM", Timer.addMinutes("12:00 AM", -720));//AM to PM);
    }

    /**
     * Tests getValue() on an empty string.
     */
    @Test
    void testAddPositive5_3() {
        assertEquals("12:00 AM", Timer.addMinutes("12:00 AM", 1440));//AM to PM);
    }

    /**
     * Tests getValue() on an empty string.
     */
    @Test
    void testAddPositive5_4() {
        assertEquals("12:00 AM", Timer.addMinutes("12:00 AM", -1440));//AM to PM);
    }

    /**
     * Tests getValue() on an empty string.
     */
    @Test
    void testAddPositive6() {
        assertEquals("8:40 PM", Timer.addMinutes("12:00 AM", -200));//AM to PM);
    }

    /**
     * Tests getValue() on an empty string.
     */
    @Test
    void testAddPositive7() {
        assertEquals("11:50 AM", Timer.addMinutes("1:00 PM", -70));//AM to PM);
    }

    /**
     * Tests getValue() on an empty string.
     */
    @Test
    void testAddPositive8() {
        assertEquals("12:10 PM", Timer.addMinutes("11:00 AM", 70));//AM to PM);
    }

    /**
     * Tests getValue() on an empty string.
     */
    @Test
    void testAddPositive9() {
        assertEquals("12:10 AM", Timer.addMinutes("11:00 PM", 70));//AM to PM);
    }

    /**
     * Tests getValue() on an empty string.
     */
    @Test
    void testAddPositive10() {
        assertEquals("12:00 AM", Timer.addMinutes("1:00 AM", -60));//AM to PM);
    }

    /**
     * Tests getValue() on an empty string.
     */
    @Test
    void testAddPositive11() {
        assertEquals("11:59 PM", Timer.addMinutes("1:00 AM", -61));//AM to PM);
    }

    /**
     * Tests getValue() on an empty string.
     */
    @Test
    void testAddPositive12() {
        assertEquals("11:59 PM", Timer.addMinutes("11:00 PM", 59));//AM to PM);
    }

    /**
     * Tests getValue() on an empty string.
     */
    @Test
    void testAddPositive13() {
        assertEquals("12:00 AM", Timer.addMinutes("11:00 PM", 60));//AM to PM);
    }

    /**
     * Tests getValue() on an empty string.
     */
    @Test
    void testAddPositive14() {
        assertEquals("12:00 AM", Timer.addMinutes("11:00 PM", 60));//AM to PM);
    }

    /**
     * Tests getValue() on an empty string.
     */
    @Test
    void testAddPositive15() {
        assertEquals("12:01 AM", Timer.addMinutes("11:02 PM", 59));//AM to PM);
    }

}
