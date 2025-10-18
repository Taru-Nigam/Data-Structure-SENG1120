/**
 * Interface for a generic deque that is iterable.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 20 Aug 2025
 */
public interface DequeADT<E> extends Iterable<E> {
    /**
     * Adds an element to the front of the deque.
     * @param element the element to be added
     * @return true if the element was added successfully, false otherwise
     */
    public boolean addFirst(E element);

    /**
     * Adds an element to the end of the deque.
     * @param element the element to be added
     * @return true if the element was added successfully, false otherwise
     */
    public boolean addLast(E element);

    /**
     * Removes and returns the front element of the deque.
     * @return the front element after removal
     */
    public E removeFirst();

    /**
     * Removes and returns the last element of the deque.
     * @return the last element after removal
     */
    public E removeLast();

    /**
     * Returns the front element of the deque without removing it.
     * @return the front element
     */
    public E front();

    /**
     * Returns the last element of the deque without removing it.
     * @return the last element
     */
    public E last();

    /**
     * Checks if the deque is empty.
     * @return true if the deque is empty, false otherwise
     */
    public boolean isEmpty();
    
    /**
     * Returns the number of elements in the deque.
     * @return the size of the deque
     */
    public int size();

    /**
     * Removes all elements from the deque, leaving it in an empty, but usable, state.
     */
    public void clear();
}
