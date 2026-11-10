package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Categoria;
import com.biblioteca.biblioteca.repository.CategoriaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository repository;

    public CategoriaController(CategoriaRepository repository) {
        this.repository = repository;
    }

    // Endpoints de Listar e Exibir Formulário
    @GetMapping("/exibir")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("categoria", new Categoria());
        model.addAttribute("listaCategorias", repository.findAll());
        return "categoria";
    }

    // Endpoint de Cadastro
    @PostMapping("/exibir")
    public String cadastrar(@ModelAttribute("categoria") Categoria categoria) {
        repository.save(categoria);
        return "redirect:/categorias/exibir";
    }

    // Endpoint de Exclusão
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/categorias/exibir";
    }
}