package teamgobu.test.Event;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import teamgobu.components.Address.Address;
import teamgobu.components.Address.Address1;
import teamgobu.components.Date.Date;
import teamgobu.components.Date.Date1;
import teamgobu.components.Event.Event;
import teamgobu.components.TagList.TagList;
import teamgobu.components.TagList.TagList1;

/**
 *
 * @author 135no
 *
 */
//TODO - Add documentation
public abstract class EventTest {

    /**
     * Invokes the appropriate {@code Event} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new event
     */
    protected abstract Event constructorTest();

    /**
     * Invokes the appropriate {@code Event} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new event
     */
    protected abstract Event constructorRef();

    /*
     * Sample strings for test cases--------------------------------------------
     */

    /**
     * String for an incomplete event object.
     */
    private final String eventStringIncomplete = "Name = NAME; "
            + "Description = DESCRIPTION; ID = 21; OrganizationID = 54; "
            + "DateTime = MISSING ATTRIBUTE VALUE; "
            + "Location = MISSING ATTRIBUTE VALUE; "
            + "Tags = MISSING ATTRIBUTE VALUE; Attending = 27";

    /**
     * String for a sample dateTime.
     */
    private final String dateTimeString = "1997/5/13/7/30/false";

    /**
     * String for a sample location.
     */
    private final String locationString = "Ohio/Columbus/43210/"
            + "136 West Woodruff Ave./Room 216/40.004128/-83.012633";

    /**
     * String for a sample tagList.
     */
    private final String tagListString = "Business/Marketing/Engineering";

    /*
     * Test cases---------------------------------------------------------------
     */
    //TODO - Add empty constructor test cases

    /*
     * Test cases for setting and then retrieving attributes of the event
     */
    @Test
    public final void testSetNameAndName() {
        Event test = this.constructorTest();
        test.setName("Event 1");
        String result = test.name();
        assertEquals("Event 1", result);
    }

    @Test
    public final void testSetDescriptionAndDescription() {
        Event test = this.constructorTest();
        test.setDescription("A sample event.");
        String result = test.description();
        assertEquals("A sample event.", result);
    }

    @Test
    public final void testSetIdAndId() {
        Event test = this.constructorTest();
        test.setId(111);
        int result = test.id();
        assertEquals(111, result);
    }

    @Test
    public final void testSetOrganizationIdAndOrganizationId() {
        Event test = this.constructorTest();
        test.setOrganizationId(222);
        int result = test.organizationId();
        assertEquals(222, result);
    }

    @Test
    public final void testSetDateTimeAndDateTime() {
        Event test = this.constructorTest();
        test.setDateTime(new Date1(this.dateTimeString));
        Date result = test.dateTime();
        assertEquals(this.dateTimeString, result.toString());
    }

    @Test
    public final void testSetLocationAndLocation() {
        Event test = this.constructorTest();
        test.setLocation(new Address1(this.locationString));
        Address result = test.location();
        assertEquals(this.locationString, result.toString());
    }

    @Test
    public final void testSetTagsAndTags() {
        Event test = this.constructorTest();
        test.setTags(new TagList1(this.tagListString));
        TagList result = test.tags();
        assertEquals(this.tagListString, result.toString());
    }

    @Test
    public final void testSetAttendingAndAttending() {
        Event test = this.constructorTest();
        test.setAttending(20);
        int result = test.attending();
        assertEquals(20, result);
    }

    /*
     * Test for isSet method
     */
    @Test
    public final void testIsSetTrueUsingSet() {
        Event test = this.constructorTest();
        test.setDescription("A sample description.");
        assertTrue(test.isSet(Event.EventAttribute.DESCRIPTION));
    }

    @Test
    public final void testIsSetFalse() {
        Event test = this.constructorTest();
        test.setAttending(40);
        assertTrue(!test.isSet(Event.EventAttribute.ORGANIZATIONID));
    }

    @Test
    public final void testIsSetFalseSettingEmptyString() {
        Event test = this.constructorTest();
        test.setName("");
        assertTrue(!test.isSet(Event.EventAttribute.NAME));
    }

    /*
     * Test for toString method
     */
    @Test
    public final void testToStringIncomplete() {
        Event test = this.constructorTest();
        test.setName("NAME");
        test.setDescription("DESCRIPTION");
        test.setId(21);
        test.setOrganizationId(54);
        test.setAttending(27);
        assertEquals(this.eventStringIncomplete, test.toString());
    }

    /*
     * Test for equals method
     */
    @Test
    public final void testEqualsTrueSetting() {
        Event test1 = this.constructorTest();
        Event test2 = this.constructorTest();
        test1.setOrganizationId(42311);
        test2.setOrganizationId(42311);
        assertTrue(test1.equals(test2));
    }

    @Test
    public final void testEqualsFalseSetting() {
        Event test1 = this.constructorTest();
        Event test2 = this.constructorTest();
        test1.setId(42314);
        test2.setId(42311);
        assertTrue(!test1.equals(test2));
    }

    @Test
    public final void testEqualsBothEmpty() {
        Event test1 = this.constructorTest();
        Event test2 = this.constructorTest();
        assertTrue(test1.equals(test2));
    }

    /*
     * Test for transferFrom
     */
    @Test
    public final void testTransferFrom() {
        Event test1 = this.constructorTest();
        test1.setName("NAME");
        test1.setDateTime(new Date1(this.dateTimeString));
        Event test2 = this.constructorTest();
        test2.setName("NAME");
        test2.setDateTime(new Date1(this.dateTimeString));
        Event test3 = this.constructorTest();
        Event test4 = this.constructorTest();
        test4.transferFrom(test2);
        assertEquals(test1, test4);
        assertEquals(test2, test3);
    }

    /*
     * Test for clear
     */
    @Test
    public final void testClear() {
        Event test1 = this.constructorTest();
        test1.setName("NAME");
        test1.setDateTime(new Date1(this.dateTimeString));
        Event test2 = this.constructorTest();
        test1.clear();
        assertEquals(test2, test1);
    }

}
