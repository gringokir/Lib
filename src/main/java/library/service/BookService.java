package library.service;

import library.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {
    BookDto getBookById(Long id);

    List<BookDto> getAll();

    BookDto createBook(BookDto bookDto);

    BookDto updateBook(BookDto bookDto);

    void deleteBook(Long id);
}
