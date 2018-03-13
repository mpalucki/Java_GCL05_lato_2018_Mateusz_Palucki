package com.company;

import java.util.*;

/**
 * Created by mpalucki on 2018-03-13.
 */
public class ChatEngine extends User{

   Map<Long, User> users = new HashMap<Long, User>();


    void loginUser(User user) throws UserLoginException{
        for (Map.Entry<Long, User> entry : users.entrySet()) {
            try {
                if (user == entry.getValue()) {
                    throw new UserLoginException(new ChatException());
                }
            }
            catch(UserLoginException except)
            {
                System.out.println("Bład");
            }

        }
        users.put(user.getId(), user);
    }

    void logoutUser(long UserId) {
        for (Map.Entry<Long, User> entry : users.entrySet()) {
            try {
                if (entry.getKey() == UserId) {
                    users.remove(UserId);
                } else
                    throw new UserRemoveException(new ChatException());
            }
            catch(UserRemoveException except)
            {
                System.out.println("blad)");
            }
        }

    }

    int getNumberOfUsers() {
        return users.size();
    }

    void addUserStar(String userName) {
        for (Map.Entry<Long, User> entry : users.entrySet()){
            if((entry.getValue()).getName().compareTo(userName) == 0)
                (entry.getValue()).addStar();
        }
    }

    void removeUserStar(String userName) {
        for (Map.Entry<Long, User> entry : users.entrySet()) {
            if ((entry.getValue()).getName().compareTo(userName) == 0)
                (entry.getValue()).removeStar();
        }
    }

    boolean hasUser(long userId) {
        return users.containsKey(userId);
    }


    boolean hasUser(String userName) {
        return true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChatEngine that = (ChatEngine) o;

        return users != null ? users.equals(that.users) : that.users == null;
    }

    @Override
    public int hashCode() {
        return users != null ? users.hashCode() : 0;
    }

    boolean broadcastMessage(long UserId, String message)
    {
        for (Map.Entry<Long, User> entry : users.entrySet())
        {
            System.out.println(entry.getValue().getId());
            System.out.println(entry.getValue().getName());
        }
        return true;
    }
    void printStatistics()
    {
        long min=0,max=0;

        for (Map.Entry<Long, User> entry : users.entrySet())
        {
            if(entry.getValue().getNumberOfMessages() < min)
                 min = entry.getValue().getNumberOfMessages();
            if(entry.getValue().getNumberOfMessages() > max);
                max = entry.getValue().getNumberOfMessages();

            entry.getValue().print();
        }
    }
    List<User> listUsers(Criteria kryt)
    {
        List<User> tmp = new LinkedList<User>();

        for (Map.Entry<Long, User> entry : users.entrySet())
        {
            tmp.add(entry.getValue());
        }
        switch (kryt) {
            case NAME: {
                Collections.sort(tmp);
            }
            case ID:
            {
                Collections.sort(tmp, new CompareById());
            }
            case NUMBER_OF_MESSAGES: {
                Collections.sort(tmp, new CompareByMessage());
            }
            case NUMBER_OF_STARS:{
                Collections.sort(tmp, new CompareByStars());
            }
        }
        return tmp;
    }
}

