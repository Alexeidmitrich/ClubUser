package clubUser.database;

import clubUser.Admin;
import clubUser.database.Hibernate.HiberUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class AdminDAOImpl implements AdminDAO{
    @Override
    public List<Admin> getAllAdmin() {
        SessionFactory  factory = HiberUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        List<Admin> admin = session.
                createQuery("FROM ClubUser").
                getResultList();
        session.getTransaction().commit();
        factory.close();
        return admin;
    }

    @Override
    public Admin getAdminById(int id) {
        Admin admin = null;
        SessionFactory factory = HiberUtil.getSessionFactory();
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            admin = session.get(Admin.class, id);
            session.getTransaction().commit();
        }catch (Exception e) {
            factory.close();
        }
        return admin;
    }

    @Override
    public void save(Admin admin) {
        SessionFactory factory = HiberUtil.getSessionFactory();
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(admin);
        session.getTransaction().commit();
        factory.close();
    }
}
