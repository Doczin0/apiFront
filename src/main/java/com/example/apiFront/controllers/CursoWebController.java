package com.example.apiFront.controllers;

import com.example.apiFront.dtos.CursoRequestDTO;
import com.example.apiFront.dtos.CursoResponseDTO;
import com.example.apiFront.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller@RequestMapping("/cursos")
public class CursoWebController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public String paginaListagem(Model model) {

        var cursos = cursoService.listarCursos();


        model.addAttribute("cursos", cursos);

        return "cursos/listar";
    }

    @GetMapping("/novo")
    public String paginaFormularioCadastro(Model model) {
        model.addAttribute("curso", new CursoRequestDTO("", "", "", null));
        return "cursos/cadastrar";
    }

    @PostMapping("/salvar")
    public String salvarCurso(@ModelAttribute CursoRequestDTO cursoDTO) {
        cursoService.criarCurso(cursoDTO);
        return "redirect:/cursos";
    }

    @GetMapping("/{id}")
    public String paginaDetalhes(@PathVariable UUID id, Model model) {
        CursoResponseDTO curso = cursoService.buscarCursoPorId(id);
        model.addAttribute("curso", curso);
        return "cursos/detalhes"; // Nome da página HTML que vamos criar
    }


    @GetMapping("/editar/{id}")
    public String paginaEditarCurso(@PathVariable UUID id, Model model) {
        CursoResponseDTO curso = cursoService.buscarCursoPorId(id);
        model.addAttribute("curso", curso);
        return "cursos/editar"; // Nome da página HTML que vamos criar
    }


    @PostMapping("/atualizar/{id}")
    public String atualizarCurso(@PathVariable UUID id, @ModelAttribute CursoRequestDTO cursoDTO) {
        cursoService.atualizarCurso(id, cursoDTO);
        return "redirect:/cursos/" + id; // Redireciona de volta para os detalhes do curso
    }

    @GetMapping("/deletar/{id}")
    public String deletarCurso(@PathVariable UUID id) {
        cursoService.deletarCurso(id);
        return "redirect:/cursos"; // Redireciona para a lista após apagar
    }
}