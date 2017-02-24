package betterfy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

/**
 * Created by nik on 2/22/17.
 */

@Entity
@Table(name="GOALS")
public class Goal {

    @Id
    @Column(name="GOALS_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name="NAME")
    private String name;

    @Column(name="END_DATE")
    private Date endDate;

    @Column(name="IS_FINISHED")
    boolean isFinsihed = false;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="goal", cascade=CascadeType.ALL)
    private Set tasks = new HashSet<Task>();


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    public Goal() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public boolean isFinsihed() {
        return isFinsihed;
    }

    public void setFinsihed(boolean finsihed) {
        isFinsihed = finsihed;
    }

    public Set getTasks() {
        return tasks;
    }

    public void setTasks(Set tasks) {
        this.tasks = tasks;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
