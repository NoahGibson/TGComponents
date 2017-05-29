package teamgobu.test.Event;

import teamgobu.components.Event.Event;
import teamgobu.components.Event.Event1;

/**
 * Customized JUnit test fixture for {@code Event1}.
 */
public class Event1Test extends EventTest {

    @Override
    protected final Event constructorTest() {
        return new Event1();
    }

    @Override
    protected final Event constructorRef() {
        return new Event1();
    }

}
