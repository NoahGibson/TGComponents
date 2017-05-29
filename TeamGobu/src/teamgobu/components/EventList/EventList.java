package teamgobu.components.EventList;

import teamgobu.components.Date.Date;
import teamgobu.components.Event.Event;

/**
 * Created by Noah Gibson on 5/21/2017.
 *
 * Interface for enhanced methods of an EventList object.
 */
public interface EventList extends EventListKernel {

    /**
     * Enum type for filters for the EventList.
     */
    enum Filter {

        /**
         * Filters for the EventList.
         */
        EQUAL, GREATER, LESS;

    }

    /**
     * Returns a filtered list of those Events in {@code this} whose name
     * contains the substring {@code name}.
     *
     * @param name
     *            the substring the name should contain
     * @return an EventList containing only the Events initially in this whose
     *         name attribute has the substring name
     */
    EventList filterName(String name);

    /**
     * Returns a filtered list of those Events in {@code this} whose description
     * contains the substring {@code description}.
     *
     * @param description
     *            the substring the description should contain
     * @return an EventList containing only the Events initially in this whose
     *         description attribute has the substring description
     */
    EventList filterDescription(String description);

    /**
     * Returns a filtered list of those Events in {@code this} that are by the
     * organization with the id {@code orgId}.
     *
     * @param orgId
     *            the id of the organization
     * @return an EventList containing only the Events initially in this whose
     *         organizationId attribute is equal to orgId
     */
    EventList filterOrganization(int orgId);

    /**
     * Returns a filtered list of those Events in {@code this} that take place
     * before, on, or after the given date {@code date} (depending on the value
     * of {@code filter}).
     *
     * @param date
     *            the date to filter by
     * @param filter
     *            the type of comparison to make between the given date and the
     *            Events in this
     * @requires all aspects of date have been set
     * @return an EventList containing only the Events initially in this whose
     *         dateTime attribute is before, on, or after the given date
     */
    EventList filterDate(Date date, EventList.Filter filter);

    //TODO - Add filterLocation

    /**
     * Returns a filtered list of those Events in {@code this} that have the
     * number attending greater than, less than, or equal to the given value
     * {@code attending} (depending on the value of {@code filter}).
     *
     * @param attending
     *            the number of people attending to filter by
     * @param filter
     *            the type of comparison to make between the given value and the
     *            Events in this
     * @return an EventList containing only the Events initially in this whose
     *         attending attribute is greater than, less than, or equal to the
     *         given value
     */
    EventList filterAttending(int attending, EventList.Filter filter);

    /**
     * Removes the given Event from {@code this}.
     *
     * @param event
     *            the Event to remove
     * @requires [the given event is already in this]
     * @ensures [this contains all Events it did previously minus the given
     *          event]
     */
    void removeEvent(Event event);

    /**
     * Returns a reference to the event in {@code this} with the given id.
     *
     * @param id
     *            the id of the event to return the reference to
     * @aliases getEvent
     * @requires [there exists an event in this with the given id]
     * @return a reference to an Event in this
     */
    Event getEvent(int id);

    /**
     * Reports whether or not an Event {@code event} is in {@code this}.
     *
     * @param event
     *            the event that might be in this
     * @return true iff there exists an Event in this that has the same id as
     *         the given event
     */
    boolean isInList(Event event);

}
