package betterfy.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nik on 2/8/17.
 */

@Entity
@Table(name="USERS")
public class User {

    @Id
    @Column(name="USER_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name="EMAIL")
    private String email;

    @Column(name="PASSWORD")
    private String password;

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    //@JoinColumn(name="TOKEN_ID")
    private List<Token> tokens = new ArrayList<Token>();


    public User(){
        //empty constructor
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTokens(List<Token> tokens) {
        this.tokens = tokens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getId() != user.getId()) return false;
        if (!getEmail().equals(user.getEmail())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        return getTokens() != null ? getTokens().equals(user.getTokens()) : user.getTokens() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + (getTokens() != null ? getTokens().hashCode() : 0);
        return result;
    }
}
