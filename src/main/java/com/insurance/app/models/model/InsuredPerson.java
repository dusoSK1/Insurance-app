package com.insurance.app.models.model;

public class InsuredPerson { private String firstName;
    private String lastName;
    private int age;
    private String phone;

    public InsuredPerson(String firstName, String lastName, int age, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + ", age: " + age + ", phone: " + phone;
    }
}

