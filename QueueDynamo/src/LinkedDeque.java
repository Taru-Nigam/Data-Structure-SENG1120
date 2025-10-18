import java.util.Iterator;

/*Author: Taru Nigam
 *Student No: c3509116
 *Date: 10/11/2024
 *Description: This class implements a generic deque using a LinkedList as its underlying
 *             data structure, adhering to the DequeADT interface. It provides operations
 *             for adding and removing elements from both ends, and is iterable.
 */
public class LinkedDeque<E> implements DequeADT<E> {

    /**
     * The underlying LinkedList instance to manage deque elements.
     */
    private LinkedList<E> list;

    /**
     * Constructor for LinkedDeque.
     * Initializes an empty deque by creating a new LinkedList.
     */
    public LinkedDeque() {
        list = new LinkedList<>();
    }

    /**
     * Adds an element to the front of the deque.
     * This operation corresponds to adding an element to the first position of the underlying linked list.
     * @param element the element to be added.
     * @return true if the element was added successfully, false otherwise.
     */
    @Override
    public boolean addFirst(E element) {
        return list.addFirst(element);
    }

    /**
     * Adds an element to the end of the deque.
     * This operation corresponds to adding an element to the last position of the underlying linked list.
     * @param element the element to be added.
     * @return true if the element was added successfully, false otherwise.
     */
    @Override
    public boolean addLast(E element) {
        return list.addLast(element);
    }

    /**
     * Removes and returns the front element of the deque.
     * This operation corresponds to removing the first element from the underlying linked list.
     * @return the front element after removal.
     * @throws IllegalStateException if the deque is empty.
     */
    @Override
    public E removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty, cannot remove first element.");
        }
        return list.removeFirst();
    }

    /**
     * Removes and returns the last element of the deque.
     * This operation corresponds to removing the last element from the underlying linked list.
     * @return the last element after removal.
     * @throws IllegalStateException if the deque is empty.
     */
    @Override
    public E removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty, cannot remove last element.");
        }
        return list.removeLast();
    }

    /**
     * Returns the front element of the deque without removing it.
     * This operation corresponds to retrieving the first element of the underlying linked list.
     * @return the front element.
     * @throws IllegalStateException if the deque is empty.
     */
    @Override
    public E front() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty, no front element.");
        }
        return list.head();
    }

    /**
     * Returns the last element of the deque without removing it.
     * This operation corresponds to retrieving the last element of the underlying linked list.
     * @return the last element.
     * @throws IllegalStateException if the deque is empty.
     */
    @Override
    public E last() {
        if (isEmpty()) {
            throw new IllegalStateException("Deque is empty, no last element.");
        }
        return list.tail();
    }

    /**
     * Checks if the deque is empty.
     * @return true if the deque is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns the number of elements in the deque.
     * @return the size of the deque.
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Removes all elements from the deque, leaving it in an empty, but usable, state.
     * This operation delegates to the clear method of the underlying linked list.
     */
    @Override
    public void clear() {
        list.clear();
    }

    /**
     * Returns an iterator over the elements in this deque in proper sequence.
     * This simply returns the iterator of the underlying LinkedList.
     * @return an iterator over the elements in this deque.
     */
    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    /**
     * Returns a string representation of the deque.
     * @return A string containing all elements of the deque, from front to back.
     */
    @Override
    public String toString() {
        return list.toString();
    }
}
