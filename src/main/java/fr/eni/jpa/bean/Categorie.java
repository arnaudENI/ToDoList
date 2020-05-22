package fr.eni.jpa.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Categorie implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_Categorie;

    private String libelle;

    public Categorie() {
    }

    public Categorie(int id_Categorie, String libelle) {
        this.id_Categorie = id_Categorie;
        this.libelle = libelle;
    }

    public Categorie(String libelle) {
        this.libelle = libelle;
    }

    public int getId_Categorie() {
        return id_Categorie;
    }

    public void setId_Categorie(int idCategorie) {
        this.id_Categorie = idCategorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Categorie{");
        sb.append("idCategorie=").append(id_Categorie);
        sb.append(", libelle='").append(libelle).append('\'');
        sb.append('}');
        return sb.toString();
    }
}