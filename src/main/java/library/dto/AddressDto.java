package library.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddressDto {
    @JsonProperty(value = "address_id")
    private Long addressId;
    @JsonProperty(value = "street")
    private String street;
    @JsonProperty(value = "house")
    private Integer house;
    @JsonProperty(value = "flat")
    private Integer flat;
    @JsonProperty(value = "person")
    private PersonDto person;

    public AddressDto() {
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
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

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }
}
