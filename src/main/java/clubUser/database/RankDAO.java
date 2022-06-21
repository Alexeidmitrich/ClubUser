package clubUser.database;

import clubUser.Rank;
import java.util.List;


public interface RankDAO {

    List<Rank> getAllRank();
    Rank getRankById(int id);
    void save (Rank rank);
}
