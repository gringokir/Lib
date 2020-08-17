package library.converter;

import library.dto.BookDto;
import library.entity.Book;
import library.entity.Person;
import library.entity.Purchase;
import library.entity.Storage;
import library.enums.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookDtoToBookConverter implements Converter<BookDto, Book> {

    @Override
    public Book convert(BookDto bookDto) {
        Book book = new Book();
        book.setId(bookDto.getBookId());
        book.setName(bookDto.getName());
        book.setAuthor(bookDto.getAuthor());
        return book;
    }
}
