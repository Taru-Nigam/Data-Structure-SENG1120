/**
 * A generic doubly linked list implementation with head and tail sentinels.
 * Implements the ListADT interface.
 *
 * @author Your Name
 * @version 1.0
 */
public class LinkedList<E> implements ListADT<E> {

    /**
     * Node class for doubly linked list nodes.
     */
    private class Node {
        E data;
        Node prev;
        Node next;

        Node(E data) {
            this.data = data;
        }
    }

    private Node head;  // Sentinel node at the front (does not hold data)
    private Node tail;  // Sentinel node at the end (does not hold data)
    private int size;

    /**
     * Constructs an empty linked list with head and tail sentinels.
     */
    public LinkedList() {
        head = new Node(null);  // head sentinel
        tail = new Node(null);  // tail sentinel
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /**
     * Validates that the element is not null.
     */
    private void checkElementNotNull(E element) {
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
    }

    /**
     * Validates that the index is within bounds for add (0 <= index <= size).
     */
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

    /**
     * Validates that the index is within bounds for get/remove (0 <= index < size).
     */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
    }

    /**
     * Returns the node at the specified index.
     * Assumes index is valid.
     */
    private Node getNode(int index) {
        Node current;
        if (index < size / 2) {
            // Start from head
            current = head.next;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            // Start from tail
            current = tail.prev;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    @Override
    public void add(int index, E element) {
        checkElementNotNull(element);
        checkIndexForAdd(index);

        // Find node currently at index (or tail sentinel if index == size)
        Node nextNode = (index == size) ? tail : getNode(index);
        Node prevNode = nextNode.prev;

        Node newNode = new Node(element);
        newNode.prev = prevNode;
        newNode.next = nextNode;
        prevNode.next = newNode;
        nextNode.prev = newNode;

        size++;
    }

    @Override
    public void addFirst(E element) {
        add(0, element);
    }

    @Override
    public void addLast(E element) {
        add(size, element);
    }

    @Override
    public boolean contains(E element) {
        checkElementNotNull(element);
        Node current = head.next;
        while (current != tail) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return getNode(index).data;
    }

    @Override
    public E head() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return head.next.data;
    }

    @Override
    public E tail() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return tail.prev.data;
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return remove(0);
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return remove(size - 1);
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        Node nodeToRemove = getNode(index);
        Node prevNode = nodeToRemove.prev;
        Node nextNode = nodeToRemove.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        size--;
        return nodeToRemove.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        // Disconnect all nodes for GC
        Node current = head.next;
        while (current != tail) {
            Node next = current.next;
            current.prev = null;
            current.next = null;
            current.data = null;
            current = next;
        }
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /**
     * Returns a string representation of the list in the form [e1, e2, e3, ...].
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node current = head.next;
        while (current != tail) {
            sb.append(current.data);
            if (current.next != tail) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Returns an iterator over the elements in this list in proper sequence.
     */
    @Override
    public java.util.Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    /**
     * Iterator implementation for LinkedList.
     */
    private class LinkedListIterator implements java.util.Iterator<E> {
        private Node current = head.next;

        @Override
        public boolean hasNext() {
            return current != tail;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            E data = current.data;
            current = current.next;
            return data;
        }
    }
}
