package ru.vaka.springcourse.models;

import jakarta.validation.constraints.*;

import java.util.Optional;

public class Book {
    private int id;
    private Integer person_id;

    @NotEmpty(message="Name shouldn't be empty")
    private String name;

    @NotEmpty(message = "Author shouldn't be empty")
    private String author;

    private int year;

    public Book() {};

    public Book(int id, Integer person_id, String name, String author, int year) {
        this.id = id;
        this.person_id = person_id;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public boolean hasOwner() {
        return person_id != null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }
}
