package library.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "storage")
@Inheritance(strategy = InheritanceType.JOINED)

public class Storage extends EntityBase{
    @OneToMany(mappedBy = "storage", fetch = FetchType.LAZY)
    private List<Person> customers;
    @OneToMany(mappedBy = "storage", fetch = FetchType.LAZY)
    private List<Book> availableBooks;

    public Storage() {
    }

    public List<Person> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Person> customers) {
        this.customers = customers;
    }

    public List<Book> getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(List<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }
}
