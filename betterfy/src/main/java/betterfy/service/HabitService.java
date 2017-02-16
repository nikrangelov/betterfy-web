package betterfy.service;

import betterfy.entity.Habit;
import betterfy.repository.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by nik on 2/13/17.
 */
@Component
public class HabitService {

    @Autowired
    HabitRepository habitRepository;

    public boolean createHabit(Habit habit){
        try {

            habitRepository.save(habit);
        }
        catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean updateUser(Habit habit){
        return createHabit(habit);
    }


}
