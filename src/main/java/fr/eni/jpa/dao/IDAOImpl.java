package fr.eni.jpa.dao;

import fr.eni.jpa.exception.DAOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
        return null;
    }

    @Override
    public List<T> findAll(Class c) throws DAOException {
        return null;
    }
}
