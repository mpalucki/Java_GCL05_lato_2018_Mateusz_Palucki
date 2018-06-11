package com.example.hibernate.rest;

import com.example.hibernate.dao.MatchDAO;
import com.example.hibernate.dao.StadiumDAO;
import com.example.hibernate.dao.TeamDAO;
import com.example.hibernate.entity.Matches;
import com.example.hibernate.entity.Stadium;
import com.example.hibernate.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;

@RestController
public class MainController {

    private final StadiumDAO stadiumDAO;
    private final TeamDAO teamDAO;
    private final MatchDAO matchDAO;

    @Autowired
    public MainController(StadiumDAO stadiumDAO, TeamDAO teamDAO, MatchDAO matchDAO) {
        this.stadiumDAO = stadiumDAO;
        this.teamDAO = teamDAO;
        this.matchDAO = matchDAO;
    }

    //Add team
    @RequestMapping(value = "/team/add", method = RequestMethod.POST)
    public void addTeam(@RequestParam(value = "team_name") String teamName,@RequestParam(value = "team_country") String teamCountry) {
        teamDAO.create(new Team(teamName,teamCountry));
    }

    //Update team name
    @RequestMapping(value = "/team/update", method = RequestMethod.POST)
    public void updateTeam(@RequestParam(value = "new_team_name") String newTeamName, @RequestParam(value = "team_name") String teamName){
        Team team = teamDAO.getTeamByName(teamName);
        team.setTeam_name(newTeamName);
        teamDAO.update(team);
    }


    //read team by name
    @RequestMapping(value = "/team/{name}", method = RequestMethod.GET)
    public Team getTeam(@PathVariable(value = "name") String teamName) {
        try {
            return teamDAO.getTeamByName(teamName);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    //delete team by name
    @RequestMapping(value = "/team/{team_name}", method = RequestMethod.DELETE)
    public void removeTeam(@PathVariable(value = "team_name") String teamName) {
        try {
            Team team = teamDAO.getTeamByName(teamName);
            teamDAO.delete(team);
        } catch (NoResultException e) {

        }
    }

    //Add stadium
    @RequestMapping(value = "/stadium/add", method = RequestMethod.POST)
    public void addStadium(@RequestParam(value = "stadium_name") String stadiumName) {
        teamDAO.create(new Stadium(stadiumName));
    }

    //Update stadium name
    @RequestMapping(value = "/stadium/update", method = RequestMethod.POST)
    public void updateStadium(@RequestParam(value = "new_stadium_name") String newStadiumName, @RequestParam(value = "team_name") String stadiumName) {
        Stadium stadium = stadiumDAO.getStadiumByName(stadiumName);
        stadium.setStadium_name(newStadiumName);
        stadiumDAO.update(stadium);
    }


    //read stadium by name
    @RequestMapping(value = "/stadium/{name}", method = RequestMethod.GET)
            public Stadium getStadium(@PathVariable(value = "name") String stadiumName) {
                try {
            return stadiumDAO.getStadiumByName(stadiumName);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
    //delete stadium by name
    @RequestMapping(value = "/stadium/{stadium_name}", method = RequestMethod.DELETE)
    public void removeStadium(@PathVariable(value = "stadium_name") String stadiumName) {
        try {
            Stadium stadium = stadiumDAO.getStadiumByName(stadiumName);
            stadiumDAO.delete(stadium);
        } catch (NoResultException e) {

        }
    }

    //Add match
    @RequestMapping(value = "/match/add", method = RequestMethod.POST)
    public void addStadium(@RequestParam(value = "first_opponent") String firstOpponent,@RequestParam(value = "second_opponent") String secondOpponent, @RequestParam(value = "stadium") String stadium) {
        matchDAO.create(new Matches(firstOpponent,secondOpponent,stadium));
    }


    //Update match stadium
    @RequestMapping(value = "/match/update", method = RequestMethod.POST)
    public void updateTeam(@RequestParam(value = "new_stadium_name") String newStadiumName, @RequestParam(value = "match_id") int matchId){
        Matches matches = matchDAO.getMatchById(matchId);
        matches.setMatchStadium(newStadiumName);
        matchDAO.update(matches);
    }

    //read match by id
    @RequestMapping(value = "/match/{match_id}", method = RequestMethod.GET)
    public Matches getMatch(@PathVariable(value = "match_id") int matchId) {
        try {
            return matchDAO.getMatchById(matchId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    //delete match by id
    @RequestMapping(value = "/match/{match_id}", method = RequestMethod.DELETE)
    public void removeStadium(@PathVariable(value = "match_id") int match_id) {
        try {
            Matches match = matchDAO.getMatchById(match_id);
            matchDAO.delete(match);
        } catch (NoResultException e) {

        }
    }
}
