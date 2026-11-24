package com.example.bibliotheque.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotheque.entities.Livre;
import com.example.bibliotheque.repos.LivreRepository;

@RestController
@RequestMapping("/api/livres")
@CrossOrigin("*")
public class LivreController {

    private final LivreRepository repo;

    public LivreController(LivreRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Livre> getAll() {
        return repo.findAll();
    }

    // Nouveau : consulter un livre (utilisé par la page "Modifier" d'Angular)
    @GetMapping("/{id}")
    public Livre getById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Livre add(@RequestBody Livre l) {
        return repo.save(l);
    }

    @PutMapping
    public Livre update(@RequestBody Livre l) {
        return repo.save(l);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
