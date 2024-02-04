package com.aplicaciones.aplicacion1.dto;

import com.aplicaciones.aplicacion1.model.Goals;
import lombok.Data;

@Data
public class TasksDTO {
    private Long id;
    private String name;
    private boolean completed;
    private Long goalId;
}
