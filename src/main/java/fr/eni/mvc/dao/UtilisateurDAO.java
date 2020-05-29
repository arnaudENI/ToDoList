package fr.eni.mvc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.mvc.bean.Utilisateur;

public interface UtilisateurDAO extends JpaRepository<Utilisateur, Integer> {

    List<Utilisateur> findByNom(String nom);
    List<Utilisateur> findByIdentifiant(String identifiant);
    
    List<Utilisateur> findByOrderByCategories();
}
