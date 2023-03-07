package service;

import model.Specialite;

import java.util.List;

public interface ISpecialite {
    public Specialite add(Specialite specialite) throws Exception;
    public List<Specialite> findAll() throws Exception;
    public Specialite find(long id) throws Exception;
    public void remove(Specialite specialite) throws Exception;
    public long count() throws Exception;
    List<Specialite> findByService(Long serviceId) throws Exception;
}
