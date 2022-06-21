package clubUser.database;

import clubUser.Rank;
import clubUser.database.Hibernate.HiberUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class RankDAOImpl implements RankDAO {
    @Override
    public List<Rank> getAllRank() {
        SessionFactory  factory = HiberUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        List<Rank> rank = session.
                createQuery("FROM ClubUser").
                getResultList();
        session.getTransaction().commit();
        factory.close();
        return rank;
    }

    @Override
    public Rank getRankById(int id) {
        Rank rank = null;
        SessionFactory factory = HiberUtil.getSessionFactory();
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            rank = session.get(Rank.class, id);
            session.getTransaction().commit();
        }catch (Exception e) {
            factory.close();
        }
        return rank;
    }

    @Override
    public void save(Rank rank) {
        SessionFactory factory = HiberUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(rank);
        session.getTransaction().commit();
        factory.close();
    }
}
