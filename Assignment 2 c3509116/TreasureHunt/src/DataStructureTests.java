/**
 * Unit tests for the data structures LinkedBinarySearchTree and ChainingHashTable.
 *
 * @author Taru Nigam
 * @studentNo c3509116
 * @date 11 Nov 2025
 * @description Comprehensive JUnit tests for BST and HashTable functionality.
 */
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Iterator;

public class DataStructureTests {
    private LinkedBinarySearchTree<String, Integer> bst;
    private ChainingHashTable<String, Integer> hashTable;

    @BeforeEach
    public void setUp() {
        bst = new LinkedBinarySearchTree<>();
        hashTable = new ChainingHashTable<>();
    }

    // Tests for LinkedBinarySearchTree
    @Test
    public void testBSTInsertAndFind() {
        bst.insert("key1", 1);
        assertEquals(1, bst.find("key1"));
        assertNull(bst.find("key2"));
    }

    @Test
    public void testBSTRemove() {
        bst.insert("key1", 1);
        bst.remove("key1");
        assertNull(bst.find("key1"));
        assertEquals(1, bst.size());
    }

    @Test
    public void testBSTContains() {
        bst.insert("key1", 1);
        assertTrue(bst.contains("key1"));
        assertFalse(bst.contains("key2"));
    }

    @Test
    public void testBSTMinMax() {
        bst.insert("b", 2);
        bst.insert("a", 1);
        bst.insert("c", 3);
        assertEquals(1, bst.findMin());
        assertEquals(3, bst.findMax());
    }

    @Test
    public void testBSTIterator() {
        bst.insert("b", 2);
        bst.insert("a", 1);
        bst.insert("c", 3);
        Iterator<Integer> iter = bst.iterator();
        assertEquals(1, iter.next());
        assertEquals(2, iter.next());
        assertEquals(3, iter.next());
        assertFalse(iter.hasNext());
    }

    @Test
    public void testBSTSizeAndEmpty() {
        assertTrue(bst.isEmpty());
        assertEquals(0, bst.size());
        bst.insert("key1", 1);
        assertFalse(bst.isEmpty());
        assertEquals(1, bst.size());
        bst.clear();
        assertTrue(bst.isEmpty());
    }

    // Tests for ChainingHashTable
    @Test
    public void testHashTableInsertAndGet() {
        hashTable.insert("key1", 1);
        assertEquals(1, hashTable.get("key1"));
        assertNull(hashTable.get("key2"));
    }

    @Test
    public void testHashTableRemove() {
        hashTable.insert("key1", 1);
        assertEquals(null, hashTable.remove("key1"));
        assertNull(hashTable.get("key1"));
        assertEquals(0, hashTable.size());
    }

    @Test
    public void testHashTableContains() {
        hashTable.insert("key1", 1);
        assertTrue(hashTable.contains("key1"));
        assertFalse(hashTable.contains("key2"));
    }

    @Test
    public void testHashTableSizeAndEmpty() {
        assertTrue(hashTable.isEmpty());
        assertEquals(0, hashTable.size());
        hashTable.insert("key1", 1);
        assertFalse(hashTable.isEmpty());
        assertEquals(1, hashTable.size());
        hashTable.clear();
        assertTrue(hashTable.isEmpty());
    }

    @Test
    public void testHashTableUpdateValue() {
        hashTable.insert("key1", 1);
        hashTable.insert("key1", 2); // Update value
        assertEquals(2, hashTable.get("key1"));
        assertEquals(2, hashTable.size()); // Size should not increase
    }
}
