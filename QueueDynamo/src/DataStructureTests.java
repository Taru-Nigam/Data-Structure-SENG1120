import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*Author: Taru Nigam
 *Student No: c3509116
 *Date: 10/11/2024
 *Description: This class provides comprehensive unit tests for the LinkedList, LinkedQueue,
 *             and LinkedDeque data structures using JUnit Jupiter. It aims to verify the
 *             correctness of all implemented methods and edge cases.
 */
public class DataStructureTests {

    private LinkedList<String> linkedList;
    private LinkedQueue<String> linkedQueue;
    private LinkedDeque<String> linkedDeque;

    /**
     * Sets up a fresh instance of each data structure before every test method.
     * This ensures that tests are independent and run in a clean state.
     */
    @BeforeEach
    void setUp() {
        linkedList = new LinkedList<>();
        linkedQueue = new LinkedQueue<>();
        linkedDeque = new LinkedDeque<>();
    }

    // --- LinkedList Tests ---

    @Test
    @DisplayName("LinkedList: Should be empty on initialization")
    void linkedList_isEmptyOnInitialization() {
        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
    }

    @Test
    @DisplayName("LinkedList: addFirst should add element to the front")
    void linkedList_addFirst_addsToFront() {
        linkedList.addFirst("A");
        assertEquals(1, linkedList.size());
        assertEquals("A", linkedList.head());
        assertEquals("A", linkedList.tail());
        linkedList.addFirst("B");
        assertEquals(2, linkedList.size());
        assertEquals("B", linkedList.head());
        assertEquals("A", linkedList.tail());
        assertEquals("[B, A]", linkedList.toString());
    }

    @Test
    @DisplayName("LinkedList: addLast should add element to the end")
    void linkedList_addLast_addsToEnd() {
        linkedList.addLast("A");
        assertEquals(1, linkedList.size());
        assertEquals("A", linkedList.head());
        assertEquals("A", linkedList.tail());
        linkedList.addLast("B");
        assertEquals(2, linkedList.size());
        assertEquals("A", linkedList.head());
        assertEquals("B", linkedList.tail());
        assertEquals("[A, B]", linkedList.toString());
    }

    @Test
    @DisplayName("LinkedList: add at specific index should work correctly")
    void linkedList_add_atIndex() {
        linkedList.addLast("A"); // [A]
        linkedList.addLast("C"); // [A, C]
        linkedList.add(1, "B"); // [A, B, C]
        assertEquals(3, linkedList.size());
        assertEquals("A", linkedList.get(0));
        assertEquals("B", linkedList.get(1));
        assertEquals("C", linkedList.get(2));
        assertEquals("[A, B, C]", linkedList.toString());

        linkedList.add(0, "Z"); // [Z, A, B, C]
        assertEquals("Z", linkedList.head());
        assertEquals(4, linkedList.size());

        linkedList.add(4, "W"); // [Z, A, B, C, W]
        assertEquals("W", linkedList.tail());
        assertEquals(5, linkedList.size());
    }

    @Test
    @DisplayName("LinkedList: add at invalid index should throw IndexOutOfBoundsException")
    void linkedList_add_invalidIndex_throwsException() {
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(-1, "X"));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(1, "X")); // Empty list, size 0
        linkedList.addLast("A");
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.add(2, "X")); // Size 1, valid indices 0, 1
    }

    @Test
    @DisplayName("LinkedList: removeFirst should remove and return the first element")
    void linkedList_removeFirst_removesFirst() {
        linkedList.addLast("A");
        linkedList.addLast("B"); // [A, B]
        assertEquals("A", linkedList.removeFirst()); // [B]
        assertEquals(1, linkedList.size());
        assertEquals("B", linkedList.head());
        assertEquals("B", linkedList.tail());
        assertEquals("B", linkedList.removeFirst()); // []
        assertTrue(linkedList.isEmpty());
    }

    @Test
    @DisplayName("LinkedList: removeLast should remove and return the last element")
    void linkedList_removeLast_removesLast() {
        linkedList.addLast("A");
        linkedList.addLast("B"); // [A, B]
        assertEquals("B", linkedList.removeLast()); // [A]
        assertEquals(1, linkedList.size());
        assertEquals("A", linkedList.head());
        assertEquals("A", linkedList.tail());
        assertEquals("A", linkedList.removeLast()); // []
        assertTrue(linkedList.isEmpty());
    }

    @Test
    @DisplayName("LinkedList: remove at specific index should work correctly")
    void linkedList_remove_atIndex() {
        linkedList.addLast("A");
        linkedList.addLast("B");
        linkedList.addLast("C"); // [A, B, C]
        assertEquals("B", linkedList.remove(1)); // [A, C]
        assertEquals(2, linkedList.size());
        assertEquals("A", linkedList.head());
        assertEquals("C", linkedList.tail());
        assertEquals("[A, C]", linkedList.toString());

        assertEquals("A", linkedList.remove(0)); // [C]
        assertEquals(1, linkedList.size());
        assertEquals("C", linkedList.head());

        assertEquals("C", linkedList.remove(0)); // []
        assertTrue(linkedList.isEmpty());
    }

    @Test
    @DisplayName("LinkedList: remove from empty list should throw IllegalStateException")
    void linkedList_remove_emptyList_throwsException() {
        assertThrows(IllegalStateException.class, () -> linkedList.removeFirst());
        assertThrows(IllegalStateException.class, () -> linkedList.removeLast());
        assertThrows(IllegalStateException.class, () -> linkedList.remove(0));
    }

    @Test
    @DisplayName("LinkedList: get at invalid index should throw IndexOutOfBoundsException")
    void linkedList_get_invalidIndex_throwsException() {
        linkedList.addLast("A");
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.get(1)); // Size 1, valid index 0
    }

    @Test
    @DisplayName("LinkedList: head and tail from empty list should throw IllegalStateException")
    void linkedList_headTail_emptyList_throwsException() {
        assertThrows(IllegalStateException.class, () -> linkedList.head());
        assertThrows(IllegalStateException.class, () -> linkedList.tail());
    }

    @Test
    @DisplayName("LinkedList: contains should correctly identify elements")
    void linkedList_contains_elements() {
        linkedList.addLast("Apple");
        linkedList.addLast("Banana");
        assertTrue(linkedList.contains("Apple"));
        assertTrue(linkedList.contains("Banana"));
        assertFalse(linkedList.contains("Orange"));
        assertFalse(linkedList.contains(null)); // Assuming nulls are not stored or handled
    }

    @Test
    @DisplayName("LinkedList: clear should empty the list")
    void linkedList_clear_emptiesList() {
        linkedList.addLast("X");
        linkedList.addLast("Y");
        linkedList.clear();
        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
        assertEquals("[]", linkedList.toString());
    }

    @Test
    @DisplayName("LinkedList: Iterator should traverse all elements")
    void linkedList_iterator_traversesAllElements() {
        linkedList.addLast("One");
        linkedList.addLast("Two");
        linkedList.addLast("Three");
        Iterator<String> it = linkedList.iterator();
        assertTrue(it.hasNext());
        assertEquals("One", it.next());
        assertTrue(it.hasNext());
        assertEquals("Two", it.next());
        assertTrue(it.hasNext());
        assertEquals("Three", it.next());
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    @DisplayName("LinkedList: Iterator on empty list should have no elements")
    void linkedList_iterator_emptyList() {
        Iterator<String> it = linkedList.iterator();
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }

    // --- LinkedQueue Tests ---

    @Test
    @DisplayName("LinkedQueue: Should be empty on initialization")
    void linkedQueue_isEmptyOnInitialization() {
        assertTrue(linkedQueue.isEmpty());
        assertEquals(0, linkedQueue.size());
    }

    @Test
    @DisplayName("LinkedQueue: enqueue should add elements to the back")
    void linkedQueue_enqueue_addsToBack() {
        linkedQueue.enqueue("First");
        assertEquals(1, linkedQueue.size());
        assertEquals("First", linkedQueue.front());
        linkedQueue.enqueue("Second");
        assertEquals(2, linkedQueue.size());
        assertEquals("First", linkedQueue.front()); // Front should remain "First"
        assertEquals("[First, Second]", linkedQueue.toString());
    }

    @Test
    @DisplayName("LinkedQueue: dequeue should remove and return the front element")
    void linkedQueue_dequeue_removesFront() {
        linkedQueue.enqueue("A");
        linkedQueue.enqueue("B"); // [A, B]
        assertEquals("A", linkedQueue.dequeue()); // [B]
        assertEquals(1, linkedQueue.size());
        assertEquals("B", linkedQueue.front());
        assertEquals("B", linkedQueue.dequeue()); // []
        assertTrue(linkedQueue.isEmpty());
    }

    @Test
    @DisplayName("LinkedQueue: dequeue from empty queue should throw IllegalStateException")
    void linkedQueue_dequeue_emptyQueue_throwsException() {
        assertThrows(IllegalStateException.class, () -> linkedQueue.dequeue());
    }

    @Test
    @DisplayName("LinkedQueue: front should return front element without removing it")
    void linkedQueue_front_returnsFront() {
        linkedQueue.enqueue("X");
        linkedQueue.enqueue("Y");
        assertEquals("X", linkedQueue.front());
        assertEquals(2, linkedQueue.size()); // Size should not change
        assertEquals("X", linkedQueue.front());
    }

    @Test
    @DisplayName("LinkedQueue: front from empty queue should throw IllegalStateException")
    void linkedQueue_front_emptyQueue_throwsException() {
        assertThrows(IllegalStateException.class, () -> linkedQueue.front());
    }

    @Test
    @DisplayName("LinkedQueue: clear should empty the queue")
    void linkedQueue_clear_emptiesQueue() {
        linkedQueue.enqueue("1");
        linkedQueue.enqueue("2");
        linkedQueue.clear();
        assertTrue(linkedQueue.isEmpty());
        assertEquals(0, linkedQueue.size());
        assertEquals("[]", linkedQueue.toString());
    }

    @Test
    @DisplayName("LinkedQueue: Iterator should traverse all elements in FIFO order")
    void linkedQueue_iterator_traversesAllElements() {
        linkedQueue.enqueue("Alpha");
        linkedQueue.enqueue("Beta");
        linkedQueue.enqueue("Gamma");
        Iterator<String> it = linkedQueue.iterator();
        assertTrue(it.hasNext());
        assertEquals("Alpha", it.next());
        assertTrue(it.hasNext());
        assertEquals("Beta", it.next());
        assertTrue(it.hasNext());
        assertEquals("Gamma", it.next());
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }

    // --- LinkedDeque Tests ---

    @Test
    @DisplayName("LinkedDeque: Should be empty on initialization")
    void linkedDeque_isEmptyOnInitialization() {
        assertTrue(linkedDeque.isEmpty());
        assertEquals(0, linkedDeque.size());
    }

    @Test
    @DisplayName("LinkedDeque: addFirst should add element to the front")
    void linkedDeque_addFirst_addsToFront() {
        linkedDeque.addFirst("A");
        assertEquals(1, linkedDeque.size());
        assertEquals("A", linkedDeque.front());
        assertEquals("A", linkedDeque.last());
        linkedDeque.addFirst("B");
        assertEquals(2, linkedDeque.size());
        assertEquals("B", linkedDeque.front());
        assertEquals("A", linkedDeque.last());
        assertEquals("[B, A]", linkedDeque.toString());
    }

    @Test
    @DisplayName("LinkedDeque: addLast should add element to the end")
    void linkedDeque_addLast_addsToEnd() {
        linkedDeque.addLast("A");
        assertEquals(1, linkedDeque.size());
        assertEquals("A", linkedDeque.front());
        assertEquals("A", linkedDeque.last());
        linkedDeque.addLast("B");
        assertEquals(2, linkedDeque.size());
        assertEquals("A", linkedDeque.front());
        assertEquals("B", linkedDeque.last());
        assertEquals("[A, B]", linkedDeque.toString());
    }

    @Test
    @DisplayName("LinkedDeque: removeFirst should remove and return the front element")
    void linkedDeque_removeFirst_removesFront() {
        linkedDeque.addLast("X");
        linkedDeque.addLast("Y"); // [X, Y]
        assertEquals("X", linkedDeque.removeFirst()); // [Y]
        assertEquals(1, linkedDeque.size());
        assertEquals("Y", linkedDeque.front());
        assertEquals("Y", linkedDeque.removeFirst()); // []
        assertTrue(linkedDeque.isEmpty());
    }

    @Test
    @DisplayName("LinkedDeque: removeLast should remove and return the last element")
    void linkedDeque_removeLast_removesLast() {
        linkedDeque.addFirst("X");
        linkedDeque.addFirst("Y"); // [Y, X]
        assertEquals("X", linkedDeque.removeLast()); // [Y]
        assertEquals(1, linkedDeque.size());
        assertEquals("Y", linkedDeque.last());
        assertEquals("Y", linkedDeque.removeLast()); // []
        assertTrue(linkedDeque.isEmpty());
    }

    @Test
    @DisplayName("LinkedDeque: removeFirst/Last from empty deque should throw IllegalStateException")
    void linkedDeque_remove_emptyDeque_throwsException() {
        assertThrows(IllegalStateException.class, () -> linkedDeque.removeFirst());
        assertThrows(IllegalStateException.class, () -> linkedDeque.removeLast());
    }

    @Test
    @DisplayName("LinkedDeque: front and last should return elements without removing them")
    void linkedDeque_frontLast_returnsElements() {
        linkedDeque.addFirst("C");
        linkedDeque.addLast("D"); // [C, D]
        assertEquals("C", linkedDeque.front());
        assertEquals("D", linkedDeque.last());
        assertEquals(2, linkedDeque.size()); // Size should not change
    }

    @Test
    @DisplayName("LinkedDeque: front/last from empty deque should throw IllegalStateException")
    void linkedDeque_frontLast_emptyDeque_throwsException() {
        assertThrows(IllegalStateException.class, () -> linkedDeque.front());
        assertThrows(IllegalStateException.class, () -> linkedDeque.last());
    }

    @Test
    @DisplayName("LinkedDeque: clear should empty the deque")
    void linkedDeque_clear_emptiesDeque() {
        linkedDeque.addFirst("P");
        linkedDeque.addLast("Q");
        linkedDeque.clear();
        assertTrue(linkedDeque.isEmpty());
        assertEquals(0, linkedDeque.size());
        assertEquals("[]", linkedDeque.toString());
    }

    @Test
    @DisplayName("LinkedDeque: Iterator should traverse all elements from front to back")
    void linkedDeque_iterator_traversesAllElements() {
        linkedDeque.addFirst("Z"); // [Z]
        linkedDeque.addLast("A");  // [Z, A]
        linkedDeque.addFirst("Y"); // [Y, Z, A]
        Iterator<String> it = linkedDeque.iterator();
        assertTrue(it.hasNext());
        assertEquals("Y", it.next());
        assertTrue(it.hasNext());
        assertEquals("Z", it.next());
        assertTrue(it.hasNext());
        assertEquals("A", it.next());
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }
}
