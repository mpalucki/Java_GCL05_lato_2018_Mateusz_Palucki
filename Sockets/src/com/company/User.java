package com.company;

public class User {

    private int id;
    private String login;
    private String password;


    public User(String login, String password)
    {
        this.id = 1;
        this.login = login;
        this.password = password;
    }
    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}

