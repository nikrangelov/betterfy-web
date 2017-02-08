package betterfy.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by nik on 2/8/17.
 */
@Entity
@Table(name="TOKENS")
public class Token {

    @Id
    @Column(name="TOKEN_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="TOKEN")
    private String token;

    @Column(name="EXPIRATION_DATE")
    private Date expirationDate;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    public Token(){
        //empty constructor
    }
    public Token(String token, Date expirationDate) {
        this.token = token;
        this.expirationDate = expirationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Token)) return false;

        Token token1 = (Token) o;

        if (getId() != token1.getId()) return false;
        if (!getToken().equals(token1.getToken())) return false;
        return getExpirationDate().equals(token1.getExpirationDate());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getToken().hashCode();
        result = 31 * result + getExpirationDate().hashCode();
        return result;
    }
}
