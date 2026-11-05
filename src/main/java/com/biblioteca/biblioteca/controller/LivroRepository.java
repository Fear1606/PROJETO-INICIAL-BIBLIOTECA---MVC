package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LivroRepository
            extends JpaRepository<Livro, Long> {

    Object save(Livro livro);
    void deleteById(Long id);
    Optional<Livro> findById(Long id);
    List<Livro> findAll();
}
