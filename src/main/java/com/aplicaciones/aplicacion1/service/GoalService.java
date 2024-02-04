package com.aplicaciones.aplicacion1.service;

import com.aplicaciones.aplicacion1.model.Goals;
import  com.aplicaciones.aplicacion1.dto.GoalsDTO;
import com.aplicaciones.aplicacion1.repository.GoalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    private final GoalsRepository goalsRepository;

    @Autowired
    public GoalService(GoalsRepository goalsRepository){
        this.goalsRepository = goalsRepository;
    }

    public List<Goals> getAllGoals(){
      return goalsRepository.findAll();
    }

    public Goals createGoal(GoalsDTO goalsDTO){
        Goals goals = convertGoalDTOToEntity(goalsDTO);
        return goalsRepository.save(goals);
    }

    private Goals convertGoalDTOToEntity(GoalsDTO goalDTO) {
        Goals goal = new Goals();
        goal.setName(goalDTO.getName());
        // Puedes asignar otras propiedades según sea necesario
        return goal;
    }
}
