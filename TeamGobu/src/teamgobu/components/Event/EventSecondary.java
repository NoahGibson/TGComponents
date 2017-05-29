package teamgobu.components.Event;

import teamgobu.components.Address.Address;
import teamgobu.components.Address.Address1;
import teamgobu.components.Date.Date;
import teamgobu.components.Date.Date1;
import teamgobu.components.TagList.TagList;
import teamgobu.components.TagList.TagList1;

/**
 * Created by Noah Gibson on 5/14/2017.
 *
 * Layered implementations of secondary methods for {@code Event}, including
 * overriden methods inherited from {@code Object}.
 */
public abstract class EventSecondary implements Event {

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
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        EventAttribute[] attributes = EventAttribute.values();
        for (EventAttribute attribute : attributes) {
            if (!this.get(attribute).equals(event.get(attribute))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final String toString() {
        String eventString = "";
        eventString += "Name = " + this.get(EventAttribute.NAME) + "; ";
        eventString += "Description = " + this.get(EventAttribute.DESCRIPTION)
                + "; ";
        eventString += "ID = " + this.get(EventAttribute.ID) + "; ";
        eventString += "OrganizationID = "
                + this.get(EventAttribute.ORGANIZATIONID) + "; ";
        eventString += "DateTime = " + this.get(EventAttribute.DATETIME) + "; ";
        eventString += "Location = " + this.get(EventAttribute.LOCATION) + "; ";
        eventString += "Tags = " + this.get(EventAttribute.TAGS) + "; ";
        eventString += "Attending = " + this.get(EventAttribute.ATTENDING);
        return eventString;
    }

    @Override
    public final int hashCode() {
        //TODO - Write hashCode method
        return 1;
    }

    /*
     * Accessor methods---------------------------------------------------------
     */
    @Override
    public final String name() {
        return this.get(EventAttribute.NAME);
    }

    @Override
    public final String description() {
        return this.get(EventAttribute.DESCRIPTION);
    }

    @Override
    public final int id() {
        return Integer.parseInt(this.get(EventAttribute.ID));
    }

    @Override
    public final int organizationId() {
        return Integer.parseInt(this.get(EventAttribute.ORGANIZATIONID));
    }

    @Override
    public final Date dateTime() {
        return new Date1(this.get(EventAttribute.DATETIME));
    }

    @Override
    public final Address location() {
        return new Address1(this.get(EventAttribute.LOCATION));
    }

    @Override
    public final TagList tags() {
        return new TagList1(this.get(EventAttribute.TAGS));
    }

    @Override
    public final int attending() {
        return Integer.parseInt(this.get(EventAttribute.ATTENDING));
    }

    /*
     * Manipulator methods------------------------------------------------------
     */
    @Override
    public final void setName(String name) {
        this.set(EventAttribute.NAME, name);
    }

    @Override
    public final void setDescription(String description) {
        this.set(EventAttribute.DESCRIPTION, description);
    }

    @Override
    public final void setId(int id) {
        this.set(EventAttribute.ID, ("" + id));
    }

    @Override
    public final void setOrganizationId(int orgId) {
        this.set(EventAttribute.ORGANIZATIONID, ("" + orgId));
    }

    @Override
    public final void setDateTime(Date dateTime) {
        this.set(EventAttribute.DATETIME, dateTime.toString());
    }

    @Override
    public final void setLocation(Address location) {
        this.set(EventAttribute.LOCATION, location.toString());
    }

    @Override
    public final void setTags(TagList tags) {
        this.set(EventAttribute.TAGS, tags.toString());
    }

    @Override
    public final void setAttending(int numAttending) {
        this.set(EventAttribute.ATTENDING, ("" + numAttending));
    }
}
