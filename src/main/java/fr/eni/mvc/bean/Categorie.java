package fr.eni.mvc.bean;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_Categorie;

    @NotNull(message="Vous devez saisir un libelle")
    private String libelle;

    @ManyToMany(mappedBy = "categories")
    private List<Tache> taches;

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
        sb.append("id_Categorie=").append(id_Categorie);
        sb.append(", libelle='").append(libelle).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
