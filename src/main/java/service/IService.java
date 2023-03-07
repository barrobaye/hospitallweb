package service;

import model.Service;

import java.util.List;

public interface IService {
    public Service add(Service service) throws Exception;
    public List<Service> findAll() throws Exception;
    public Service find(long id) throws Exception;
    public void remove(Service service) throws Exception;
    public long count() throws Exception;
}
