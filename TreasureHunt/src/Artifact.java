/**
 * Represents a rare artifact treasure that has no direct effect on player stats.
 * Inherits from the Treasure class.
 * Artifacts are simply collectibles that players can find during their exploration and have no effect, but can be sold for their value.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 26 Sept 2025
 */
public class Artifact extends Treasure {
    /**
     * Constructor to initialise the artifact with a name and value.
     * @param name the name of the artifact
     * @param value the value of the artifact in gold coins
     */
    public Artifact(String name, int value) {
        super(name, value);
    }

    /**
     * Artifacts have no direct effect on player stats, but can display a message when found.
     * @param player the player to apply the effect to
     */
    @Override
    public void applyEffect(Player player) {
        System.out.println("You found a rare artifact: " + getName());
    }

    /**
     * Artifacts have no lasting effect to remove.
     * @param player the player to remove the effect from
     */
    @Override
    public void removeEffect(Player player) {
        // Artifacts have no lasting effect to remove
    }

    @Override
    public String toString() {
        return super.toString() + " [Artifact]";
    }
}
