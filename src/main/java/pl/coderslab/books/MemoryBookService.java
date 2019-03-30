package pl.coderslab.books;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBookService implements BookService{

    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public List<Book> getList() {
        return list;}

    public void setList(List<Book> list) {
        this.list = list;
    }

    @Override
    @GetMapping(path = "/",  produces = "application/json")
    public List<Book> getAllBooks() {
        return getList();
    }

    @Override
    @GetMapping(path = "{id}", produces = "application/json")
    public Book getBookById(@PathVariable(name = "id") long id) {
        Book book = null;
        for (Book bookToFind : list){
            if(bookToFind.getId() == id){
                book = bookToFind;
            }else{
                System.out.println("Cannot find book with id " + id);
            }
        }
        return book;
    }

    @Override
    @PostMapping(path = "/", produces = "application/json")
    public void addBook(String isbn, String title, String author, String publisher, String type){
        Book newBook = new Book(isbn, title, author, publisher, type);
        list.add(newBook);
    }

    @Override
    @PutMapping(path = "{id}")
    public void updateBook(@PathVariable(name="id") long id, String isbn, String title, String author, String publisher, String type){
        for (Book bookToFind : list){
            if(bookToFind.getId() == id){
                bookToFind.setIsbn(isbn);
                bookToFind.setTitle(title);
                bookToFind.setAuthor(author);
                bookToFind.setPublisher(publisher);
                bookToFind.setType(type);
                System.out.println("Updated book with id " + id);
            }else{
                System.out.println("Cannot find book with id " + id);
            }
        }
    }

    @Override
    @DeleteMapping(path = "{id}")
    public void deleteBook(@PathVariable(name="id") long id){
        for (Book bookToFind : list){
            if(bookToFind.getId() == id){
                list.remove(bookToFind);
                System.out.println("Removed book with id " + id);
            }else{
                System.out.println("Cannot find book with id " + id);
            }
        }
    }

}
