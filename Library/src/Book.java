/**
 * A simple book that has a title and an author.
 * 
 * @author Kyle Robert Harrison
 * @version 1.0, 12 March 2025
 */
public class Book {
    /**
     * The title of the book.
     */
    private String title;

    /**
     * The author of the book.
     */
    private String author;

    /**
     * Constructs a new book with the given title and author.
     * 
     * @param title the title of the book
     * @param author the author of the book
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    /**
     * Gets the title of the book.
     * 
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the author of the book.
     * 
     * @return the author of the book
     */
    public String getAuthor() {
        return author;
    }
}