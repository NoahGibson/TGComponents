package teamgobu.components.EventList;

import teamgobu.components.Date.Date;
import teamgobu.components.Event.Event;
import teamgobu.components.TagList.TagList;

/**
 * Created by Noah Gibson on 5/21/2017.
 *
 * Layered implementations of secondary methods for {@code EventList}, including
 * overriden methods inherited from {@code Object}.
 */
public abstract class EventListSecondary implements EventList {

    /*
     * Public members-----------------------------------------------------------
     */

    /*
     * Common methods (from Object)---------------------------------------------
     */
    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof TagList)) {
            return false;
        }
        EventList events = (EventList) obj;
        if (this.length() != events.length()) {
            return false;
        }
        for (Event event : this) {
            if (!events.isInList(event.id())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final String toString() {
        //TODO - Write toString method
        return null;
    }

    @Override
    public final int hashCode() {
        //TODO - Write hashCode method
        return 1;
    }

    /*
     * EventList interface methods----------------------------------------------
     */
    @Override
    public final EventList filterName(String name) {
        return this.filterString(Event.EventAttribute.NAME, name);
    }

    @Override
    public final EventList filterDescription(String description) {
        return this.filterString(Event.EventAttribute.DESCRIPTION, description);
    }

    @Override
    public final EventList filterOrganization(int orgId) {
        return this.filterInteger(Event.EventAttribute.ORGANIZATIONID, orgId,
                EventList.Filter.EQUAL);
    }

    @Override
    public final EventList filterDate(Date date, EventList.Filter filter) {
        //TODO - Write filterDate method
        return null;
    }

    @Override
    public final EventList filterAttending(int attending,
            EventList.Filter filter) {
        return this.filterInteger(Event.EventAttribute.ATTENDING, attending,
                filter);
    }

    @Override
    public final void removeEvent(Event event) {
        this.removeEvent(event.id());
    }

    @Override
    public final Event getEvent(int id) {
        Event event = this.removeEvent(id);
        Event alias = event;
        this.addEvent(event);
        return alias;
    }

    @Override
    public final boolean isInList(Event event) {
        return this.isInList(event.id());
    }
}
