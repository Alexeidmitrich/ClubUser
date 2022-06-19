package clubUser.database;

import clubUser.Rank;
import clubUser.database.Hibernate.HiberUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class RankDAOImpl implements RankDAO {
    @Override
    public List<Rank> getAllAdmin() {
        SessionFactory  factory = HiberUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        List<Rank> admin = session.
                createQuery("FROM ClubUser").
                getResultList();
        session.getTransaction().commit();
        factory.close();
        return admin;
    }

    @Override
    public Rank getAdminById(int id) {
        Rank admin = null;
        SessionFactory factory = HiberUtil.getSessionFactory();
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            admin = session.get(Rank.class, id);
            session.getTransaction().commit();
        }catch (Exception e) {
            factory.close();
        }
        return admin;
    }

    @Override
    public void save(Rank admin) {
        SessionFactory factory = HiberUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(admin);
        session.getTransaction().commit();
        factory.close();
    }
}
