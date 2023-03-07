package service;

import model.Medecin;

import java.util.List;

public interface IMedecin {
    public Medecin add(Medecin medecin) throws Exception;
    public List<Medecin> findAll() throws Exception;
    public Medecin find(long id) throws Exception;
    public void remove(Medecin medecin) throws Exception;
    public long count() throws Exception;
}
