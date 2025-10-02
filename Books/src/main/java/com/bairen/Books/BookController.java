package com.bairen.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping
    public List<Book>getBookList(){
        return bookService.getBookList();
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }
    @PostMapping
    public Book addBooks(@RequestBody Book book){
        return bookService.addBooks(book);
    }
    @PutMapping("/{id}")
    public Book changeBook(@PathVariable Long id, @RequestBody Book bookUpdated){
        return bookService.changeBook(id,bookUpdated);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        bookService.deleteById(id);
    }
}
