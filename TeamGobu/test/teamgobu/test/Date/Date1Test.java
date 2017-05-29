package teamgobu.test.Date;

import teamgobu.components.Date.Date;
import teamgobu.components.Date.Date1;

/**
 * Customized JUnit test fixture for {@code Date1}.
 */
public class Date1Test extends DateTest {

    @Override
    protected final Date constructorTest() {
        return new Date1();
    }

    @Override
    protected final Date constructorStringTest(String dateString) {
        return new Date1(dateString);
    }

    @Override
    protected final Date constructorRef() {
        return new Date1();
    }

}
