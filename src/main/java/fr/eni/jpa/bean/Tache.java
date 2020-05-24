package fr.eni.jpa.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
public class Tache implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_Tache;

    private String description;

    private Date date_tache;

    @ManyToMany
    @JoinTable(name = "tacheCategorie",
        joinColumns = {@JoinColumn(name = "id_Tache")},
        inverseJoinColumns = {@JoinColumn(name = "id_Categorie")})
    private List<Categorie> categories;

    @ManyToOne
    private Etat etat;

    public Tache() {
    }

    public Tache(int id_Tache, String description, Date date_tache) {
        this.id_Tache = id_Tache;
        this.description = description;
        this.date_tache = date_tache;
    }

    public Tache(String description, Date date_tache) {
        this.description = description;
        this.date_tache = date_tache;
    }

    public Tache(String description, Date date_tache, List<Categorie> categories, Etat etat) {
        this.description = description;
        this.date_tache = date_tache;
        this.categories = categories;
        this.etat = etat;
    }

    public Tache(String description, Date date_tache, Etat etat) {
        this.description = description;
        this.date_tache = date_tache;
        this.etat = etat;
    }

    public int getId_Tache() {
        return id_Tache;
    }

    public void setId_Tache(int id_Tache) {
        this.id_Tache = id_Tache;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description.length() > 255){
            System.out.println("La description ne peut pas dépasser 255 caracteres ! ");
        }else {
            this.description = description;
        }
    }

    public Date getDate_tache() {
        return date_tache;
    }

    public void setDate_tache(Date date_tache) {
        this.date_tache = date_tache;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tache{");
        sb.append("id_Tache=").append(id_Tache);
        sb.append(", description='").append(description).append('\'');
        sb.append(", date_tache=").append(date_tache);
        sb.append(", categories=").append(categories);
        sb.append(", etat=").append(etat);
        sb.append('}');
        return sb.toString();
    }
}
