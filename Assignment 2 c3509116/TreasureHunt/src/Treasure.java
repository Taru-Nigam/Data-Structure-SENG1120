/**
 * Base class for treasures in the game.
 * Treasures can be of various types (e.g., Weapon, Potion) and have different effects on the player.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 26 Sept 2025
 */
public abstract class Treasure {
    /**
     * Name of the treasure.
     */
    private String name;
    /**
     * Value of the treasure, in gold coins.
     */
    private int value;

    /**
     * Constructor to initialise the treasure with a name and value.
     * @param name The name of the treasure.
     * @param value The value of the treasure in gold coins.
     */
    public Treasure(String name, int value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Get the name of the treasure.
     * @return The name of the treasure.
     */
    public String getName() { return name; }

    /**
     * Get the value of the treasure.
     * @return The value of the treasure in gold coins.
     */
    public int getValue() { return value; }

    /**
     * Apply the treasure’s effect to the player.
     */
    public abstract void applyEffect(Player player);

    /**
     * Remove the treasure's effect from the player.
     * @param player
     */
    public abstract void removeEffect(Player player);
    
    @Override
    public String toString() {
        return name + " (value: " + value + ")";
    }
}
