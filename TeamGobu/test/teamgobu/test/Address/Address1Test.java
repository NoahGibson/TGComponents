package teamgobu.test.Address;

import teamgobu.components.Address.Address;
import teamgobu.components.Address.Address1;

/**
 * Customized JUnit test fixture for {@code Address1}.
 */
public class Address1Test extends AddressTest {

    @Override
    protected final Address constructorTest() {
        return new Address1();
    }

    @Override
    protected final Address constructorStringTest(String addressString) {
        return new Address1(addressString);
    }

    @Override
    protected final Address constructorRef() {
        return new Address1();
    }

}
