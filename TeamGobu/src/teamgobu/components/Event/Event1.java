package teamgobu.components.Event;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Noah Gibson on 5/14/2017.
 *
 *
 */
//TODO - Write convention and correspondence
public class Event1 extends EventSecondary {

    /*
     * Private Members----------------------------------------------------------
     */

    /**
     * Representation of an Event1 object.
     */
    private Map<EventAttribute, String> rep;

    /**
     * String for an empty attribute value.
     */
    //TODO - Move EMPTY_ATTRIBUTE string to values
    private final String EMPTY_ATTRIBUTE = "MISSING ATTRIBUTE VALUE";

    /**
     * Creator of initial representation.
     *
     * @replaces this
     * @ensures <pre>
     *  for all attribute: Event.EventAttribute
     *      (this.rep.get(attribute) = "MISSING ATTRIBUTE VALUE")
     * </pre>
     */
    private void createNewRep() {
        EventAttribute[] attributes = EventAttribute.values();
        this.rep = new TreeMap<>();
        for (EventAttribute attribute : attributes) {
            this.rep.put(attribute, this.EMPTY_ATTRIBUTE);
        }
    }

    /*
     * Constructors-------------------------------------------------------------
     */

    /**
     * No argument constructor.
     */
    public Event1() {
        this.createNewRep();
    }

    /*
     * Standard Methods---------------------------------------------------------
     */
    @SuppressWarnings("unchecked")
    @Override
    public final Event newInstance() {
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
    public final void transferFrom(Event source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof Event1 : ""
                + "Violation of: source is of dynamic type Event1";

        Event1 localSource = (Event1) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    /*
     * Kernel Methods-----------------------------------------------------------
     */
    @Override
    public final void set(EventAttribute attributeName, String value) {
        this.rep.remove(attributeName);
        this.rep.put(attributeName, value);
    }

    @Override
    public final String get(EventAttribute attributeName) {
        return this.rep.get(attributeName);
    }

    @Override
    public final boolean isSet(EventAttribute attributeName) {
        return !this.rep.get(attributeName).equals(this.EMPTY_ATTRIBUTE)
                && this.rep.get(attributeName).length() > 0;
    }

}
