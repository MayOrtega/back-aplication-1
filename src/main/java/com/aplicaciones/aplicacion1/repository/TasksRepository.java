package com.aplicaciones.aplicacion1.repository;

import com.aplicaciones.aplicacion1.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<Tasks, Long> {
}
