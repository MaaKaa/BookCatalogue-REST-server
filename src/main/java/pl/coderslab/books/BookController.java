package pl.coderslab.books;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @RequestMapping("/hello")
    public String hello(){
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L,"9788324631766","Thinking in Java",
                "Bruce Eckel","Helion","programming");
    }

    //Utwórz zmienną tej klasy w kontrolerze, a następnie wstrzyknij ją:
    private MemoryBookService memoryBookService;

    @GetMapping("/")
    @ResponseBody
    public List<Book> getAllBooks(){
        return new MemoryBookService().getList();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Book getBookById(@PathVariable("id") long id){
        return new MemoryBookService().getBookById(id);
    }

    @PostMapping("/")
    public void addBook(@RequestParam(name="isbn") String isbn,
                        @RequestParam(name="title") String title,
                        @RequestParam(name="author") String author,
                        @RequestParam(name="publisher") String publisher,
                        @RequestParam(name="type") String type){
        new MemoryBookService().addBook(isbn, title, author, publisher, type);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable(name="id") String id,
                           @RequestParam(name="isbn") String isbn,
                           @RequestParam(name="title") String title,
                           @RequestParam(name="author") String author,
                           @RequestParam(name="publisher") String publisher,
                           @RequestParam(name="type") String type){
        new MemoryBookService().addBook(isbn, title, author, publisher, type);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable(name="id") long id){
        new MemoryBookService().deleteBook(id);
    }

}
