package pl.coderslab.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    //Metoda testowa:
    @RequestMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }

    //Metoda testująca działania biblioteki Jackson:
    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }

    @Autowired
    private MemoryBookService memoryBookService;

    @GetMapping("/")
    @ResponseBody
    public List<Book> getAllBooks(){
        return memoryBookService.getList();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Book getBookById(@PathVariable("id") long id){
        return memoryBookService.getBookById(id);
    }

    @PostMapping("/")
    public void addBook(@RequestParam(name="isbn") String isbn,
                        @RequestParam(name="title") String title,
                        @RequestParam(name="author") String author,
                        @RequestParam(name="publisher") String publisher,
                        @RequestParam(name="type") String type){
        memoryBookService.addBook(isbn, title, author, publisher, type);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable(name="id") String id,
                           @RequestParam(name="isbn") String isbn,
                           @RequestParam(name="title") String title,
                           @RequestParam(name="author") String author,
                           @RequestParam(name="publisher") String publisher,
                           @RequestParam(name="type") String type){
        memoryBookService.addBook(isbn, title, author, publisher, type);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable(name="id") long id){
        memoryBookService.deleteBook(id);
    }

}
