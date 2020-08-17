package library.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PersonDto {
    @JsonProperty("id")
    private Long personId;
    @JsonProperty(value = "first_Name")
    private String firstName;
    @JsonProperty(value = "last_Name")
    private String lastName;
    @JsonProperty(value = "address")
    private AddressDto address;
    @JsonProperty(value = "obtained_books")
    private List<BookDto> obtainedBooks;
    @JsonProperty(value = "person_type")
    private PersonTypeDto personType;
    @JsonProperty(value = "purchase")
    private PurchaseDto purchase;
    @JsonProperty(value = "storage")
    private StorageDto storage;

    public PersonDto() {
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

    public List<BookDto> getObtainedBooks() {
        return obtainedBooks;
    }

    public void setObtainedBooks(List<BookDto> obtainedBooks) {
        this.obtainedBooks = obtainedBooks;
    }

    public PersonTypeDto getPersonType() {
        return personType;
    }

    public void setPersonType(PersonTypeDto personType) {
        this.personType = personType;
    }

    public PurchaseDto getPurchase() {
        return purchase;
    }

    public void setPurchase(PurchaseDto purchase) {
        this.purchase = purchase;
    }

    public StorageDto getStorage() {
        return storage;
    }

    public void setStorage(StorageDto storage) {
        this.storage = storage;
    }
}
