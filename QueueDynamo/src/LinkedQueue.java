import java.util.Iterator;

/*Author: Taru Nigam
 *Student No: c3509116
 *Date: 10/11/2024
 *Description: This class implements a generic queue using a LinkedList as its underlying
 *             data structure, adhering to the QueueADT interface. It provides standard
 *             queue operations (enqueue, dequeue, front) and is iterable.
 */
public class LinkedQueue<E> implements QueueADT<E> {

    /**
     * The underlying LinkedList instance to manage queue elements.
     */
    private LinkedList<E> list;

    /**
     * Constructor for LinkedQueue.
     * Initializes an empty queue by creating a new LinkedList.
     */
    public LinkedQueue() {
        list = new LinkedList<>();
    }

    /**
     * Adds an element to the end of the queue.
     * This operation corresponds to adding an element to the last position of the underlying linked list.
     * @param element the element to be added.
     * @return true if the element was added successfully, false otherwise.
     */
    @Override
    public boolean enqueue(E element) {
        return list.addLast(element);
    }

    /**
     * Removes and returns the front element of the queue.
     * This operation corresponds to removing the first element from the underlying linked list.
     * @return the front element.
     * @throws IllegalStateException if the queue is empty.
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty, cannot dequeue.");
        }
        return list.removeFirst();
    }

    /**
     * Returns the front element of the queue without removing it.
     * This operation corresponds to retrieving the first element of the underlying linked list.
     * @return the front element.
     * @throws IllegalStateException if the queue is empty.
     */
    @Override
    public E front() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty, no front element.");
        }
        return list.head();
    }

    /**
     * Checks if the queue is empty.
     * @return true if the queue is empty, false otherwise.
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Returns the number of elements in the queue.
     * @return the size of the queue.
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Removes all elements from the queue, leaving it in an empty, but usable, state.
     * This operation delegates to the clear method of the underlying linked list.
     */
    @Override
    public void clear() {
        list.clear();
    }

    /**
     * Returns an iterator over the elements in this queue in proper sequence.
     * This simply returns the iterator of the underlying LinkedList.
     * @return an iterator over the elements in this queue.
     */
    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }

    /**
     * Returns a string representation of the queue.
     * @return A string containing all elements of the queue, from front to back.
     */
    @Override
    public String toString() {
        return list.toString();
    }
}
