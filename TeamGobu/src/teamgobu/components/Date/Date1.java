package teamgobu.components.Date;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Noah Gibson on 5/15/2017.
 *
 *
 */
//TODO - Write documentation
public class Date1 extends DateSecondary {

    /*
     * Private Members----------------------------------------------------------
     */

    /**
     * A Map representation for the date.
     */
    private Map<DateAspect, String> rep;

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
     *  for all aspect: Date.DateAspect
     *      (this.rep.get(aspect) = "MISSING ASPECT VALUE")
     * </pre>
     */
    private void createNewRep() {
        DateAspect[] aspects = DateAspect.values();
        this.rep = new TreeMap<>();
        for (DateAspect aspect : aspects) {
            this.rep.put(aspect, this.EMPTY_ASPECT);
        }
    }

    /*
     * Constructors-------------------------------------------------------------
     */

    /**
     * No argument constructor.
     */
    public Date1() {
        this.createNewRep();
    }

    /**
     * From String constructor.
     *
     * @param dateString
     *            the string to create the Date object from, formatted correctly
     */
    public Date1(String dateString) {
        this.createNewRep();
        DateAspect[] aspects = DateAspect.values();
        String dateVariable = dateString;
        for (int aspectId = 0; aspectId < aspects.length; aspectId++) {
            int slashIndex = dateVariable.indexOf("/");
            String nextAspect;
            if (slashIndex >= 0) {
                nextAspect = dateVariable.substring(0, slashIndex);
            } else {
                nextAspect = dateVariable.substring(0);
            }
            this.rep.put(aspects[aspectId], nextAspect);
            dateVariable = dateVariable.substring(slashIndex + 1);
            slashIndex = dateVariable.indexOf("/");
        }
    }

    /*
     * Standard Methods---------------------------------------------------------
     */
    @SuppressWarnings("unchecked")
    @Override
    public final Date newInstance() {
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
    public final void transferFrom(Date source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof Date1 : ""
                + "Violation of: source is of dynamic type Date1";

        Date1 localSource = (Date1) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    /*
     * Kernel Methods-----------------------------------------------------------
     */
    @Override
    public final void set(DateAspect aspectName, String value) {
        this.rep.remove(aspectName);
        this.rep.put(aspectName, value);
    }

    @Override
    public final String get(DateAspect aspectName) {
        return this.rep.get(aspectName);
    }

    @Override
    public final boolean isSet(DateAspect aspectName) {
        return !this.rep.get(aspectName).equals(this.EMPTY_ASPECT)
                && this.rep.get(aspectName).length() > 0;
    }
}
