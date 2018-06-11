package com.example.hibernate.dao;

import com.example.hibernate.entity.Team;
import org.springframework.stereotype.Repository;


@Repository
public class TeamDAO extends AbstractDAO{

    public TeamDAO()
    {
        setClazz(Team.class);
    }
    public Team getTeamByName(String team) {
        return (Team) entityManager.createQuery("SElECT u FROM Team u WHERE u.team_name=:userTeam")
                .setParameter("userTeam", team)
                .getSingleResult();
    }

}
