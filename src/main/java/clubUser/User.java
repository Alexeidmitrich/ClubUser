package clubUser;

import javax.persistence.*;

import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.HashSet;
import java.util.Set;

@Entity
@ToString(exclude = "ranks")
@DynamicInsert
@DynamicUpdate
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    private String firstName;
    private String lastName;
    private String email;

    public User(int idUser, String firstName, String lastName, String email) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    @ManyToMany(mappedBy = "users")
    private Set<Rank>  ranks = new HashSet<>();

    public int getIdUser() {
        return idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void printIformationUser(){
        System.out.println(getIdUser() + " " + getFirstName() + " " + getLastName() + " " + getEmail());
    }
}
