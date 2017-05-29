package teamgobu.components.Date;

/**
 * Created by Noah Gibson on 5/15/2017.
 *
 * Layered implementation of secondary methods for {@code Date}, including
 * overriden methods inherited from {@code Object}.
 */
public abstract class DateSecondary implements Date {

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
        if (!(obj instanceof Date)) {
            return false;
        }
        Date date = (Date) obj;
        DateAspect[] aspects = DateAspect.values();
        for (DateAspect aspect : aspects) {
            if (!this.get(aspect).equals(date.get(aspect))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final String toString() {
        String dateString = "";
        dateString += this.get(DateAspect.YEAR) + "/";
        dateString += this.get(DateAspect.MONTH) + "/";
        dateString += this.get(DateAspect.DAY) + "/";
        dateString += this.get(DateAspect.HOUR) + "/";
        dateString += this.get(DateAspect.MINUTE) + "/";
        dateString += this.get(DateAspect.AM);
        return dateString;
    }

    @Override
    public final int hashCode() {
        //TODO - Write hashCode method
        return 1;
    }

    /*
     * Accessor methods
     * -------------------------------------------------------------------------
     * ---
     */
    @Override
    public final int year() {
        return Integer.parseInt(this.get(DateAspect.YEAR));
    }

    @Override
    public final int month() {
        return Integer.parseInt(this.get(DateAspect.MONTH));
    }

    @Override
    public final int day() {
        return Integer.parseInt(this.get(DateAspect.DAY));
    }

    @Override
    public final int hour() {
        return Integer.parseInt(this.get(DateAspect.HOUR));
    }

    @Override
    public final int minute() {
        return Integer.parseInt(this.get(DateAspect.MINUTE));
    }

    @Override
    public final boolean am() {
        return Boolean.parseBoolean(this.get(DateAspect.AM));
    }

    /*
     * Manipulator methods
     * -------------------------------------------------------------------------
     */
    @Override
    public final void setYear(int year) {
        this.set(DateAspect.YEAR, ("" + year));
    }

    @Override
    public final void setMonth(int month) {
        this.set(DateAspect.MONTH, ("" + month));
    }

    @Override
    public final void setDay(int day) {
        this.set(DateAspect.DAY, ("" + day));
    }

    @Override
    public final void setHour(int hour) {
        this.set(DateAspect.HOUR, ("" + hour));
    }

    @Override
    public final void setMinute(int minute) {
        this.set(DateAspect.MINUTE, ("" + minute));
    }

    @Override
    public final void setAm(boolean am) {
        this.set(DateAspect.AM, ("" + am));
    }

}
