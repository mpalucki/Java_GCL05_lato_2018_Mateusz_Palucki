package com.company;

/**
 * Created by mpalucki on 2018-03-13.
 */
public class UserLoginException extends ChatException{

    public UserLoginException(ChatException except)
    {

        super();
        System.out.println("blad");
    }
}
