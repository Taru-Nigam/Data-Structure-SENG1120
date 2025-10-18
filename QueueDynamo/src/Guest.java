/*Author: Taru Nigam
 *Student No: c3509116
 *Date: 10/11/2024
 *Description: This abstract class serves as the base for all guest types in the Queue Dynamo
 *             simulation. It provides common functionality such as storing the guest's name
 *             and a basic string representation.
 */
public abstract class Guest {

    /**
     * The name of the guest.
     */
    private String name;

    /**
     * Constructor for the Guest class.
     * @param name The name of the guest.
     */
    public Guest(String name) {
        this.name = name;
    }

    /**
     * Retrieves the name of the guest.
     * @return The name of the guest.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a string representation of the Guest.
     * The format is "Guest: <name>".
     * @return A string representing the guest.
     */
    @Override
    public String toString() {
        return "Guest: " + name;
    }
}
