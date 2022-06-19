package clubUser.database;

import clubUser.Rank;
import java.util.List;


public interface RankDAO {

    List<Rank> getAllAdmin();
    Rank getAdminById(int id);
    void save (Rank admin);
}
