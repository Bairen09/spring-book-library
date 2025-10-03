package com.bairen.Books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepo bookRepo;
    @Autowired
    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public List<Book> getBookList() {
        return bookRepo.findAll();
    }

    public Book getBookById(Long id) {
        return bookRepo.findById(id).orElseThrow(()->new RuntimeException("Invalid ID"));
    }

    public Book addBooks(Book book) {
        if(book.getTitle().isEmpty()|| book.getTitle()==null){
            throw new IllegalArgumentException("Invalid Exception");
        }
        book.setId(null);
        return bookRepo.save(book);
    }

    public Book changeBook(Long id, Book bookUpdated) {
        Book existing = getBookById(id);
        existing.setTitle(bookUpdated.getTitle());
        existing.setAuthor(bookUpdated.getAuthor());
        existing.setYear(bookUpdated.getYear());
        existing.setPublished(bookUpdated.isPublished());
        return bookRepo.save(existing);
    }

    public void deleteById(Long id) {
        bookRepo.deleteById(id);
    }

    public List<Book> getPublishedBooks() {
        return bookRepo.findByPublishedTrue();
    }
}
