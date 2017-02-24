package betterfy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by nik on 2/22/17.
 */

@Entity
@Table(name="TASKS")
public class Task {

    @Id
    @Column(name="TASK_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name="NAME")
    private String name;

    @Column(name="FINISHED_DATE")
    private Date finishedDate;

    @Column(name="IS_FINISHED")
    private boolean isFinsihed;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="GOAL_ID")
    private Goal goal;

    public Task() {

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

    public Date getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(Date finishedDate) {
        this.finishedDate = finishedDate;
    }

    public boolean isFinsihed() {
        return isFinsihed;
    }

    public void setFinsihed(boolean finsihed) {
        isFinsihed = finsihed;
    }

    public Goal getGoal() {
        return goal;
    }

    public void setGoal(Goal goal) {
        this.goal = goal;
    }
}
