package org.example.escuelarural_jpa.repository;

import org.example.escuelarural_jpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Course, Long> {
}
