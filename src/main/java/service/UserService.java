package service;

import model.User;
import org.hibernate.Session;
import utils.HibernateUtil;

public class UserService extends AbstractFacade <User> implements IUser  {
    private Session session;
    public UserService() {
        super(User.class);
        session = HibernateUtil.getSession();
    }

    @Override
    public Session getSession() {
        return session;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws Exception {
        try {
            return getSession().createQuery("SELECT u FROM User u " +
                    "WHERE u.email =:email AND u.password=:pass", User.class)
                    .setParameter("email", email)
                    .setParameter("pass", password).getSingleResult();
        }
        catch(Exception e){
            throw e;
        }
    }
}
