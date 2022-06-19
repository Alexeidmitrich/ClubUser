package clubUser;

import javax.persistence.*;

import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Set;

@Entity
@ToString(exclude = "users")
@DynamicInsert
@DynamicUpdate
@Table(name = "admin")
public class Admin extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAdmin;
    private String rank;

    public Admin(int idAdmin, String firstName, String lastName, String email, String rank) {
        super(firstName, lastName, email);
        this.idAdmin = idAdmin;
        this.rank = rank;
    }
    public Admin(String firstName, String lastName, String email, String rank){
        super(firstName, lastName, email);
        this.rank = rank;
    }
    @ManyToMany
    @JoinTable(name = "Admin_User",
            joinColumns = @JoinColumn(name = "Admin_ID"),
            inverseJoinColumns = @JoinColumn(name = "User_ID")
    )
    private Set<User> users;

    public int getIdAdmin() {
        return idAdmin;
    }

    public String getRank() {
        return rank;
    }

    public void printInformation(){
        System.out.println(getIdAdmin() + " " + getFirstName() + " " + getLastName() + " " + getEmail() + " " + getRank());
    }
}
