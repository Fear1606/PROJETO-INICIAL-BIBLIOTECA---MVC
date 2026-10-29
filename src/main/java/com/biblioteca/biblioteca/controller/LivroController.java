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

    private List<Livro> livrosSalvos = new ArrayList<>();

    @GetMapping
    public String inicio(){
        return "livros/inicio";
    }
    @GetMapping("/exibir")
    public String exibirLivros(Model model) {

        Livro livro = new Livro();

        livro.setTitulo("Harry Potter e a Pedra Filosofal");
        livro.setAutor("J.K. Rowling");
        livro.setIsbn("978-0439708180");

        model.addAttribute("livro", livro);

        return "livro";
    }

    // ... (seu código acima continua igual)

    @GetMapping("/cadastrar")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("livro", new Livro());
        model.addAttribute("listaLivros", livrosSalvos);
        return "livro";
    }

    @PostMapping("/cadastrar")
    public String salvarLivro(Livro livro, Model model) {
        livrosSalvos.add(livro);

        model.addAttribute("listaLivros", livrosSalvos);
        model.addAttribute("livro", livro);

        model.addAttribute("mensagem", "O livro '" + livro.getTitulo() + "' foi cadastrado!");

        // (Nota: esta linha sobrescreve o livro preenchido por um vazio, o que está certíssimo para limpar a tela para o próximo cadastro!)
        model.addAttribute("livro", new Livro());

        return "livro";
    }
}


