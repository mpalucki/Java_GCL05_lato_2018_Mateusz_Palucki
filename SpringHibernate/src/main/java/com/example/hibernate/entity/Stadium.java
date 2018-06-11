package com.example.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "stadium")
public class Stadium implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="stadium_id")
    private int stadium_id;

    @Column(name="stadium_name", unique = true)
    private String stadium_name;


    public Stadium()
    {
        this.stadium_name = "tmp stadium";
    }

    public Stadium(String stadium_name)
    {
        this.stadium_name = stadium_name;
    }

//    @ManyToMany(cascade = {
//            CascadeType.ALL,
//            CascadeType.MERGE
//    })
//    @JoinTable(name = "match",
//            joinColumns = @JoinColumn(name = "match_id"),
//            inverseJoinColumns = @JoinColumn(name = "match_stadium")
//    )

    @Override
    public String toString() {
        return "Stadium{" +
                "stadium_id=" + stadium_id +
                ", stadium_name='" + stadium_name + '\'' +
                '}';
    }


    public int getStadium_id() {
        return stadium_id;
    }

    public void setStadium_id(int stadium_id) {
        this.stadium_id = stadium_id;
    }

    public String getStadium_name() {
        return stadium_name;
    }

    public void setStadium_name(String stadium_name) {
        this.stadium_name = stadium_name;
    }
}
