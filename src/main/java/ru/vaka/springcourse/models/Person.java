package ru.vaka.springcourse.models;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class Person {

    private int id;

    @NotEmpty(message="Name shouldn't be empty")
    private String fullname;

    @Size(min = 4, max = 4, message="Year should contains 4 digits")
    private int birthyear;


    public Person() {}

    public Person(int id, String fullname, int birthyear) {
        this.id = id;
        this.fullname = fullname;
        this.birthyear = birthyear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(int birthyear) {
        this.birthyear = birthyear;
    }
}
