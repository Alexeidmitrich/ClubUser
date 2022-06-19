package clubUser.database;

import clubUser.Admin;
import java.util.List;


public interface AdminDAO {

    List<Admin> getAllAdmin();
    Admin getAdminById(int id);
    void save (Admin admin);
}
