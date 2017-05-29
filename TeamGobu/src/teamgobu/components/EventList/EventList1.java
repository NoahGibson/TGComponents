package teamgobu.components.EventList;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import teamgobu.components.Event.Event;

/**
 * Created by Noah Gibson on 5/21/2017.
 *
 *
 */
//TODO - Write convention and correspondence
public class EventList1 extends EventListSecondary {

    /*
     * Private Members----------------------------------------------------------
     */

    /**
     * A list representation for the EventList.
     */
    private Map<Integer, Event> rep;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.rep = new TreeMap<>();
    }

    /*
     * Constructors-------------------------------------------------------------
     */

    /**
     * No argument constructor.
     */
    public EventList1() {
        this.createNewRep();
    }

    /*
     * Standard Methods---------------------------------------------------------
     */
    @SuppressWarnings("unchecked")
    @Override
    public final EventList newInstance() {
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
    public final void transferFrom(EventList source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof EventList1 : ""
                + "Violation of: source is of dynamic type EventList1";

        EventList1 localSource = (EventList1) source;
        this.rep = localSource.rep;
        localSource.createNewRep();
    }

    /*
     * Kernel Methods-----------------------------------------------------------
     */
    @Override
    public final void addEvent(Event event) {
        assert !this.rep.containsKey(event.id()) : "Violation of: "
                + "event is not in this";
        this.rep.put(event.id(), event);
    }

    @Override
    public final Event removeEvent(int id) {
        return this.rep.remove(id);
    }

    @Override
    public final EventList filterInteger(Event.EventAttribute attributeName,
            int value, EventList.Filter filter) {
        EventList filtered = new EventList1();
        switch (filter) {
            case EQUAL:
                for (int id : this.rep.keySet()) {
                    Event event = this.rep.get(id);
                    if (Integer.parseInt(event.get(attributeName)) == value) {
                        filtered.addEvent(event);
                    }
                }
                break;
            case GREATER:
                for (int id : this.rep.keySet()) {
                    Event event = this.rep.get(id);

                    if (Integer.parseInt(event.get(attributeName)) >= value) {
                        filtered.addEvent(event);
                    }
                }
                break;
            case LESS:
                for (int id : this.rep.keySet()) {
                    Event event = this.rep.get(id);
                    if (Integer.parseInt(event.get(attributeName)) <= value) {
                        filtered.addEvent(event);
                    }
                }
                break;
            default:
                // This will never happen
                break;
        }
        return filtered;
    }

    @Override
    public final EventList filterString(Event.EventAttribute attributeName,
            String value) {
        EventList filtered = new EventList1();
        for (int id : this.rep.keySet()) {
            Event event = this.rep.get(id);
            if (event.get(attributeName).indexOf(value) >= 0) {
                filtered.addEvent(event);
            }
        }
        return filtered;
    }

    @Override
    public final EventList filterTag(String tag) {
        EventList filtered = new EventList1();
        for (int id : this.rep.keySet()) {
            Event event = this.rep.get(id);
            if (event.tags().isInList(tag)) {
                filtered.addEvent(event);
            }
        }
        return filtered;
    }

    @Override
    public final boolean isInList(int id) {
        return this.rep.containsKey(id);
    }

    @Override
    public final Set<Integer> ids() {
        return this.rep.keySet();
    }

    @Override
    public final int length() {
        return this.rep.size();
    }

    @Override
    public final Iterator<Event> iterator() {
        return this.rep.values().iterator();
    }

}
