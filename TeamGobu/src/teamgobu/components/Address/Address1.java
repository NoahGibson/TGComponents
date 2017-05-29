package teamgobu.components.Address;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Noah Gibson on 5/14/2017.
 *
 *
 */
//TODO - Write convention and correspondence
public class Address1 extends AddressSecondary {

    /*
     * Private Members----------------------------------------------------------
     */

    /**
     * A Map representation for the address.
     */
    private Map<AddressAspect, String> rep;

    /**
     * A string representing the value of an aspect if it has not been
     * initialized.
     */
    private final String EMPTY_ASPECT = "MISSING ASPECT VALUE";

    /**
     * Creator of initial representation.
     *
     * @replaces this
     * @ensures <pre>
     *  for all aspect: Address.AddressAspect
     *      (this.rep.get(aspect) = "MISSING ASPECT VALUE")
     * </pre>
     */
    private void createNewRep() {
        AddressAspect[] aspects = AddressAspect.values();
        this.rep = new TreeMap<>();
        for (AddressAspect aspect : aspects) {
            this.rep.put(aspect, this.EMPTY_ASPECT);
        }
    }

    /*
     * Constructors-------------------------------------------------------------
     */

    /**
     * No argument constructor.
     */
    public Address1() {
        this.createNewRep();
    }

    /**
     * From String constructor.
     *
     * @param addressString
     *            the string to create the Address from, formatted correctly
     */
    public Address1(String addressString) {
        this.createNewRep();
        AddressAspect[] aspects = AddressAspect.values();
        String addressVariable = addressString;
        for (int aspectId = 0; aspectId < aspects.length; aspectId++) {
            int slashIndex = addressVariable.indexOf("/");
            String nextAspect;
            if (slashIndex >= 0) {
                nextAspect = addressVariable.substring(0, slashIndex);
            } else {
                nextAspect = addressVariable.substring(0);
            }
            this.rep.put(aspects[aspectId], nextAspect);
            addressVariable = addressVariable.substring(slashIndex + 1);
            slashIndex = addressVariable.indexOf("/");
        }
    }

    /*
     * Standard Methods---------------------------------------------------------
     */
    @SuppressWarnings("unchecked")
    @Override
    public final Address newInstance() {
        try {
            return this.getClass().newInstance();
        } catch (Exception e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(Address source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof Address1 : ""
                + "Violation of: source is of dynamic type Address1";

        Address1 localSource = (Address1) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    /*
     * Kernel Methods-----------------------------------------------------------
     */
    @Override
    public final void set(AddressAspect aspectName, String value) {
        this.rep.remove(aspectName);
        this.rep.put(aspectName, value);
    }

    @Override
    public final String get(AddressAspect aspectName) {
        return this.rep.get(aspectName);
    }

    @Override
    public final boolean isSet(AddressAspect aspectName) {
        return !this.rep.get(aspectName).equals(this.EMPTY_ASPECT)
                && this.rep.get(aspectName).length() > 0;
    }

}
