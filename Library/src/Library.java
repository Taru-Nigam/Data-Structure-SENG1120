import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A library that holds a collection of books in an ArrayList (i.e., an extendable array).
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 12 March 2025
 * @see ArrayList
 * @see List
 */
public class Library implements Iterable<Book>{
    /**
     * The collection of books in the library.
     * This is defined using the list interface to allow for flexibility in the implementation.
     */
    private List<Book> books;
    private int currentIndex = 0;

    private class LibraryIterator implements Iterator<Book> {
        @Override
        public boolean hasNext() {
            return currentIndex<books.size();
        }
        @Override
        public Book next() {
            if (hasNext()){
                Book book = books.get(currentIndex);
                currentIndex++;
                return book;
            }
            return null;
        }
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator();
    }
    /**
     * Constructs a new library with an empty collection of books.
     * THe collection is implemented as an ArrayList, which is an extendable array.
     */
    public Library() {
        books = new ArrayList<>();
    }

    /**
     * Adds a book to the library.
     * 
     * @param book the book to add
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /**
     * Finds a book in the library by its title.
     * 
     * @param title the title of the book to find
     * @return the book with the given title, or null if no such book exists
     */
    public Book findBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Prints all the books in the library, one per line.
     */
    public void printBooks() {
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        }
    }
}