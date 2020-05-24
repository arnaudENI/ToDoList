package fr.eni.jpa.dao;

import fr.eni.jpa.bean.Utilisateur;
import fr.eni.jpa.exception.DAOException;
import org.hibernate.type.EntityType;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class IDAOImpl<T, U> implements IDao<T, U> {

    private Class<T> classEntity;

    public IDAOImpl(Class<T> classEntity) {
        this.classEntity = classEntity;
    }

    public IDAOImpl() {

    }

    public Class<T> getClassEntity() {
        return classEntity;
    }

    @Override
    public void add(T t) throws Exception {
        EntityManager em = DAOUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.persist(t);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw new DAOException("Erreur lors de l'ajout de " + t + " : " + e.getMessage());
        }
    }

    public void add(List<T> listeT) throws Exception {
        EntityManager em  = DAOUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try{
            listeT.forEach(em::persist);
            et.commit();
        }catch (Exception e){
            et.rollback();
            throw new DAOException("Erreur lors de l'ajout de " + listeT  + " : " + e.getMessage());
        }
    }

    @Override
    public void delete(T t) throws Exception {
        EntityManager em = DAOUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.remove(t);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw e;
        }
    }

    @Override
    public void update(T t) throws Exception {
        EntityManager em = DAOUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            em.merge(t);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw e;
        }
    }

    @Override
    public void update(List<T> listeT) throws Exception {
        EntityManager em = DAOUtil.getEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();
        try {
            listeT.forEach(em::merge);
            et.commit();
        } catch (Exception e) {
            et.rollback();
            throw e;
        }
    }

    @Override
    public T findById(Class c, U id) {
        return (T) DAOUtil.getEntityManager().find(c.getClass(), id);
    }


    /**
     * soluce 1
     * @param c
     * @return
     * @throws DAOException
     */
    @Override
    public List<T> findAll(Class c) throws DAOException {
        String req = "select Object(t) from " + c.getName() + " t";
        return DAOUtil
                .getEntityManager()
                .createQuery(req, c)
                .getResultList();

    }

    /**
     * Soluce 2
     * @return
     * @throws DAOException
     */
    public List<T> findAll() throws DAOException {

        EntityManager em = DAOUtil.getEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<T> query = cb.createQuery(classEntity);
        Root<T> rt = query.from(classEntity);

        CriteriaQuery<T> all = query.select(rt);
        TypedQuery<T> allQuery = em.createQuery(all);

        return allQuery.getResultList();


    }

    public List<Utilisateur> findAllUser() {
        TypedQuery<Utilisateur> query = DAOUtil.getEntityManager().createNamedQuery("findAllUser", Utilisateur.class);
        return query.getResultList();
    }


}
