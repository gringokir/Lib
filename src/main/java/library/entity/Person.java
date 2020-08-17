package library.entity;

import library.enums.PersonType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)

public class Person extends EntityBase{
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "person_type")
    @Enumerated(value = EnumType.STRING)
    private PersonType personType;
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private List<Book> obtainedBooks;
    @OneToOne
    @JoinColumn(name = "purchase_id")
    private Purchase purchase;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_id")
    private Storage storage;

    public Person() {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Book> getObtainedBooks() {
        return obtainedBooks;
    }

    public void setObtainedBooks(List<Book> obtainedBooks) {
        this.obtainedBooks = obtainedBooks;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
