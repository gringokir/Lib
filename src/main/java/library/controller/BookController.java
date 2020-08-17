package library.controller;

import library.dto.BookDto;
import library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @RequestMapping("/{id}")
    public BookDto getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<BookDto> getAll(){
        return bookService.getAll();
    }

    @PostMapping
    @RequestMapping("/create")
    public BookDto createBook(BookDto bookDto){
        return bookService.createBook(bookDto);
    }

    @PutMapping
    @RequestMapping("/update/")
    public BookDto updateBook(BookDto bookDto) {
        return bookService.updateBook(bookDto);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
    }
}
