package service;

import model.Specialite;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;

public class SpecialiteService extends AbstractFacade <Specialite> implements ISpecialite {
    private Session session;

    public SpecialiteService() {
        super(Specialite.class);
        session= HibernateUtil.getSession();
    }

    @Override
    public Session getSession() {
        return session= HibernateUtil.getSession();
    }

    @Override
    public List<Specialite> findByService(Long serviceId) throws Exception {
        return getSession().createQuery("Select  sp From Specialite sp join sp.service s WHERE s.id=:serviceId",
                Specialite.class)
                .setParameter("serviceId", serviceId).list();
    }
}
