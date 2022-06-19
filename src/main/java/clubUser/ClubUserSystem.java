package clubUser;

import clubUser.database.AdminDAO;
import clubUser.database.AdminDAOImpl;
import clubUser.database.UserDAO;
import clubUser.database.UserDAOImpl;

public class ClubUserSystem {
    AdminDAO adminDAO = new AdminDAOImpl();
    UserDAO userDAO = new UserDAOImpl();
   public void addAdmin(String firstName, String lastName, String email, String rank){
       Admin admin = new Admin(firstName,lastName,email,rank);
       adminDAO.save(admin);
   }
   public void addUser(String firstName, String lastName, String email){
       User user = new User(firstName,lastName,email);
       userDAO.save(user);
   }
}
