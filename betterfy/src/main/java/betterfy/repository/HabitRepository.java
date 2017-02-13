package betterfy.repository;

import betterfy.entity.Habit;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by nik on 2/13/17.
 */
@Transactional
public interface HabitRepository extends CrudRepository<Habit, Long> {

    public Habit findById(long id);
}
