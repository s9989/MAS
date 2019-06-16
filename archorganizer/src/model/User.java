package model;

import lib.ObjectPlusPlus;

public class User extends ObjectPlusPlus
{
    private String name;
    private String surname;

    /* atrybut opcjonalny */
    private String phoneNumber;

    public User(String name, String surname)
    {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
