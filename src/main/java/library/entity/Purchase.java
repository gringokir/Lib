package library.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "purchase")
@Inheritance(strategy = InheritanceType.JOINED)

public class Purchase extends EntityBase {
    @Column(name = "return_date")
    private LocalDate returnDate;
    @OneToMany(mappedBy = "purchase", fetch = FetchType.LAZY)
    private List<Book> books;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    public Purchase() {
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

}
