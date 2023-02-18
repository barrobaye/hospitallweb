package service;

import model.User;

import java.util.List;

public interface IUser {
    public User add(User user) throws Exception;
    public List<User> findAll() throws Exception;
    public User find(long id) throws Exception;
    public void remove(User user) throws Exception;
    public long count() throws Exception;
    public User findByEmailAndPassword(String email, String password) throws Exception;
}
