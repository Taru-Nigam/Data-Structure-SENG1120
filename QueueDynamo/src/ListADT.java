/**
 * Interface for a generic linked list that contains references to both the head and tail.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 8 Jan 2025
 */
public interface ListADT<E> extends Iterable<E>{

    /**
     * Inserts the specified element at the supplied index of this list.
     * @param index - the index (location) to insert the supplied element.
     * @param element - the element to add.
     */
    public boolean add(int index, E element);

    /**
     * Inserts the specified element at the beginning of this list.
     * @param element - the element to add.
     */
    public boolean addFirst(E element);

    /**
     * Inserts the specified element at the end of this list.
     * @param element - the element to add.
     */
    public boolean addLast(E element);

    
    /**
     * Returns true if this list contains the specified element.
     * @param element - element whose presence in this list is to be tested.
     * @return true if this list contains the specified element.
     */
    public boolean contains(E element);

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return.
     * @return the element at the specified position in this list.
     */
    public E get(int index);

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     * @return the head of this list
     */
    public E head();

    /**
     * Retrieves, but does not remove, the tail (last element) of this list.
     * @return the tail of this list
     */
    public E tail();

    /**
     * Removes and returns the first element from this list.
     * If the list is empty, an exception is thrown.
     * @return The first element from this list.
     */
    public E removeFirst();

    /**
     * Removes and returns the last element from this list.
     * If the list is empty, an exception is thrown.
     * @return The last element from this list.
     */
    public E removeLast();

    /**
     * Removes and returns the item at the specified index from this list. 
     * If the list is empty or the index is out of range, an exception is thrown.
     * @param index - the index of the element to be removed.
     * @return The element that was (previously) at the specified index.
     */
    public E remove(int index);

    /**
     * Returns true if this list contains no elements.
     * @return true if this list contains no elements.
     */
    public boolean isEmpty();

    /**
     * Returns the number of elements in this list.
     * @return the number of elements in this list.
     */
    public int size();

    /**
     * Removes all of the elements from this list, leaving it in an empty, but usable, state.
     */
    public void clear();
}
