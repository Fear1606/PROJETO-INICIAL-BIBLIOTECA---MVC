package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Livro;
import com.biblioteca.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    private final LivroRepository repository;

    public LivroController(LivroRepository repository) {
        this.repository = repository;
    }



    @GetMapping
    public String inicio(){
        return "livros/inicio";
    }

    // exibir a tela do formulário e a lista vinda do banco
    @GetMapping("/exibir")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("livro", new Livro());
        // busca todos os livros no banco de dados via JPA
        model.addAttribute("listaLivros", repository.findAll());
        return "livro";
    }

    // salva os dados no banco
    @PostMapping("/exibir")
    public String cadastrar(@ModelAttribute("livro") Livro livro) {
        repository.save(livro); // salva usando JPA
        return "redirect:/livros/exibir";
    }

    // o Controller mapeia "/livros", então mapeamos apenas o restante
    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/livros/exibir";
    }
    @ModelAttribute("categoria")
    public List<String> ListarCategorias() {
        return Arrays.asList("Ficção", "Não Ficção", "Romance", "Fantasia", "Biografia");
    }
}