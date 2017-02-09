package betterfy.entity;

import betterfy.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Created by nik on 2/8/17.
 */
@Entity
@Table(name="TOKENS")
public class Token {

    @Transient
    @Autowired
    TokenService tokenService;

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
    public void initToken(){
        String token = null;
        do {
            token = UUID.randomUUID().toString().replaceAll("-", "");
        }while(tokenService.isTokenUsed(token));
        Date today = new Date();
        Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24)); // adds one day in milliseconds
        this.token = token;
        this.expirationDate = tomorrow;
    }
    public boolean isTokenExpired(){
        Date today = new Date();
        int tmp = today.compareTo(expirationDate);
        if(tmp == -1){
            return false;
        }else{
            return true;
        }
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
