package fr.eni.mvc.service;

import fr.eni.mvc.bean.Utilisateur;
import fr.eni.mvc.dao.UtilisateurDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "gestionUtilisateur")
public class GestionUtilisateur {

    @Autowired
    UtilisateurDAO udao;

    public List<Utilisateur> listeUtilisateur()throws Exception  {
        return udao.findAll();
    }

    public Utilisateur rechercherUtilisateur(int id)throws Exception  {
        return udao.findOne(id);
    }

    public void ajouterUtilisateur(Utilisateur u)throws Exception {
        udao.save(u);
    }

    public void modifierUtilisateur(Utilisateur u) throws Exception {
        udao.save(u);
    }

    public void supprimerUtilisateur(Utilisateur u)throws Exception  {
        udao.delete(u);
    }

    public void supprimerUtilisateur(int id)throws Exception  {
        udao.delete(id);
    }

    public List<Utilisateur> rechercherUtilisateur(String nom)throws Exception {
        return udao.findByNom(nom);
    }

    public List<Utilisateur> rechercherUtilisateurParIdentifiant(String identifiant)throws Exception  {
        return udao.findByIdentifiant(identifiant);
    }
}
