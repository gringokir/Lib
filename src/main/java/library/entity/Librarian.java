package library.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "librarian")
//@DiscriminatorValue(value = "librarian")
public class Librarian extends Person{
}
