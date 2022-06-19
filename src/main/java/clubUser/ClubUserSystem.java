package clubUser;

import clubUser.database.RankDAO;
import clubUser.database.RankDAOImpl;
import clubUser.database.UserDAO;
import clubUser.database.UserDAOImpl;

public class ClubUserSystem {
    RankDAO adminDAO = new RankDAOImpl();
    UserDAO userDAO = new UserDAOImpl();
   public void addRank(String rank){
       Rank admin = new Rank(rank);
       adminDAO.save(admin);
   }
   public void addUser(String firstName, String lastName, String email){
       User user = new User(firstName,lastName,email);
       userDAO.save(user);
   }
}
