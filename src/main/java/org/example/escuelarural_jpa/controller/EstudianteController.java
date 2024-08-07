package org.example.escuelarural_jpa.controller;

import jakarta.validation.Valid;
import org.example.escuelarural_jpa.entity.Course;
import org.example.escuelarural_jpa.entity.Student;
import org.example.escuelarural_jpa.service.CursoService;
import org.example.escuelarural_jpa.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        if (estudiante == null) {
            model.addAttribute("error", "Estudiante no encontrado");
            return "error"; // Asegúrate de tener una plantilla de error adecuada
        }
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

    @PostMapping("/guardar")
    public String save(@Valid @ModelAttribute("estudiante") Student estudiante, BindingResult result) {
        if (result.hasErrors()) {
            return "estudiantes/formulario";
        }
        estudianteService.save(estudiante);
        return "redirect:/estudiantes";
    }
}
