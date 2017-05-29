import java.util.Scanner;

import teamgobu.components.Address.Address1;
import teamgobu.components.Date.Date1;
import teamgobu.components.Event.Event;
import teamgobu.components.Event.Event1;
import teamgobu.components.EventList.EventList;
import teamgobu.components.EventList.EventList1;
import teamgobu.components.TagList.TagList1;

/**
 * This is a class to test the general functionality of the TeamGobu components.
 */
public final class ComponentsTest {

    /**
     * Constant for number of attributes of an Event.
     */
    private static final int NUM_ATTRIBUTES = 8;

    /**
     * An EventList object to store the added events.
     */
    private static EventList eventList = new EventList1();

    /**
     * Constructor to not allow instantiation.
     */
    private ComponentsTest() {
        //Intentionally left empty
    }

    /**
     * Method to ask for input for attributes of an Event object, and returns a
     * string array of those attributes.
     *
     * @param in
     *            the scanner object to read from
     * @return an array containing the attributes entered
     */
    private static String[] askForEventInput(Scanner in) {
        String[] attributes = new String[NUM_ATTRIBUTES];
        System.out.println("Enter the following information to add an Event:");
        System.out.print("    Event Name: ");
        attributes[0] = in.nextLine();
        System.out.print("    Event Description: ");
        attributes[1] = in.nextLine();
        System.out.print("    Unique Event ID: ");
        attributes[2] = in.nextLine();
        System.out.print("    Organization ID: ");
        attributes[3] = in.nextLine();
        System.out
                .print("    Date and Time (YYYY/MM/DD/HH/MM/(true or false): ");
        attributes[4] = in.nextLine();
        System.out.print(
                "    Event Location (STATE/CITY/ZIP/ADDRESS1/ADDRESS2/LAT/LONG): ");
        attributes[5] = in.nextLine();
        System.out.print("    Event Tags (TAG1/TAG2/...): ");
        attributes[6] = in.nextLine();
        System.out.print("    Number Attending: ");
        attributes[7] = in.nextLine();
        return attributes;
    }

    /**
     * Method to add an Event having the given attributes to the EventList.
     *
     * @param attributes
     *            the attributes to create the Event from
     */
    private static void addEvent(String[] attributes) {
        Event event = new Event1();
        event.setName(attributes[0]);
        event.setDescription(attributes[1]);
        event.setId(Integer.parseInt(attributes[2]));
        event.setOrganizationId(Integer.parseInt(attributes[3]));
        event.setDateTime(new Date1(attributes[4]));
        event.setLocation(new Address1(attributes[5]));
        event.setTags(new TagList1(attributes[6]));
        event.setAttending(Integer.parseInt(attributes[7]));
        eventList.addEvent(event);
    }

    /**
     * Method to print the contents of an Event.
     *
     * @param id
     *            the id of the event to print
     */
    private static void printEvent(int id) {
        Event event = eventList.getEvent(id);
        System.out.println();
        System.out.println("    Name: " + event.name());
        System.out.println("    Description: " + event.description());
        System.out.println("    ID: " + event.id());
        System.out.println("    Organization ID: " + event.organizationId());
        System.out.println("    Date: " + event.dateTime().month() + "/"
                + event.dateTime().day() + "/" + event.dateTime().year());
        System.out.print("    Time: " + event.dateTime().hour() + ":"
            + event.dateTime().minute());
        if (event.dateTime().am()) {
            System.out.println(" AM");
        } else {
            System.out.println(" PM");
        }
        System.out.println("    Location: " + event.location().address1() + " "
                + event.location().address2());
        System.out.println("              " + event.location().city() + " "
                + event.location().state() + " " + event.location().zip());
        System.out.println("    Tags: " + event.tags().toString());
        System.out.println("    Number Attending: " + event.attending());
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        boolean cont = true;
        Scanner in = new Scanner(System.in);
        while (cont) {
            System.out.println("What would you like to do?");
            System.out.println("    Enter Event: type E");
            System.out.println("    Print Event: type P");
            System.out.println("    Exit: type X");
            System.out.println();
            System.out.print(">> ");
            String input = in.nextLine();
            System.out.println();
            switch (input) {
                case "E":
                    String[] eventAttributes = askForEventInput(in);
                    addEvent(eventAttributes);
                    System.out.println();
                    System.out.println("Thank You for Adding Your Event!");
                    System.out.println();
                    break;
                case "P":
                    System.out.print(
                            "What is the ID of the Event you want to print?: ");
                    int id = Integer.parseInt(in.nextLine());
                    if (eventList.isInList(id)) {
                        printEvent(id);
                    } else {
                        System.out.println(
                                "Sorry, that Event doesn't seem to exist.");
                    }
                    System.out.println();
                    break;
                case "X":
                    cont = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Your input was not understood.");
                    System.out.println();
            }
        }
    }
}
