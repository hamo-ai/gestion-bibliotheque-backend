package com.example.bibliotheque.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCat;
    private String nomCat;

    public Categorie() {}

    public Categorie(String nomCat) {
        this.nomCat = nomCat;
    }

    public Long getIdCat() { return idCat; }
    public void setIdCat(Long idCat) { this.idCat = idCat; }
    public String getNomCat() { return nomCat; }
    public void setNomCat(String nomCat) { this.nomCat = nomCat; }
}