package teamgobu.components.Date;

/**
 * Created by Noah Gibson on 5/15/2017.
 *
 * Interface for enhanced methods of a Date object.
 */
public interface Date extends DateKernel {

    /**
     * Enum type for date aspects.
     */
    enum DateAspect {

        /**
         * Aspects of the date.
         */
        YEAR("Year", 0), MONTH("Month", 1), DAY("Day", 2), HOUR("Hour", 3), MINUTE("Minute", 4), AM("AM", 5);

        /**
         * Variable to store the string representation.
         */
        private String toString;

        /**
         * Variable to store the id of the aspect.
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
        DateAspect(String aspect, int id) {
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
     * Returns the year aspect of date.
     *
     * @requires this.year.isSet
     * @return the year of this
     */
    int year();

    /**
     * Returns the month aspect of date.
     *
     * @requires this.month.isSet
     * @return the month of this
     */
    int month();

    /**
     * Returns the day aspect of date.
     *
     * @requires this.day.isSet
     * @return the day of this
     */
    int day();

    /**
     * Returns the hour aspect of date.
     *
     * @requires this.hour.isSet
     * @return the hour of this
     */
    int hour();

    /**
     * Returns the minute aspect of date.
     *
     * @requires this.minute.isSet
     * @return the minute of this
     */
    int minute();

    /**
     * Returns the am aspect of date.
     *
     * @requires this.am.isSet
     * @return the am of this
     */
    boolean am();

    /**
     * Sets the year aspect of the date to the given year.
     *
     * @param year
     *            the new year
     * @replaces this.year
     * @ensures this.year = year
     */
    void setYear(int year);

    /**
     * Sets the month aspect of the date to the given month.
     *
     * @param month
     *            the new month
     * @replaces this.month
     * @ensures this.month = month
     */
    void setMonth(int month);

    /**
     * Sets the day aspect of the date to the given day.
     *
     * @param day
     *            the new day
     * @replaces this.day
     * @ensures this.day = day
     */
    void setDay(int day);

    /**
     * Sets the hour aspect of the date to the given hour.
     *
     * @param hour
     *            the new hour
     * @replaces this.hour
     * @ensures this.hour = hour
     */
    void setHour(int hour);

    /**
     * Sets the minute aspect of the date to the given minute.
     *
     * @param minute
     *            the new minute
     * @replaces this.minute
     * @ensures this.minute = minute
     */
    void setMinute(int minute);

    /**
     * Sets the am aspect of the date to the given am.
     *
     * @param am
     *            the new am
     * @replaces this.am
     * @ensures this.am = am
     */
    void setAm(boolean am);

}
