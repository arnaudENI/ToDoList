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

    @Column(name = "date_tache")
    @Temporal(TemporalType.DATE)
    private Date date_tache;

    private boolean fait;

    @ManyToMany
    @JoinTable(name = "tacheCategorie",
        joinColumns = {@JoinColumn(name = "id_Tache")},
        inverseJoinColumns = {@JoinColumn(name = "id_Categorie")})
    private List<Categorie> categories;

    public Tache() {
    }

    public Tache(String description, Date date_tache, boolean fait) {
        this.description = description;
        this.date_tache = date_tache;
        this.fait = fait;
    }

    public Tache(String description, Date date_tache, boolean fait, List<Categorie> categories) {
        this.description = description;
        this.date_tache = date_tache;
        this.fait = fait;
        this.categories = categories;
    }

    public Tache(int id_Tache, String description, Date date_tache, boolean fait, List<Categorie> categories) {
        this.id_Tache = id_Tache;
        this.description = description;
        this.date_tache = date_tache;
        this.fait = fait;
        this.categories = categories;
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
        this.description = description;
    }

    public Date getDate_tache() {
        return date_tache;
    }

    public void setDate_tache(Date date_tache) {
        this.date_tache = date_tache;
    }

    public boolean isFait() {
        return fait;
    }

    public void setFait(boolean fait) {
        this.fait = fait;
    }

    public List<Categorie> getCategories() {
        return categories;
    }

    public void setCategories(List<Categorie> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tache{");
        sb.append("id_Tache=").append(id_Tache);
        sb.append(", description='").append(description).append('\'');
        sb.append(", date_tache=").append(date_tache);
        sb.append(", fait=").append(fait);
        sb.append(", categories=").append(categories);
        sb.append('}');
        return sb.toString();
    }
}
