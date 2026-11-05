package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Livro;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/livros")
public class LivroController {

    // lista na memória para guardar os livros
    private List<Livro> livros = new ArrayList<>();

    @GetMapping
    public String inicio(){
        return "livros/inicio";
    }

    // exibir a tela do formulário e a lista
    @GetMapping("/exibir")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("livro", new Livro());
        model.addAttribute("listaLivros", livros);
        return "livro";
    }

    // recebe os dados do formulário na exata mesma rota
    @PostMapping("/exibir")
    public String cadastrar(@ModelAttribute("livro") Livro livro) {
        livros.add(livro);
        return "redirect:/livros/exibir";
    }

    @GetMapping("/livros/excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        livros.remove(indice);
        return "redirect:/livros/exibir";
    }

}