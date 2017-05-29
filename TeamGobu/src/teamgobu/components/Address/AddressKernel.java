package teamgobu.components.Address;

import teamgobu.components.Standard.Standard;

/**
 * Created by Noah Gibson on 5/14/2017.
 *
 * An object to hold the contents of an address.
 *
 * An address for this object includes: - Latitude - Longitude - State - City -
 * Street Address 1 - Street Address 2 - Zip Code
 */
public interface AddressKernel extends Standard<Address> {

    /**
     * Method to set the value of the {@code aspectName} aspect of {@code this}
     * to the given value {@code value}.
     *
     * @param aspectName
     *            the name of the aspect to set
     * @param value
     *            the value to set the aspect to
     * @replaces this.aspectName
     * @requires [{@code value} is of the proper format for the aspect being
     *           set]
     * @ensures this.aspectName = value
     */
    void set(Address.AddressAspect aspectName, String value);

    /**
     * Returns the value of the {@code aspectName} aspect of {@code this}.
     *
     * @param aspectName
     *            the name of the aspect to get the value of
     * @return the value of this.aspectName
     * @ensures get = [value of this.aspectName]
     */
    String get(Address.AddressAspect aspectName);

    /**
     * Reports if the {@code aspectName} aspect of {@code this} has already been
     * set.
     *
     * @param aspectName
     *            the name of the aspect
     * @return true iff this.aspectName has already been set
     * @ensures isSet = [this.aspectName has been set by calling {@code set}]
     */
    boolean isSet(Address.AddressAspect aspectName);

}
