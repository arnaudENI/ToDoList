package fr.eni.jpa.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "findAllUser",
                    query = "SELECT u FROM Utilisateur u"),
        @NamedQuery(name = "findNameLike",
                    query = "SELECT u FROM Utilisateur u WHERE u.nom LIKE :var")
})
public class Utilisateur implements Serializable {

    //TODO : ajouter les annotaions pour la validation des formulaires
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_utilisateur;

    @Column(name = "identifiant", unique = true)
    private String identifiant;

    private String nom;

    private String prenom;

    private String mdp;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "Utilisateur_id")
    private List<Tache> taches;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "Utilisateur_id")
    private List<Categorie> categories;

    public Utilisateur() {
    }

    public Utilisateur(int id_utilisateur, String identifiant, String nom, String prenom, String mdp) {
        this.id_utilisateur = id_utilisateur;
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
    }

    public Utilisateur(String identifiant, String nom, String prenom, String mdp) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
    }



    public Utilisateur(String identifiant, String nom, String prenom, String mdp, List<Tache> taches, List<Categorie> categories) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.taches = taches;
        this.categories = categories;
    }



    public Utilisateur(String identifiant, String nom, String prenom, String mdp, List<Categorie> categories) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.categories = categories;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id) {
        this.id_utilisateur = id;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public List<Tache> getTaches() {
        return taches;
    }

    public void setTaches(List<Tache> taches) {
        this.taches = taches;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Utilisateur{");
        sb.append("id_utilisateur=").append(id_utilisateur);
        sb.append(", identifiant='").append(identifiant).append('\'');
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", mdp='").append(mdp).append('\'');
        sb.append(", taches=").append(taches);
        sb.append(", categories=").append(categories);
        sb.append('}');
        return sb.toString();
    }
}
