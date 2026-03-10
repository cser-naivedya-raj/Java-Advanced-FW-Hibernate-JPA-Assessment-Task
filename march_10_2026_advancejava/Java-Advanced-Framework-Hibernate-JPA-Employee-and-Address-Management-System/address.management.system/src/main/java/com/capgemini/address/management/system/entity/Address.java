package com.capgemini.address.management.system.entity;


import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Address implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String street;
    private String city;
    private String zipcode;

    @OneToOne(mappedBy = "address")
    private Employee employee;

    public Address() {}

    public Address(String street, String city, String zipcode) {
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
    }

    public Integer getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
	public int hashCode() {
		return Objects.hash(city, id, street, zipcode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return Objects.equals(city, other.city) && Objects.equals(id, other.id) && Objects.equals(street, other.street)
				&& Objects.equals(zipcode, other.zipcode);
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", city=" + city + ", zipcode=" + zipcode + "]";
	}

	public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
