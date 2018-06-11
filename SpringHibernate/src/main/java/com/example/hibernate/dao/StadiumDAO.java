package com.example.hibernate.dao;

import com.example.hibernate.entity.Stadium;
import com.example.hibernate.entity.Team;
import org.springframework.stereotype.Repository;


@Repository
public class StadiumDAO extends AbstractDAO{

    public StadiumDAO(){
        setClazz(Stadium.class);
    }

    public Stadium getStadiumByName(String stadium_name) {
        return (Stadium) entityManager.createQuery("SElECT u FROM Stadium u WHERE u.stadium_name=:userStadium")
                .setParameter("userStadium", stadium_name)
                .getSingleResult();
    }
}
