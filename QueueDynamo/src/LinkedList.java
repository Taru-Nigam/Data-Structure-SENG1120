import java.util.Iterator;
import java.util.NoSuchElementException;

/*Author: Taru Nigam
 *Student No: c3509116
 *Date: 10/11/2024
 *Description: This class implements a generic doubly linked list with two sentinel nodes,
 *             adhering to the ListADT interface. It supports operations for adding,
 *             removing, and accessing elements at various positions, and provides an iterator.
 */
public class LinkedList<E> implements ListADT<E> {

    /**
     * Private nested Node class representing an element in the linked list.
     * Each node holds data and references to the previous and next nodes.
     */
    private class Node {
        private E data;
        private Node prev;
        private Node next;

        /**
         * Constructor for a Node.
         * @param data The data to be stored in the node.
         * @param prev The previous node in the list.
         * @param next The next node in the list.
         */
        public Node(E data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        /**
         * Gets the data stored in this node.
         * @return The data.
         */
        public E getData() {
            return data;
        }

        /**
         * Sets the data stored in this node.
         * @param data The new data.
         */
        public void setData(E data) {
            this.data = data;
        }

        /**
         * Gets the previous node.
         * @return The previous node.
         */
        public Node getPrev() {
            return prev;
        }

        /**
         * Sets the previous node.
         * @param prev The new previous node.
         */
        public void setPrev(Node prev) {
            this.prev = prev;
        }

        /**
         * Gets the next node.
         * @return The next node.
         */
        public Node getNext() {
            return next;
        }

        /**
         * Sets the next node.
         * @param next The new next node.
         */
        public void setNext(Node next) {
            this.next = next;
        }
    }

    /**
     * Private nested LinkedListIterator class for iterating over the elements of the list.
     */
    private class LinkedListIterator implements Iterator<E> {
        private Node current;

        /**
         * Constructor for LinkedListIterator.
         * Starts iteration from the first actual element (after the head sentinel).
         */
        public LinkedListIterator() {
            current = headSentinel.getNext();
        }

        /**
         * Checks if there is a next element in the iteration.
         * @return true if there is a next element, false otherwise.
         */
        @Override
        public boolean hasNext() {
            return current != tailSentinel;
        }

        /**
         * Returns the next element in the iteration.
         * @return The next element.
         * @throws NoSuchElementException if there are no more elements.
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the list.");
            }
            E data = current.getData();
            current = current.getNext();
            return data;
        }

        /**
         * Removes the last element returned by the iterator (optional operation).
         * Not implemented for this assignment.
         * @throws UnsupportedOperationException if called.
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove operation not supported by this iterator.");
        }
    }

    private Node headSentinel; // Sentinel node at the beginning of the list
    private Node tailSentinel; // Sentinel node at the end of the list
    private int size;          // Current number of elements in the list

    /**
     * Constructor for LinkedList.
     * Initializes an empty doubly linked list with two sentinel nodes.
     */
    public LinkedList() {
        headSentinel = new Node(null, null, null); // Head sentinel
        tailSentinel = new Node(null, headSentinel, null); // Tail sentinel
        headSentinel.setNext(tailSentinel); // Link head to tail
        size = 0;
    }

    /**
     * Helper method to add a node between two existing nodes.
     * @param element The element to add.
     * @param predecessor The node before the new node.
     * @param successor The node after the new node.
     * @return true if the element was added successfully.
     */
    private boolean addBetween(E element, Node predecessor, Node successor) {
        if (element == null) {
            // Handle null elements if necessary, or throw IllegalArgumentException
            return false;
        }
        Node newNode = new Node(element, predecessor, successor);
        predecessor.setNext(newNode);
        successor.setPrev(newNode);
        size++;
        return true;
    }

    /**
     * Helper method to remove a given node from the list.
     * @param node The node to remove.
     * @return The data of the removed node.
     * @throws IllegalArgumentException if the node is a sentinel.
     */
    private E removeNode(Node node) {
        if (node == headSentinel || node == tailSentinel) {
            throw new IllegalArgumentException("Cannot remove sentinel nodes.");
        }
        if (isEmpty()) {
            throw new IllegalStateException("List is empty, cannot remove.");
        }
        Node predecessor = node.getPrev();
        Node successor = node.getNext();
        predecessor.setNext(successor);
        successor.setPrev(predecessor);
        node.setPrev(null); // Dereference for garbage collection
        node.setNext(null); // Dereference for garbage collection
        size--;
        return node.getData();
    }

    /**
     * Helper method to get the node at a specific index.
     * @param index The index of the node to retrieve.
     * @return The node at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node current;
        if (index < size / 2) { // Traverse from head if closer
            current = headSentinel.getNext();
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } else { // Traverse from tail if closer
            current = tailSentinel.getPrev();
            for (int i = size - 1; i > index; i--) {
                current = current.getPrev();
            }
        }
        return current;
    }

    /**
     * Inserts the specified element at the supplied index of this list.
     * @param index - the index (location) to insert the supplied element.
     * @param element - the element to add.
     * @return true if the element was added successfully, false otherwise.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index > size()).
     */
    @Override
    public boolean add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == size) { // Adding to the end
            return addLast(element);
        } else if (index == 0) { // Adding to the beginning
            return addFirst(element);
        } else {
            Node successor = getNode(index);
            return addBetween(element, successor.getPrev(), successor);
        }
    }

    /**
     * Inserts the specified element at the beginning of this list.
     * @param element - the element to add.
     * @return true if the element was added successfully, false otherwise.
     */
    @Override
    public boolean addFirst(E element) {
        return addBetween(element, headSentinel, headSentinel.getNext());
    }

    /**
     * Inserts the specified element at the end of this list.
     * @param element - the element to add.
     * @return true if the element was added successfully, false otherwise.
     */
    @Override
    public boolean addLast(E element) {
        return addBetween(element, tailSentinel.getPrev(), tailSentinel);
    }

    /**
     * Returns true if this list contains the specified element.
     * @param element - element whose presence in this list is to be tested.
     * @return true if this list contains the specified element.
     */
    @Override
    public boolean contains(E element) {
        if (element == null) {
            // Decide how to handle null elements. For now, assume no nulls are stored or check for null equality.
            return false;
        }
        Node current = headSentinel.getNext();
        while (current != tailSentinel) {
            if (current.getData().equals(element)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return.
     * @return the element at the specified position in this list.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size()).
     */
    @Override
    public E get(int index) {
        return getNode(index).getData();
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     * @return the head of this list.
     * @throws IllegalStateException if the list is empty.
     */
    @Override
    public E head() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty.");
        }
        return headSentinel.getNext().getData();
    }

    /**
     * Retrieves, but does not remove, the tail (last element) of this list.
     * @return the tail of this list.
     * @throws IllegalStateException if the list is empty.
     */
    @Override
    public E tail() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty.");
        }
        return tailSentinel.getPrev().getData();
    }

    /**
     * Removes and returns the first element from this list.
     * If the list is empty, an exception is thrown.
     * @return The first element from this list.
     * @throws IllegalStateException if the list is empty.
     */
    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty, cannot remove first element.");
        }
        return removeNode(headSentinel.getNext());
    }

    /**
     * Removes and returns the last element from this list.
     * If the list is empty, an exception is thrown.
     * @return The last element from this list.
     * @throws IllegalStateException if the list is empty.
     */
    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty, cannot remove last element.");
        }
        return removeNode(tailSentinel.getPrev());
    }

    /**
     * Removes and returns the item at the specified index from this list.
     * If the list is empty or the index is out of range, an exception is thrown.
     * @param index - the index of the element to be removed.
     * @return The element that was (previously) at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size()).
     * @throws IllegalStateException if the list is empty.
     */
    @Override
    public E remove(int index) {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty, cannot remove element at index " + index);
        }
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return removeNode(getNode(index));
    }

    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all of the elements from this list, leaving it in an empty, but usable, state.
     */
    @Override
    public void clear() {
        headSentinel.setNext(tailSentinel);
        tailSentinel.setPrev(headSentinel);
        size = 0;
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     * @return an iterator over the elements in this list.
     */
    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    /**
     * Returns a string representation of the list.
     * @return A string containing all elements of the list, separated by commas.
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder("[");
        Node current = headSentinel.getNext();
        while (current != tailSentinel) {
            sb.append(current.getData());
            if (current.getNext() != tailSentinel) {
                sb.append(", ");
            }
            current = current.getNext();
        }
        sb.append("]");
        return sb.toString();
    }
}
