package betterfy.response;

import betterfy.entity.Habit;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by nik on 2/17/17.
 */
public class AllHabitsResponse {

    private List<Habit> habits = new ArrayList<Habit>();

    public AllHabitsResponse() {
    }

    public AllHabitsResponse(List<Habit> habits) {
        this.habits = habits;
    }

    public AllHabitsResponse(Set<Habit> habits) {
        this.habits.addAll(habits);
    }

    public List<Habit> getHabits() {
        return habits;
    }

    public void setHabits(List<Habit> habits) {
        this.habits = habits;
    }

    public void addHabit(Habit habit){
        habits.add(habit);
    }
}
