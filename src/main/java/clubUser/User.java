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
    @Column(nullable = false, length = 10)
    private int idUser;
    @Column(nullable = false, length = 25)
    private String firstName;
    @Column(nullable = false, length = 25)
    private String lastName;
    @Column(nullable = false, length = 45)
    private String email;
    private int idRank;

    public User(int idUser, String firstName, String lastName, String email, int idRank) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.idRank = idRank;
    }

    public User(String firstName, String lastName, String email, int idRank){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.idRank = idRank;
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
