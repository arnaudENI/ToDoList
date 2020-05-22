package fr.eni.jpa.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_utilisateur;

    private String identifiant;

    private String nom;

    private String prenom;

    private String mdp;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Utilisateur{");
        sb.append("id=").append(id_utilisateur);
        sb.append(", identifiant='").append(identifiant).append('\'');
        sb.append(", nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", mdp='").append(mdp).append('\'');
        sb.append('}');
        return sb.toString();
    }
}