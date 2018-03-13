package com.company;

import java.util.Comparator;

public class CompareByMessage implements Comparator<User> {

    public int compare(User o1, User o2)
    {
        long tmp = o1.getNumberOfMessages() - o2.getNumberOfMessages();
        if(tmp == 0)
        {
            return o1.compareTo(o2);
        }
        return (int)tmp;
    }
}
