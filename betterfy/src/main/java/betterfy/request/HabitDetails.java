package betterfy.request;

/**
 * Created by nik on 2/16/17.
 */
public class HabitDetails {

    private String name;
    private String question;
    private int times;
    private int days;

    public HabitDetails(){

    }

    public HabitDetails(String name, String question, int times, int days) {
        this.name = name;
        this.question = question;
        this.times = times;
        this.days = days;
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
}
