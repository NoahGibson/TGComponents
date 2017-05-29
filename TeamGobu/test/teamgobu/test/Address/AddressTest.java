package teamgobu.test.Address;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import teamgobu.components.Address.Address;

/**
 *
 * @author 135no
 *
 */
//TODO - Add documentation
public abstract class AddressTest {

    /**
     * Invokes the appropriate {@code Address} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new address
     */
    protected abstract Address constructorTest();

    /**
     * Invokes the appropriate {@code Address} string constructor for the
     * implementation under test and returns the result.
     *
     * @param addressString
     *            the string to construct the address from
     * @return the new address
     */
    protected abstract Address constructorStringTest(String addressString);

    /**
     * Invokes the appropriate {@code Address} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new address
     */
    protected abstract Address constructorRef();

    /*
     * Sample strings for test cases--------------------------------------------
     */

    /**
     * String for a sample address.
     */
    private final String addressString = "Ohio/Columbus/43210/"
            + "136 West Woodruff Ave./Room 216/40.004128/-83.012633";

    /**
     * String for another sample address.
     */
    private final String addressString2 = "Ohio/Columbus/43210/"
            + "137 West Woodruff Ave./Room 216/40.004128/-83.012633";

    /**
     * String for an incomplete sample address.
     */
    private final String addressStringIncomplete = "Ohio/Columbus/"
            + "MISSING ASPECT VALUE/136 West Woodruff Ave./"
            + "MISSING ASPECT VALUE/MISSING ASPECT VALUE/MISSING ASPECT VALUE";

    /*
     * Test cases---------------------------------------------------------------
     */
    //TODO - Add empty constructor test cases

    @Test
    public final void testStringConstructorComplete() {
        Address test = this.constructorStringTest(this.addressString);
        assertEquals("Ohio", test.state());
        assertEquals("Columbus", test.city());
        assertEquals(43210, test.zip());
        assertEquals("136 West Woodruff Ave.", test.address1());
        assertEquals("Room 216", test.address2());
        assertEquals(40.004128, test.latitude(), 0.01);
        assertEquals(-83.012633, test.longitude(), 0.01);
    }

    @Test
    public final void testStringConstructorIncomplete() {
        Address test = this.constructorStringTest(this.addressStringIncomplete);
        assertEquals("Ohio", test.state());
        assertEquals("Columbus", test.city());
        assertEquals("136 West Woodruff Ave.", test.address1());
        assertTrue(!test.isSet(Address.AddressAspect.ZIP));
        assertTrue(!test.isSet(Address.AddressAspect.ADDRESS2));
        assertTrue(!test.isSet(Address.AddressAspect.LAT));
        assertTrue(!test.isSet(Address.AddressAspect.LONG));
    }

    /*
     * Test cases for setting and then retrieving aspects of address
     */
    @Test
    public final void testSetStateAndState() {
        Address test = this.constructorTest();
        test.setState("Ohio");
        String result = test.state();
        assertEquals("Ohio", result);
    }

    @Test
    public final void testSetCityAndCity() {
        Address test = this.constructorTest();
        test.setCity("Columbus");
        String result = test.city();
        assertEquals("Columbus", result);
    }

    @Test
    public final void testSetZipAndZip() {
        Address test = this.constructorTest();
        test.setZip(43210);
        int result = test.zip();
        assertEquals(43210, result);
    }

    @Test
    public final void testSetAddress1AndAddress1() {
        Address test = this.constructorTest();
        test.setAddress1("136 West Woodruff Ave.");
        String result = test.address1();
        assertEquals("136 West Woodruff Ave.", result);
    }

    @Test
    public final void testSetAddress2AndAddress2() {
        Address test = this.constructorTest();
        test.setAddress2("Room 216");
        String result = test.address2();
        assertEquals("Room 216", result);
    }

    @Test
    public final void testSetLatitudeAndLatitude() {
        Address test = this.constructorTest();
        test.setLatitude(40.004128);
        double result = test.latitude();
        assertEquals(40.004128, result, 0.01);
    }

    @Test
    public final void testSetLongitudeAndLongitude() {
        Address test = this.constructorTest();
        test.setLongitude(-83.012633);
        double result = test.longitude();
        assertEquals(-83.012633, result, 0.01);
    }

    /*
     * Test for isSet method
     */
    @Test
    public final void testIsSetTrueUsingSet() {
        Address test = this.constructorTest();
        test.setCity("Lima");
        assertTrue(test.isSet(Address.AddressAspect.CITY));
    }

    @Test
    public final void testIsSetTrueUsingStringConstructor() {
        Address test = this.constructorStringTest(this.addressString);
        assertTrue(test.isSet(Address.AddressAspect.ZIP));
    }

    @Test
    public final void testIsSetFalse() {
        Address test = this.constructorTest();
        test.setCity("Lima");
        assertTrue(!test.isSet(Address.AddressAspect.LAT));
    }

    @Test
    public final void testIsSetFalseSettingEmptyString() {
        Address test = this.constructorTest();
        test.setAddress2("");
        assertTrue(!test.isSet(Address.AddressAspect.ADDRESS2));
    }

    /*
     * Test for toString method
     */
    @Test
    public final void testToStringComplete() {
        Address test = this.constructorStringTest(this.addressString);
        assertEquals(this.addressString, test.toString());
    }

    @Test
    public final void testToStringIncomplete() {
        Address test = this.constructorTest();
        test.setState("Ohio");
        test.setCity("Columbus");
        test.setAddress1("136 West Woodruff Ave.");
        assertEquals(this.addressStringIncomplete, test.toString());
    }

    /*
     * Test for equals method
     */
    @Test
    public final void testEqualsTrueStringConstructor() {
        Address test1 = this.constructorStringTest(this.addressString);
        Address test2 = this.constructorStringTest(this.addressString);
        assertTrue(test1.equals(test2));
    }

    @Test
    public final void testEqualsFalseStringConstructor() {
        Address test1 = this.constructorStringTest(this.addressString);
        Address test2 = this.constructorStringTest(this.addressString2);
        assertTrue(!test1.equals(test2));
    }

    @Test
    public final void testEqualsTrueSetting() {
        Address test1 = this.constructorTest();
        Address test2 = this.constructorTest();
        test1.setZip(42311);
        test2.setZip(42311);
        assertTrue(test1.equals(test2));
    }

    @Test
    public final void testEqualsFalseSetting() {
        Address test1 = this.constructorTest();
        Address test2 = this.constructorTest();
        test1.setZip(42314);
        test2.setZip(42311);
        assertTrue(!test1.equals(test2));
    }

    @Test
    public final void testEqualsBothEmpty() {
        Address test1 = this.constructorTest();
        Address test2 = this.constructorTest();
        assertTrue(test1.equals(test2));
    }

    /*
     * Test for transferFrom
     */
    @Test
    public final void testTransferFrom() {
        Address test1 = this.constructorStringTest(this.addressString);
        Address test2 = this.constructorStringTest(this.addressString);
        Address test3 = this.constructorTest();
        Address test4 = this.constructorTest();
        test4.transferFrom(test2);
        assertEquals(test1, test4);
        assertEquals(test2, test3);
    }

    /*
     * Test for clear
     */
    @Test
    public final void testClear() {
        Address test1 = this.constructorStringTest(this.addressString);
        Address test2 = this.constructorTest();
        test1.clear();
        assertEquals(test2, test1);
    }

}
