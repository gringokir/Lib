package library.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookDto {
    @JsonProperty(value = "book_id")
    private Long bookId;
    @JsonProperty(value = "name")
    private String name;
    @JsonProperty(value = "author")
    private String author;
    @JsonProperty(value = "person")
    private PersonDto person;
    @JsonProperty(value = "storage")
    private StorageDto storage;
    @JsonProperty(value = "purchase")
    private PurchaseDto purchase;

    public BookDto() {
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    public StorageDto getStorage() {
        return storage;
    }

    public void setStorage(StorageDto storage) {
        this.storage = storage;
    }

    public PurchaseDto getPurchase() {
        return purchase;
    }

    public void setPurchase(PurchaseDto purchase) {
        this.purchase = purchase;
    }
}
