package teamgobu.components.Address;

/**
 * Created by Noah Gibson on 5/14/2017.
 *
 * Interface for enhanced methods of an Address object.
 */
public interface Address extends AddressKernel {

    /**
     * Enum type for address aspects.
     */
    enum AddressAspect {

        /**
         * Aspects of the address.
         */
        STATE("State", 0), CITY("City", 1), ZIP("Zip Code", 2), ADDRESS1("Street Address 1", 3), ADDRESS2("Street Address 2", 4), LAT("Latitude", 5), LONG("Longitude", 6);

        /**
         * Variable to store the string representation.
         */
        private String toString;

        /**
         * Variable to store the id of each aspect.
         */
        private int id;

        /**
         * Constructor for the aspects.
         *
         * @param aspect
         *            the string representation of the aspect
         * @param id
         *            the id of the aspect
         */
        AddressAspect(String aspect, int id) {
            this.toString = aspect;
            this.id = id;
        }

        @Override
        public String toString() {
            return this.toString;
        }

        /**
         * Method to return the ID of the aspect.
         *
         * @return the id of the aspect
         */
        public int id() {
            return this.id;
        }

    }

    /**
     * Returns the latitude aspect of address.
     *
     * @requires this.latitude.isSet
     * @return the latitude of this
     */
    double latitude();

    /**
     * Returns the longitude aspect of address.
     *
     * @requires this.longitude.isSet
     * @return the longitude of this
     */
    double longitude();

    /**
     * Returns the state aspect of address.
     *
     * @requires this.state.isSet
     * @return the state of this
     */
    String state();

    /**
     * Returns the city aspect of address.
     *
     * @requires this.city.isSet
     * @return the city of this
     */
    String city();

    /**
     * Returns the address1 aspect of address.
     *
     * @requires this.address1.isSet
     * @return the address1 of this
     */
    String address1();

    /**
     * Returns the address2 aspect of address.
     *
     * @requires this.address2.isSet
     * @return the address2 of this
     */
    String address2();

    /**
     * Returns the zip aspect of address.
     *
     * @requires this.zip.isSet
     * @return the zip of this
     */
    int zip();

    /**
     * Sets the latitude aspect of the address to the given latitude.
     *
     * @param latitude
     *            the new latitude
     * @replaces this.latitude
     * @ensures this.latitude = latitude
     */
    void setLatitude(double latitude);

    /**
     * Sets the longitude aspect of the address to the given longitude.
     *
     * @param longitude
     *            the new longitude
     * @replaces this.longitude
     * @ensures this.longitude = longitude
     */
    void setLongitude(double longitude);

    /**
     * Sets the state aspect of the address to the given state.
     *
     * @param state
     *            the new state
     * @replaces this.state
     * @ensures this.state = state
     */
    void setState(String state);

    /**
     * Sets the city aspect of the address to the given city.
     *
     * @param city
     *            the new city
     * @replaces this.city
     * @ensures this.city = city
     */
    void setCity(String city);

    /**
     * Sets the address1 aspect of the address to the given address1.
     *
     * @param address1
     *            the new address1
     * @replaces this.address1
     * @ensures this.address1 = address1
     */
    void setAddress1(String address1);

    /**
     * Sets the address2 aspect of the address to the given address2.
     *
     * @param address2
     *            the new address2
     * @replaces this.address2
     * @ensures this.address2 = address2
     */
    void setAddress2(String address2);

    /**
     * Sets the zip aspect of the address to the given zip.
     *
     * @param zip
     *            the new zip
     * @replaces this.zip
     * @ensures this.zip = zip
     */
    void setZip(int zip);

}
