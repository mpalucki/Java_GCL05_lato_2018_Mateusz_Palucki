package com.example.hibernate.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "matches")
public class Matches implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="match_id")
    private int match_id;

    @Column(name="match_first_opponent")
    private String matchFirstOpponent;

    @Column(name="match_second_opponent")
    private String matchSecondOpponent;

    @Column(name ="match_stadium")
    private String matchStadium;

    public Matches(){
        this.matchSecondOpponent = "tmp";
        this.matchFirstOpponent = "tmp";
        this.matchStadium = "tmp";
    };

    public Matches(String match_First_Opponent, String match_Second_Opponent, String match_Stadium)
    {
        this.matchSecondOpponent = match_Second_Opponent;
        this.matchFirstOpponent = match_First_Opponent;
        this.matchStadium = match_Stadium;
    }

    public int getMatchId() {
        return match_id;
    }

    public void setMatchId(int matchId) {
        this.match_id = matchId;
    }

    public String getMatchFirstOpponent() {
        return matchFirstOpponent;
    }

    public void setMatchFirstOpponent(String matchFirstOpponent) {
        this.matchFirstOpponent = matchFirstOpponent;
    }

    public String getMatchSecondOpponent() {
        return matchSecondOpponent;
    }

    public void setMatchSecondOpponent(String matchSecondOpponent) {
        this.matchSecondOpponent = matchSecondOpponent;
    }

    public String getMatchStadium() {
        return matchStadium;
    }

    public void setMatchStadium(String matchStadium) {
        this.matchStadium = matchStadium;
    }
}
