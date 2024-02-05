package com.aplicaciones.aplicacion1.service;

import com.aplicaciones.aplicacion1.model.Goals;
import  com.aplicaciones.aplicacion1.dto.GoalsDTO;
import com.aplicaciones.aplicacion1.model.Tasks;
import com.aplicaciones.aplicacion1.repository.GoalsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Tasks> getTasksForGoal(Long goalId) {
        Optional<Goals> optionalGoal = goalsRepository.findById(goalId);

        if (optionalGoal.isPresent()) {
            Goals goal = optionalGoal.get();
            return goal.getTasks(); // Suponiendo que tienes un método getTasks() en la clase Goal
        } else {
            throw new EntityNotFoundException("No se encontró la meta con ID: " + goalId);
        }
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
