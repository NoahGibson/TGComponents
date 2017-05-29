package teamgobu.test.TagList;

import teamgobu.components.TagList.TagList;
import teamgobu.components.TagList.TagList1;

/**
 * Customized JUnit test fixture for {@code TagList1}.
 */
public class TagList1Test extends TagListTest {

    @Override
    protected final TagList constructorTest() {
        return new TagList1();
    }

    @Override
    protected final TagList constructorStringTest(String tagListString) {
        return new TagList1(tagListString);
    }

    @Override
    protected final TagList constructorRef() {
        return new TagList1();
    }

}
