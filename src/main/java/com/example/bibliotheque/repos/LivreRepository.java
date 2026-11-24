package com.example.bibliotheque.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.bibliotheque.entities.Livre;

// exported = false : les livres restent gérés par LivreController (/api/livres)
@RepositoryRestResource(exported = false)
public interface LivreRepository extends JpaRepository<Livre, Long> {
}
