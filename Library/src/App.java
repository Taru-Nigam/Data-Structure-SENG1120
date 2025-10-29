public class App {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("1984", "George Orwell");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee");

        library.addBook(book1);
        library.addBook(book2);

        library.printBooks();

        Book foundBook = library.findBookByTitle("To Kill a Mockingbird");
        System.out.println("Found Book: " + foundBook.getTitle());

        for (Book book : library) {
            System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor());
        }
    }
}
