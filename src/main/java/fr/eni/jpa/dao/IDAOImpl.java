package fr.eni.jpa.dao;

import fr.eni.jpa.exception.DAOException;

import java.util.List;

public class IDAOImpl<T,U> implements IDao<T,U>{


    @Override
    public void add(T t) throws Exception {

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
