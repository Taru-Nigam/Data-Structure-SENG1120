import java.util.Iterator; // Used for iterating through queues for printStatus

/*Author: Taru Nigam
 *Student No: c3509116
 *Date: 10/11/2024
 *Description: This class manages the queueing logic for The Polymorphic Plunge ride.
 *             It uses a LinkedQueue for standard guests and a LinkedDeque for FastPass guests,
 *             implementing priority-based processing and status reporting.
 */
public class RideQueueManager {

    /**
     * The queue for standard guests (First In First Out).
     */
    private QueueADT<StandardGuest> standardQueue;

    /**
     * The deque for FastPass and GoldFastPass guests (priority-based access).
     */
    private DequeADT<FastPassGuest> fastPassDeque;

    /**
     * Constructor for RideQueueManager.
     * Initializes the standard queue and the FastPass deque.
     */
    public RideQueueManager() {
        standardQueue = new LinkedQueue<>();
        fastPassDeque = new LinkedDeque<>();
    }

    /**
     * Adds a new StandardGuest to the end of the standard queue.
     * @param name The name of the standard guest.
     * @return true if the guest was successfully added, false otherwise.
     */
    public boolean addStandardGuest(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Guest name cannot be empty.");
            return false;
        }
        StandardGuest guest = new StandardGuest(name);
        return standardQueue.enqueue(guest);
    }

    /**
     * Adds a new FastPassGuest to the FastPass deque.
     * Regular FastPass guests are added to the end, while GoldFastPass guests are added to the front.
     * @param name The name of the FastPass guest.
     * @param isGold True if the guest is a GoldFastPass holder, false for a regular FastPass holder.
     * @return true if the guest was successfully added, false otherwise.
     */
    public boolean addFastPassGuest(String name, boolean isGold) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Guest name cannot be empty.");
            return false;
        }
        FastPassGuest guest = new FastPassGuest(name, isGold);
        if (isGold) {
            return fastPassDeque.addFirst(guest); // GoldFastPass guests go to the front
        } else {
            return fastPassDeque.addLast(guest); // Regular FastPass guests go to the back
        }
    }

    /**
     * Processes the next guest to board The Polymorphic Plunge ride based on priority:
     * 1. GoldFastPass guests (from the front of the deque)
     * 2. Regular FastPass guests (from the front of the deque, after GoldFastPass)
     * 3. Standard guests (from the front of the queue)
     * Prints a message indicating which guest boarded and from which line, or if both lines are empty.
     */
    public void processNextGuest() {
        if (!fastPassDeque.isEmpty()) {
            // Process FastPass guests first (GoldFastPass are already at the front)
            FastPassGuest guest = fastPassDeque.removeFirst();
            System.out.println(guest.getName() + " is now boarding The Polymorphic Plunge from the FastPass line!");
        } else if (!standardQueue.isEmpty()) {
            // If no FastPass guests, process standard guests
            StandardGuest guest = standardQueue.dequeue();
            System.out.println(guest.getName() + " is now boarding The Polymorphic Plunge from the standard queue!");
        } else {
            // Both lines are empty
            System.out.println("Both lines are empty!");
        }
    }

    /**
     * Prints a status overview of the guests waiting in both the standard queue and the FastPass deque.
     * Displays the size of each line and lists the guests in each line.
     */
    public void printStatus() {
        System.out.println("--- Current Ride Status ---");

        // Print Standard Queue Status
        System.out.println("Standard Queue size: " + standardQueue.size());
        if (standardQueue.isEmpty()) {
            System.out.println("  (empty)");
        } else {
            Iterator<StandardGuest> standardIterator = standardQueue.iterator();
            while (standardIterator.hasNext()) {
                System.out.println("  " + standardIterator.next().toString());
            }
        }

        // Print FastPass Deque Status
        System.out.println("FastPass Deque size: " + fastPassDeque.size());
        if (fastPassDeque.isEmpty()) {
            System.out.println("  (empty)");
        } else {
            Iterator<FastPassGuest> fastPassIterator = fastPassDeque.iterator();
            while (fastPassIterator.hasNext()) {
                System.out.println("  " + fastPassIterator.next().toString());
            }
        }
    }
}
