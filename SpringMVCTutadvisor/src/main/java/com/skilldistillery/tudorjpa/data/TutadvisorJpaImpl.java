package com.skilldistillery.tudorjpa.Data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Transactional
@Service
public class TutadvisorJpaImpl implements TutDAO {

    @PersistenceContext
    private EntityManager em;

//    *************PLACE HOLDER FOR ACTUAL IMPL**************
    @Override
    public Object findALL() {
        List<Object> objects = null;
        String querysql = "";
        objects = em.createQuery(querysql, Object.class).getResultList();
        return objects;
    }
}