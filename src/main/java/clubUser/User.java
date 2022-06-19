package clubUser;

import javax.persistence.*;

import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Set;

@Entity
@ToString(exclude = "admins")
@DynamicInsert
@DynamicUpdate
@Table(name = "user")
public class User extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    public User(int idUser, String firstName, String lastName, String email) {
        super(firstName, lastName, email);
        this.idUser = idUser;
    }

    public User(String firstName, String lastName, String email){
        super(firstName, lastName, email);
    }
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private Set<Admin> admins;

    public int getIdUser() {
        return idUser;
    }
    public void printIformationUser(){
        System.out.println(getIdUser() + " " + getFirstName() + " " + getLastName() + " " + getEmail());
    }
}
