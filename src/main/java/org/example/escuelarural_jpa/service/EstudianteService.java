package org.example.escuelarural_jpa.service;

import org.example.escuelarural_jpa.entity.Student;
import org.example.escuelarural_jpa.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteService {

    @Autowired
    private EstudianteRepository estudianteRepository;


    public List<Student> findAll() {
        return estudianteRepository.findAll();
    }

    public Student findById(Long id) {
        return estudianteRepository.findById(id).orElse(null);
    }

    public void save(Student estudiante) {
        estudianteRepository.save(estudiante);
    }

    public void delete(Student estudiante) {
        estudianteRepository.delete(estudiante);
    }
}
