package library.service.impl;

import library.converter.CustomConversionService;
import library.dto.BookDto;
import library.entity.Book;
import library.exception.BookException;
import library.repository.BookRepository;
import library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final CustomConversionService conversionService;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, CustomConversionService conversionService) {
        this.bookRepository = bookRepository;
        this.conversionService = conversionService;
    }

    @Override
    public BookDto getBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookException("Book is not found"));
        return conversionService.convert(book, BookDto.class);
    }

    @Override
    public List<BookDto> getAll() {
        List<Book> bookList = bookRepository.findAll();
        return bookList
                .stream()
                .map(book -> conversionService.convert(book, BookDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = conversionService.convert(bookDto, Book.class);
        return conversionService.convert(bookRepository.save(book), BookDto.class);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) {
        Book book = bookRepository.findById(bookDto.getBookId()).orElseThrow(() -> new BookException("Book is not found"));
        return conversionService.convert(book, BookDto.class);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new BookException("Book is not found"));
        bookRepository.delete(book);
    }
}
