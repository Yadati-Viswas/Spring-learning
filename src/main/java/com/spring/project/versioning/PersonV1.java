package com.spring.project.versioning;

public class PersonV1 {
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "PersonV1{" +
                "name='" + name + '\'' +
                '}';
    }

    private String name;
    public PersonV1(String name) {
        super();
        this.name=name;
    }
}
