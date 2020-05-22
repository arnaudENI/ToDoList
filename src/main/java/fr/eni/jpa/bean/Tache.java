package fr.eni.jpa.bean;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Tache {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_Tache;

    private String description;

    private Date date_tache;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tache{");
        sb.append("id_Tache=").append(id_Tache);
        sb.append(", description='").append(description).append('\'');
        sb.append(", date_tache=").append(date_tache);
        sb.append('}');
        return sb.toString();
    }
}
