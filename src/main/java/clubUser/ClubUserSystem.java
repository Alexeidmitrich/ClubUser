package clubUser;

import clubUser.database.RankDAO;
import clubUser.database.RankDAOImpl;
import clubUser.database.UserDAO;
import clubUser.database.UserDAOImpl;

public class ClubUserSystem {
    RankDAO adminDAO = new RankDAOImpl();
    UserDAO userDAO = new UserDAOImpl();
   public void addRank(String rankString){
       Rank rank = new Rank(rankString);
       adminDAO.save(rank);
   }
   public void addUser(String firstName, String lastName, String email,int idRank){
       User user = new User(firstName,lastName,email, idRank);
       userDAO.save(user);
   }
}
