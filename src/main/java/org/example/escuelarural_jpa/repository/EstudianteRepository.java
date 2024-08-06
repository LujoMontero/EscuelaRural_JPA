package org.example.escuelarural_jpa.repository;

import org.example.escuelarural_jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Student, Long> {
}
