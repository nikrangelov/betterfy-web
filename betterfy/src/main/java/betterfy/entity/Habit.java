package betterfy.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by nik on 2/13/17.
 */

@Entity
@Table(name="HABITS")
public class Habit {

    @Id
    @Column(name="HABIT_ID")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column(name="NAME")
    private String name;

    @Column(name="QUESTION")
    private String question;

    @Column(name="TIMES")
    private int times;

    @Column(name="DAYS")
    private int days;


    @ElementCollection
    @CollectionTable(
            name="CHECKED_DAYS",
            joinColumns=@JoinColumn(name="HABIT_ID")
    )
    @Column(name="DAYS")
    private List<Date> checkedDays;


    @ManyToOne
    @JoinColumn(name="USER_ID")
    private User user;

    public Habit() {

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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public List<Date> getCheckedDays() {
        return checkedDays;
    }

    public void setCheckedDays(List<Date> checkedDays) {
        this.checkedDays = checkedDays;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
