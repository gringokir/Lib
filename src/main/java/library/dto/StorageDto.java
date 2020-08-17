package library.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StorageDto {
    @JsonProperty(value = "storage_id")
    private Long storageId;
    @JsonProperty(value = "customers")
    private List<PersonDto> customers;
    @JsonProperty(value = "available_books")
    private List<BookDto> availableBooks;

    public StorageDto() {
    }

    public Long getStorageId() {
        return storageId;
    }

    public void setStorageId(Long storageId) {
        this.storageId = storageId;
    }

    public List<PersonDto> getCustomers() {
        return customers;
    }

    public void setCustomers(List<PersonDto> customers) {
        this.customers = customers;
    }

    public List<BookDto> getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(List<BookDto> availableBooks) {
        this.availableBooks = availableBooks;
    }
}
