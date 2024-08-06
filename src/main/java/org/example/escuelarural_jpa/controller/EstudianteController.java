package org.example.escuelarural_jpa.controller;

import org.example.escuelarural_jpa.entity.Student;
import org.example.escuelarural_jpa.service.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;

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
        return "estudiantes/formulario";
    }

    @PostMapping("/guardar")
    public String save(Student estudiante) {
        estudianteService.save(estudiante);
        return "redirect:/estudiantes";
    }
}
