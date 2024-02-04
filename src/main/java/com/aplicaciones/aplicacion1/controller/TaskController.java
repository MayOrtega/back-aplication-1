package com.aplicaciones.aplicacion1.controller;


import com.aplicaciones.aplicacion1.dto.TasksDTO;
import com.aplicaciones.aplicacion1.model.Tasks;
import com.aplicaciones.aplicacion1.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("app/tasks")
@CrossOrigin("http://localhost:4200")
public class TaskController {


    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Tasks> getAllTasks (){
        return taskService.getAllTasks();
    }

    @PostMapping
    public ResponseEntity<TasksDTO> createTask(@RequestBody TasksDTO tasksDTO) {
        Tasks createdTask = taskService.createdTask(tasksDTO);
        TasksDTO createdTasksDTO = convertTaskEntityToDTO(createdTask);
        return new ResponseEntity<>(createdTasksDTO, HttpStatus.CREATED);
    }

    private TasksDTO convertTaskEntityToDTO(Tasks taskEntity) {
        TasksDTO taskDTO = new TasksDTO();
        taskDTO.setId(taskEntity.getId());
        taskDTO.setName(taskEntity.getName());
        taskDTO.setCompleted(taskEntity.isCompleted());
        taskDTO.setGoalId(taskEntity.getGoals().getId());
        return taskDTO;
    }
}
