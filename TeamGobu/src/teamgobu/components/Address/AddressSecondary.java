package teamgobu.components.Address;

/**
 * Created by Noah Gibson on 5/14/2017.
 *
 * Layered implementations of secondary methods for {@code Address}, including
 * overriden methods inherited from {@code Object}.
 */
public abstract class AddressSecondary implements Address {

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
        if (!(obj instanceof Address)) {
            return false;
        }
        Address address = (Address) obj;
        AddressAspect[] aspects = AddressAspect.values();
        for (AddressAspect aspect : aspects) {
            if (!this.get(aspect).equals(address.get(aspect))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final String toString() {
        String addressString = "";
        addressString += this.get(AddressAspect.STATE) + "/";
        addressString += this.get(AddressAspect.CITY) + "/";
        addressString += this.get(AddressAspect.ZIP) + "/";
        addressString += this.get(AddressAspect.ADDRESS1) + "/";
        addressString += this.get(AddressAspect.ADDRESS2) + "/";
        addressString += this.get(AddressAspect.LAT) + "/";
        addressString += this.get(AddressAspect.LONG);
        return addressString;
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
    public final double latitude() {
        return Double.parseDouble(this.get(AddressAspect.LAT));
    }

    @Override
    public final double longitude() {
        return Double.parseDouble(this.get(AddressAspect.LONG));
    }

    @Override
    public final String state() {
        return this.get(AddressAspect.STATE);
    }

    @Override
    public final String city() {
        return this.get(AddressAspect.CITY);
    }

    @Override
    public final String address1() {
        return this.get(AddressAspect.ADDRESS1);
    }

    @Override
    public final String address2() {
        return this.get(AddressAspect.ADDRESS2);
    }

    @Override
    public final int zip() {
        return Integer.parseInt(this.get(AddressAspect.ZIP));
    }

    /*
     * Manipulator methods------------------------------------------------------
     */
    @Override
    public final void setLatitude(double latitude) {
        this.set(AddressAspect.LAT, ("" + latitude));
    }

    @Override
    public final void setLongitude(double longitude) {
        this.set(AddressAspect.LONG, ("" + longitude));
    }

    @Override
    public final void setState(String state) {
        this.set(AddressAspect.STATE, state);
    }

    @Override
    public final void setCity(String city) {
        this.set(AddressAspect.CITY, city);
    }

    @Override
    public final void setAddress1(String address1) {
        this.set(AddressAspect.ADDRESS1, address1);
    }

    @Override
    public final void setAddress2(String address2) {
        this.set(AddressAspect.ADDRESS2, address2);
    }

    @Override
    public final void setZip(int zip) {
        this.set(AddressAspect.ZIP, ("" + zip));
    }

}
