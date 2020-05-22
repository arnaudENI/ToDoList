package fr.eni.jpa.dao;

import fr.eni.jpa.exception.DAOException;

import java.util.List;

public interface IDao<T, U> {

    public void add(T t) throws Exception;

    public void delete(T t) throws Exception;

    public void update(T t) throws Exception;

    public void update(List<T> listeT) throws Exception;

    public T findById(Class c ,U id);

    public List<T> findAll(Class c) throws DAOException;
}
