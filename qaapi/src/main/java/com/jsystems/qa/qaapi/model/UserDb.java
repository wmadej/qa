package com.jsystems.qa.qaapi.model;

public class UserDb {
    private Long id;
    private String name;
    private String surname;
    //Alt + Ins
    //Gatter and Setter (wszystkie pola)
    //Constructor (wszystkie pola)
    //Constructor (select none)

    public UserDb(Long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public UserDb() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
