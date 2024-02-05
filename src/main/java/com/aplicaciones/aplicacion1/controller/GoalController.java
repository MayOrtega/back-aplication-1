package com.aplicaciones.aplicacion1.controller;

import com.aplicaciones.aplicacion1.dto.GoalsDTO;
import com.aplicaciones.aplicacion1.model.Goals;
import com.aplicaciones.aplicacion1.model.Tasks;
import com.aplicaciones.aplicacion1.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/goals")
@CrossOrigin("http://localhost:4200")
public class GoalController {

    private final GoalService goalService;

    @Autowired
    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }
    @GetMapping
    public List<Goals> getAllGoals() {
        List<Goals> goals = goalService.getAllGoals();
        goals.forEach(goal -> goal.getTasks().size()); // Carga explícita de tareas
        return goals;
    }

    @GetMapping("/{goalId}/tasks")
    public ResponseEntity<List<Tasks>>getTasksForGoal(@PathVariable Long goalId) {
        List<Tasks> tasks = goalService.getTasksForGoal(goalId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GoalsDTO> createGoal(@RequestBody GoalsDTO goalsDTO) {
        Goals createdGoal = goalService.createGoal(goalsDTO);
        GoalsDTO createdGoalsDTO = convertGoalEntityToDTO(createdGoal);
        return new ResponseEntity<>(createdGoalsDTO, HttpStatus.CREATED);
    }

    private GoalsDTO convertGoalEntityToDTO(Goals goalEntity) {
        GoalsDTO goalsDTO = new GoalsDTO();
        goalsDTO.setId(goalEntity.getId());
        goalsDTO.setName(goalEntity.getName());
        // Puedes asignar otras propiedades según sea necesario
        return goalsDTO;
    }

}
