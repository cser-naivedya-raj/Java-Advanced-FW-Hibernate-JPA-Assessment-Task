package com.capgemini.address.management.system.dao;



import com.capgemini.address.management.system.entity.Employee;

import jakarta.persistence.*;

public class EmployeeDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("employee-unit");

    EntityManager em = emf.createEntityManager();

    public void addEmployee(Employee emp) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(emp);

        tx.commit();

        System.out.println("Employee added successfully");
    }

    public Employee getEmployee(int id) {

        Employee emp = em.find(Employee.class, id);

        if (emp == null) {
            System.out.println("No employee found.");
        }

        return emp;
    }

    public void updateSalary(int id, double salary) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Employee emp = em.find(Employee.class, id);

        if (emp != null) {
            emp.setSalary(salary);
            em.merge(emp);
            System.out.println("Employee salary updated successfully");
        } else {
            System.out.println("No employee found.");
        }

        tx.commit();
    }

    public void updateAddress(int id, String street, String city, String zip) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Employee emp = em.find(Employee.class, id);

        if (emp != null) {

            emp.getAddress().setStreet(street);
            emp.getAddress().setCity(city);
            emp.getAddress().setZipcode(zip);

            em.merge(emp);

            System.out.println("Address updated successfully");
        }
        else
        {
            System.out.println("No employee found.");
        }

        tx.commit();
    }

    public void deleteEmployee(int id) {

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Employee emp = em.find(Employee.class, id);

        if (emp != null) {
            em.remove(emp);
            System.out.println("Employee deleted successfully");
        }
        else
        {
            System.out.println("No employee found.");
        }

        tx.commit();
    }
}
