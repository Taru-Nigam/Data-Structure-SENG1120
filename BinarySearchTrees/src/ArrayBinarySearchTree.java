import java.util.ArrayList;
import java.util.Iterator;

public abstract class ArrayBinarySearchTree<K extends Comparable<K>, V> implements BinarySearchTreeADT<K, V> {
    private ArrayList<KeyValueEntry<K, V>> tree;

    public ArrayBinarySearchTree() {
        tree = new ArrayList<>();
        tree.add(null); // Index 0 unused
    }

    @Override
    public void insert(K key, V value) {
        int index = 1; // Start at root
        while (index < tree.size()) {
            if (tree.get(index) == null) break;
            int cmp = key.compareTo(tree.get(index).getKey());
            if (cmp < 0) index = 2 * index;
            else if (cmp > 0) index = 2 * index + 1;
            else {
                tree.set(index, new KeyValueEntry<>(key, value)); // Update
                return;
            }
        }
        // Expand array if needed
        while (tree.size() <= index) tree.add(null);
        tree.set(index, new KeyValueEntry<>(key, value));
    }

    // Implement other methods similarly (e.g., find at index, remove by swapping, etc.). Iterators can traverse the array.
    // Note: Removal is complex (may require shifting or marking deleted).
    // This is basic; full implementation would mirror linked version but with array indices.
}