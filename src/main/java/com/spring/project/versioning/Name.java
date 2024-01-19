package com.spring.project.versioning;

public class Name {
    private String FirstName;
    private String LastName;

    public String getFirstName() {
        return FirstName;
    }

    @Override
    public String toString() {
        return "Name{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }

    public String getLastName() {
        return LastName;
    }

    public Name(String firstName, String lastName) {
        super();
        FirstName = firstName;
        LastName = lastName;
    }
}
