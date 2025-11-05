/**
 * Class representing a weapon treasure that increases the player's attack power.
 * Inherits from the Treasure class and implements specific effects for weapons.
 * The weapon has an attack bonus that is applied to the player when the weapon is acquired and removed when the weapon is discarded.
 * Note: this does not handle equipping/unequipping logic; it simply applies/removes the effect when in the player's inventory.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 26 Sept 2025
 */
public class Weapon extends Treasure {
    /**
     * Attack bonus provided by the weapon.
     */
    private int attackBonus;

    /**
     * Constructor to initialise the weapon with a name, value, and attack bonus.
     * @param name the name of the weapon
     * @param value the value of the weapon in gold coins
     * @param attackBonus the attack bonus provided by the weapon
     */
    public Weapon(String name, int value, int attackBonus) {
        super(name, value);
        this.attackBonus = attackBonus;
    }

    /**
     * Apply the weapon's effect to the player by increasing their attack power.
     * @param player the player to apply the effect to
     */
    @Override
    public void applyEffect(Player player) {
        player.increaseAttack(attackBonus);
        System.out.println("Your attack increased by " + attackBonus + "!");
    }

    /**
     * Remove the weapon's effect from the player by decreasing their attack power.
     * @param player the player to remove the effect from
     */
    @Override
    public void removeEffect(Player player) {
        player.decreaseAttack(attackBonus);
        System.out.println("Your attack decreased by " + attackBonus + ".");
    }

    @Override
    public String toString() {
        return super.toString() + " [Weapon: +" + attackBonus + " attack]";
    }
}
