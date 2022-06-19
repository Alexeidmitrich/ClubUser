package clubUser.database;

import clubUser.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUser();
    User getUserById(int id);
    void save(User user);
}
