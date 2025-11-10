/**
 * Represents the player in the game, managing stats and inventory.
 * This class tracks player health, attack, gold, and uses a BST for inventory management in the Treasure Hunt game.
 * It supports collecting treasures (applying effects), selling items, listing inventory, and handling combat damage.
 * Key methods include collectTreasure (inserts into BST and applies effects), sellTreasure (removes and reverses effects), listInventory (sorted display),
 * and stat methods like heal/takeDamage. It integrates with Treasure subclasses and GameDriver for gameplay, ensuring HP stays non-negative.
 *
 * @author Taru Nigam
 * @studentNo c3509116
 * @date 11 Nov 2025
 * @description Manages player HP, attack, gold, and inventory using a BST, supporting core game mechanics.
 */
public class Player {
    private int hp;
    private int attack;
    private int gold;
    private LinkedBinarySearchTree<String, Treasure> inventory;

    public Player() {
        hp = 100; // Default HP
        attack = 10; // Default attack
        gold = 0;
        inventory = new LinkedBinarySearchTree<>();
    }

    /**
     * Collects a treasure, adds to inventory, and applies effect.
     */
    public void collectTreasure(Treasure treasure) {
        inventory.insert(treasure.getName(), treasure);
        treasure.applyEffect(this);
    }

    /**
     * Lists inventory in sorted order.
     */
    public void listInventory() {
        for (Treasure t : inventory) {
            System.out.println(" - " + t);
        }
    }

    /**
     * Sells a treasure by name, removes effect, adds gold.
     */
    public void sellTreasure(String name) {
        Treasure t = inventory.find(name);
        if (t != null) {
            inventory.remove(name);
            t.removeEffect(this);
            gold += t.getValue();
            System.out.println("Sold " + name + " for " + t.getValue() + " gold.");
        } else {
            System.out.println("No treasure named " + name + " found in inventory.");
        }
    }

    /**
     * Heals the player.
     */
    public void heal(int amount) {
        hp += amount;
    }

    /**
     * Deals damage, ensuring HP doesn't go below 0.
     */
    public void takeDamage(int amount) {
        hp -= amount;
        if (hp < 0) hp = 0;
    }

    /**
     * Increases attack.
     */
    public void increaseAttack(int bonus) {
        attack += bonus;
    }

    /**
     * Decreases attack.
     */
    public void decreaseAttack(int amount) {
        attack -= amount;
    }

    /**
     * Adds gold.
     */
    public void addGold(int amount) {
        gold += amount;
    }

    /**
     * Prints stats.
     */
    public void printStats() {
        System.out.println("HP: " + hp + " | Attack: " + attack + " | Gold: " + gold);
    }

    // Getters for other classes
    public int getHP() { return hp; }
    public int getAttack() { return attack; }
}