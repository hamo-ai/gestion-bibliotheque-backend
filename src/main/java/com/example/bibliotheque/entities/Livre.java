package com.example.bibliotheque.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String auteur;
    private Integer anneePublication;
    private Double prix;

    // Nouveau : chaque livre appartient à une catégorie
    @ManyToOne
    private Categorie categorie;

    public Livre() {}

    public Livre(String titre, String auteur, Integer anneePublication, Double prix) {
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.prix = prix;
    }

    public Livre(String titre, String auteur, Integer anneePublication, Double prix, Categorie categorie) {
        this(titre, auteur, anneePublication, prix);
        this.categorie = categorie;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }
    public Integer getAnneePublication() { return anneePublication; }
    public void setAnneePublication(Integer anneePublication) { this.anneePublication = anneePublication; }
    public Double getPrix() { return prix; }
    public void setPrix(Double prix) { this.prix = prix; }
    public Categorie getCategorie() { return categorie; }
    public void setCategorie(Categorie categorie) { this.categorie = categorie; }
}
