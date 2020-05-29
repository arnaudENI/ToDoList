package fr.eni.mvc.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table
public class Utilisateur  {

    //TODO : ajouter les annotaions pour la validation des formulaires
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_utilisateur;

    @Column(name = "identifiant", unique = true)
    private String identifiant;

    @NotNull
    private String nom;

    @NotNull
    private String prenom;

    private String mdp;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "Utilisateur_id")
    private List<fr.eni.mvc.bean.Tache> taches;

    @OneToMany(cascade = CascadeType.ALL,fetch=FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "Utilisateur_id")
    private List<fr.eni.mvc.bean.Categorie> categories;

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



    public Utilisateur(String identifiant, String nom, String prenom, String mdp, List<fr.eni.mvc.bean.Tache> taches, List<fr.eni.mvc.bean.Categorie> categories) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.taches = taches;
        this.categories = categories;
    }



    public Utilisateur(String identifiant, String nom, String prenom, String mdp, List<fr.eni.mvc.bean.Categorie> categories) {
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

    public List<fr.eni.mvc.bean.Tache> getTaches() {
        return taches;
    }

    public void setTaches(List<Tache> taches) {
        this.taches = taches;
    }

    public List<fr.eni.mvc.bean.Categorie> getCategories() {
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
