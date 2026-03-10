package com.capgemini.address.management.system.main;


import java.util.Scanner;

import com.capgemini.address.management.system.dao.EmployeeDAO;
import com.capgemini.address.management.system.entity.Address;
import com.capgemini.address.management.system.entity.Employee;



public class JavaApp {

    public static void execute() {

        Scanner sc = new Scanner(System.in);
        EmployeeDAO dao = new EmployeeDAO();

        while (true) {

            System.out.println("1 Add Employee");
            System.out.println("2 Search Employee");
            System.out.println("3 Update Salary");
            System.out.println("4 Update Address");
            System.out.println("5 Delete Employee");
            System.out.println("6 Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

            case 1:

                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Email: ");
                String email = sc.nextLine();

                System.out.print("Enter Salary: ");
                double salary = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter Street: ");
                String street = sc.nextLine();

                System.out.print("Enter City: ");
                String city = sc.nextLine();

                System.out.print("Enter Zipcode: ");
                String zipcode = sc.nextLine();

                Address address = new Address(street, city, zipcode);

                Employee emp = new Employee(name, email, salary, address);

                dao.addEmployee(emp);

                break;

                case 2:

                    System.out.println("Enter id");

                    int id = sc.nextInt();

                    Employee e = dao.getEmployee(id);

                    if (e != null) {

                        System.out.println("ID: " + e.getId());
                        System.out.println("Name: " + e.getName());
                        System.out.println("Email: " + e.getEmail());
                        System.out.println("Salary: " + e.getSalary());

                        System.out.println("Address:");
                        System.out.println("Street: " + e.getAddress().getStreet());
                        System.out.println("City: " + e.getAddress().getCity());
                        System.out.println("Zipcode: " + e.getAddress().getZipcode());
                    }

                    break;

                case 3:

                    System.out.println("Enter id and new salary");

                    dao.updateSalary(sc.nextInt(), sc.nextDouble());

                    break;

                case 4:

                    System.out.println("Enter employeeId street city zipcode");

                    int eid = sc.nextInt();
                    sc.nextLine();

                    String st = sc.nextLine();
                    String ct = sc.next();
                    String zp = sc.next();

                    dao.updateAddress(eid, st, ct, zp);

                    break;

                case 5:

                    System.out.println("Enter id");

                    dao.deleteEmployee(sc.nextInt());

                    break;

                case 6:

                    System.exit(0);
            }
        }
    }
}
