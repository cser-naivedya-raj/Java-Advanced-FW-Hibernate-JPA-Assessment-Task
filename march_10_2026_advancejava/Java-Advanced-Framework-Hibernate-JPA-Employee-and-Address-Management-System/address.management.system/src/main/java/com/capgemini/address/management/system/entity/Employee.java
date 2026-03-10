package com.capgemini.address.management.system.entity;


import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.*;

@Entity
public class Employee implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private double salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public Employee() {}

    public Employee(String name, String email, double salary, Address address) {
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", salary=" + salary + ", address="
				+ address + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, email, id, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}

	public double getSalary() {
        return salary;
    }

    public Address getAddress() {
        return address;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
