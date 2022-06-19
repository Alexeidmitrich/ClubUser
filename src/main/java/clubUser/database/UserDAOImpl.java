package clubUser.database;

import clubUser.User;
import clubUser.database.Hibernate.HiberUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getAllUser() {
        SessionFactory factory = HiberUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        List<User> user = session.
                createQuery("FROM ClubUser").
                getResultList();
        session.getTransaction().commit();
        factory.close();
        return user;
    }

    @Override
    public User getUserById(int id) {
        User user = null;
        SessionFactory factory = HiberUtil.getSessionFactory();
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            user = session.get(User.class, id);
            session.getTransaction().commit();
        } catch (Exception e){
            factory.close();
        }
        return user;
    }

    @Override
    public void save(User user) {
        SessionFactory factory = HiberUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        factory.close();
    }
}
