import java.util.Scanner;
import java.util.LinkedList;

/**
 * Main driver class for the Treasure Hunt game.
 * It manages the game world, player interactions, and the main game loop.
 * @author Kyle Robert Harrison
 * @version 1.0, 26 Sept 2025
 */
public class GameDriver {
    /**
     * Hash table to store locations with their corresponding treasure chests and guardians.
     * Key: Location name (String)
     * Value: Object array containing TreasureChest and Guardian (Object[]). 
     * We use Object[] to store both types together. This is perhaps not the most type-safe way, but it simplifies the storage.
     */
    private HashTableADT<String, Object[]> world;

    /**
     * The player object representing the user playing the game.
     */
    private Player player;

    /**
     * List of available locations in the game.
     */
    private LinkedList<String> locations;

    /**
     * Constructor to initialise the game world, player, and locations.
     */
    public GameDriver() {
        this.world = new ChainingHashTable<>();
        this.player = new Player();
        this.locations = new LinkedList<>();
        initialiseWorld();
    }

    /**
     * Initialises the game world with predefined locations, treasure chests, and guardians.
     * This method populates the hash table with various locations, each containing a treasure chest and possibly a guardian.
     * Ideally, this data would come from a configuration file or database, but for simplicity, it's hardcoded here.
     */
    private void initialiseWorld() {
        TreasureChest caveChest = new TreasureChest();
        caveChest.addTreasure(new Weapon("RustySword", 10, 5));
        caveChest.addTreasure(new Artifact("EmeraldNecklace", 100));

        world.insert("Cave", new Object[]{caveChest, new Guardian("Goblin", 8)});
        this.locations.addLast("Cave");

        TreasureChest forestChest = new TreasureChest();
        forestChest.addTreasure(new Potion("GoldenApple", 50, 20));

        world.insert("ForestNorth", new Object[]{forestChest, null});
        this.locations.addLast("ForestNorth");

        TreasureChest lakeChest = new TreasureChest();
        lakeChest.addTreasure(new Weapon("Trident", 80, 15));
        lakeChest.addTreasure(new Potion("HealingHerb", 30, 10));

        world.insert("LakeSide", new Object[]{lakeChest, new Guardian("WaterSpirit", 15)});
        this.locations.addLast("LakeSide");

        TreasureChest mountainChest = new TreasureChest();
        mountainChest.addTreasure(new Artifact("AncientCoin", 200));

        world.insert("MountainBase", new Object[]{mountainChest, new Guardian("RockGiant", 30)});
        this.locations.addLast("MountainBase");


        TreasureChest desertChest = new TreasureChest();
        desertChest.addTreasure(new Weapon("Scimitar", 60, 12));
        desertChest.addTreasure(new Artifact("SandRuby", 150));
        desertChest.addTreasure(new Potion("OasisWater", 40, 15));

        world.insert("DesertEdge", new Object[]{desertChest, new Guardian("SandWorm", 12)});
        this.locations.addLast("DesertEdge");
    }

    /**
     * Main game loop to process user commands and interact with the game world.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Treasure Hunt!");
        System.out.println("Explore locations to find treasures and fight guardians.");
        System.out.println("Available locations: " + String.join(", ", locations));
        System.out.println("Commands: explore <loc>, inventory, sell <name>, stats, quit");

        while (true) {
            if(player.getHP() <= 0) {
                System.out.println("You have been defeated! Game over.");
                break;
            }
           
            System.out.print("> ");
            String command = scanner.next();

            if (command.equalsIgnoreCase("explore")) {
                String location = scanner.next();
                exploreLocation(location);
            } else if (command.equalsIgnoreCase("inventory")) {
                player.listInventory();
            } else if (command.equalsIgnoreCase("sell")) {
                String name = scanner.next();
                player.sellTreasure(name);
            } else if (command.equalsIgnoreCase("stats")) {
                player.printStats();
            } else if (command.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Unknown command.");
            }

            System.out.println("Available locations: " + String.join(", ", locations));
        }
        scanner.close();
    }

    /**
     * Handles the exploration of a given location.
     * If the location has a guardian, the player must fight it first. If the guardian is defeated or absent, the player collects treasures from the chest.
     * After exploration, the location is removed from the list of available locations.
     * @param location The name of the location to explore.
     */
    private void exploreLocation(String location) {
        Object[] data = world.get(location);
        if (data == null) {
            System.out.println("No such location.");
            return;
        }
        TreasureChest chest = (TreasureChest) data[0];
        Guardian guardian = (Guardian) data[1];

        if (guardian != null && !guardian.fight(player)) {
            return;
        }
        if (chest.isEmpty()) {
            System.out.println("Chest is empty.");
            return;
        }
        for (var t : chest.getTreasures()) {
            player.collectTreasure(t);
            System.out.println("Collected: " + t);
        }
        world.remove(location);
        locations.remove(location);
    }
}
