/**
 * Class representing a healing potion treasure.
 * Inherits from the Treasure class and implements specific effects for potions.
 * It is used immediately upon acquisition, and has no lasting effect to remove.
 * The potion then stays in the player's inventory as a record of what they have found, and can be then be sold for its value.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 26 Sept 2025
 */
public class Potion extends Treasure {
    /**
     * Amount of health restored by the potion.
     */
    private int healAmount;

    /**
     * Constructor to initialise the potion with a name, value, and heal amount.
     * @param name the name of the potion
     * @param value the value of the potion in gold coins
     * @param healAmount the amount of health restored by the potion
     */
    public Potion(String name, int value, int healAmount) {
        super(name, value);
        this.healAmount = healAmount;
    }

    /**
     * Apply the potion's effect to the player by restoring health.
     * @param player the player to apply the effect to
     */
    @Override
    public void applyEffect(Player player) {
        player.heal(healAmount);
        System.out.println("You restored " + healAmount + " HP!");
    }

    /**
     * Remove the potion's effect from the player.
     * Potions have no lasting effect to remove.
     * @param player the player to remove the effect from
     */
    @Override
    public void removeEffect(Player player) {
        // Potions have no lasting effect to remove
    }

    @Override
    public String toString() {
        return super.toString() + " [Potion: +" + healAmount + " HP]";
    }
}
