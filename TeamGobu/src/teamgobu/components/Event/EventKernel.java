package teamgobu.components.Event;

import teamgobu.components.Standard.Standard;

/**
 * Created by Noah Gibson on 5/14/2017.
 *
 * Interface for {@code set}, {@code get}, and {@code isSet} methods that are
 * used to manipulate and access an {@code Event} object.
 *
 * The formats of the different attribute types are as follows: - For the
 * attribute DATETIME, the string is formatted as "YYYY/MM/DD/HH/MM/AM" - For
 * the attribute LOCATION, the string is formatted as
 * "STATE/CITY/ZIP/ADDRESS1/ADDRESS2/LAT/LONG" - For the attribute TAGS, the
 * string is formatted as "TAG1/TAG2/..."
 */
//TODO - Move descriptions of correct date and address to respective kernels
public interface EventKernel extends Standard<Event> {

    /**
     * Method to set the value of the {@code attributeName} attribute of
     * {@code this} to the given value {@code value}.
     *
     * @param attributeName
     *            the name of the attribute to set
     * @param value
     *            the value to set the attribute to
     * @replaces this.attributeName
     * @requires [{@code value} is of the proper format for the attribute being
     *           set]
     * @ensures this.attributeName = value
     */
    void set(Event.EventAttribute attributeName, String value);

    /**
     * Returns the value of the {@code attributeName} attribute of {@code this}.
     *
     * @param attributeName
     *            the name of the attribute to get the value of
     * @return the value of this.attributeName
     * @ensures get = [value of this.attributeName]
     */
    String get(Event.EventAttribute attributeName);

    /**
     * Reports if the {@code attributeName} attribute of {@code this} has
     * already been set.
     *
     * @param attributeName
     *            the name of the attribute
     * @return true iff this.attributeName has already been set
     * @ensures isSet = [this.attributeName has been set by calling {@code set}]
     *          or [this.attributeName is empty]
     */
    boolean isSet(Event.EventAttribute attributeName);

}
