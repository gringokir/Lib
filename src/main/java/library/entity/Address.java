package library.entity;

import javax.persistence.*;

@Entity
@Table(name = "address")
@Inheritance(strategy = InheritanceType.JOINED)

public class Address extends EntityBase{
    @Column(name = "street")
    private String street;
    @Column(name = "house")
    private Integer house;
    @Column(name = "flat")
    private Integer flat;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    public Address() {
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public Integer getFlat() {
        return flat;
    }

    public void setFlat(Integer flat) {
        this.flat = flat;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
