package fr.eni.mvc.service;

import fr.eni.mvc.bean.Categorie;
import fr.eni.mvc.bean.Utilisateur;
import fr.eni.mvc.dao.UtilisateurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "gestionUtilisateur")
public class GestionUtilisateur {

    @Autowired
    UtilisateurDAO udao;

    public List<Utilisateur> listeUtilisateur() {
        return udao.findAll();
    }

    public Utilisateur rechercherUtilisateur(int id) {
        return udao.findOne(id);
    }

    public void ajouterUtilisateur(Utilisateur u) {
        udao.save(u);
    }

    public void modifierUtilisateur(Utilisateur u) {
        udao.save(u);
    }

    public void supprimerUtilisateur(Utilisateur u) {
        udao.delete(u);
    }

    public void supprimerUtilisateur(int id) {
        udao.delete(id);
    }

    public List<Utilisateur> rechercherUtilisateur(String nom){
        return udao.findByNom(nom);
    }

    public List<Utilisateur> rechercherUtilisateurParIdentifiant(String identifiant) {
        return udao.findByIdentifiant(identifiant);
    }

    public List<Categorie> categoriesDeUtilisateur(String nom) {
        return udao.findAllUtilisateurCategories(nom);
    }
}
