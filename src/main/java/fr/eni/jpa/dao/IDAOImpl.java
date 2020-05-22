package fr.eni.jpa.dao;

import fr.eni.jpa.bean.Utilisateur;
import fr.eni.jpa.exception.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

public class IDAOImpl<T,U> implements IDao<T,U>{


    @Override
    public void add(T t) throws Exception {
        EntityManager em  = DAOUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try{
            em.persist(t);
            et.commit();
        }catch (Exception e){
            et.rollback();
            throw new DAOException("Erreur lors de l'ajout de " + t  + " : " + e.getMessage());
        }
    }

    @Override
    public void delete(T t) throws Exception {

    }

    @Override
    public void update(T t) throws Exception {

    }

    @Override
    public void update(List<T> listeT) throws Exception {

    }

    @Override
    public T findById(Class c, U id) {
        return (T) DAOUtil.getEntityManager().find(c.getClass(),id);
    }

    @Override
    public List<T> findAll(Class c) throws DAOException {
        EntityManager em = DAOUtil.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

//        Class classe = c.forName(c.getClass());

//        CriteriaBuilder<> query = cb.createQuery(c.getClass());

        return null;
    }

    public List<Utilisateur> findAllUser(){
        TypedQuery<Utilisateur> query = DAOUtil.getEntityManager().createNamedQuery("findAllUser", Utilisateur.class);
        return query.getResultList();
    }


}
