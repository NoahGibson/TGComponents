package teamgobu.components.EventList;

import java.util.Set;

import teamgobu.components.Event.Event;
import teamgobu.components.Standard.Standard;

/**
 * Created by Noah Gibson on 5/21/2017.
 *
 * An object to hold the contents of a list of Events.
 */
public interface EventListKernel extends Standard<EventList>, Iterable<Event> {

    /**
     * Adds the given Event object to {@code this}.
     *
     * @param event
     *            the Event object to add to {@code this}
     * @updates this
     * @ensures [this contains all Events it did previously plus {@code event}]
     */
    void addEvent(Event event);

    /**
     * Removes and returns the Event in {@code this} with the given id
     * {@code id}.
     *
     * @param id
     *            the id of the Event to remove
     * @updates this
     * @requires [there is an Event in this with the given id]
     * @ensures removeEvent = [the Event in this with the given id] and [this
     *          contains all Events it did previously minus removeEvent]
     * @return the Event in this with the given id
     */
    Event removeEvent(int id);

    /**
     * Returns a list containing only the Events in {@code this} with the
     * attribute {@code attributeName} with a value greater than, equal to, or
     * less than (depending on the filter type {@code filter}) the given value
     * {@code value}.
     *
     * @param attributeName
     *            the name of the attribute to filter by
     * @param value
     *            the value to compare the value of the attribute to
     * @param filter
     *            the type of comparison to make between the attributeName and
     *            value
     * @requires attributeName = ID | ORGANIZATIONID | DATETIME | ATTENDING
     * @return an EventList containing only Events that were initially in this
     *         that have a value of the attribute attributeName properly
     *         compared to the given value by filter
     */
    EventList filterInteger(Event.EventAttribute attributeName, int value,
            EventList.Filter filter);

    /**
     * Returns a list containing only the Events in [@code this} with the
     * attribute {@code attributeName} containing the string {@code value}.
     *
     * @param attributeName
     *            the name of the attribute to filter by
     * @param value
     *            the value to compare the value of the attribute to
     * @requires attributeName = NAME | DESCRIPTION
     * @return an EventList containing only Events that were initially in this
     *         that have a value of the attribute attributeName containing the
     *         string value
     */
    EventList filterString(Event.EventAttribute attributeName, String value);

    /**
     * Returns a filtered list of those Events in {@code this} that have the
     * given tag {@code tag}.
     *
     * @param tag
     *            the tag to filter this by
     * @return an EventList containing only Events that were initially in this
     *         that have the given tag
     */
    EventList filterTag(String tag);

    /**
     * Reports whether or not an Event with the given id {@code id} is in
     * {@code this}.
     *
     * @param id
     *            the id of an Event that might be in this
     * @return true iff there exists an Event in this that has the given id
     */
    boolean isInList(int id);

    /**
     * Returns a set of all the event IDs in {@code this}.
     *
     * @return a set object containing the set of IDs in this
     */
    Set<Integer> ids();

    /**
     * Reports the number of Events that are in {@code this}.
     *
     * @return the number of Events in this
     */
    int length();

}
