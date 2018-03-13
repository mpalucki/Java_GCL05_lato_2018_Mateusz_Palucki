package com.company;

import java.util.Comparator;

public class CompareById implements Comparator<User>{

    public int compare(User o1, User o2)
    {
        long iid = o1.getId() - o2.getId();
        if(iid == 0)
        {
            return o1.compareTo(o2);
        }
        return (int)iid;
    }

}
