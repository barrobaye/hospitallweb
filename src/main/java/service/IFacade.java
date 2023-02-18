package service;

import model.User;

import java.util.List;

public interface IFacade<T> {
    public T add(T t) throws Exception;
    public List<T> findAll() throws Exception;
    public T find(long id) throws Exception;
    public void remove(T t) throws Exception;
    public long count() throws Exception;
}
