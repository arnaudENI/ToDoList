package fr.eni.jpa.bean;

import javax.persistence.*;

@Entity
public class Etat {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_Etat;

    private String libelle;

    public Etat() {
    }

    public Etat(int id_Etat, String libelle) {
        this.id_Etat = id_Etat;
        this.libelle = libelle;
    }

    public Etat(String libelle) {
        this.libelle = libelle;
    }

    public int getId_Etat() {
        return id_Etat;
    }

    public void setId_Etat(int id_Etat) {
        this.id_Etat = id_Etat;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Etat{");
        sb.append("id_Etat=").append(id_Etat);
        sb.append(", libelle='").append(libelle).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
