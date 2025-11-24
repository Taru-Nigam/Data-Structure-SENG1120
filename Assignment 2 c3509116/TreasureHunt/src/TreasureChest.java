import java.util.ArrayList;
import java.util.List;

/**
 * Represents a chest containing treasures.
 *
 * @author Taru Nigam
 * @studentNo c3509116
 * @date 11 Nov 2025
 * @description Manages a list of treasures using ArrayList.
 */
public class TreasureChest {
    private ArrayList<Treasure> treasures;

    public TreasureChest() {
        treasures = new ArrayList<>();
    }

    /**
     * Adds a treasure to the chest.
     */
    public void addTreasure(Treasure treasure) {
        treasures.add(treasure);
    }

    /**
     * Returns the list of treasures.
     */
    public List<Treasure> getTreasures() {
        return treasures;
    }

    /**
     * Checks if chest is empty.
     */
    public boolean isEmpty() {
        return treasures.isEmpty();
    }
}