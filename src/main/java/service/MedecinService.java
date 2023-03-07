package service;

import model.Medecin;
import org.hibernate.Session;
import utils.HibernateUtil;

public class MedecinService extends AbstractFacade<Medecin>  implements IMedecin{
    private Session session;
    public MedecinService() {
        super(Medecin.class);
        session = HibernateUtil.getSession();
    }

    @Override
    public Session getSession() {
        return session = HibernateUtil.getSession();
    }
}
