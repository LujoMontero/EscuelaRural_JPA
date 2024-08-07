package org.example.escuelarural_jpa.service;

import org.example.escuelarural_jpa.entity.Course;
import org.example.escuelarural_jpa.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;


    public List<Course> findAll() {
        return cursoRepository.findAll();
    }

    public Course findById(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Transactional
    public Course save(Course curso) {
        return cursoRepository.save(curso);
    }

    @Transactional
    public void deleteById(Long id) {
        cursoRepository.deleteById(id);
    }
}
