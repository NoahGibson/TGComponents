package teamgobu.components.Event;

import teamgobu.components.Address.Address;
import teamgobu.components.Date.Date;
import teamgobu.components.TagList.TagList;

/**
 * Created by Noah Gibson on 5/14/2017.
 *
 * Interface for enhanced methods for an Event object.
 */
public interface Event extends EventKernel {

    /**
     * Enum type for attribute names.
     */
    enum EventAttribute {

        /**
         * Values for the attributes.
         */
        NAME("Name", 0), DESCRIPTION("Description", 1), ID("ID", 2), ORGANIZATIONID("OrganizationId", 3), DATETIME("DateTime", 4), LOCATION("Location", 5), TAGS("Tags", 6), ATTENDING("Attending", 7);

        /**
         * Variable for string description of type.
         */
        private String toString;

        /**
         * Variable for the id of the type.
         */
        private int id;

        /**
         * Constructor to set toString to string representation.
         *
         * @param name
         *            the string representation
         * @param id
         *            the id of the attribute
         */
        EventAttribute(String name, int id) {
            this.toString = name;
            this.id = id;
        }

        @Override
        public String toString() {
            return this.toString;
        }

        /**
         * Method to return the ID of the attribute.
         *
         * @return the id of the attribute
         */
        public int id() {
            return this.id;
        }

    }

    /**
     * Reports the name attribute of {@code this}.
     *
     * @requires this.name.isSet
     * @return the name of this
     */
    String name();

    /**
     * Reports the description attribute of {@code this}.
     *
     * @requires this.description.isSet
     * @return the description of this
     */
    String description();

    /**
     * Reports the unique ID of {@code this}.
     *
     * @requires this.id.isSet
     * @return the ID of this
     */
    int id();

    /**
     * Reports the ID of the organization that is putting on {@code this}.
     *
     * @requires this.organizationId.isSet
     * @return the organization ID of this
     */
    int organizationId();

    /**
     * Reports the date and time of {@code this}.
     *
     * @requires this.date.isSet
     * @return a Date object containing the date and time of this
     */
    Date dateTime();

    /**
     * Reports the location of {@code this}.
     *
     * @requires this.location.isSet
     * @return an Address object containing the location of this
     */
    Address location();

    /**
     * Returns a list of the tags describing {@code this}.
     *
     * @requires this.tags.isSet
     * @return a list of strings which are the tags of this
     */
    TagList tags();

    /**
     * Reports the number of people planning on attending {@code this}.
     *
     * @requires this.attending.isSet
     * @return the number of users saying the plan on attending this
     */
    int attending();

    /**
     * Updates the name attribute of {@code this} to {@code name}.
     *
     * @param name
     *            the name of the event to set
     * @replaces this.name
     * @ensures this.name = name
     */
    void setName(String name);

    /**
     * Updates the description attribute of {@code this} to {@code description}.
     *
     * @param description
     *            the description of the event to set
     * @replaces this.description
     * @ensures this.description = description
     */
    void setDescription(String description);

    /**
     * Updates the ID attribute of {@code this} to {@code id}.
     *
     * @param id
     *            the ID of the event to set
     * @replaces this.id
     * @requires [id is a unique id]
     * @ensures this.id = id
     */
    void setId(int id);

    /**
     * Updates the organization ID attribute of {@code this} to {@code orgId}.
     *
     * @param orgId
     *            the organization ID of the event to set
     * @replaces this.organizationId
     * @ensures this.organizationId = organizationId
     */
    void setOrganizationId(int orgId);

    /**
     * Updates the date and time attribute of {@code this} to {@code dateTime}.
     *
     * @param dateTime
     *            the date and time of the event to set
     * @replaces this.dateTime
     * @ensures this.dateTime = dateTime
     */
    void setDateTime(Date dateTime);

    /**
     * Updates the location attribute of {@code this} to {@code location}.
     *
     * @param location
     *            the location of the event to set
     * @replaces this.location
     * @ensures this.location = location
     */
    void setLocation(Address location);

    /**
     * Updates the tag attribute of {@code this} to {@code tags}.
     *
     * @param tags
     *            the tags of the event to set
     * @replaces this.tags
     * @clears tags
     * @ensures this.tags = tags
     */
    void setTags(TagList tags);

    /**
     * Updates the attending attribute of {@code this} to {@code numAttending}.
     *
     * @param numAttending
     *            the number of people attending the event to set
     * @replaces this.attending
     * @ensures this.attending = numAttending
     */
    void setAttending(int numAttending);

}
