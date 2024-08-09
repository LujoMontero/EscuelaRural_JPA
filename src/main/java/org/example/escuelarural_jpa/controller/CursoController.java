package org.example.escuelarural_jpa.controller;

import org.example.escuelarural_jpa.entity.Course;
import org.example.escuelarural_jpa.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("")
    public String findAll(Model model) {
        model.addAttribute("cursos", cursoService.findAll());
        return "cursos/listaCursos";
    }

    @GetMapping("/nuevo")
    public String nuevoCursoForm(Model model) {
        model.addAttribute("curso", new Course());
        return "cursos/formularioCurso";
    }

    @PostMapping("/guardarCurso")
    public String saveCurso(@ModelAttribute("curso") Course course) {
        cursoService.save(course);
        return "redirect:/cursos";
    }

    @GetMapping("/editar/{id}")
    public String editarCurso(@PathVariable("id") Long id, Model model) {
        Course course = cursoService.findById(id);
        model.addAttribute("curso", course);
        return "cursos/formularioCurso";
    }

    @GetMapping("/borrar/{id}")
    public String borrarCurso(@PathVariable("id") Long id) {
        cursoService.deleteById(id);
        return "redirect:/cursos";
    }
}
