package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Autor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/autores") // nova rota exclusiva para autores
public class AutorController {

    // lista na memória para guardar os autores
    private List<Autor> autoresSalvos = new ArrayList<>();

    @GetMapping("/cadastrar")
    public String exibirFormulario(Model model) {
        model.addAttribute("autor", new Autor());
        model.addAttribute("listaAutores", autoresSalvos);
        return "autor"; // vai procurar o arquivo autor.html
    }

    @PostMapping("/cadastrar")
    public String salvarAutor(Autor autor, Model model) {
        autoresSalvos.add(autor); // salva na lista

        model.addAttribute("listaAutores", autoresSalvos); // Atualiza a lista na tela
        model.addAttribute("mensagem", "O autor '" + autor.getNome() + "' foi cadastrado!");
        model.addAttribute("autor", new Autor()); // limpa o formulário

        return "autor";
    }
}