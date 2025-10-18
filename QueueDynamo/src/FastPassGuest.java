/*Author: Taru Nigam
 *Student No: c3509116
 *Date: 10/11/2024
 *Description: This class represents a FastPass guest, who may also be a GoldFastPass guest,
 *             in the theme park simulation. It extends the abstract Guest class and includes
 *             additional functionality to indicate their FastPass tier status.
 */
public class FastPassGuest extends Guest {

    /**
     * A boolean indicating whether this FastPass guest is a GoldFastPass guest.
     * true for GoldFastPass, false for regular FastPass.
     */
    private boolean isGold;

    /**
     * Constructor for FastPassGuest.
     * Calls the superclass (Guest) constructor to set the guest's name and
     * initializes the GoldFastPass status.
     * @param name The name of the FastPass guest.
     * @param isGold True if the guest is a GoldFastPass holder, false otherwise.
     */
    public FastPassGuest(String name, boolean isGold) {
        super(name);
        this.isGold = isGold;
    }

    /**
     * Checks if this FastPass guest is a GoldFastPass holder.
     * @return true if the guest is a GoldFastPass holder, false otherwise.
     */
    public boolean isGold() {
        return isGold;
    }

    /**
     * Returns a string representation of the FastPassGuest.
     * The format is "FastPassGuest: <name>, Gold: <isGold>".
     * @return A string representing the FastPass guest and their Gold status.
     */
    @Override
    public String toString() {
        return "FastPassGuest: " + getName() + ", Gold: " + isGold;
    }
}
