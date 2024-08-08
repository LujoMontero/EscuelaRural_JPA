package org.example.escuelarural_jpa.controller;

import org.example.escuelarural_jpa.entity.Course;
import org.example.escuelarural_jpa.entity.Student;
import org.example.escuelarural_jpa.service.CursoService;
import org.example.escuelarural_jpa.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

    @Autowired
    private CursoService cursoService;

    @GetMapping("")
    public String findAll(Model model) {
        List<Student> estudiantes = estudianteService.findAll();
        model.addAttribute("estudiantes", estudiantes);
        return "estudiantes/lista";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        Student estudiante = estudianteService.findById(id);
        model.addAttribute("estudiante", estudiante);
        return "estudiantes/detalle";
    }

    @GetMapping("/nuevo")
    public String nuevoEstudianteForm(Model model) {
        model.addAttribute("estudiante", new Student());
        List<Course> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        return "estudiantes/formulario";
    }
    @GetMapping("/editar/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {

        Student estudiante = estudianteService.findById(id);
        model.addAttribute("estudiante", estudiante);
        List<Course> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        return "estudiantes/formulario";
    }

    @PostMapping("/guardar")
    public String update(@ModelAttribute("estudiante") Student student, Model model){
        estudianteService.save(student);
        List<Course> cursos = cursoService.findAll();
        model.addAttribute("cursos", cursos);
        return "redirect:/estudiantes";
    }

    @GetMapping("/borrar/{id}")
    public String delete(@PathVariable("id") Long id) {
        Student estudiante = estudianteService.findById(id);
        if (estudiante != null) {
            estudianteService.delete(estudiante);
        }
        return "redirect:/estudiantes";
    }
}