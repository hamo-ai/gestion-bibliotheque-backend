package com.example.bibliotheque;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.example.bibliotheque.entities.Categorie;
import com.example.bibliotheque.entities.Livre;
import com.example.bibliotheque.repos.CategorieRepository;
import com.example.bibliotheque.repos.LivreRepository;

@SpringBootApplication
public class BibliothequeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BibliothequeApplication.class, args);
    }

    // Atelier 09, étape 2 : exposer les id (idCat) dans le JSON de Spring Data REST
    @Bean
    RepositoryRestConfigurer repositoryRestConfigurer() {
        return RepositoryRestConfigurer.withConfig(
            config -> config.exposeIdsFor(Categorie.class, Livre.class));
    }

    @Bean
    CommandLineRunner init(LivreRepository repo, CategorieRepository catRepo) {
        return args -> {
            // On insère les données de test seulement si les tables sont vides
            Categorie roman = null;
            Categorie jeunesse = null;
            if (catRepo.count() == 0) {
                roman = catRepo.save(new Categorie("Roman"));
                jeunesse = catRepo.save(new Categorie("Jeunesse"));
                catRepo.save(new Categorie("Science-fiction"));
            }
            if (repo.count() == 0) {
                repo.save(new Livre("Les Misérables", "Victor Hugo", 1862, 25.0, roman));
                repo.save(new Livre("L'Étranger", "Albert Camus", 1942, 18.5, roman));
                repo.save(new Livre("Le Petit Prince", "Saint-Exupéry", 1943, 15.0, jeunesse));
            }
        };
    }
}
