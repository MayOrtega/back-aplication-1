package com.aplicaciones.aplicacion1.service;


import com.aplicaciones.aplicacion1.dto.TasksDTO;
import com.aplicaciones.aplicacion1.model.Goals;
import com.aplicaciones.aplicacion1.model.Tasks;
import com.aplicaciones.aplicacion1.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TasksRepository tasksRepository;

    @Autowired

    public TaskService(TasksRepository tasksRepository){
        this.tasksRepository = tasksRepository;
    }

    public List<Tasks> getAllTasks(){
        return tasksRepository.findAll();
    }

    public Tasks createdTask(TasksDTO taskDTO){
        Tasks task = convertTaskDTOToEntity(taskDTO);
        return tasksRepository.save(task);
    }

    private Tasks convertTaskDTOToEntity(TasksDTO taskDTO) {
        Tasks task = new Tasks();
        task.setName(taskDTO.getName());
        task.setCompleted(taskDTO.isCompleted());

        Goals goal = new Goals();
        goal.setId(taskDTO.getGoalId());
        task.setGoals(goal);

        // Puedes asignar otras propiedades según sea necesario
        return task;
    }

}
