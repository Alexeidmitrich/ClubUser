package clubUser;

import javax.persistence.*;

import lombok.ToString;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.ArrayList;
import java.util.List;


@Entity
@ToString(exclude = "users")
@DynamicInsert
@DynamicUpdate
@Table(name = "rank")
public class Rank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRank;
    private String  rank;


    public Rank(int idRank, String rank) {
        this.idRank = idRank;
        this.rank = rank;
    }
    public Rank(String rank){
        this.rank = rank;
    }
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "User_Rank",
            joinColumns = { @JoinColumn(name = "idRank") },
            inverseJoinColumns = { @JoinColumn(name = "idUser") })
    private List<User> users = new ArrayList<>();

    public int getIdRank() {
        return idRank;
    }

    public String getRank() {
        return rank;
    }

    public void printInformation(){
        System.out.println(getIdRank() + " " + getRank());
    }
}
