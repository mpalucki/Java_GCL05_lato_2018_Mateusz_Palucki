package com.company;

import java.util.Comparator;

public class CompareByStars implements Comparator<User> {

    public int compare(User o1, User o2)
    {
        long tmp = o1.getNumberOfStars() - o2.getNumberOfStars();
        if(tmp == 0)
        {
            return o1.compareTo(o2);
        }
        return (int)tmp;
    }
}
