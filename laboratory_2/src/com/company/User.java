package com.company;

/**
 * Created by mpalucki on 2018-03-13.
 */
public class User implements Comparable<User> {
    private static long id;
    private String name;
    private long numberOfStars;
    private long numberOfMessages;



    public int compareTo(User o)
    {
        return (this.name).compareTo(o.name);

    }

    public void addStar()
    {
        numberOfStars++;
    }
    public void removeStar()
    {
        numberOfStars--;
    }
    public long getId()
    {
        return this.id;
    }
    public void setId(long given_id)
    {
        this.id = given_id;
    }

    public String getName() {
        return name;
    }
    public void setName(String given_name)
    {
        this.name = given_name;
    }
    public long getNumberOfStars()
    {
        return this.numberOfStars;
    }
    public void setNumberOfStars(long given_stars)
    {
        this.numberOfStars = given_stars;
    }
    public long getNumberOfMessages()
    {
        return numberOfMessages;
    }
    public void setNumberOfMessages(long given_messages)
    {
        this.numberOfMessages = given_messages;
    }
    public void print()
    {
        System.out.println(this.id);
        System.out.println(this.name);
        System.out.println(this.numberOfMessages);
        System.out.println(this.numberOfStars);
    }
    public User()
    {
        this.name = "robot";
        this.id++;
        this.numberOfMessages = 0;
        this.numberOfStars = 0;
    }

    public User(long id, String name, long numberOfStars, long numberOfMessages) {
        this.id = id;
        this.name = name;
        this.numberOfStars = numberOfStars;
        this.numberOfMessages = numberOfMessages;
    }
}

