package library.converter;

import library.dto.BookDto;
import library.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookToBookDtoConverter implements Converter<Book, BookDto> {

    @Override
    public BookDto convert(Book book) {
        BookDto bookDto = new BookDto();
        bookDto.setBookId(book.getId());
        bookDto.setName(book.getName());
        bookDto.setAuthor(book.getAuthor());
        return bookDto;
    }
}