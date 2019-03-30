package pl.coderslab.books;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();
    Book getBookById(long id);
    void addBook(String isbn, String title, String author, String publisher, String type);
    void updateBook(long id, String isbn, String title, String author, String publisher, String type);
    void deleteBook(long id);

}
