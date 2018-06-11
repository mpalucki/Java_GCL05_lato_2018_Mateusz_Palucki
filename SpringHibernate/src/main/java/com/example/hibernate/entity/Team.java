package com.example.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "team")
public class Team implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="team_id")
    private int team_id;

    @Column(name="team_name", unique = true)
    private String team_name;

    @Column(name="team_country")
    private String team_country;


    public Team()
    {
        this.team_name = "tmp team name";
        this.team_country = "tmp country";
    }

    public Team(String team_name, String team_country)
    {
        this.team_name = team_name;
        this.team_country = team_country;
    }

//    @ManyToMany(cascade = {
//            CascadeType.ALL,
//            CascadeType.MERGE
//    })
//    @JoinTable(name = "match",
//            joinColumns = @JoinColumn(name = "match_stadium"),
//            inverseJoinColumns = @JoinColumn(name = "match_id")
//    )


    @Override
    public String toString() {
        return "Team{" +
                "team_id=" + team_id +
                ", team_name='" + team_name + '\'' +
                ", team_country='" + team_country + '\'' +
                '}';
    }

    public int getTeam_id() {
        return team_id;
    }

    public void setTeam_id(int team_id) {
        this.team_id = team_id;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public String getTeam_country() {
        return team_country;
    }

    public void setTeam_country(String team_country) {
        this.team_country = team_country;
    }
}
