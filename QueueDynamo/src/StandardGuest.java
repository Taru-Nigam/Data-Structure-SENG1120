/*Author: Taru Nigam
 *Student No: c3509116
 *Date: 10/11/2024
 *Description: This class represents a standard guest in the theme park simulation.
 *             It extends the abstract Guest class and provides its own constructor
 *             to initialize the guest's name.
 */
public class StandardGuest extends Guest {

    /**
     * Constructor for StandardGuest.
     * Calls the superclass (Guest) constructor to set the guest's name.
     * @param name The name of the standard guest.
     */
    public StandardGuest(String name) {
        super(name);
    }

    // No additional functionality or overridden methods are required for StandardGuest
    // beyond what is inherited from Guest, as per assignment specifications.
}
