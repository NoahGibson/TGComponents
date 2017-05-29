package teamgobu.test.TagList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import teamgobu.components.TagList.TagList;

/**
 *
 * @author 135no
 *
 */
//TODO - Add documentation
public abstract class TagListTest {

    /**
     * Invokes the appropriate {@code TagList} constructor for the
     * implementation under test and returns the result.
     *
     * @return the new TagList
     */
    protected abstract TagList constructorTest();

    /**
     * Invokes the appropriate {@code TagList} string constructor for the
     * implementation under test and returns the result.
     *
     * @param tagListString
     *            the string to construct the TagList from
     * @return the new TagList
     */
    protected abstract TagList constructorStringTest(String tagListString);

    /**
     * Invokes the appropriate {@code TagLIst} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new TagList
     */
    protected abstract TagList constructorRef();

    /*
     * Sample strings for test cases--------------------------------------------
     */

    /**
     * String for a sample TagList.
     */
    private final String tagListString = "Business/Marketing/Engineering";

    /**
     * String for another sample TagList.
     */
    private final String tagListString2 = "Business/Accounting/Engineering";

    /*
     * Test cases---------------------------------------------------------------
     */
    //TODO - Add empty constructor test cases

    @Test
    public final void testStringConstructorComplete() {
        TagList test = this.constructorStringTest(this.tagListString);
        assertTrue(test.isInList("Business"));
        assertTrue(test.isInList("Marketing"));
        assertTrue(test.isInList("Engineering"));
    }

    /*
     * Test cases for setting and then retrieving aspects of address
     */
    @Test
    public final void testAddTagAndIsInList() {
        TagList test = this.constructorTest();
        test.addTag("AI");
        assertTrue(test.isInList("AI"));
    }

    @Test
    public final void testRemoveTagAndIsInList() {
        TagList test = this.constructorStringTest(this.tagListString);
        test.removeTag("Marketing");
        assertTrue(test.isInList("Business"));
        assertTrue(test.isInList("Engineering"));
        assertTrue(!test.isInList("Marketing"));
    }

    @Test
    public final void testRemoveAnyTagAndIsInList() {
        TagList test = this.constructorStringTest(this.tagListString);
        String tag = test.removeAnyTag();
        assertTrue(!test.isInList(tag));
    }

    @Test
    public final void testLengthEmpty() {
        TagList test = this.constructorTest();
        assertEquals(0, test.length());
    }

    @Test
    public final void testLengthNonEmpty() {
        TagList test = this.constructorTest();
        test.addTag("Business");
        assertEquals(1, test.length());
    }

    /*
     * Test for toString method
     */
    @Test
    public final void testToString() {
        TagList test = this.constructorStringTest(this.tagListString);
        assertEquals(this.tagListString, test.toString());
    }

    /*
     * Test for equals method
     */
    @Test
    public final void testEqualsTrueStringConstructor() {
        TagList test1 = this.constructorStringTest(this.tagListString);
        TagList test2 = this.constructorStringTest(this.tagListString);
        assertTrue(test1.equals(test2));
    }

    @Test
    public final void testEqualsFalseStringConstructor() {
        TagList test1 = this.constructorStringTest(this.tagListString);
        TagList test2 = this.constructorStringTest(this.tagListString2);
        assertTrue(!test1.equals(test2));
    }

    @Test
    public final void testEqualsTrueSetting() {
        TagList test1 = this.constructorTest();
        TagList test2 = this.constructorTest();
        test1.addTag("Marketing");
        test2.addTag("Marketing");
        assertTrue(test1.equals(test2));
    }

    @Test
    public final void testEqualsFalseSetting() {
        TagList test1 = this.constructorTest();
        TagList test2 = this.constructorTest();
        test1.addTag("Marketing");
        test2.addTag("Accounting");
        assertTrue(!test1.equals(test2));
    }

    @Test
    public final void testEqualsBothEmpty() {
        TagList test1 = this.constructorTest();
        TagList test2 = this.constructorTest();
        assertTrue(test1.equals(test2));
    }

    /*
     * Test for transferFrom
     */
    @Test
    public final void testTransferFrom() {
        TagList test1 = this.constructorStringTest(this.tagListString);
        TagList test2 = this.constructorStringTest(this.tagListString);
        TagList test3 = this.constructorTest();
        TagList test4 = this.constructorTest();
        test4.transferFrom(test2);
        assertEquals(test1, test4);
        assertEquals(test2, test3);
    }

    /*
     * Test for clear
     */
    @Test
    public final void testClear() {
        TagList test1 = this.constructorStringTest(this.tagListString);
        TagList test2 = this.constructorTest();
        test1.clear();
        assertEquals(test2, test1);
    }

}
