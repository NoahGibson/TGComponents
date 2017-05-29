package teamgobu.test.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import teamgobu.components.Date.Date;

/**
 *
 * @author 135no
 *
 */
//TODO - Add documentation
public abstract class DateTest {

    /**
     * Invokes the appropriate {@code Date} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new Date
     */
    protected abstract Date constructorTest();

    /**
     * Invokes the appropriate {@code Date} string constructor for the
     * implementation under test and returns the result.
     *
     * @param dateString
     *            the string to construct the date from
     * @return the new date
     */
    protected abstract Date constructorStringTest(String dateString);

    /**
     * Invokes the appropriate {@code Date} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new Date
     */
    protected abstract Date constructorRef();

    /*
     * Sample strings for test cases--------------------------------------------
     */

    /**
     * String for a sample date.
     */
    private final String dateString = "1997/5/13/8/11/true";

    /**
     * String for another sample date.
     */
    private final String dateString2 = "1997/5/13/8/10/true";

    /**
     * String for an incomplete sample date.
     */
    private final String dateStringIncomplete = "MISSING ASPECT VALUE/5/13/8/11/true";

    /*
     * Test cases---------------------------------------------------------------
     */
    @Test
    public final void testStringConstructorComplete() {
        Date test = this.constructorStringTest(this.dateString);
        assertEquals(1997, test.year());
        assertEquals(5, test.month());
        assertEquals(13, test.day());
        assertEquals(8, test.hour());
        assertEquals(11, test.minute());
        assertTrue(test.am());
    }

    @Test
    public final void testStringConstructorIncomplete() {
        Date test = this.constructorStringTest(this.dateStringIncomplete);
        assertEquals(5, test.month());
        assertEquals(13, test.day());
        assertEquals(8, test.hour());
        assertEquals(11, test.minute());
        assertTrue(test.am());
        assertTrue(!test.isSet(Date.DateAspect.YEAR));
    }

    /*
     * Test cases for setting and then retrieving aspects of date
     */
    @Test
    public final void testSetYearAndYear() {
        Date test = this.constructorTest();
        test.setYear(2017);
        int result = test.year();
        assertEquals(2017, result);
    }

    @Test
    public final void testSetMonthAndMonth() {
        Date test = this.constructorTest();
        test.setMonth(5);
        int result = test.month();
        assertEquals(5, result);
    }

    @Test
    public final void testSetDayAndDay() {
        Date test = this.constructorTest();
        test.setDay(13);
        int result = test.day();
        assertEquals(13, result);
    }

    @Test
    public final void testSetHourAndHour() {
        Date test = this.constructorTest();
        test.setHour(8);
        int result = test.hour();
        assertEquals(8, result);
    }

    @Test
    public final void testSetMinuteAndMinute() {
        Date test = this.constructorTest();
        test.setMinute(11);
        int result = test.minute();
        assertEquals(11, result);
    }

    @Test
    public final void testSetAmAndAm() {
        Date test = this.constructorTest();
        test.setAm(true);
        boolean result = test.am();
        assertTrue(result);
    }

    /*
     * Test for isSet method
     */
    @Test
    public final void testIsSetTrueUsingSet() {
        Date test = this.constructorTest();
        test.setMonth(7);
        assertTrue(test.isSet(Date.DateAspect.MONTH));
    }

    @Test
    public final void testIsSetTrueUsingStringConstructor() {
        Date test = this.constructorStringTest(this.dateString);
        assertTrue(test.isSet(Date.DateAspect.DAY));
    }

    @Test
    public final void testIsSetFalse() {
        Date test = this.constructorTest();
        test.setMinute(58);
        assertTrue(!test.isSet(Date.DateAspect.HOUR));
    }

    @Test
    public final void testIsSetAm() {
        Date test = this.constructorTest();
        test.setAm(false);
        assertTrue(test.isSet(Date.DateAspect.AM));
    }

    /*
     * Test for toString method
     */
    @Test
    public final void testToStringComplete() {
        Date test = this.constructorStringTest(this.dateString);
        assertEquals(this.dateString, test.toString());
    }

    @Test
    public final void testToStringIncomplete() {
        Date test = this.constructorTest();
        test.setMonth(5);
        test.setDay(13);
        test.setHour(8);
        test.setMinute(11);
        test.setAm(true);
        assertEquals(this.dateStringIncomplete, test.toString());
    }

    /*
     * Test for equals method
     */
    @Test
    public final void testEqualsTrueStringConstructor() {
        Date test1 = this.constructorStringTest(this.dateString);
        Date test2 = this.constructorStringTest(this.dateString);
        assertTrue(test1.equals(test2));
    }

    @Test
    public final void testEqualsFalseStringConstructor() {
        Date test1 = this.constructorStringTest(this.dateString);
        Date test2 = this.constructorStringTest(this.dateString2);
        assertTrue(!test1.equals(test2));
    }

    @Test
    public final void testEqualsTrueSetting() {
        Date test1 = this.constructorTest();
        Date test2 = this.constructorTest();
        test1.setYear(2017);
        test2.setYear(2017);
        assertTrue(test1.equals(test2));
    }

    @Test
    public final void testEqualsFalseSetting() {
        Date test1 = this.constructorTest();
        Date test2 = this.constructorTest();
        test1.setYear(2017);
        test2.setYear(2016);
        assertTrue(!test1.equals(test2));
    }

    @Test
    public final void testEqualsBothEmpty() {
        Date test1 = this.constructorTest();
        Date test2 = this.constructorTest();
        assertTrue(test1.equals(test2));
    }

    /*
     * Test for transferFrom
     */
    @Test
    public final void testTransferFrom() {
        Date test1 = this.constructorStringTest(this.dateString);
        Date test2 = this.constructorStringTest(this.dateString);
        Date test3 = this.constructorTest();
        Date test4 = this.constructorTest();
        test4.transferFrom(test2);
        assertEquals(test1, test4);
        assertEquals(test2, test3);
    }

    /*
     * Test for clear
     */
    @Test
    public final void testClear() {
        Date test1 = this.constructorStringTest(this.dateString);
        Date test2 = this.constructorTest();
        test1.clear();
        assertEquals(test2, test1);
    }
}
