package com.example.hibernate.dao;

import com.example.hibernate.entity.Matches;
import org.springframework.stereotype.Repository;

@Repository
public class MatchDAO extends AbstractDAO{

    public MatchDAO()
    {
        setClazz(Matches.class);
    }
    public Matches getMatchById(int match_id) {
        return (Matches) entityManager.createQuery("SElECT u FROM Matches u WHERE u.match_id=:userMatch")
                .setParameter("userMatch", match_id)
                .getSingleResult();
    }
}
