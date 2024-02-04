package com.aplicaciones.aplicacion1.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean completed;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goals goals;



}
