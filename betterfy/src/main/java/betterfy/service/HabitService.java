package betterfy.service;

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


}