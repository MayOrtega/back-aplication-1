package com.aplicaciones.aplicacion1.repository;

import com.aplicaciones.aplicacion1.model.Goals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalsRepository extends JpaRepository<Goals, Long> {
    // Puedes agregar consultas personalizadas aquí si es necesario
}

