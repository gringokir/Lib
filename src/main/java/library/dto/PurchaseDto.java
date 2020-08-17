package library.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class PurchaseDto {
    @JsonProperty(value = "purchase_id")
    private Long purchaseId;
    @JsonProperty(value = "books")
    private List<BookDto> books;
    @JsonProperty(value = "return_date")
    private LocalDate returnDate;
    @JsonProperty(value = "person")
    private PersonDto person;

    public PurchaseDto() {
    }

    public Long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public List<BookDto> getBooks() {
        return books;
    }

    public void setBooks(List<BookDto> books) {
        this.books = books;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }
}
