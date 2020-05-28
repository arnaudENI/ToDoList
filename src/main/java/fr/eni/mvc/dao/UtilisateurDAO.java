package fr.eni.mvc.dao;

import fr.eni.mvc.bean.Categorie;
import fr.eni.mvc.bean.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UtilisateurDAO extends JpaRepository<Utilisateur, Integer> {

    List<Utilisateur> findByNom(String nom);
    List<Utilisateur> findByIdentifiant(String identifiant);
    List<Categorie> findAllUtilisateurCategories(String nom);
}
